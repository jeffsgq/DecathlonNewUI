package searchbar;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import screenshot.Screenshot;


public class Test_man_SearchBar {
	public static WebDriver driver;
	// 打开网页，如果出现异常截图
	public static void openurl(String url) throws Exception {
		try {
			System.setProperty("webdriver.firefox.bin",
					"D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize(); // 窗口最大化
			driver.get(url); // 打开网页
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // 设置超时时间
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Search_OpenBrowser.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 在首页搜索框搜索，如果出现异常截图
	public static void typesearchbar() throws Exception {
		try {
			driver.findElement(By.id("search")).clear(); // 清除搜索框
			driver.findElement(By.id("search")).sendKeys("跑步鞋"); // 在搜索框输入“跑步鞋”
			driver.findElement(By.id("btn-search")).click(); // 点击搜索按钮
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Search_TypeSearchBar.png");
			driver.quit();
			throw new Exception();
		}
	}

	// 按条件筛选，如果出现异常截图
	public static void searchshoe() throws Exception {
		try {
			driver.findElement(By.xpath("//a[contains(text(),'跑步')]")).click(); // 点击运动分类中的跑步
			driver.findElement(By.xpath("//a[contains(text(),'男士')]")).click(); // 点击性别分类中的男士
			driver.findElement(By.xpath("//a[contains(text(),'鞋子')]")).click(); // 点击产品类型
																				// 分类中的鞋子
			driver.findElement(By.id("price-from")).click(); // 价格区间--从
			driver.findElement(By.id("price-from")).clear();// 清除价格区间--从
			driver.findElement(By.id("price-from")).sendKeys("0");//价格区间--从的值
			driver.findElement(By.id("price-to")).clear();//价格区间--至
			driver.findElement(By.id("price-to")).sendKeys("100");//价格区间--至的值
			driver.findElement(By.id("btn-range")).click();//点击确定
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Search_SearchShoe.png");
			driver.quit();
			System.out.println("false");
			throw new Exception();
		}

	}

	// 选择男士跑步鞋，并跳转至新的窗口，如果出现异常截图
	public static void selectshoe() throws Exception {
		try {
			driver.findElement(
					By.cssSelector("img[alt=\"EKIDEN ONE 男式健身跑步鞋\"]")).click();
			String currentWindow = driver.getWindowHandle(); // 获取当前窗口句柄
			Set<String> handles = driver.getWindowHandles(); // 获取所有窗口句柄
			Iterator<String> it = handles.iterator();
			while (it.hasNext()) {
				if (currentWindow == it.next()) {
					continue;
				}
				WebDriver window = driver.switchTo().window(it.next()); // 切换到新窗口
				window.findElement(By.id("value13694")).click(); // 选择颜色
				window.findElement(By.id("value13673")).click(); // 选择尺码 42码
				window.findElement(By.cssSelector("button.button.btn-cart"))
						.click();//加入购物车
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			Screenshot.snapshot((TakesScreenshot) driver,
					"Search_SelectShoe.png");
			driver.quit();
			throw new Exception();
		}
	}

	//判断是否缺货
	public static void isoutofstock_shoe() throws Exception
		{
			if(driver.findElement(By.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li/span")).getText().trim().equals("该产品目前缺货。"))
			{
			Screenshot.snapshot((TakesScreenshot) driver,"NewCustomer_outofstock.png");
			System.out.println("It is out of stock");
			driver.quit();
			throw new Exception();
			}
	}
		
	// 关闭浏览器
	public static void closebrowser() {
		driver.quit();
	}
}
