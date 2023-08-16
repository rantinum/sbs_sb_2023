package com.khj.exam.demo.vo;

import lombok.Getter;

public class ResultData {
	@Getter
	private String resultCode;
	@Getter
	private String msg;
	@Getter
	private Object data1;

	private ResultData() {

	}

	public static ResultData from(String reslutCode, String msg, Object data1) {
		ResultData rd = new ResultData();
		rd.resultCode = reslutCode;
		rd.msg = msg;
		rd.data1 = data1;

		return rd;
	}

	public static ResultData from(String resultCode, String msg) {
		return from(resultCode, msg, null);
	}

	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}

	public boolean isFail() {
		return isSuccess() == false;
	}

	public static ResultData newData(ResultData joinRd, Object newData) {
		return from(joinRd.getResultCode(), joinRd.getMsg(), newData);
	}

}