package com.charter.poc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpClientPost {

	public static void main(String[] args) {

	  try {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost(
			"http://localhost:8080/CharterPOC/api/deviceComparison/");

		//StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
		StringEntity input1 = new StringEntity("{\"macId\":null,\"cmMacAddress\":null,\"type\":\"Network\",\"ownerId\":null,\"profile\":null,\"model\":null,"
				+ "\"portMap\":null,\"status\":null}");
		
		//StringEntity input2 = new StringEntity("{\"macId\":null,\"cmMacAddress\":null,\"type\":\"Network\",\"ownerId\":null,\"profile\":null,\"model\":null,"
				//+ "\"portMap\":null,\"status\":null}");
		input1.setContentType("application/json");
		
		//input2.setContentType("application/json");
		postRequest.setEntity(input1);
		//postRequest.setEntity(input2);

		HttpResponse response = httpClient.execute(postRequest);

		if (response.getStatusLine().getStatusCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		httpClient.getConnectionManager().shutdown();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

	}

}