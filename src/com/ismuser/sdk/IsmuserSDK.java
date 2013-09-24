/*
* Ismuser Java SDK
* http://www.ismuser.com/
*
* Copyright 2013, Ismuser.
*
*/

package com.ismuser.sdk;

import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.net.URLEncoder;
import java.util.HashMap;

import com.ismuser.exception.IsmuserException;


public class IsmuserSDK {

	protected String api_key;
	protected String api_secret;
	
	public IsmuserSDK(String api_key, String api_secret) {
		this.api_key = api_key;
		this.api_secret = api_secret.trim();
	}
	
	public IsmuserRoom createRoom(RoomProperties properties) throws IsmuserException {

		Map<String, String> params;
		
		if (properties != null)
			params = properties.to_map();
		else
			params = new HashMap<String, String>();
		
		return this.createRoom(params);
	}
	
	
	// Overloaded methods
	public IsmuserRoom createRoom() throws IsmuserException {
		
		return createRoom(new HashMap<String, String>());
	}
	
	public IsmuserRoom createRoom(Map<String, String> params) throws IsmuserException {

		String result =  this.do_request("/room/create", params);

		return new IsmuserRoom(result);
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
