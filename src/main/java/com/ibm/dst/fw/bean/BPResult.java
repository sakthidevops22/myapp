package com.ibm.dst.fw.bean;

import java.io.Serializable;

/**
 * Java bean to hold the BLUEPAGE output.
 */
public class BPResult implements Serializable
{

	/**
	 * Required for serialization/de-serialization
	 */
	private static final long serialVersionUID = 2240047930364315253L;

	private int code;
	private String message;
	private int count;
	
	/**
	 * Default constructor 
	 */
	public BPResult()
	{
		super();
	}

	/**
	 * @return the code
	 */
	public int getCode()
	{
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code)
	{
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * @return the count
	 */
	public int getCount()
	{
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count)
	{
		this.count = count;
	}
}
