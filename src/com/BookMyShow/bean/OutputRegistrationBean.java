package com.BookMyShow.bean;

public class OutputRegistrationBean {
	private boolean statusFlag;
	public boolean isStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(boolean statusFlag) {
		this.statusFlag = statusFlag;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	private String statusMessage;

}
