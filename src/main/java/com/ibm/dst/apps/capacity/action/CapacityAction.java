package com.ibm.dst.apps.capacity.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.dst.apps.capacity.dao.CapacityDAO;
import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.DSTFmwkConstants;
import com.ibm.dst.fw.DSTFrameworkHelper;
import com.ibm.dst.fw.ActionError;
 
@Controller
public class CapacityAction {
    
    @RequestMapping("/capacity.wss")
	public ModelAndView viewTicket(HttpServletRequest request, HttpServletResponse response){
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.CAPACITY_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/capacity/capacity.jsp");
    	return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
	}
    
    
    @RequestMapping("/searchlocation.wss")
    public ModelAndView searchLocationCapacity(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.CAPACITY_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/capacity/searchlocation.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}
    
    @RequestMapping("/processlocationsearch.wss")
    public ModelAndView processLocationCapacitySearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	ModelAndView mv = new ModelAndView(DSTFmwkConstants.JSP_VIEW);
    	try {
    		if(request.getParameter("location") != null) {
    	    	mv.addObject("availability_bean", (new CapacityDAO()).searchLocationAvailability(request.getParameter("location")));
    	    	mv.addObject("location", request.getParameter("location"));
    		} else {
    			mv.addObject("availability_bean", new ArrayList());
    		}
			DSTFrameworkHelper.setModuleDetails(request, AppConstants.CAPACITY_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
			DSTFrameworkHelper.setOutputJSP(request, "/dst/capacity/processlocationsearch.jsp");
    	} catch(Exception e) {
    		DSTFrameworkHelper.signalError(e, request);
    	}
		return mv;		
	}
		
}
