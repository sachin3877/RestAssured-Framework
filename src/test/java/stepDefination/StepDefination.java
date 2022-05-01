package stepDefination;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import pojoDeserialization.ResType;
import resource.APIResource;
import resource.TestDataBuild;
import resource.Utilites;

public class StepDefination extends Utilites {
	TestDataBuild data = new TestDataBuild();

	ResponseSpecification res;

	ResType qwer;
	Response response;
	RequestSpecification req1;
	public static String palce_id;

	@Given("Add place payload {string} {string}{string}")
	public void add_place_payload(String string, String string2, String string3) throws Exception {
		req1 = given().spec(requestSpecification()).body(data.addPlacePayload(string, string2, string3));

	}

	@When("user call {string} with the {string} request")
	public void user_call_with_the_request(String resource, String HTTPmethod) {

		APIResource resou = APIResource.valueOf(resource);
		System.out.println(resou.getResource());

		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		if (HTTPmethod.equalsIgnoreCase("post")) {
			response = req1.when().post(resou.getResource()).then().spec(res).extract().response();
		}
		if (HTTPmethod.equalsIgnoreCase("get")) {
			response = req1.when().get(resou.getResource()).then().spec(res).extract().response();
		}

	}

	@Then("the api call got succes with status code {int}")
	public void the_api_call_got_succes_with_status_code(Integer int1) {
		assertEquals(200,response.getStatusCode());
	}

	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String string, String string2) {

		assertEquals(getJson(response, string), string2);

	}

	@Then("verify place_Id creadted maps to {string} using {string}")
	public void verify_place_id_creadted_maps_to_using(String name, String httpmethod) throws Exception {

		palce_id = getJson(response, "place_id");
		req1 = given().spec(requestSpecification()).queryParam("place_id", palce_id);
		user_call_with_the_request(httpmethod, "get");
		String sr1 = getJson(response, "name");
		assertEquals(sr1, name);

	}

@Given("Delete Place Payload")
public void delete_place_payload() throws Exception {
	req1=given().spec(requestSpecification()).body(data.deletePlace(palce_id));
    
}


}
