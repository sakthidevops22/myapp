<%@ page import="java.util.ArrayList, com.ibm.dst.apps.teams.beans.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script language="Javascript">
function val(){
	document.onkeydown=function(){
	    if(window.event.keyCode=='13'){
	    	searchVal = document.getElementById("search").value;
	    	if(searchVal == null || searchVal == '' ){
	    		alert('Please enter search criteria');
	    		return;
	    	}
	        form.submit();
	    }
	};
}
</script>
<%
	ArrayList<PersonBean> personBeans  = (ArrayList<PersonBean>) request.getAttribute("person_bean"); 
	String searchVal = (String)request.getAttribute("search");
	if(searchVal == null || searchVal.trim().equals("")){
		searchVal = "";
	} 
	
%>	
<div id="ibm-pcon">
	<div id="ibm-content">
		<div id="ibm-content-body">
			<div id="ibm-content-main">
				<div class="ibm-columns">
				    <form method="post" action="processempsearch.wss">
						<div class="ibm-col-1-1">
					        <p>
						        <label for="search">Search:</label>
						        <input type="search" name="search" id="search" value="<%=searchVal%>" placeholder="Search for employee using skill..." onClick="javascript: val()">
					    	</p>
					    	<% PersonBean person = null; 
					    	   for(int i = 0; i < personBeans.size() ; i++) {
					    	   person = personBeans.get(i); 
					    	%>
								<div class="ibm-container ibm-show-hide ibm-alternate">
									<h2><a class="" href="#show-hide"><%=person.getName()%></a></h2>
									<div style="overflow: hidden; display: none; height: 1px;" class="ibm-container-body">
										<ul>
											<%if(person.getMobileNumber() != "") {%>
												<li class="ibm-mobile ibm-phone-link"><a href="tel:<%=person.getMobileNumber()%>"><%=person.getMobileNumber()%></a></li>
												<li class="ibm-no-mobile ibm-phone-link"><%=person.getMobileNumber()%></li>
											<%} else {%>
												<li class="ibm-phone-link">Number not found</li>
											<%}%>
											<li class="ibm-email-link ibm-no-mobile"><a href="mailto:<%=person.getEmail()%>"><%=person.getEmail()%></a></li>
											<li class="ibm-email-link ibm-mobile"><%=person.getEmail()%></li>
											<li>Job Role    : <%=person.getPrimaryJRSS()%></li>
											<li>Team        : <%=person.getSubProjName()%></li>
											<li>Skill       : <%=person.getSkill()%></li>
										</ul>
									</div>
								</div>		
							<%}%>
							<%if(personBeans.size() == 0) {%>
								<p>
									<b>
										No matching records found for your search criteria..
									</b>
								</p>
							<%}%>		
							<div class="ibm-rule"><hr></div>
							<p>
								<a class="ibm-back-link" href="javascript: history.go(-1)">Go Back</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>