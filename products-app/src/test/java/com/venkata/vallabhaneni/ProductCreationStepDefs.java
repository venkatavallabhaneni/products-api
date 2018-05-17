package com.venkata.vallabhaneni;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.venkata.vallabhaneni.domain.Product;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductCreationStepDefs extends ProductsIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private ResponseEntity<Product> response;

	private String productName;

	@Given("^product name Orrange$")
	public void product_name_Orrange() throws Throwable {
		productName = "Orrange";
	}

	@When("^I call the service create product$")
	public void i_call_the_service_create_product() throws Throwable {

		Product p = new Product();
		p.setName(productName);
		response = restTemplate.postForEntity("/products", p, Product.class);
	}

	@Then("^I should get response with HTTP tatus code (\\d+)$")
	public void i_should_get_response_with_HTTP_tatus_code(int arg1) throws Throwable {

		HttpStatus currentStatusCode = response.getStatusCode();
		assertEquals(currentStatusCode.value(), arg1);

	}

	@Then("^the response should contain the Orrange$")
	public void the_response_should_contain_the_Orrange() throws Throwable {
		if (response != null && response.getStatusCode().is2xxSuccessful()) {
			Product responseBody = response.getBody();
			assertEquals(responseBody.getName(), "Orrange");

		}
	}
	
	@Given("^product name null$")
	public void product_name_null() throws Throwable {
		productName = null;
	}

	@Then("^the response should contain the null$")
	public void the_response_should_contain_the_null() throws Throwable {
		if (response != null ) {
			Product responseBody = response.getBody();
			assertEquals(responseBody.getName(), null);

		}
	}


}
