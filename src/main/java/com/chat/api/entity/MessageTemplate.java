package com.chat.api.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="convoDetails")
public class MessageTemplate {

	@Id
	private String id;
	private String convoKey;
	private String user;
	private String toUser;
	private String message;
	private Date date;
	private boolean lastSeen;

	public boolean isLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(boolean lastSeen) {
		this.lastSeen = lastSeen;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
		return "MessageTemplate [id=" + id + ", convoKey=" + convoKey + ", user=" + user + ", toUser=" + toUser
				+ ", message=" + message + ", date=" + date + ", lastSeen=" + lastSeen + "]";
	}

}
