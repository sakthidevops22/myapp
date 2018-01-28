package com.ibm.dst.fw.bean;

import java.io.Serializable;

/**
 * Java bean to hold BLUPAGE individual field records. 
 */
public class BPResultEntry implements Serializable
{

	/**
	 * Required for serialization/de-serialization
	 */
	private static final long serialVersionUID = -4684206865130188981L;
	
	private String name;
	private String[] value;
	
	/**
	 * Default constructor 
	 */
	public BPResultEntry()
	{
		super();
	}
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String[] getValue()
	{
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String[] value)
	{
		this.value = value;
	}
	
	public String getValueString()
	{
		String retValue = null;
		if(value!=null && value.length>0)
		{
			if(value.length==1)
			{
				retValue = value[0];
			}
			else
			{
				StringBuilder strBldr= new StringBuilder();
				for(String valueString: value)
				{
					strBldr.append(valueString).append(",");
				}
				retValue= strBldr.toString();
			}
		}
		return retValue;
	}
	
}
