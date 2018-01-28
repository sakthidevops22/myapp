package com.ibm.dst.fw;

import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This class handles the JSON output produced by the action class methods.
 * If the model name is set as CNPFmwkConstants.AJAX_VIEW, then 
 * this render method of this view class would be called. 
 * 
 * The render method expects the AjaxResponse object would be 
 * available inside the HttpServletRequest with the attribute 
 * CNPFmwkConstants.AJAX_CONTENT
 * 
 * This class instance would be invoked by the framework and the 
 * public methods should not be called from application classes. 
 *
 */
public class DSTAjaxView extends DSTBaseView
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.support.electronic.fw.DSTBaseView#getContentType()
	 */
	@Override
	public String getContentType()
	{
		// TODO Auto-generated method stub
		return "application/json";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.support.electronic.fw.CNPBaseView#render(java.util.Map,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		response.setCharacterEncoding("UTF-8");
		OutputStream out = response.getOutputStream();
		AjaxResponse responseObject =(AjaxResponse)request.getAttribute(DSTFmwkConstants.AJAX_CONTENT);
		if(responseObject==null)
		{
			responseObject = new AjaxResponse();
			responseObject.setMessgae("Response Not Set");
			responseObject.setResponseData("Data not available");
			responseObject.setStatus(DSTFmwkConstants.AJAX_INVALID_RESPONSE_ERROR);
		}
		String outputJSON = responseObject.toJSON();
		out.write(outputJSON.getBytes());
		out.flush();
		out.close();
	}


}
