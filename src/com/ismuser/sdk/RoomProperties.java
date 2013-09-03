/*
* Ismuser Java SDK
* http://www.ismuser.com/
*
* Copyright 2013, Ismuser.
*
*/

package com.ismuser.sdk;

import java.util.*;

public class RoomProperties {
	
	// Ismuser modules
	Boolean videoconference_mod = false;
	Boolean magicboard_mod = false;
	Boolean chat_mod = false;
	
	// Debug mode
	Boolean debug = false;
	
	public void activateVideoconference() {
		this.videoconference_mod = true;
	}
	
	public void activateMagicBoard() {
		this.magicboard_mod = true;
	}
	
	public void activateChat() {
		this.chat_mod = true;
	}
	
	public void activateDebugMode() {
		this.debug = true;
	}
	
	public Map<String, String> to_map() {
		Map<String, String> m = new HashMap<String, String>();
		
		if (this.videoconference_mod != null)
			m.put("videoconference_mod", this.videoconference_mod.toString());
		if (this.magicboard_mod != null)
			m.put("magicboard_mod", this.magicboard_mod.toString());
		if (this.chat_mod != null)
			m.put("chat_mod", this.chat_mod.toString());
		if (this.debug != null)
			m.put("debug", this.debug.toString());
		
		return m;
	}
}
