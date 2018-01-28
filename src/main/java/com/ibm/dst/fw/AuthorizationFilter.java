package com.ibm.dst.fw;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ibm.dst.fw.bean.UserDetails;
import com.ibm.dst.fw.util.BluePageHelper;

/**
 * This filter is mapped to *.wss and checks the authorization of logged in user
 *  
 */
public class AuthorizationFilter implements Filter
{

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException
	{
		boolean isAuthorized  = false;
		if(request instanceof HttpServletRequest)
		{
			//Checking the authorization
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			UserDetails userDetails = (UserDetails)httpRequest.getSession().getAttribute(DSTFmwkConstants.USER_DETAILS);
			if(userDetails==null)
			{
				//Retrieve the user
				userDetails = BluePageHelper.createUser(httpRequest.getRemoteUser());
				if(userDetails!=null)
				{
					isAuthorized = BluePageHelper.isUserAuthorized(userDetails);
					userDetails.setAuthorized(isAuthorized);
					httpRequest.getSession().setAttribute(DSTFmwkConstants.USER_DETAILS, userDetails);
				}
			}
			else
			{
				if(!httpRequest.getRemoteUser().equals(userDetails.getEmailId())){
					httpRequest.getSession().invalidate();
					userDetails = BluePageHelper.createUser(httpRequest.getRemoteUser());
					isAuthorized = BluePageHelper.isUserAuthorized(userDetails);
					userDetails.setAuthorized(isAuthorized);
					httpRequest.getSession().setAttribute(DSTFmwkConstants.USER_DETAILS, userDetails);
				} else {
					isAuthorized = userDetails.isAuthorized();
				}
			}
		}
		if(isAuthorized)
		{
			chain.doFilter(request, response);
		}
		else
		{
			request.getRequestDispatcher("/dst/common/unauthorized_access.jsp").forward(request, response);
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException	{
	}

}
