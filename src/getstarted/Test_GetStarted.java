package getstarted;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import screenshot.Screenshot;


public class Test_GetStarted {
    // 申明driver为WebDriver对象
    static WebDriver driver;
    
    // 打开页面的function
    public static void openURL(String url) throws Exception{
	try{
	    // 使用浏览器为火狐浏览器
	    driver = new FirefoxDriver();
	    // 使窗口最大化
	    driver.manage().window().maximize();
	    // 打开网页
	    driver.get(url);
	}catch (Exception e) {
	    // 如果捕获到错误，则截图    
	    Screenshot.snapshot((TakesScreenshot) driver,"Error_OpenBrowser.png");
	    // 退出浏览器
	    driver.quit();
	    // 抛出异常
	throw new Exception();
	}
    }
    
    // 在搜素框中搜索的function
    public static void search() throws Exception{
	try{
	    // 在搜索框输入“跑步鞋”
	    driver.findElement(By.id("search")).sendKeys("跑步鞋");
	    // 点击搜索按钮
	    driver.findElement(By.id("btn-search")).sendKeys(Keys.ENTER); 
	}catch (Exception e) {
	    // 如果捕获到错误，则截图
	    Screenshot.snapshot((TakesScreenshot) driver, "Error_TypeSearchBar.png");
	    // 退出浏览器
	    driver.quit();
	    // 抛出异常
	throw new Exception();
	}
    }
    
    // 退出浏览器的function
    public static void closebrowser() {
	// 退出浏览器
	driver.quit();
    }    
}
