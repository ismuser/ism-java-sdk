/*
* Ismuser Java SDK
* http://www.ismuser.com/
*
* Copyright 2013, Ismuser.
*
*/

package com.ismuser.sdk;

public class IsmuserRoom {

	public String roomID;

	public IsmuserRoom(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomId() {
		return this.roomID;
	}
}