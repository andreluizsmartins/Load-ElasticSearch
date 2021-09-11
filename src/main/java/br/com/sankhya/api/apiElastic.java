package br.com.sankhya.api;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class apiElastic {

	public apiElastic() {
		// TODO Auto-generated constructor stub
	}

public static String setDoc(StringBuilder json){
		
		//JSONObject object = new JSONObject(ca.toString()); 
		try {
			HttpResponse<String> response = Unirest.post("http://127.0.0.1:9200/_bulk?pretty")
					.header("Content-Type", "application/json")
					.body(json.toString())
					.asString();
			if(response.getStatus() == 201){
				System.out.println(response.getBody());
				return response.getBody(); 
			}else {
				System.out.println(response.getBody());
				return null;
			}
					
		} catch (UnirestException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return null;
	}
}
