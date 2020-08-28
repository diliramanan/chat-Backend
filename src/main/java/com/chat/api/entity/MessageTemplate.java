package com.chat.api.entity;

public class MessageTemplate {

	private String user;
	private String message;
	private String convoKey;

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getConvoKey() {
		return convoKey;
	}
	public void setConvoKey(String convoKey) {
		this.convoKey = convoKey;
	}
	@Override
	public String toString() {
		return "Message [user=" + user + ", message=" + message + ", convoKey=" + convoKey + "]";
	}

}
