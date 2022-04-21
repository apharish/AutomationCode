import org.testng.Assert;
import org.testng.annotations.Test;

import Apipayloadfiles.AddApiPayload;
import io.restassured.path.json.JsonPath;

public class ContinuereadingComplesJson {
	
	
	@Test
	public void sumValidatio() {
		
		int totalSum = 0;
		JsonPath js = new JsonPath(AddApiPayload.getCoursePriceJson());
		
		//Print the number of Courses present the Json
		int noOfCourses = js.getInt("courses.size()");
		
		//Print all course title and respective prices
				for(int i = 0; i<noOfCourses; i++) {
					int cousestitle = js.getInt("courses["+i+"].copies");
					int coursePrize = js.getInt("courses["+i+"].price");
					totalSum= totalSum + cousestitle*coursePrize;
				}
				
				System.out.println("totalSum ::" + totalSum);
				int purchaseAmount = js.getInt("dashboard.purchaseAmount");
				System.out.println("purchaseAmount ::" + purchaseAmount);
				Assert.assertEquals(totalSum, purchaseAmount);
				
		
	}

}
