package com.chat.api.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="convoDetails")
public class MessageTemplate {

	private String convoKey;
	private String user;
	private String message;
	private Date date;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
