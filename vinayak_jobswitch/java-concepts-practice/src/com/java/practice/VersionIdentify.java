package com.java.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VersionIdentify {

	public ArrayList<String> processData(List<String> strList) {

		HashMap<String, String> versionLatest = new HashMap<String, String>();
		ArrayList<String> obsolete = new ArrayList<String>();
		for (int i = 0; i < strList.size(); i++) {
			strList.set(i,strList.get(i).replaceAll("\\s", ""));
			String[] arr = strList.get(i).split(",");
			if (versionLatest.get(arr[1]) != null) {
				String s = versionLatest.get(arr[1]);
				s = s.substring(s.lastIndexOf('v')+1, s.length());
				int existing = Integer.parseInt(s);
				String s2 = arr[2].substring(arr[2].lastIndexOf('v')+1, arr[2].length());
				int later = Integer.parseInt(s2);
				if(existing > later){
					if(!obsolete.contains(arr[0])) {
						obsolete.add(arr[0]);
					}
				}else if(existing == later){
					continue;
				}else {
					String temp = versionLatest.get(arr[1]).substring(0, versionLatest.get(arr[1]).lastIndexOf('v'));
					if(!obsolete.contains(temp)) {
						obsolete.add(temp);
					}
					versionLatest.put(arr[1], arr[0].concat(arr[2]));
					
				}
			}else {
				versionLatest.put(arr[1], arr[0].concat(arr[2]));
			}
		}

		return obsolete;
	}
	
	public static void main(String[] args) {
		VersionIdentify version = new VersionIdentify();
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("Mail Server, Authentication Library, v6");
		strList.add("Video Call Server, Authentication Library, v7");
		strList.add("Mail Server, Data Storage Library, v10");
		strList.add("Chat Server, Data Storage Library, v11");
		strList.add("Mail Server, Search Library, v6");
		strList.add("Chat Server, Authentication Library, v8");
		strList.add("Chat Server, Presence Library, v2");
		strList.add("Video Call Server, Data Storage Library, v11");
		strList.add("Video Call Server, Video Compression Library, v3");
		ArrayList<String> list = version.processData(strList);
		int i=0;
		while(i<list.size()) {
			System.out.println(list.get(i));
			i++;
		}
	}

}
