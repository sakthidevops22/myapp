package com.ibm.dst.apps.ticketing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.dst.apps.ticketing.beans.TicketBean;
import com.ibm.dst.apps.ticketing.beans.TicketCategoryBean;
import com.ibm.dst.fw.util.DatabaseUtil;
import com.ibm.dst.apps.common.AppConstants;

public class TicketingDAO {
	
	public ArrayList<TicketCategoryBean> searchTicketsByAdminSite(String search) throws Exception {
		ArrayList<TicketCategoryBean> ticketsCategoryList = new ArrayList<TicketCategoryBean>();		
		Connection con = null; 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DatabaseUtil.getDatabaseConnection(AppConstants.TICKETING_JDBC_INFO);
			stmt = con.prepareStatement(" SELECT OSNAME, ADMINSITE, TOTAL_TICKETS, CLOSED_TICKETS, OPEN_TICKETS FROM" +
										" (SELECT OSNAME, ADMINSITE, TOTAL_TICKETS, CLOSED_TICKETS, TOTAL_TICKETS-CLOSED_TICKETS AS OPEN_TICKETS FROM " +
										" (SELECT  OSNAME, ADMINSITE,  COUNT(DOCNUMBER) AS TOTAL_TICKETS, SUM(TICKET_STATUS) AS CLOSED_TICKETS FROM "+
										" (SELECT OS.OSNAME as OSNAME , LSS.DOCNUMBER as DOCNUMBER, SR.ADMINSITE AS ADMINSITE, CASE WHEN " +
										" SR.DATECLOSED IS NULL THEN '0' ELSE '1' END AS TICKET_STATUS "+
										" FROM OPERATINGSYSTEM OS "+ 
										" JOIN LOGICALSERVER LS ON OS.OSID = LS.SERVEROS "+ 
										" JOIN LOGICALSERVERSERVICEREQUESTMAPPER LSS ON LS.LSID = LSS.LSID "+
										" JOIN SERVICEREQUEST SR ON LSS.ID = SR.GUID "+
										" JOIN PEMPLOYEEDATA ED ON ED.EID = SR.ASSIGNEDTO"+
										" WHERE LOWER(SR.ADMINSITE) LIKE ? )"+
										" GROUP BY OSNAME,ADMINSITE "+
										" ) ) WHERE OPEN_TICKETS > 2 ");
			stmt.setString(1, "%"+search.toLowerCase()+"%");
			rs = stmt.executeQuery();
			TicketCategoryBean ticketCategoryBean = null;
			while (rs.next()) {
				ticketCategoryBean = new TicketCategoryBean();
				ticketCategoryBean.setCategory(rs.getString("OSNAME"));
				ticketCategoryBean.setAdminSite(rs.getString("ADMINSITE"));
				ticketCategoryBean.setTotalTickets(rs.getString("TOTAL_TICKETS"));
				ticketCategoryBean.setClosedTickets(rs.getString("CLOSED_TICKETS"));
				ticketCategoryBean.setOpenTickets(rs.getString("OPEN_TICKETS"));
				ticketsCategoryList.add(ticketCategoryBean);
			}
		} 
		catch(Exception e){
			throw e;
		}
		finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return ticketsCategoryList;		
	}

	public ArrayList<TicketBean> searchTicketsByCategory(String adminSite, String category) throws Exception {
		ArrayList<TicketBean> ticketsList = new ArrayList<TicketBean>();		
		Connection con = null; 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DatabaseUtil.getDatabaseConnection(AppConstants.TICKETING_JDBC_INFO);
			stmt = con.prepareStatement("SELECT  NAME, OSNAME, ADMINSITE, TOTAL_TICKETS, CLOSED_TICKETS, OPEN_TICKETS FROM " +
							" (SELECT  NAME, OSNAME, ADMINSITE, TOTAL_TICKETS, CLOSED_TICKETS, TOTAL_TICKETS-CLOSED_TICKETS " +
							" AS OPEN_TICKETS FROM " +
							" (SELECT  NAME, OSNAME, ADMINSITE,  COUNT(DOCNUMBER) AS TOTAL_TICKETS, SUM(TICKET_STATUS) AS CLOSED_TICKETS FROM " +
							" (SELECT OS.OSNAME as OSNAME , LSS.DOCNUMBER as DOCNUMBER, ED.NAME AS NAME,  SR.ADMINSITE AS ADMINSITE, " +
							" CASE WHEN SR.DATECLOSED IS NULL THEN '0' ELSE '1' END AS TICKET_STATUS" +
							" FROM OPERATINGSYSTEM OS "+
							" JOIN LOGICALSERVER LS ON OS.OSID = LS.SERVEROS " + 
							" JOIN LOGICALSERVERSERVICEREQUESTMAPPER LSS ON LS.LSID = LSS.LSID " +
							" JOIN SERVICEREQUEST SR ON LSS.ID = SR.GUID " +
							" JOIN PEMPLOYEEDATA ED ON ED.EID = SR.ASSIGNEDTO " +
							" WHERE LOWER(SR.ADMINSITE) LIKE ? AND LOWER(OSNAME) = ? )"+
							" GROUP BY OSNAME, ADMINSITE, NAME "+
							" ) ) WHERE OPEN_TICKETS > 0 " ) ;
			stmt.setString(1, "%"+adminSite.toLowerCase()+"%");
			stmt.setString(2, category.toLowerCase());
			rs = stmt.executeQuery();
			TicketBean ticketBean = null;
			while (rs.next()) {
				ticketBean = new TicketBean();
				ticketBean.setAdminSite("ADMINSITE");
				ticketBean.setCategory("OSNAME");
				ticketBean.setAdminName(rs.getString("NAME"));
				ticketBean.setTotalTickets(rs.getString("TOTAL_TICKETS"));
				ticketBean.setOpenTickets(rs.getString("OPEN_TICKETS"));
				ticketBean.setClosedTickets(rs.getString("CLOSED_TICKETS"));
				ticketsList.add(ticketBean);
			}
		} 
		catch(Exception e){
			throw e;
		}
		finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return ticketsList;		
	}

}
