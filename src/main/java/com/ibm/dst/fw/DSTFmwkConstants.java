package com.ibm.dst.fw;

/**
 * This interface that defines all the framework constants
 */
public interface DSTFmwkConstants
{

	//To be used as view name when JSP rendering is required
	String JSP_VIEW = "JSP_VIEW";
	//To be used as view name when file download is required
	String AJAX_VIEW = "AJAX_RESPONSE";
	//Used by the framework 
	String MAIN_CONTENT = "MAIN_CONTENT";
	//Used by the framework 
	String PAGE_TITLE = "PAGE_TITLE";
	//Used by the framework 
	String APP_NAME = "APP_NAME";
	//Used by the framework 
	String LEFTMENU_CONTENT = "LEFTMENU_CONTENT";
	//Used by the framework 
	String AJAX_CONTENT = "AJAX_CONTENT";
	//Used by the framework 
	String ACTION_ERROR = "actionError";
	// Error in action that is handled by the action class
	String AJAX_ACTION_ERROR = "AJAX_ACTION_ERROR";
	// Error that is not handled by the action class
	String AJAX_INVALID_RESPONSE_ERROR = "INVALID_RESP_ERROR";
	// Error of some general kind but handled
	String AJAX_RESPONSE_ERROR = "RESP_ERROR";
	
	String AJAX_RESPONSE_SUCCESS = "SUCESS";
	//Used by the framework 
	String FILE_CONTENT = "FILE_CONTENT";
	//Used by the framework 
	String FILE_NAME = "OUTPUT_FILE_NAME";
	//Used by the framework 
	String GENERIC_ERROR_JSP = "/dst/common/generic_error.jsp";
	//Used by the framework 
	String EXTRA_WIDE_CONTENT_SIZE = "extraWide";
	
	String USER_DETAILS = "USER_DETAILS";
}