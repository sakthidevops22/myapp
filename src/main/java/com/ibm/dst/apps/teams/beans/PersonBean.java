package com.ibm.dst.apps.teams.beans;

public class PersonBean {
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = (name != null) ? name : "";
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = (email != null) ? email : "";
	}
	/**
	 * @return the officeNumber
	 */
	public String getOfficeNumber() {
		return officeNumber;
	}
	/**
	 * @param officeNumber the officeNumber to set
	 */
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = (officeNumber != null) ? officeNumber : "";
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = (mobileNumber != null) ? mobileNumber : "";
	}
	/**
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = (skill != null) ? skill : "";
	}
	/**
	 * @return the primaryJRSS
	 */
	public String getPrimaryJRSS() {
		return primaryJRSS;
	}
	/**
	 * @param primaryJRSS the primaryJRSS to set
	 */
	public void setPrimaryJRSS(String primaryJRSS) {
		this.primaryJRSS = (primaryJRSS != null) ? primaryJRSS : "";
	}
	/**
	 * @return the subProjName
	 */
	public String getSubProjName() {
		return subProjName;
	}
	/**
	 * @param subProjName the subProjName to set
	 */
	public void setSubProjName(String subProjName) {
		this.subProjName = (subProjName != null) ? subProjName : "";
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = (country != null) ? country : "";
	}
	
	String name;
	String email;
	String officeNumber;
	String mobileNumber;
	String skill;
	String primaryJRSS;
	String subProjName;
	String country;
}