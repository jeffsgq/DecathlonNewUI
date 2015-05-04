package sendmail;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class nc_desktop {
	public static WebDriver driver;

	public static void screenshot(String filename) {	
		String currentPath = System.getProperty("user.dir"); // 获取用户当前路径
		driver = new FirefoxDriver();
		String url = "file:///" + currentPath
				+ "/test-output/Index_Report.html";
		driver.get(url);
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("save snapshot path is:" + currentPath + "\\"
					+ filename);
			FileUtils
					.copyFile(scrFile, new File(currentPath + "\\" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		}
		System.out.println("screen shot finished");
	}

	 public static String getName1() {
	 driver.switchTo().frame("navigation");
	 driver.findElement(By.xpath("/html/body/div[3]/div")).click();
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame("content");
	 String Name1 = driver.findElement(
	 By.xpath("//table[@class='testMethodsTable']/tbody/tr[2]/td[1]/a"))
	 .getText();
	 return Name1;
	 }
	
	 public static String getName2() {
//	 driver.switchTo().frame("navigation");
//	 driver.findElement(By.xpath("/html/body/div[3]/div")).click();
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame("content");
	 String Name2 = driver.findElement(
	 By.xpath("//table[@class='testMethodsTable']/tbody/tr[5]/td[1]/a"))
	 .getText();
	 return Name2;
	 }
	
//	 public static String getName3() {
////	 driver.switchTo().frame("navigation");
////	 driver.findElement(By.xpath("/html/body/div[3]/div")).click();
//	 driver.switchTo().defaultContent();
//	 driver.switchTo().frame("content");
//	 String Name3 = driver.findElement(
//	 By.xpath("//table[@class='testMethodsTable']/tbody/tr[8]/td[1]/a"))
//	 .getText();
//	 return Name3;
//	 }
	
//	 public static String getName4() {
////	 driver.switchTo().frame("navigation");
////	 driver.findElement(By.xpath("/html/body/div[3]/div")).click();
//	 driver.switchTo().defaultContent();
//	 driver.switchTo().frame("content");
//	 String Name4 = driver.findElement(
//	 By.xpath("//table[@class='testMethodsTable']/tbody/tr[11]/td[1]/a"))
//	 .getText();
//	 return Name4;
//	 }

	public static String getException1() {
//		driver.switchTo().frame("navigation");
//		driver.findElement(By.xpath("/html/body/div[3]/div")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		String e1 = driver.findElement(By.xpath("//table[@class='testMethodsTable']/tbody/tr[2]/td[4]")).getText();
		if (e1.equals(" ")){
			return "Pass";
		}
		else {
			return "No Pass";
		}
	}

	public static String getException2() {
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("navigation");
		// driver.findElement(By.xpath("/html/body/div[3]/div")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		String e2 = driver.findElement(By.xpath("//table[@class='testMethodsTable']/tbody/tr[5]/td[4]")).getText();
		if (e2.equals(" ")){
			return "Pass";
		}
		else {
			return "No Pass";
		}
		}

//	public static String getException3() {
//		driver.switchTo().defaultContent();
////		driver.switchTo().frame("navigation");
//		// driver.findElement(By.xpath("/html/body/div[3]/div")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("content");
//		String e3 = driver.findElement(By.xpath("//table[@class='testMethodsTable']/tbody/tr[8]/td[4]")).getText();
//		if (e3.equals(" ")){
//			return "Pass";
//		}
//		else {
//			return "No Pass";
//		}
//		
//	}
	
//	 public static String getException4() {
////	 driver.switchTo().frame("navigation");
////	 driver.findElement(By.xpath("/html/body/div[3]/div")).click();
//	 driver.switchTo().defaultContent();
//	 driver.switchTo().frame("content");
//	 String e4 = driver.findElement(By.xpath("//table[@class='testMethodsTable']/tbody/tr[11]/td[4]")).getText();
//		if (e4.equals(" ")){
//			return "Pass";
//		}
//		else {
//			return "No Pass";
//		}
//	}
}


