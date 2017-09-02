package com.poslovna.service.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.poslovna.service.soap.SOAPTestI")
public class SOAPTest implements SOAPTestI {

	/* (non-Javadoc)
	 * @see com.poslovna.service.soap.SOAPTestI#getTestData()
	 */
	@Override
	public List<String> getTestData(){
		List<String> testData = new ArrayList<>();
		testData.add("test1");
		testData.add("test2");
		testData.add("test3");
		
		return testData;
	}
}
