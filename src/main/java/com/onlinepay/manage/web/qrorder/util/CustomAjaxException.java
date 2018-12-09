/**
 * 自定义异常
 */
package com.onlinepay.manage.web.qrorder.util;

public class CustomAjaxException extends Exception{

	private static final long serialVersionUID = 1482885737377502518L;

	//异常信息
	private String message;
	
	/**
	 * 
	* @param message
	 */
	public CustomAjaxException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
