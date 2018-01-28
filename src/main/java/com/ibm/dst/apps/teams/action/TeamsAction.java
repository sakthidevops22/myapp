package com.ibm.dst.apps.teams.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.dst.apps.teams.dao.SkillSearchDAO;
import com.ibm.dst.apps.capacity.dao.CapacityDAO;
import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.DSTFmwkConstants;
import com.ibm.dst.fw.DSTFrameworkHelper;
 
@Controller
public class TeamsAction {
   
    @RequestMapping("/teams.wss")
    public ModelAndView creatTicket(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/teams.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}
    
    @RequestMapping("/addemployee.wss")
    public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/addemployee.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}
    
    @RequestMapping("/processempadd.wss")
    public ModelAndView processempAdd(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/processempadd.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}

    @RequestMapping("/editemployee.wss")
    public ModelAndView editEmployee(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/editemployee.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}
    
    @RequestMapping("/processempedit.wss")
    public ModelAndView processempEdit(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/processempedit.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}    
    
    @RequestMapping("/archiveemployee.wss")
    public ModelAndView archiveEmployee(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/archiveemployee.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}
    
    @RequestMapping("/processemparchive.wss")
    public ModelAndView processempArchive(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/processemparchive.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}  
    
    @RequestMapping("/searchemployee.wss")
    public ModelAndView searchEmployee(HttpServletRequest request, HttpServletResponse response) {    	
		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/searchemployee.jsp");
		return new ModelAndView(DSTFmwkConstants.JSP_VIEW);	
		
	}    

    @RequestMapping("/processempsearch.wss")
    public ModelAndView processEmployeeSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	ModelAndView mv = new ModelAndView(DSTFmwkConstants.JSP_VIEW);    	
    	try {
    		if(request.getParameter("search") != null) {
    	    	mv.addObject("person_bean", (new SkillSearchDAO()).searchEmployeeSkill(request.getParameter("search")));
    	    	mv.addObject("search", request.getParameter("search"));
    		} else {
    			mv.addObject("person_bean", new ArrayList());
    		}
    		DSTFrameworkHelper.setModuleDetails(request, AppConstants.TEAMS_PAGE_TITLE, AppConstants.MYAPP_APP_NAME);
    		DSTFrameworkHelper.setOutputJSP(request, "/dst/teams/processempsearch.jsp");
    	} catch(Exception e) {
    		DSTFrameworkHelper.signalError(e, request);
    	}
		return mv;		
	}
}
