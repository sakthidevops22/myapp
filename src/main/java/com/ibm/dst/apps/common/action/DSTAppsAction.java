package com.ibm.dst.apps.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.DSTFrameworkHelper;
import com.ibm.dst.fw.DSTFmwkConstants;
 
@Controller
public class DSTAppsAction {
    
    @RequestMapping("/home.wss")
    public ModelAndView viewHomepage(HttpServletRequest request, HttpServletResponse response) {
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.HOME_PAGE_TITLE, AppConstants.HOME_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/common/home.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);
	}

    @RequestMapping("/supportlinks.wss")
    public ModelAndView supportLinks(HttpServletRequest request, HttpServletResponse response) {
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.SUPLNK_PAGE_TITLE, AppConstants.SUPLNK_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/common/supportlinks.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);
   	}
    
    @RequestMapping("/faq.wss")
    public ModelAndView faq(HttpServletRequest request, HttpServletResponse response) {
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.FAQ_PAGE_TITLE, AppConstants.FAQ_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/common/faq.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);
    }
    
    @RequestMapping("/myapps.wss")
    public ModelAndView viewDashboard(HttpServletRequest request, HttpServletResponse response) {
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.MYAPP_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/common/myapps.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);
	}
    		
}
