/*
* Ismuser Java SDK
* http://www.ismuser.com/
*
* Copyright 2013, Ismuser.
*
*/

package com.ismuser.sdk;

import java.util.*;
import java.net.*;
import java.io.*;

class IsmuserConnection {
	
	public String request(String reqString, Map<String, String> paramList, Map<String, String> headers) {
		
		StringBuilder returnString = new StringBuilder();
		
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		OutputStreamWriter wr = null;
		BufferedWriter bufWriter = null;
		
		try {
			StringBuilder dataString = new StringBuilder();
			
			url = new URL(reqString);
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Content-Length", Integer.toString(dataString.toString().length()));
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("Accept", "text/html, application/xhtml+xml,application/xml");
			
			// Writing headers
			for (Iterator<String> i = headers.keySet().iterator(); i.hasNext();) {
				String key = i.next();
				String value = headers.get(key);
				conn.setRequestProperty(key, value);
			}
			
			// Writing room properties
			if (paramList != null) {
				for (Iterator<String> i = paramList.keySet().iterator(); i.hasNext();) {
					String key = i.next();
					String value = paramList.get(key);
					conn.setRequestProperty(key, value);
				}
			}
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF8"));
			
			String str;
			while ((str = br.readLine()) != null) {
				returnString.append(str);
				returnString.append("\n");
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.disconnect();
				if (wr != null) wr.close();
				if (br != null) br.close();
				if (bufWriter != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return returnString.toString();
	}
}
