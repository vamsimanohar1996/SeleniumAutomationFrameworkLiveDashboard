package org.personal.elk;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
public class SendResultsToELK {
	
	
	public static void main(String[] args)
	{
		Map<String,String>map=new HashMap<>();
		map.put("testName", "test-java-skip");
		map.put("status", "skip");
		map.put("executionTime", LocalDateTime.now().toString());
		given().header("Content-Type","application/json")
		.body(map)
		.post("http://localhost:9200/suite/result");
	
		
	}

}
