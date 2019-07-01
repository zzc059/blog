package com.chenbo.domain;
/**
 * @author 11366
 * 这个类是专门为了保证富文本上传的返回类而建立的
 */
import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class SimpleResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer errno; //错误代码，0 表示没有错误。
    private String[] data; //已上传的图片路径

    
    public SimpleResult(Integer errno, String[] data) {
		super();
		this.errno = errno;
		this.data = data;
	}
	public SimpleResult(String[] data) {
		super();
		this.errno=0;
		this.data = data;
	}
	public SimpleResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getErrno() {
        return errno;
    }
    public void setErrno(Integer errno) {
        this.errno = errno;
    }
    public String[] getData() {
        return data;
    }
    public void setData(String[] data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "WangEditor [errno=" + errno + ", data=" + Arrays.toString(data)
                + "]";
    }

}
