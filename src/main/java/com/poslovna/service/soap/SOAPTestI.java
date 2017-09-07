package com.poslovna.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

public interface SOAPTestI {

	List<String> getTestData();

}