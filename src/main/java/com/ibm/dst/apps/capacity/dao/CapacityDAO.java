package com.ibm.dst.apps.capacity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.dst.apps.capacity.beans.AvailabilityBean;
import com.ibm.dst.fw.util.DatabaseUtil;
import com.ibm.dst.apps.common.AppConstants;

public class CapacityDAO {
	
	public ArrayList<AvailabilityBean> searchLocationAvailability(String location) throws Exception {
		ArrayList<AvailabilityBean> availabilityList = new ArrayList<AvailabilityBean>();		
		Connection con = null; 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DatabaseUtil.getDatabaseConnection(AppConstants.CAPACITY_JDBC_INFO);
			stmt = con.prepareStatement("select vw_l.location_id as location, vw_r.location_id, vw_l.location_city as city, vw_l.building as building, " +
										" vw_r.name as resource_pool_name, vw_r.available_cpu as cpu, vw_r.available_ram as ram, "+
										" vw_r.available_storage as storage, vw_r.available_ram_color as ram_color, "+
										" vw_r.available_cpu_color as cpu_color, vw_r.available_disk_color as storage_color  "+
										" from capacity.vw_location vw_l, capacity.vw_resource_pool vw_r  "+
										" where vw_r.location_id = vw_l.location_id and lower(location_city) like ?");
			stmt.setString(1, "%"+location.toLowerCase()+"%");
			rs = stmt.executeQuery();
			AvailabilityBean availabilityInfo = null;
			while (rs.next()) {
				availabilityInfo = new AvailabilityBean();
				availabilityInfo.setCity(rs.getString("city"));
				availabilityInfo.setBuilding(rs.getString("building"));
				availabilityInfo.setResource_pool_name(rs.getString("resource_pool_name"));
				availabilityInfo.setAvailable_cpu(rs.getString("cpu"));
				availabilityInfo.setAvailable_ram(rs.getString("ram"));
				availabilityInfo.setAvailable_storage(rs.getString("storage"));
				availabilityInfo.setAvailable_cpu_color(rs.getString("cpu_color"));
				availabilityInfo.setAvailable_ram_color(rs.getString("ram_color"));
				availabilityInfo.setAvailable_storage_color(rs.getString("storage_color"));
				availabilityList.add(availabilityInfo);
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
		return availabilityList;		
	}

}
