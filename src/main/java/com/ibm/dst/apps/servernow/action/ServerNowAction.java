package com.ibm.dst.apps.servernow.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.DSTFmwkConstants;
import com.ibm.dst.fw.DSTFrameworkHelper;
 
@Controller
public class ServerNowAction {
    
    @RequestMapping("/servernow.wss")
	public ModelAndView viewServerNow(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.SERVERNOW_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/servernow/servernow.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  
		
    @RequestMapping("/createvm.wss")
	public ModelAndView viewPattern(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.SERVERNOW_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/servernow/serverprovision_step1.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  

    @RequestMapping("/selpattern.wss")
	public ModelAndView configureServer(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.SERVERNOW_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/servernow/serverprovision_step2.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  
    
    @RequestMapping("/reqhist.wss")
	public ModelAndView viewRequestHistory(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.SERVERNOW_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/servernow/reqhist.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  

    @RequestMapping("/managevm.wss")
	public ModelAndView vieManageVM(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.SERVERNOW_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/servernow/managevm.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  
}
