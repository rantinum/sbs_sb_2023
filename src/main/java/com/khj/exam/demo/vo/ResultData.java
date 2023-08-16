package com.khj.exam.demo.vo;

import lombok.Getter;

public class ResultData<DT> {
	@Getter
	private String resultCode;
	@Getter
	private String msg;
	@Getter
	private DT data1;

	private ResultData() {

	}

	public static <DT> ResultData<DT> from(String reslutCode, String msg, DT data1) {
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

	public static <DT> ResultData<DT> newData(ResultData oldRd, DT newData) {
		return from(oldRd.getResultCode(), oldRd.getMsg(), newData);
	}

}