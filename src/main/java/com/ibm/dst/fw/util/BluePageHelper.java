package com.ibm.dst.fw.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import com.ibm.dst.fw.bean.UserDetails;

/**
 * Helper class that implements the helper methods of IBM blue page and
 * directory for user lookup
 * 
 */
public class BluePageHelper
{
	private static final Logger LOGGER = Logger.getLogger(BluePageHelper.class.getName());
	private static String BLUE_GROUPS_URL = "http://bluepages.ibm.com/tools/groups/groupsxml.wss?task=inAnyGroup&email=";
	private static String BLUE_PAGE_URL = "ldap://bluepages.ibm.com:636";
	private static String GROUP_LIST_PARAMS = "";
	private static String[] attributesToReturn = { "uid", "cn", "sn", "givenName", "mail", "o", "ou", "c" };
	private static boolean isInitialized = false;
	private static Properties ldapEnvironment = null;

	/**
	 * Constructor made private to avoid direct class creation
	 */
	private BluePageHelper()
	{
		super();
	}

	/**
	 * Initializes the URLS from spring config beans
	 * 
	 * @return True if initialization is done properly
	 */
	private static boolean init()
	{
		try
		{
			if (!isInitialized)
			{
				String[] groupList = new String[] {"DST India II", "DST India"};
				StringBuilder strBldr = new StringBuilder();
				for (String gruopName : groupList)
				{
					strBldr.append("&group=").append(URLEncoder.encode(gruopName, "UTF-8"));
				}
				//Updated the depth to 1 in order resolve the issue of Unauthorized access ( START) 
				strBldr.append("&depth=1");
				//Updated the depth to 1 in order resolve the issue of Unauthorized access ( END)
				GROUP_LIST_PARAMS = strBldr.toString();
				ldapEnvironment = new Properties();
				ldapEnvironment.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
				ldapEnvironment.put("java.naming.ldap.version", "3");
				ldapEnvironment.put("java.naming.provider.url", BLUE_PAGE_URL);
				ldapEnvironment.put(Context.SECURITY_PROTOCOL, "ssl");
				ldapEnvironment.put(Context.SECURITY_AUTHENTICATION, "simple");

				isInitialized = true;
			}
		} catch (Exception ex)
		{
			LOGGER.log(Level.WARNING, "|BP_HELPER|Error in initializing", ex);
			isInitialized = false;
		}
		return isInitialized;
	}

	/**
	 * Retrieves the user details from LDAP
	 * 
	 * @param serialNumber
	 *            Serial number of the user
	 * @return UserDetails
	 */
	public static UserDetails createUser(String email)
	{
		UserDetails user = null;
		DirContext ctx = null;
		try
		{
			if (init())
			{
				ctx = new InitialDirContext(ldapEnvironment);
				SearchControls constraints = new SearchControls();
				constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
				constraints.setReturningAttributes(attributesToReturn);
				NamingEnumeration<SearchResult> results = null;
				LOGGER.log(Level.FINE, "Going to retreieve information from " + BLUE_PAGE_URL + " for " + email);
				results = ctx.search("ou=bluepages,o=ibm.com", "(|(mail=" + email + "))", constraints);
				while (results.hasMore())
				{
					SearchResult si = (SearchResult) results.next();
					Attributes attrs = si.getAttributes();
					String commonName = (String) attrs.get("cn").get();
					String uid = (String) attrs.get("uid").get();
					String mail = (String) attrs.get("mail").get();
					user = new UserDetails();
					user.setEmailId(mail);
					user.setUserDisplayName(commonName);
					user.setUserId(uid);
					LOGGER.log(Level.FINE, "Found information from " + BLUE_PAGE_URL + " for " + email + ":"
							+ user);
				}
			} else
			{
				LOGGER.log(Level.WARNING, "|BP_HELPER|Could not initialize config params");
			}

		} catch (Exception ex)
		{
			LOGGER.log(Level.WARNING, "|BP_HELPER|Error in retriving blue page information for " + email
					+ "from url " + BLUE_PAGE_URL, ex);
			user = null;
		} finally
		{
			try
			{
				if (ctx != null)
				{
					ctx.close();
				}
			} catch (Exception ex)
			{
				LOGGER.log(Level.WARNING, "|BP_HELPER|Error in closing context " + email + "from url "
						+ BLUE_PAGE_URL, ex);

			}
		}
		return user;
	}

	/**
	 * Checks if a user is authorized to access eDesktop application or not
	 * based on blue group association
	 * 
	 * @param userDetails
	 *            UserDetails
	 * @return (true if user is authorized false otherwise)
	 */
	public static boolean isUserAuthorized(UserDetails userDetails)
	{
		boolean isAuthorized = false;
		StringBuffer resultBuffer = null;
		try
		{
			if (init() && userDetails != null && userDetails.getEmailId() != null)
			{
				resultBuffer = new StringBuffer("");
				URL blueGrpURL = new URL(BLUE_GROUPS_URL + userDetails.getEmailId().trim() + GROUP_LIST_PARAMS);
				BufferedReader in = new BufferedReader(new InputStreamReader(blueGrpURL.openStream()));
				String inputLine = "";
				while ((inputLine = in.readLine()) != null)
				{
					resultBuffer.append(inputLine);
				}
				in.close();
				// We have a XML string here
				if (LOGGER.isLoggable(Level.FINE))
				{
					LOGGER.log(Level.FINE, "|BP_HELPER|Retrived INFOMRATION FOR BLUEGROUP  IS " + resultBuffer);
				}
				String safeResult = resultBuffer.toString();
				if (safeResult.contains("<rc>0</rc>"))
				{
					isAuthorized = true;
				}
				else
				{
					LOGGER.log(Level.WARNING, "|BP_HELPER|Retrived INFOMRATION FOR UNAUTHORIZED ACCESS " + resultBuffer);
				}
			}
		} catch (Exception ex)
		{
			LOGGER.log(Level.WARNING, "|BP_HELPER|Error in retriving group information " + userDetails + "from url "
					+ BLUE_GROUPS_URL, ex);
			isAuthorized = false;

		}
		return isAuthorized;
	}

}
