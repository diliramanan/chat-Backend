package com.chat.api.entity;

public class UnSeenMsg {

	private String fromUser;
	private int count;
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "UnSeenMsg [fromUser=" + fromUser + ", count=" + count + "]";
	}
}
