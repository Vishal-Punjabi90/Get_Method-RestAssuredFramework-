package CommonFunction;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class APICommonFunction {

	public static int statusCode(String baseURI, String resource) {
		RestAssured.baseURI=baseURI;
		int statusCode=given().header("Content-Type","application/json").when().get(resource).then().extract().statusCode();
		return statusCode;
	}
	
	public static String responseBody(String baseURI, String resource) {
		RestAssured.baseURI=baseURI;
		String responseBody=given().header("Content-Type","application/json").when().get(resource).then().extract().response().asString();
		return responseBody;
		
	}
}
