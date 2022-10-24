package br.nkey.mattos.core;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class BaseApiTeste implements Constantes {

@BeforeClass

public static void setup() {
	
	
	RestAssured.baseURI = APP_BASE_URL;
	RestAssured.port = APP_PORT;
	RestAssured.basePath = APP_BASE_PATH;
	
	RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
	reqBuilder.setContentType(APP_CONTENT_TYPE);
	RestAssured.requestSpecification = reqBuilder.build();
	
	ResponseSpecBuilder respSpecBuilder = new ResponseSpecBuilder();
	respSpecBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
	RestAssured.responseSpecification = respSpecBuilder.build();
	
	RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

//
//		Map<String, String> login = new HashMap<String, String>();
//		login.put("email", "dougaq@gmail.com");
//		login.put("password", "D26a01q90");
//
//
//		String TOKEN = given()
//				.body(login)
//				.when()
//				.post("auth/email")
//				.then()
//				//.statusCode(200)
//				.extract().path("accessToken");
//		RestAssured.requestSpecification.header("Authorization", "JWT " + TOKEN); //bearer em apis mais novas

	}



}






