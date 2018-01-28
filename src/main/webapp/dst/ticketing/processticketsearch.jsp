<%@ page import="java.util.ArrayList,com.ibm.dst.apps.ticketing.beans.TicketCategoryBean"%>
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
	ArrayList<TicketCategoryBean> ticketCategoryBeans  = (ArrayList<TicketCategoryBean>) request.getAttribute("tickets_category_bean"); 
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
				    <form method="post" action="processticketsearch.wss">
					<div class="ibm-col-1-1">
				        <p>
					        <label for="search">Search by admin site:</label>
							<input type="search" name="search" id="search" placeholder="Search by admin site.." value="<%=searchVal%>" onclick="javascript: val()">
					        <br /><br /><br />
				    	</p>
				    	<%if(ticketCategoryBeans.size() != 0) {%>
							<div class="ibm-col-1-1">
								<table cellspacing="0" cellpadding="0" border="0" summary="OS ticket table" class="ibm-data-table ibm-sortable-table ibm-alternating ibm-vertical-dividers-color-labels">
								<caption>
									<em>Open tickets based on OS</em>
								</caption>
								<thead>
									<tr>
										<th scope="col">Operating system</th>
										<th class="ibm-numeric" scope="col">Total tickets</th>
										<th class="ibm-numeric" scope="col">Closed tickets</th>
										<th class="ibm-numeric" scope="col">Open tickets</th>
									</tr>
								</thead>
								<tbody>
						    	<% 
						    	   TicketCategoryBean ticketCategoryBean = null;
						    	   for(int i = 0; i < ticketCategoryBeans.size() ; i++) {
						    	   ticketCategoryBean = ticketCategoryBeans.get(i);
						    	%>
									<tr>
										<th class="ibm-table-row" scope="row"><%=ticketCategoryBean.getCategory()%></th>
										<td class="ibm-numeric"><%=ticketCategoryBean.getTotalTickets()%></td>
										<td class="ibm-numeric"><%=ticketCategoryBean.getClosedTickets()%></td>
										<td class="ibm-numeric"><a href="processticketcategory.wss?adminsite=<%=ticketCategoryBean.getAdminSite()%>&category=<%=ticketCategoryBean.getCategory()%>"><%=ticketCategoryBean.getOpenTickets()%></a></td>
									</tr>
								<%}%>
								</tbody>
								</table>
					    	</div>
				    	<%}%>
						<%if(ticketCategoryBeans.size() == 0) {%>
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