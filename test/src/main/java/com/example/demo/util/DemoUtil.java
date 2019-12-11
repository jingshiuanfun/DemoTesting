package com.example.demo.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class DemoUtil {

	public static Map<String,Object> introspect(Object obj) throws Exception{
		Map<String,Object> result = new LinkedHashMap<>();
		BeanInfo info = Introspector.getBeanInfo(obj.getClass());
		for(PropertyDescriptor pd : info.getPropertyDescriptors()) {
			Method reader = pd.getReadMethod();
			if(reader != null && !pd.getName().equals("class"))
				result.put(pd.getName(), reader.invoke(obj));
		}
		return result;
	}
	
	public static String demoUrl(Map<String, Object> map) {
		
		try {
			StringBuilder x = new StringBuilder();
			if(map != null) {
				
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if (x.length() > 0) {
		                x.append("&");
		            }
		            x.append(String.format("%s=%s",
		                entry.getKey().toString(),
		                entry.getValue().toString()
		            ));
				}

			}
			return x.toString();
		}catch(Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
}
