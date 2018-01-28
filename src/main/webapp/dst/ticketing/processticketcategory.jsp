<%@ page import="java.util.ArrayList,com.ibm.dst.apps.ticketing.beans.TicketBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<TicketBean> ticketBeans  = (ArrayList<TicketBean>) request.getAttribute("tickets_bean");
	String adminSite = (String)request.getAttribute("adminsite");
	String category = (String)request.getAttribute("category");
%>	
<div id="ibm-pcon">
	<div id="ibm-content">
		<div id="ibm-content-body">
			<div id="ibm-content-main">
				<div class="ibm-columns">
				    <form method="post" action="processticketcategory.wss">
					<div class="ibm-col-1-1">
				        <p>
					     <label for="adminsite">Admin site: <%=adminSite%></label>
					     <br />
					     <label for="os">OS: <%=category%></label>
						 <br />
				    	</p>
				    	<% 
				    	   TicketBean ticketBean = null;
				    	   for(int i = 0; i < ticketBeans.size() ; i++) {
				    	   ticketBean = ticketBeans.get(i);
				    	%>
								<div class="ibm-container ibm-show-hide ibm-alternate">
									<h2><a class="" href="#show-hide"><%=ticketBean.getAdminName()%></a></h2>
									<div style="overflow: hidden; display: none; height: 1px;" class="ibm-container-body">
										<ul>
											<li>Total tickets	: <%=ticketBean.getTotalTickets()%></li>
											<li>Open tickets	: <%=ticketBean.getOpenTickets()%></li>
											<li>Closed tickets  	: <%=ticketBean.getClosedTickets()%></li>
										</ul>
									</div>
								</div>		
							<%}%>
						<%if(ticketBeans.size() == 0) {%>
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