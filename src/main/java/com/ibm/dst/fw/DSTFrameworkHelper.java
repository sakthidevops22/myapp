package com.ibm.dst.fw;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;



/**
 * Generic Framework Helper class for DST web framework
 *
 */
public class DSTFrameworkHelper {
	
	private DSTFrameworkHelper()
	{
		super();
	}
	public static void setOutputJSP(HttpServletRequest request,String jspName)
	{
		if(request!=null)
		{
			request.setAttribute(DSTFmwkConstants.MAIN_CONTENT, jspName);
		}
	}
	public static void setModuleDetails(HttpServletRequest request,String pageTitle, String pageName)
	{
		if(request!=null)
		{
			request.setAttribute(DSTFmwkConstants.PAGE_TITLE, pageTitle);
			request.setAttribute(DSTFmwkConstants.APP_NAME, pageName);
		}
	}
	public static void setAJAXOutput(HttpServletRequest request,String ajaxOutput)
	{
		if(request!=null)
		{
			AjaxResponse response = new AjaxResponse();
			response.setResponseData(ajaxOutput);
			response.setStatus(DSTFmwkConstants.AJAX_RESPONSE_SUCCESS);
			request.setAttribute(DSTFmwkConstants.AJAX_CONTENT, response);
		}
	}
	public static void setFileErrorOutput(HttpServletRequest request,String errorMessage)
	{
		if(request!=null)
		{
			request.setAttribute(DSTFmwkConstants.FILE_NAME, "Error.csv");
			request.setAttribute(DSTFmwkConstants.FILE_CONTENT, errorMessage.getBytes());
		}
	}
	public static void setFileOutput(HttpServletRequest request,byte[] content,String fileName)
	{
		if(request!=null)
		{
			request.setAttribute(DSTFmwkConstants.FILE_NAME, fileName);
			request.setAttribute(DSTFmwkConstants.FILE_CONTENT, content);
		}
	}
	
	
	
	public static void setActionError(String error, HttpServletRequest request)
	{
		ActionError errorObj = new ActionError(null, error);
		request.setAttribute(DSTFmwkConstants.ACTION_ERROR, errorObj);
		request.setAttribute(DSTFmwkConstants.PAGE_TITLE, "Error Page");
		request.setAttribute(DSTFmwkConstants.APP_NAME, "My Portal Lite");
		AjaxResponse ajaxReponse  = new AjaxResponse();
		ajaxReponse.setMessgae(error);
		ajaxReponse.setResponseData("");
		ajaxReponse.setStatus(DSTFmwkConstants.AJAX_ACTION_ERROR);
		request.setAttribute(DSTFmwkConstants.AJAX_CONTENT, ajaxReponse);
	
	}
	
	public static void signalError(Throwable t,HttpServletRequest request)
	{
		setOutputJSP(request, DSTFmwkConstants.GENERIC_ERROR_JSP);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		setActionError(sw.toString(), request); 
	}
	
	public static void setLeftMenuJsp(String jspPath,HttpServletRequest request)
	{
		request.getSession().setAttribute(DSTFmwkConstants.LEFTMENU_CONTENT,jspPath );
	}
	
	public static void setContentExtraWide(ModelAndView model)
	{
		if(model!=null)
		{
			model.addObject(DSTFmwkConstants.EXTRA_WIDE_CONTENT_SIZE,"Y");
		}
	}
}
