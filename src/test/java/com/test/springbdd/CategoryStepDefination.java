package com.test.springbdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoryStepDefination {
	
	@Autowired
	private MockMvc mvc;
	
	ResultActions action;
	
	@When("the client calls \\/getCategory")
	public void the_client_calls_getCategory() throws Exception {
		action=mvc.perform(get("/getCategory").contentType(MediaType.APPLICATION_JSON));
	}

	@Then("the client receives status code of {int} for category")
	public void the_client_receives_status_code_of_for_category(Integer int1) throws Exception {
		action.andExpect(status().isOk());
	}

	@Then("the client receives category with name")
	public void the_client_receives_category_with_name() throws Exception {
		action.andExpect(jsonPath("name", Matchers.is("Men")));
	}
}
