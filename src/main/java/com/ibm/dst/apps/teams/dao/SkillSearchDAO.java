package com.ibm.dst.apps.teams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.dst.apps.teams.beans.PersonBean;
import com.ibm.dst.apps.common.AppConstants;
import com.ibm.dst.fw.util.DatabaseUtil;

public class SkillSearchDAO {
	
	public ArrayList<PersonBean> searchEmployeeSkill(String skill) throws Exception {
		ArrayList<PersonBean> personList = new ArrayList<PersonBean>();		
		Connection con = null; 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DatabaseUtil.getDatabaseConnection(AppConstants.TEAMS_JDBC_INFO);
			stmt = con.prepareStatement("select NAME, MOBILENUMBER, EMAIL, PJRSS_NAME, SUBPROJNAME, SKILLSET from empdet_skilldet where lower(SKILLSET) like ? or lower(NAME) like ? order by NAME ASC");
			stmt.setString(1, "%"+skill.toLowerCase()+"%");
			stmt.setString(2, "%"+skill.toLowerCase()+"%");
			rs = stmt.executeQuery();
			PersonBean person = null;
			while (rs.next()) {
				person = new PersonBean();
				person.setName(rs.getString("NAME"));
				person.setMobileNumber(rs.getString("MOBILENUMBER"));
				person.setEmail(rs.getString("EMAIL"));
				person.setPrimaryJRSS(rs.getString("PJRSS_NAME"));
				person.setSubProjName(rs.getString("SUBPROJNAME"));
				person.setSkill(rs.getString("SKILLSET"));
				personList.add(person);
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
		return personList;		
	}

}
