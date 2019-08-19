package cn.xinxing.json.core;

import java.util.Date;   

import cn.xinxing.json.status.StatusObject;

/**
 *响应基类
 */
public class AbstractJsonObject {

	private String code;//响应状态码，项目中接口的运行状态，成功时会设置为“OK
	
	private String msg;//响应状态描述
	

	private Long time = new Date().getTime();//时间戳

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}   

	public void setContent(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void setStatusObject(StatusObject statusObject) {
		this.code = statusObject.getCode();
		this.msg = statusObject.getMsg();
	}
}
