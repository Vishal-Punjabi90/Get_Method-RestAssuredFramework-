package PackageReqRepository;
import org.testng.annotations.BeforeTest;

public class ReqRepository {
	@BeforeTest
	public static String baseURI() {
		
		// Step 1: Declare base URL
		String baseURI="https://gorest.co.in/";
		return baseURI;
	}
	 
	public static String resource() {
		
		// Step 2: configure resource
		String resource="/public/v2/users";
		return resource;
	}
}
