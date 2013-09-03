package com.ismuser.sdk;

import java.util.*;

public class SessionProperties {
	
	// Ismuser modules
	public Boolean videoconference_mod = null;
	public Boolean magicboard_mod = null;
	public Boolean chat_mod = null;
	
	// Debug mode
	public Boolean debug = null;
	
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
