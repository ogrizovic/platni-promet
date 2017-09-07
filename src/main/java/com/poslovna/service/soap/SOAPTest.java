package com.poslovna.service.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class SOAPTest extends SpringBeanAutowiringSupport implements SOAPTestI {

	public SOAPTest() {
		// TODO Auto-generated constructor stub
	}
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
