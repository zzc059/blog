package com.chenbo.domain;
/**
 * @author 11366
 * 这个类封装了需要返回的信息，状态码，信息和实体类数据
 */
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class RestResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int LOGIN_FAIL = -1;
	public static int USERNAME_EXIST = 1;
	public static int EMAIL_EXIST = 3;
	public static int PHONE_EXIST = 4;
	public static int PASSWORD_UPLOAD_FAIL = 2;
	private int code;  //状态码
    private String message;   //返回信息
    private Object data;//返回的数据
    private Object flag;//返回的辅助标志，不同的时候返回的类型不同
	private Object id;
	private Object helper;
	private Object page;
    public final static int SUCCESS = 200;
    public final static int FAIL = 400;
    public RestResult(){

    }

    public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public RestResult(int code) {
		super();
		this.code = code;
	}
	public RestResult(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public RestResult(int code, String message, Object data, Object flag) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.flag = flag;
	}
	public Object getFlag() {
		return flag;
	}
	public void setFlag(Object flag) {
		this.flag = flag;
	}
	public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) { //这个地方注意返回值
        this.message = message;
        return this;
    }

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	public Object getHelper() {
		return helper;
	}

	public void setHelper(Object helper) {
		this.helper = helper;
	}

	public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }

	@Override
	public String toString() {
		return "RestResult{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				", flag=" + flag +
				", id=" + id +
				", helper=" + helper +
				'}';
	}
}
