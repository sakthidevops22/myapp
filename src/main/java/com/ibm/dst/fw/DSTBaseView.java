package com.ibm.dst.fw;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

/**
* This class handles the JSP based output produced by the action classes 
 * If the model name is set as DSTFmwkConstants.JSP_VIEW, then 
 * this render method of this view class would be called. 
 * In case some other non standard view names are set then also 
 * this view is used.
 * 
 * This class instance would be invoked by the framework and the 
 * public methods should not be called from application classes.
 * 
 *
 */
public class DSTBaseView implements View
{

	@Override
	public String getContentType()
	{
		// TODO Auto-generated method stub
		return "text/html";
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.View#render(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//
		// As of now redirect to a fixed JSP file
		if (model != null && model.size() > 0)
		{
			for (String key : model.keySet())
			{
				request.setAttribute(key, model.get(key));
			}
		}
		// TODO:Resolve the theme template from the
		// session object, Following hard coding of /dst/theme/dst_web_main.jsp
		// should be removed.
		request.getRequestDispatcher("/dst/theme/dst_web_main.jsp").forward(request, response);

	}

}
