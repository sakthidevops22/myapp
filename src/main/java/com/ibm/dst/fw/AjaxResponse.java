package com.ibm.dst.fw;

import java.io.Serializable;



public class AjaxResponse implements Serializable
{

	/**
	 * Generated serialVersionUID 
	 */
	private static final long serialVersionUID = 4200350559584233129L;
	
	private Object responseData=null;
	private String status = null;
	private String messgae = null;
	
	public AjaxResponse()
	{
		super();
	}

	/**
	 * @return the reponseData
	 */
	public Object getResponseData()
	{
		return responseData;
	}

	/**
	 * @param reponseData the reponseData to set
	 */
	public void setResponseData(Object reponseData)
	{
		this.responseData = reponseData;
	}

	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * @return the messgae
	 */
	public String getMessgae()
	{
		return messgae;
	}

	/**
	 * @param messgae the messgae to set
	 */
	public void setMessgae(String messgae)
	{
		this.messgae = messgae;
	}
	
	public String toJSON()
	{
		StringBuilder strBldr = new StringBuilder();
		if(responseData!=null)
		{
			strBldr.append("{responseData:\"").append(escaseJSON(responseData)).append("\" , ");
			strBldr.append("status:\"").append(status!=null?status:DSTFmwkConstants.AJAX_RESPONSE_ERROR).append("\" ");
			if(messgae!=null)
			{
				strBldr.append(",message:\"").append(messgae).append("\"");
			}
			strBldr.append("}");
		}
		else
		{
			strBldr.append("{responseData:\"\" , ");
			strBldr.append("status:\"").append(status!=null?status:DSTFmwkConstants.AJAX_INVALID_RESPONSE_ERROR).append("\" ");
			if(messgae!=null)
			{
				strBldr.append(",message:\"").append(messgae).append("\"");
			}
			strBldr.append("}");
		}
		
		return strBldr.toString();
	}
	
	private String escaseJSON(Object input)
	{
		if (input != null)
		{
			String objectToReform = input.toString();
			objectToReform = objectToReform.replaceAll("[\\\\]", "\\\\\\\\");
			objectToReform = objectToReform.replaceAll("[\r]", "\\\\r");
			objectToReform = objectToReform.replaceAll("[\n]", "\\\\n");
			objectToReform = objectToReform.replaceAll("[\t]", "\\\\t");
			objectToReform = objectToReform.replaceAll("[\"]", "\\\\\"");
			objectToReform = objectToReform.replaceAll("[\']", "\\\\u0027");// \u0027
			objectToReform = objectToReform.replaceAll("[&]", "\\\\u0026");// \u0026
			objectToReform = objectToReform.replaceAll("[=]", "\\\\u003d");// \u0026
			return objectToReform;
		}
		return "";

	}
}
