package com.ibm.dst.apps.devops.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.DSTFmwkConstants;
import com.ibm.dst.fw.DSTFrameworkHelper;
 
@Controller
public class DevopsAction {
    
    @RequestMapping("/devops.wss")
	public ModelAndView viewDevops(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.DEVOPS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/devops/devops.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  
		
    @RequestMapping("/questionnaire")
	public ModelAndView viewQuestionnaire(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.DEVOPS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/devops/questionnaire.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}  
}
