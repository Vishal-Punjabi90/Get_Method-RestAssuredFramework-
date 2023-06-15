package CommonFunction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.AfterTest;

public class Utilitycommonfunction {
	@AfterTest
	public static void evidencefilecreator(String filename, String responseBody) throws IOException {
		File newfile=new File("E:\\New folder\\"+filename+".txt");
		System.out.println("A new file created"+newfile.getName());
		FileWriter datawrite=new FileWriter(newfile);
		datawrite.write("Response Body:"+responseBody);
		System.out.println("response body is recorded in"+newfile.getName());
	}
	
}
