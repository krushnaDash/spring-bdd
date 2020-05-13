package com.test.springbdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = TestConfiguration.class)
public class ProductStepDefination {
	
	@Autowired
	private MockMvc mvc;
	
	ResultActions action;
	
	
	@When("the client calls \\/getProduct")
	public void the_client_calls_getProduct() throws Exception {
		action=mvc.perform(get("/getProduct").contentType(MediaType.APPLICATION_JSON));
	}
	@Then("the client receives status code of {int}")
	public void the_client_receives_status_code_of(Integer status) throws Exception {
		action.andExpect(status().is(status));
	}

	@Then("the client receives product with name")
	public void the_client_receives_product_with_name() throws Exception {
		action.andExpect(jsonPath("name", Matchers.is("Test")));  
	}
}
