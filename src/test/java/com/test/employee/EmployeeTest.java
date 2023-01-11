package com.test.employee;

import com.restassured.dummy.model.EmployeePojo;
import com.test.base.BaseClass;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class EmployeeTest extends BaseClass {

	@Test
	public void getEmployeesTC00() {
		Response responseApi = given().when().get("/employees");

		responseApi.then().statusCode(200).log().all();

	}

	@Test
	public void getEmployeeTC01() {
		Response responseApi = given().pathParam("id", 1).when().get("/employee" + "/{id}");

		responseApi.then().statusCode(200).log().body();

	}

	@Test
	public void postEmployeeTC02() {

		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo.setEmployee_name("Mike");
		employeePojo.setEmployee_salary("2000");
		employeePojo.setEmployee_age("20");
		employeePojo.setId("120");

		Response responseApi = given().body(employeePojo).when().post("/create");
		responseApi.then().statusCode(200).log().body();
	}

	@Test
	public void putEmployeeTC03() {
		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo.setId("21");
		employeePojo.setEmployee_name("John");
		employeePojo.setEmployee_salary("1000");
		employeePojo.setEmployee_age("26");

		Response responseApi = given().pathParam("id", 21).body(employeePojo).when().put("/update" + "/{id}");
		responseApi.then().statusCode(200).log().body();
	}

	@Test
	public void deleteEmployeeTC04() {
		Response responseApi = given().pathParam("id", 2).when().delete("/delete" + "/{id}");
		responseApi.then().statusCode(200).log().body();
	}

}
