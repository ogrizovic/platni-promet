//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.05 at 09:36:04 PM CEST 
//


package com.poslovna.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="testData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "testData"
})
@XmlRootElement(name = "getTestDataResponse")
public class GetTestDataResponse {

    @XmlElement(required = true)
    protected String testData;

    /**
     * Gets the value of the testData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestData() {
        return testData;
    }

    /**
     * Sets the value of the testData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestData(String value) {
        this.testData = value;
    }

}
