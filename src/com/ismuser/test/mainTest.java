/*
* Ismuser Java SDK
* http://www.ismuser.com/
*
* Copyright 2013, Ismuser.
*
*/

package com.ismuser.test;

import com.ismuser.sdk.API_Config;
import com.ismuser.sdk.RoomProperties;
import com.ismuser.sdk.IsmuserSDK;
import com.ismuser.exception.IsmuserException;

public class mainTest {

	public static void main(String[] args) throws IsmuserException {
		
		// Creating Ismuser SDK object.
		IsmuserSDK sdk = new IsmuserSDK(API_Config.API_KEY, API_Config.API_SECRET);
		
		// Setting up our room's properties
		RoomProperties rp = new RoomProperties();
		
		// Activating Videoconference, MagicBoard and Chat modules
		rp.activateVideoconference();
		rp.activateMagicBoard();
		rp.activateChat();
		
		// Debug
		rp.activateDebugMode();
		
		// Let's send a request for creating a new room.
		// If everything goes fine, we'll receive the roomID token.
		String roomID = sdk.createRoom(rp).getRoomId();
		
		// This roomID must be used in Ismuser JavaScript API.
		System.out.print("roomID received: " + roomID);
	}

}
