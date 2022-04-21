import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Apipayloadfiles.AddApiPayload;

public class AddApiDemo {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type" , "application/json")
		.body(AddApiPayload.getAddSampleApi()).when().post("/maps/api/place/add/json")
				.then().log().all().statusCode(200).extract().response().asString();
		
		//Reading Json response
		JsonPath js=new JsonPath(response);
		String placeid=js.getString("place_id");
		
		//update existing address in given API
		String expectedNewAdress = "30, side layout, cohen 09 ,Alur Maddur";
		given().queryParam("key", "qaclick123").header("Content-Type" , "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+expectedNewAdress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		//to validate above change in Address ,lets call get Api to verify Address is updated or not
		String getResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeid )
		.when().get("/maps/api/place/get/json").then().log().all().statusCode(200).assertThat().body("address", equalTo(expectedNewAdress)).extract().response().asString();
		
		//Reading Json response
		JsonPath js1=new JsonPath(getResponse);
		String actualAddress = js1.getString("address");
		Assert.assertEquals(actualAddress, expectedNewAdress ,"Expected address is not changed");
		
		

	}

}
