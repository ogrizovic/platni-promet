package com.poslovna.service.soap;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class TestRepo {

	private ArrayList<String> dummyData;
	
	public TestRepo() {
		dummyData = new ArrayList<>();
		dummyData.add("test1");
		dummyData.add("test2");
		dummyData.add("test3");
		dummyData.add("test4");
		
	}
	
	public String getOneTest(int index) {
		return getDummyData().get(index);
	}

	public ArrayList<String> getDummyData() {
		return dummyData;
	}

	public void setDummyData(ArrayList<String> dummyData) {
		this.dummyData = dummyData;
	}
	
	
}
