package com.test.base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {

	@BeforeClass
	public static void initiate() {
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		RestAssured.basePath = "/api/v1";

	}

}
