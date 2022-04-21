package JavaStreamProject;

import java.io.File;
import java.nio.file.Paths;

import org.testng.Assert;

public class DirectoryPathReader {
	
	public static void main(String[] args) {
		
		getCurrentWorkinghomeDirectory();
		getCurrentWorkingDirectory();
		getCurrentWorkingDirectory2();
		getCurrentWorkingDirectory3();
		goToCustomPathDirectory("\\eclipse-workspace\\AutomationProject");
		
		checkTheExistanceOfFilesInDirectoy("\\AutomationSetup\\FilecheckFolder\\harish.txt");
		
	}
	
	public static void getCurrentWorkingDirectory() {
		//to fetch the current working directory
				String userDirectory = System.getProperty("user.dir");
				System.out.println(userDirectory);
		
	}
	public static String goToCustomPathDirectory(String pathToAppend) {
		//to fetch the current working directory
				String userDirectory = System.getProperty("user.home");
				String path = userDirectory+ pathToAppend;
				
				return path;
		
	}
	
	public static void getCurrentWorkinghomeDirectory() {
		//to fetch the current working directory
				String userDirectory = System.getProperty("user.home");
				System.out.println(userDirectory);
		
	}
	
	public static void getCurrentWorkingDirectory2() {
		//to fetch the current working directory
				String userDirectory = Paths.get("").toAbsolutePath().toString();
				System.out.println(userDirectory);
		
	}
	
	public static void getCurrentWorkingDirectory3() {
		//to fetch the current working directory
				String userDirectory = new File("").getAbsolutePath();
				System.out.println(userDirectory);
		
	}
	
	public static void checkTheExistanceOfFilesInDirectoy(String pathOfTheFiles) {
		//to check whether file is exist in given path or not
			File files=new File(System.getProperty("user.home")+pathOfTheFiles);
			Assert.assertTrue(files.exists(),"Given File is not exist in directory");
		
	}
	

}
