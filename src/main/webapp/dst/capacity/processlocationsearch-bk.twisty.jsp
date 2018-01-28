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
<%
	ArrayList<AvailabilityBean> availabilityBeans  = (ArrayList<AvailabilityBean>) request.getAttribute("availability_bean"); 
	String locationVal = (String)request.getAttribute("location"); 
%>	
<div id="ibm-pcon">
	<div id="ibm-content">
		<div id="ibm-content-body">
			<div id="ibm-content-main">
				<div class="ibm-columns">
				    <form method="post" action="processlocationsearch.wss">
						<div class="ibm-col-1-1">
					        <p>
						        <label for="Location">Search:</label>
						        <input type="location" name="location" id="location" value="<%=locationVal%>" placeholder="Search for location..." onClick="javascript: val()">
					    	</p>
					    	<% AvailabilityBean availabilityBean = null; 
					    	   for(int i = 0; i < availabilityBeans.size() ; i++) {
					    	   availabilityBean = availabilityBeans.get(i); 
					    	%>
								<div class="ibm-container ibm-show-hide ibm-alternate">
									<h2><a class="" href="#show-hide"><%=availabilityBean.getResource_pool_name()%></a></h2>
									<div style="overflow: hidden; display: none; height: 1px;" class="ibm-container-body">
										<ul>
											<li>Building    		: <%=availabilityBean.getBuilding()%></li>
											<li>Available CPU   	: <%=availabilityBean.getAvailable_cpu()%></li>
											<li>Available RAM   	: <%=availabilityBean.getAvailable_ram()%></li>
											<li>Available Storage  	: <%=availabilityBean.getAvailable_storage()%></li>
										</ul>
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
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>