package com.ibm.dst.apps.ticketing.beans;

public class TicketCategoryBean {
	String openTickets;
	String closedTickets;
	String totalTickets;
	String category;
	String adminSite;
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the adminSite
	 */
	public String getAdminSite() {
		return adminSite;
	}
	/**
	 * @param adminSite the adminSite to set
	 */
	public void setAdminSite(String adminSite) {
		this.adminSite = adminSite;
	}
	/**
	 * @return totalTickets
	 */
	public String getTotalTickets() {
		return totalTickets;
	}
	/**
	 * @param totalTickets the totalTickets to set
	 */
	public void setTotalTickets(String totalTickets) {
		this.totalTickets = totalTickets;
	}
	/**
	 * @return the openTickets
	 */
	public String getOpenTickets() {
		return openTickets;
	}
	/**
	 * @param openTickets the openTickets to set
	 */
	public void setOpenTickets(String openTickets) {
		this.openTickets = openTickets;
	}
	/**
	 * @return the closedTickets
	 */
	public String getClosedTickets() {
		return closedTickets;
	}
	/**
	 * @param closedTickets the closedTickets to set
	 */
	public void setClosedTickets(String closedTickets) {
		this.closedTickets = closedTickets;
	}
}