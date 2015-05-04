package selectdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverTools {
	public static WebDriver driver;
	public static String value = BaseLib.getPropertyString("BROWSER_TYPE");
	public WebDriver getDriver() throws InterruptedException {
		String currentPath = System.getProperty("user.dir");
		
		if (value.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					currentPath + "\\driver\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);

			return driver = new InternetExplorerDriver(capabilities);

		} else if (value.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					currentPath + "\\driver\\chromedriver.exe");
			// 如果出现填写防火墙要求 还需测试
			// driver = new ChromeDriver();
			// driver.get("https://gateway.zscaler.net/auT?origurl=http%3A%2F%2Fwww%2egoogle%2ecom%2f");
			// Thread.sleep(3000);
			// driver.findElement(By.xpath("//*[@id='username']")).sendKeys("jshi02");
			// driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12171002");
			// driver.findElement(By.xpath("/html/body/div[1]/div/div/form/button")).click();
			return driver = new ChromeDriver();

		} else {
//			System.setProperty("webdriver.firefox.bin",
//				currentPath +"\\Mozilla Firefox\\firefox.exe");
			return driver = new FirefoxDriver();
		}
	}

	public static int Judge1() {
		int flag = 0;
		if (value.equals("IE")) {
			flag = 1;
			System.out.println("This is IE");
		} else if (value.equals("Chrome")) {
			flag = 2;
			System.out.println("This is Chrome");
		} else {
			flag = 3;
			System.out.println("This is FireFox");
		}
		return flag;
	}
}
