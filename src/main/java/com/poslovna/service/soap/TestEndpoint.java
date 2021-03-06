package com.poslovna.service.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.poslovna.service.PrenosService;
import com.poslovna.ws.GetTestDataRequest;
import com.poslovna.ws.GetTestDataResponse;

@Endpoint
public class TestEndpoint {

	private static final String NAMESPACE_URI = "http://www.poslovna.com/webservices";
	
	private PrenosService prenosService;
	private TestRepo testRepo;
	
	@Autowired
	public TestEndpoint(TestRepo testRepo, PrenosService prenosService) {
		this.testRepo = testRepo;
		this.prenosService = prenosService;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTestDataRequest")
	@ResponsePayload
	public GetTestDataResponse getTest(@RequestPayload GetTestDataRequest request) {
		GetTestDataResponse response = new GetTestDataResponse();
		response.setTestData(testRepo.getOneTest(request.getIndexOfTestData()));
		return response;
	}
	
	
}
