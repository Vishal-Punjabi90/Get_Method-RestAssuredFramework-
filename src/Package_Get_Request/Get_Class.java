package Package_Get_Request;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunction.APICommonFunction;
import CommonFunction.Utilitycommonfunction;
import PackageReqRepository.ReqRepository;
import io.restassured.path.json.JsonPath;

public class Get_Class {
	@Test
	public static void execute() throws IOException {

		for (int i=0; i<5; i++) 
		{
		int statusCode=APICommonFunction.statusCode(ReqRepository.baseURI(), ReqRepository.resource());
		System.out.println(statusCode);
		
		if (statusCode==200)
		{
		String responseBody=APICommonFunction.responseBody(ReqRepository.baseURI(), ReqRepository.resource());
		System.out.println(responseBody);
		
		Get_Class.validator(responseBody);
		Utilitycommonfunction.evidencefilecreator("GetEvidenceFile", responseBody);
		break;
		}
		else { 
			System.out.println("incorrect status code found hence retrying API again");
		}			
		}
	}
		public static void validator(String responseBody) {
		
		// Step 4: Extract response body.
		JsonPath jspres=new JsonPath(responseBody);
		int datasize=jspres.getList("data").size();
		for (int i=0; i<datasize; i++)
		{
		String res_id=jspres.getString("["+i+"].id");
		String res_name=jspres.getString("["+i+"].name");
		String res_email=jspres.getString("["+i+"].email");
		String res_gender=jspres.getString("["+i+"].gender");
		String res_status=jspres.getString("["+i+"].status");

		Assert.assertNotNull(res_id);
		Assert.assertNotNull(res_name);
		Assert.assertNotNull(res_email);
		Assert.assertNotNull(res_gender);
		Assert.assertNotNull(res_status);
		
		}
}
}