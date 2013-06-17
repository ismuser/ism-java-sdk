package com.ismuser.sdk;

import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.net.URLEncoder;
import java.util.HashMap;

import com.ismuser.exception.IsmuserException;


public class IsmuserSDK {

	protected int api_key;
	protected String api_secret;
	
	public IsmuserSDK(int api_key, String api_secret) {
		this.api_key = api_key;
		this.api_secret = api_secret.trim();
	}
	
	public IsmuserSession createRoom(String location, SessionProperties properties) throws IsmuserException {
		
		// Session properties are under heavy development
		// Right now, properties will always be null
		Map<String, String> params;
		params = new HashMap<String, String>();
		
		return this.createRoom(location, params);
	}
	
	
	// Overloaded methods
	public IsmuserSession createRoom() throws IsmuserException {
		
		return createRoom(null, new HashMap<String, String>());
	}
	
	public IsmuserSession createRoom(String location) throws IsmuserException {
		
		return createRoom(location, new HashMap<String, String>());
	}
	
	public IsmuserSession createRoom(String location, Map<String, String> params) throws IsmuserException {
		
		params.put("location", location);
		String result =  this.do_request("/room/create", params);

		return new IsmuserSession(result);
	}
	
	protected String do_request(String url, Map<String, String> params) throws IsmuserException {
		
		IsmuserConnection n = new IsmuserConnection();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("ism_sdk_auth", this.api_key + ":" + this.api_secret);
		
		return n.request(API_Config.API_URL + url, params, headers);
	}
	
	protected static String join(List<String> s, String delimiter) throws java.io.UnsupportedEncodingException {
		
		if (s.isEmpty()) return "";
		
		Iterator<String> iter = s.iterator();
		StringBuffer buffer = new StringBuffer(URLEncoder.encode(iter.next(), "UTF-8"));
		while (iter.hasNext()) buffer.append(delimiter).append(URLEncoder.encode(iter.next(), "UTF-8"));
		
		return buffer.toString();
	}
}
