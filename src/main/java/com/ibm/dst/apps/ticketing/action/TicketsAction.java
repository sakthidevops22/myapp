package com.ibm.dst.apps.ticketing.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.dst.apps.teams.dao.SkillSearchDAO;
import com.ibm.dst.apps.ticketing.dao.TicketingDAO;
import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.DSTFmwkConstants;
import com.ibm.dst.fw.DSTFrameworkHelper;
 
@Controller
public class TicketsAction {
   
    @RequestMapping("/ticketing.wss")
    public ModelAndView creatTicket(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TICKETING_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/ticketing/ticketing.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}
    
    @RequestMapping("/searchtickets.wss")
    public ModelAndView searchTicket(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TICKETING_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/ticketing/searchtickets.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);		
	}
    
    @RequestMapping("/processticketsearch.wss")
    public ModelAndView processTicketSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	ModelAndView mv = new ModelAndView(DSTFmwkConstants.JSP_VIEW);    	
    	try {
    		if(request.getParameter("search") != null) {
    	    	mv.addObject("tickets_category_bean", (new TicketingDAO()).searchTicketsByAdminSite(request.getParameter("search")));
    	    	mv.addObject("search", request.getParameter("search"));
    		} else {
    			mv.addObject("tickets_category_bean", new ArrayList());
    		}
    		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TICKETING_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
    		DSTFrameworkHelper.setOutputJSP(request, "/dst/ticketing/processticketsearch.jsp");
    	} catch(Exception e) {
    		DSTFrameworkHelper.signalError(e, request);
    	}
		return mv;		
	}

    @RequestMapping("/processticketcategory.wss")
    public ModelAndView processTicketSearchByCategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	ModelAndView mv = new ModelAndView(DSTFmwkConstants.JSP_VIEW);    	
    	try {
    		String adminSite = request.getParameter("adminsite");
    		String category = request.getParameter("category");
    		if(adminSite != null && category != null) {
    	    	mv.addObject("tickets_bean", (new TicketingDAO()).searchTicketsByCategory(adminSite, category));
    	    	mv.addObject("adminsite", adminSite);
    	    	mv.addObject("category", category);
    		} else {
    			mv.addObject("tickets_bean", new ArrayList());
    		}
    		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TICKETING_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
    		DSTFrameworkHelper.setOutputJSP(request, "/dst/ticketing/processticketcategory.jsp");
    	} catch(Exception e) {
    		DSTFrameworkHelper.signalError(e, request);
    	}
		return mv;		
	}
}
