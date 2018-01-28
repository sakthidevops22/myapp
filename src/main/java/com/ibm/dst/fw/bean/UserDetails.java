package com.ibm.dst.fw.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * This bean holds the required user details in the session.
 */
public class UserDetails implements Serializable
{
	/**
	 * Required for session serialization/de-serialization
	 */
	private static final long serialVersionUID = -3582347718162225844L;
	private Locale userLocale ;
	private String userDisplayName ;
	private String userId ;
	private String emailId;
	private Map<String, String> userDetailsMap;
	private boolean authorized=false;
	/**
	 * Default constructor
	 */
	public UserDetails()
	{
		super();
		userDetailsMap = new HashMap<String, String>(50);
	}

	/**
	 * @return the userLocale
	 */
	public Locale getUserLocale(HttpServletRequest request)
	{
		if (userLocale == null)
		{
			userLocale = request.getLocale();
		}
		return userLocale;
	}

	/**
	 * @param userLocale
	 *            the userLocale to set
	 */
	public void setUserLocale(Locale userLocale)
	{
		this.userLocale = userLocale;
	}

	/**
	 * @return the userDisplayName
	 */
	public String getUserDisplayName() {
		return userDisplayName;
	}

	/**
	 * @param userDisplayName the userDisplayName to set
	 */
	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	/**
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId()
	{
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	/**
	 * Builds user details out of Blue Page entries
	 * @param entries BPResultEntry
	 * @return UserDetails
	 */
	public static final UserDetails buildUserDetails(BPResultEntry[] entries)
	{
		Map<String, String> userInfoMap = null;
		if(entries!=null && entries.length>0)
		{
			userInfoMap = new HashMap<String, String>(entries.length);
			for(BPResultEntry entry:entries)
			{
				userInfoMap.put(entry.getName(),entry.getValueString());
			}
			UserDetails userDetails= new UserDetails();
			userDetails.setUserDisplayName(userInfoMap.get("cn"));
			userDetails.setUserId(userInfoMap.get("uid"));
			userDetails.setEmailId(userInfoMap.get("preferredidentity"));
			userDetails.setUserDetailsMap(userInfoMap);
			return userDetails;
			
		}
		return null;
			
	}

	/**
	 * @return the userDetailsMap
	 */
	public Map<String, String> getUserDetailsMap()
	{
		return userDetailsMap;
	}

	/**
	 * @param userDetailsMap the userDetailsMap to set
	 */
	public void setUserDetailsMap(Map<String, String> userDetailsMap)
	{
		this.userDetailsMap = userDetailsMap;
	}

	/**
	 * @return the authorized
	 */
	public boolean isAuthorized()
	{
		return authorized;
	}

	/**
	 * @param authorized the authorized to set
	 */
	public void setAuthorized(boolean authorized)
	{
		this.authorized = authorized;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetails [userLocale=");
		builder.append(userLocale);
		builder.append(", userDisplayName=");
		builder.append(userDisplayName);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(", authorized=");
		builder.append(authorized);
		builder.append("]");
		return builder.toString();
	}
}
