package src.test.user.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class serviceUtil {

	public MultiValueMap<String, String> requestToMultiValueMap(HttpServletRequest request){
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
	    
	    Enumeration<String> enumber = request.getParameterNames();
	    
	    while (enumber.hasMoreElements()) {
	        String key = enumber.nextElement().toString();
	        String[] values = request.getParameterValues(key);
	        String value=null;
	        if(values.length <= 1 ) {
	        	value = values[0];
	        	map.add(key, value);  
	        }
//	        else
//		        map.add(key, values);  
//	        
	    }
	    
	    return map;
	}
	
	public Map<String, String> requestToHashMap(HttpServletRequest request){
		Map<String, String> map = new HashMap<>();
		
		Enumeration<String> enumber = request.getParameterNames();
		
		while (enumber.hasMoreElements()) {
			String key = enumber.nextElement().toString();
			String[] values = request.getParameterValues(key);
			String value=null;
			if(values.length <= 1 ) {
				value = values[0];
				map.put(key, value);  
			}
//	        else
//		        map.add(key, values);  
//	        
		}
		
		return map;
	}
}
