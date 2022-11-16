package restassuredtesting;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
public class RestAssuredTesting
{
	public static String baseurl="http://rest-api.upskills.in/";
	public static String accesstoken;
	@Test(priority = 0,enabled=true)
	public void gettoken()
	{
		RestAssured.baseURI=baseurl;
		//String Authorization="Basic c2hvcHBpbmdfb2F1dGhfY2xpZW50OnNob3BwaW5nX29hdXRoX3NlY3JldA==";
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Basic c2hvcHBpbmdfb2F1dGhfY2xpZW50OnNob3BwaW5nX29hdXRoX3NlY3JldA==")
				.when().post("api/rest/oauth2/token/client_credentials")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		   String jsonresponse=response.asString();
		   System.out.println(jsonresponse);
		JsonPath objects=new JsonPath(jsonresponse);
	 accesstoken=objects.getString("data.access_token");
		System.out.println(accesstoken);
	}
	@Test(priority = 1,enabled=false)
	public void register()
	{
		RestAssured.baseURI=baseurl;
		String requestbody="{\r\n"
				+ "  \"firstname\": \"remo\",\r\n"
				+ "  \"lastname\": \"User\",\r\n"
				+ "  \"email\": \"Rk34567@gmail.com\",\r\n"
				+ "  \"password\": \"Rk@123\",\r\n"
				+ "  \"confirm\": \"Rk@123\",\r\n"
				+ "  \"telephone\": \"1-541-754-3010\",\r\n"
				+ "  \"customer_group_id\": \"1\",\r\n"
				+ "  \"agree\": \"1\",\r\n"
				+ "  \"custom_field\": {\r\n"
				+ "    \"account\": {\r\n"
				+ "      \"1\": \"+364545454\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}\r\n";
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken).body(requestbody)
				.when().post("api/rest/register")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		  String jsonresponse =response.asString();
		  System.out.println(jsonresponse);
}
	@Test(priority = 2)
	public void login()
	{
		RestAssured.baseURI=baseurl;
		String requestbody="{\r\n"
				+ "  \"email\": \"Rk34567@gmail.com\",\r\n"
				+ "  \"password\": \"Rk@123\"\r\n"
				+ "}\r\n";
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken).body(requestbody)
				.when().post("api/rest/login")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
			String jsonresponse=response.asString();
			System.out.println(jsonresponse);
	}
	@Test(priority = 3)
	public void logout()
	{
		RestAssured.baseURI=baseurl;
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken)
				.when().post("api/rest/logout")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
			String jsonresponse=response.asString();
			System.out.println(jsonresponse);
	}
	@Test(priority = 4)
	public void forgotpwd()
	{
		RestAssured.baseURI=baseurl;
		String requestbody="{\r\n"
				+ "  \"email\": \"Rk34567@gmail.com\"\r\n"
				+ "}\r\n";
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken).body(requestbody)
				.when().post("api/rest/forgotten")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
		String jsonresponse=response.asString();
		System.out.println(jsonresponse);
	}
	@Test(priority = 5)
	public void login1()
	{
		RestAssured.baseURI=baseurl;
		String requestbody="{\r\n"
				+ "  \"email\": \"Rk34567@gmail.com\",\r\n"
				+ "  \"password\": \"Rk@123\"\r\n"
				+ "}\r\n";
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken).body(requestbody)
				.when().post("api/rest/login")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
			String jsonresponse=response.asString();
			System.out.println(jsonresponse);
	}
	@Test(priority = 6)
	public void getaccountdetails()
	{
		RestAssured.baseURI=baseurl;
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken)
				.when().get("api/rest/account")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
			String jsonresponse=response.asString();
			System.out.println(jsonresponse);
		
	}
	//http://rest-api.upskills.in/api/rest/account
	@Test(priority = 7)
	public void updateaccountdata()
	{
		RestAssured.baseURI=baseurl;
		String requestbody="{\r\n"
				+ "  \"firstname\": \"remo1\",\r\n"
				+ "  \"lastname\": \"User1\",\r\n"
				+ "  \"email\": \"Rk1234@gmail.com\",\r\n"
				+ "  \"telephone\": \"1-541-754-3010\",\r\n"
				+ "  \"custom_field\": {\r\n"
				+ "    \"account\": {\r\n"
				+ "      \"1\": \"+364545454\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}\r\n";
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken).body(requestbody)
				.when().put("api/rest/account")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
			String jsonresponse=response.asString();
			System.out.println(jsonresponse);
	}
	@Test(priority = 8)
	public void getaccountdetails1()
	{
		RestAssured.baseURI=baseurl;
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken)
				.when().get("api/rest/account")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
			String jsonresponse=response.asString();
			System.out.println(jsonresponse);
		
	}
	@Test(priority = 9)
	public void logout1()
	{
		RestAssured.baseURI=baseurl;
		Response response=given().header("Content-Type","application/json")
				.header("Authorization","Bearer "+accesstoken)
				.when().post("api/rest/logout")
				.then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
			String jsonresponse=response.asString();
			System.out.println(jsonresponse);
	}
	
}
