package com.poslovna.service.soap;

import javax.xml.ws.Endpoint;

public class ExporterTest {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8089/test1/1", new SOAPTest());
		System.out.println("Exporter is running...");
	}

}
