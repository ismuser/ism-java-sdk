package com.ismuser.sdk;

public class IsmuserSession {

	public String roomID;

	public IsmuserSession(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomId() {
		return this.roomID;
	}
}