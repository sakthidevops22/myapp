package com.ibm.dst.fw;

public class ActionError
{

	private String errorCode = null;
	private String errorMessage = null;
	private String errorNlsKey = null;
	
	public ActionError()
	{
		super();
	}
	public ActionError(String code)
	{
		super();
		errorCode =code;
	}
	public ActionError(String code,String errorMsg)
	{
		this(code);
		errorMessage= errorMsg;
	}
	public ActionError(String code,String errorMsg,String nlsKey)
	{
		this(code,errorMsg);
		errorNlsKey= nlsKey;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode()
	{
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage()
	{
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorNlsKey
	 */
	public String getErrorNlsKey()
	{
		return errorNlsKey;
	}
	/**
	 * @param errorNlsKey the errorNlsKey to set
	 */
	public void setErrorNlsKey(String errorNlsKey)
	{
		this.errorNlsKey = errorNlsKey;
	}
	
	
}
