package com.ismuser.test;

import com.ismuser.sdk.API_Config;
import com.ismuser.sdk.IsmuserSDK;
import com.ismuser.exception.IsmuserException;

public class mainTest {

	public static void main(String[] args) throws IsmuserException {
		
		System.out.print("Creating Ismuser SDK object.\n");
		IsmuserSDK sdk = new IsmuserSDK(API_Config.API_KEY, API_Config.API_SECRET);
		
		System.out.print("Let's send a request for creating a new room.\n");
		System.out.print("If everything goes fine, we'll receive the roomID token.\n");
		
		String roomID = sdk.createRoom().getRoomId();
		
		System.out.print("roomID received: " + roomID);
		
		System.out.print("This roomID must be used in Ismuser JavaScript API.");
	}

}
