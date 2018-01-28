<%@ page import="java.util.ArrayList, com.ibm.dst.apps.capacity.beans.AvailabilityBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script language="Javascript">
function val(){
	document.onkeydown=function(){
	    if(window.event.keyCode=='13'){
	    	searchVal = document.getElementById("location").value;
	    	if(searchVal == null || searchVal == '' ){
	    		alert('Please enter search criteria');
	    		return;
	    	}
	        form.submit();
	    }
	};
}
</script>
<%!
	public String getColorCode(String zone){
		String color = null;
		if(zone != null && !zone.trim().equals("")) {
			if(zone.contains("BZP_") || zone.contains("BZPDO_")) {
				color = "#0000FF";
			} else if(zone.contains("YZD_") || zone.contains("YZC_")) {
				color = "#FFD700";
			} else if(zone.contains("BZR_")) {
				color = "#6495ED";
			}
		}
		return color;
	}

 %>
<%
	ArrayList<AvailabilityBean> availabilityBeans  = (ArrayList<AvailabilityBean>) request.getAttribute("availability_bean"); 
	String locationVal = (String)request.getAttribute("location");
	if(locationVal == null || locationVal.trim().equals("")){
		locationVal = "";
	} 
%>	
<div id="ibm-pcon">
	<div id="ibm-content">
		<div id="ibm-content-body">
			<div id="ibm-content-main">
				<div class="ibm-columns">
				    <form method="post" action="processlocationsearch.wss">
				        <p>
					        <label for="Location">Search:</label>
					        <input type="location" name="location" id="location" value="<%=locationVal%>" placeholder="Search for location..." onClick="javascript: val()">
					        <br /><br />
				    	</p>
						<%if(availabilityBeans.size() != 0) {%>
					    	<div>
					    		<b>Legend:</b>
					        	<ul>
									<li style="color:#0000FF">Blue zone</li> 
									<li style="color:#FFD700">Yellow zone</li>
									<li style="color:#6495ED">Restricted blue zone</li>
									<li> <span style="color:yellow">Warning </span>(threshold)</li>
								</ul>
						        <br />
					    	</div>
				    	<%}%>
				    	<% 
				    	   AvailabilityBean availabilityBean = null;
				    	   String color = ""; 
				    	   for(int i = 0; i < availabilityBeans.size() ; i++) {
				    	   availabilityBean = availabilityBeans.get(i);
				    	   color = getColorCode(availabilityBean.getResource_pool_name());
				    	%>
						<div class="ibm-col-6-2">
							<div class="ibm-card study ddn_transform ddn_build ddn_optimize ddn_extend ddn_manage ddi_banking">
								<div class="ibm-inner-margin">
									<p class="ibm-category"  style="color:<%=color%>"><%=availabilityBean.getResource_pool_name()%></p>
									<ul>
										<li>Building    		: <%=availabilityBean.getBuilding()%></li>
										<li>Available CPU   	: <span style="color: <%=availabilityBean.getAvailable_cpu_color()%>; font-weight: bold; "><%=availabilityBean.getAvailable_cpu()%> </span> </li>
										<li>Available RAM   	: <span style="color: <%=availabilityBean.getAvailable_ram_color()%>; font-weight: bold;"> <%=availabilityBean.getAvailable_ram()%> </span> </li>
										<li>Available Storage  	: <span style="color: <%=availabilityBean.getAvailable_storage_color()%>; font-weight: bold;"><%=availabilityBean.getAvailable_storage()%> </span> </li>
									</ul>
								</div>
							</div>	
						</div>								
						<%}%>
						<%if(availabilityBeans.size() == 0) {%>
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
					</form>
				</div>
			</div>
		</div>
	</div>
</div>