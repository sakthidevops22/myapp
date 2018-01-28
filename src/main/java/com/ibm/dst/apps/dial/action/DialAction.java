package com.ibm.dst.apps.dial.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.DSTFmwkConstants;
import com.ibm.dst.fw.DSTFrameworkHelper;
 
@Controller
public class DialAction {
    
    @RequestMapping("/dial.wss")
	public ModelAndView viewDail(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.DIAL_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/dial/dial.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  
		
}
