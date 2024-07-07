package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class GetandPostExamples {
  
  @Test
  public  void testGet() {
	  
	  given().
	   baseUri("https://reqres.in/api").
	  when().
	   get("/users?page=2").
	  then().
	   statusCode(200).
	   body("data[4].first_name", equalTo("George"));
  }
  
  @Test
  public void testPost() {
	 
	  Map<String, Object> map = new HashMap<String, Object>();
	  JSONObject request = new JSONObject();
	  
	  request.put("name", "Raghav");
	  request.put("job", "teacher");
	  
	  baseURI = "https://reqres.in/api";
	  
	  given().
	   header("Content-Type", "application.json").
	   contentType(ContentType.JSON).
	   accept(ContentType.JSON).
	   body(request.toJSONString()).
	  when().
	   post("/users").
	  then().
	   statusCode(201).log().all();
  }
}
