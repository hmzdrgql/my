package com.my.im.model;

public class Message {

	private Long id;
	private Integer fromUser;
	private Integer toUser;
	private Integer toGroup;
	private String content;
	private String datetime;
	private String type;
	private Integer offLine;
	private String userPhoto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getFromUser() {
		return fromUser;
	}
	public void setFromUser(Integer fromUser) {
		this.fromUser = fromUser;
	}
	public Integer getToUser() {
		return toUser;
	}
	public void setToUser(Integer toUser) {
		this.toUser = toUser;
	}
	public Integer getToGroup() {
		return toGroup;
	}
	public void setToGroup(Integer toGroup) {
		this.toGroup = toGroup;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getOffLine() {
		return offLine;
	}
	public void setOffLine(Integer offLine) {
		this.offLine = offLine;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", fromUser=" + fromUser + ", toUser=" + toUser + ", toGroup=" + toGroup
				+ ", content=" + content + ", datetime=" + datetime + ", type=" + type + ", offLine=" + offLine
				+ ", userPhoto=" + userPhoto + "]";
	}
	
	
}
