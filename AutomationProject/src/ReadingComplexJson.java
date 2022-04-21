import Apipayloadfiles.AddApiPayload;
import io.restassured.path.json.JsonPath;

public class ReadingComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(AddApiPayload.getCoursePriceJson());
		
		//Print the number of Courses present the Json
		int noOfCourses = js.getInt("courses.size()");
		System.out.println("noOfCourses ::" + noOfCourses);
		
		//Print the Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("purchaseAmount ::" + purchaseAmount);
		
		//Print the 1st Course title
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println("firstCourseTitle ::" + firstCourseTitle);
		
		//Print all course title and respective prices
		for(int i = 0; i<noOfCourses; i++) {
			String cousestitle = js.getString("courses["+i+"].title");
			int coursePrize = js.getInt("courses["+i+"].price");
			System.out.println("cousestitle::" +cousestitle + " & " + "coursePrize::" + coursePrize) ;
		}
		
		//No of copies sold my RPA courses
		for(int i = 0; i<noOfCourses; i++) {
			
			 if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")) {
				 System.out.println("No of Copies sold by RPA::" +js.getString("courses["+i+"].copies"));
				 break;
			 }
		}
		
		//
	}
}
