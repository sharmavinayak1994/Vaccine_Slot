package com.java.practice;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */

public class Main {
    public static List<String> processData(ArrayList<String> array) {
    	HashMap<String, String> versionLatest = new HashMap<String, String>();
        List<String> retVal = new ArrayList<String>();
        for (int i = 0; i < array.size(); i++) {
			array.set(i,array.get(i).replaceAll("\\s", ""));
			String[] arr = array.get(i).split(",");
			if (versionLatest.get(arr[1]) != null) {
				String s = versionLatest.get(arr[1]);
				s = s.substring(s.lastIndexOf('v')+1, s.length());
				int existing = Integer.parseInt(s);
				String s2 = arr[2].substring(arr[2].lastIndexOf('v')+1, arr[2].length());
				int later = Integer.parseInt(s2);
				if(existing > later){
					if(!retVal.contains(arr[0])) {
						retVal.add(arr[0]);
					}
				}else if(existing == later){
					continue;
				}else {
					String temp = versionLatest.get(arr[1]).substring(0, versionLatest.get(arr[1]).lastIndexOf('v'));
					if(!retVal.contains(temp)) {
						retVal.add(temp);
					}
					versionLatest.put(arr[1], arr[0].concat(arr[2]));
					
				}
			}else {
				versionLatest.put(arr[1], arr[0].concat(arr[2]));
			}
		}
       return retVal;
    }
    
public Main() {
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
	Main.processData(strList);
	for(int i=0;i<strList.size(); i++) {
		strList.get(i);
	}	
}
}
