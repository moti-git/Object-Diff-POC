package com.charter.poc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.entity.StringEntity;


public class NetClientGet {
	
		// http://localhost:8080/RESTfulExample/json/product/get
		public static void main(String[] args) {

		  try {
 
			URL url = new URL("http://localhost:8080/CharterPOC/api/deviceComparison/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			//StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
			String input1 = "{\"macId\":null,\"cmMacAddress\":null,\"type\":\"Network\",\"ownerId\":null,\"profile\":null,\"model\":null,"
					+ "\"portMap\":null,\"status\":null}";
			
			String input2 = "{\"macId\":null,\"cmMacAddress\":null,\"type\":\"Network\",\"ownerId\":null,\"profile\":null,\"model\":null,"
					+ "\"portMap\":null,\"status\":null}";
			
			OutputStream os = conn.getOutputStream();
			os.write(input1.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }

		}
}

