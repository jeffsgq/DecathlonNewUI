package returncustomer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import selectdriver.DriverTools;
import createfile.CreateFile;

public class Test_women_ReturnCustomer {
	static WebDriver driver;
	Actions action;
	int sleepTime;
	Map<Integer, String> map = new HashMap<Integer, String>(); // 截图名称
	static CreateFile cf = new CreateFile();
	static String imgName = null;
	public Test_women_ReturnCustomer() throws InterruptedException {
		DriverTools d=new DriverTools();
		driver=d.getDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
		sleepTime = 3000; // 休眠时间
		// 截图名称
		map.put(1, "Error_openURL.png");
		map.put(2, "Error_localWomenShoes.png");
		map.put(3, "Error_localSportRange.png");
		map.put(4, "Error_inputPrice.png");
		map.put(5, "Error_choiceCertainShoes.png");
		map.put(6, "Error_choiceShoesSize.png");
		map.put(7, "Error_increaseShoesNum.png");
		map.put(8, "Error_joinToCartShoes.png");
		map.put(9, "Error_selectTshirt.png");
		map.put(10, "Error_choiceCertainTshirt.png");
		map.put(11, "Error_joinToCartTshirt.png");
		map.put(12, "Error_enterCart.png");
		map.put(13, "Error_addShoesQuanity.png");
		map.put(14, "Error_removeTshirt.png");
		map.put(15, "Error_useCoupon.png");
		map.put(16, "Error_toPayment.png");
		map.put(17, "Error_userLogin.png");
		map.put(19, "Error_alertExpress.png");
		map.put(20, "Error_paymentOnDelivery.png");
		map.put(21, "Error_payment.png");
	}
	// 截图
	public static void snapShot(TakesScreenshot drivername, String filename) {
		imgName = cf.ImageName("ReturnCustomer");
		String currentPath = System.getProperty("user.dir"); // 获取用户当前路径
		File scrFile = (File) drivername.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time = sdf.format(new Date());
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + "\\image" + "\\"
					+ imgName + "\\" + time + "_" + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//滑动滚动条
    public static void setScroll(WebDriver driver,int height){  
        try {  
            String setscroll = "document.documentElement.scrollTop=" + height;  
            JavascriptExecutor jse=(JavascriptExecutor) driver;  
            jse.executeScript(setscroll);  
        } catch (Exception e) {  
            System.out.println("Add: Fail to set the scroll.");  
        }             
    }     
	// 1.打开网站
	public void openURL(String url) throws Exception { 
		try {
			 driver.get(url);
			 System.out.println("1.open");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(1));
			driver.quit();
			throw new Exception();
		}
	}
	//2.选择女士跑步鞋
	public void choiceWomenShoes() throws Exception{
        try {
        	Thread.sleep(sleepTime);
            WebElement menu = driver.findElement(By.xpath("//a[@title='跑步']"));
            action.moveToElement(menu).build().perform();
            Thread.sleep(sleepTime);
//            action.moveToElement(driver.findElement(By.xpath("//a/span[contains(text(),'女式跑步鞋')]"))).click().perform();
            action.click(driver.findElement(By.xpath("//a/span[contains(text(),'女式跑步鞋')]"))).build().perform();
            System.out.println("2.women shoes");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(2));
			driver.quit();
			throw new Exception();
		}
	}
	//3.选择运动范围
	public void choiceSportRange() throws Exception { 
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//a[contains(text(),'筛选')]"));
				}
			}).click();
			driver.findElement(By.xpath("//a[contains(text(),'10公里以内')]")).click();
			System.out.println("3.sport range");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(3));
			driver.quit();
			throw new Exception();
		}
	}
	//4.确定价格范围
	public void inputPrice(String frome,String to) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);//等待元素出现
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("price-from"));
				}
			});
			driver.findElement(By.id("price-from")).sendKeys(frome);
			driver.findElement(By.id("price-to")).sendKeys(to);
			driver.findElement(By.id("btn-range")).click();
			System.out.println("4.price range");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(4));
			driver.quit();
			throw new Exception();
		}
	}
	//5.选择女士跑步鞋
	public void choiceCertainShoes() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebElement element = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//img[@alt='EKIDEN ONE 女式跑步鞋']"));
				}
			});
			action.moveToElement(element).build().perform();
			Thread.sleep(1000);
			action.click(element).build().perform();
			System.out.println("5.choice women shoes");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(5));
			driver.quit();
			throw new Exception();
		}
	}
	//6.选择鞋子尺码
	public void choiceShoesSize() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//div[@class='config_product_size']/label"));
				}
			}).click();
			driver.findElement(By.xpath("//a[@id='swatch16781']")).click();//swatch16781|36|swatch16779|38
			System.out.println("6.shoes's size");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(6));
			driver.quit();
			throw new Exception();
		}
	}
	//7.增加鞋子数量
	public void increaseShoesNum() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//div[@class='qty-wrapper']/label"));
				}
			}).click();
			driver.findElement(By.xpath("//li[contains(text(),'2')]")).click();
			System.out.println("7.increase shoes");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(7));
			driver.quit();
			throw new Exception();
		}
	}
	//8.加入购物车
	public void joinToCartShoes() throws Exception {
		try {
			driver.findElement(By.xpath("//button[@title='加入购物车']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//div[@id='messages_product_view']/ul/li/ul/li/span"));
				}
			});
			System.out.println("8.join to cart");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(8));
			driver.quit();
			throw new Exception();
		}
	}
	//9.搜索T-shirt
	public void selectTshirt() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("search"));
				}
			}).clear();
			driver.findElement(By.id("search")).sendKeys("T-shirt");
			driver.findElement(By.id("btn-search")).click();
			System.out.println("9.select t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(9));
			driver.quit();
			throw new Exception();
		}
	}
	//10.选择T-shirt
	public void choiceCertainTshirt() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			WebElement element = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//a[@title='户外运动 保暖 青少年T恤 QUECHUA T-SHIRT WARM JR']"));
				}
			});
			action.moveToElement(element).build().perform();
			action.click(element).build().perform();
			System.out.println("10.choice t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(10));
			driver.quit();
			throw new Exception();
		}
	}
	//11.T-shirt加入购物车
	public void joinToCartTshirt() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebElement element = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='加入购物车']"));
				}
			});
			action.moveToElement(element).build().perform();
			Thread.sleep(1000);//等待1秒种
			action.click(element).build().perform();
			System.out.println("11.join to cart");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(11));
			driver.quit();
			throw new Exception();
		}
		//等待加入成功提示
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By
						.xpath("//div[@id='messages_product_view']/ul/li/ul/li/span"));
			}
		});
	}
	//12.查看购物车
	public void enterCart() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//div[@class='header-minicart']/a"));
				}
			}).click();
			System.out.println("12.check cart");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(12));
			driver.quit();
			throw new Exception();
		}
	}
	//13.增加鞋子的数量
	public void addShoesQuanity() throws Exception {
		Thread.sleep(sleepTime);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//tbody[@id='shopping-cart-list']/tr[1]/td[2]/div[3]/button[1]"));
				}
			}).click();
			System.out.println("13.increase shoes");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(13));
			driver.quit();
			throw new Exception();
		}
	}
	//14.删除T-shirt
	public void removeTshirt() throws Exception {
		Thread.sleep(sleepTime);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By
							.xpath("//tbody[@id='shopping-cart-list']/tr[4]/td[2]/a[@title='删除']"));
				}
			}).click();
			System.out.println("14.remove t-shirt");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(14));
			driver.quit();
			throw new Exception();
		}
	}
	//15.使用优惠券
	public void useCoupon(String num) throws Exception {
		Thread.sleep(sleepTime);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.id("coupon_code"));
				}
			}).sendKeys(num);
			driver.findElement(By.xpath("//button[@value='应用优惠券']")).click();
			System.out.println("15.use coupon");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(15));
			driver.quit();
			throw new Exception();
		}
	}
	//16.去结算
	public void toPayment() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath("//button[@title='去结算']"));
				}
			}).click();
			System.out.println("16.payment");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(16));
			driver.quit();
			throw new Exception();
		}
	}
	//17.用户登录
	public void userLogin(String username,String passwd) throws Exception {
		Thread.sleep(sleepTime);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath("//div[@id='mydkt-content']/div/div[1]/div/div[2]/div/input")).isDisplayed();
				}
			});
			driver.findElement(By.xpath("//div[@id='mydkt-content']/div/div[1]/div/div[2]/div/input")).sendKeys(username);
			driver.findElement(By.xpath("//div[@id='mydkt-content']/div/div[1]/div/div[3]/div/input")).sendKeys(passwd);
			driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
			System.out.println("17.login");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(17));
			driver.quit();
			throw new Exception();
		}
	}
	//18.去结算--->调用16
	//19.修改物流信息
	public void alertExpress() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By
							.xpath("//li[@id='opc-shipping_method']/div[1]/a")).isDisplayed();
				}
			});
			driver.findElement(By.xpath("//li[@id='opc-shipping_method']/div[1]/a")).click();
			driver.findElement(By.xpath("//div[@id='checkout-shipping-method-load']/dl/dd[1]/ul")).click();
			driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button")).click();	
			System.out.println("19.alert express");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(19));
			driver.quit();
			throw new Exception();
		}
	}
	//20.货到付款
	public void paymentOnDelivery() throws Exception {
		Thread.sleep(sleepTime+sleepTime);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			WebElement webElement = wait
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By
									.xpath("//dl[@id='checkout-payment-method-load']/dt[2]"));
						}
					});
			action.moveToElement(webElement).build().perform();
			action.click(webElement).build().perform();
			driver.findElement(By.xpath("//div[@id='payment-buttons-container']/button")).click();
			System.out.println("20.payment on delivery");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(20));
			driver.quit();
			throw new Exception();
		}
	}
	//21.最终支付
	public void payment() throws Exception {
		//button disabled
		Thread.sleep(sleepTime);
		setScroll(driver,100); //滑动滚动条
		try {
			//对支付按钮进行判断
			String buttonStatus = driver.findElement(By.xpath("//div[@id='review-buttons-container']/button")).getAttribute("class");
			while(!buttonStatus.equals("button")){
				Thread.sleep(sleepTime);
				buttonStatus = driver.findElement(By.xpath("//div[@id='review-buttons-container']/button")).getAttribute("class");
				System.out.println("21.1"+buttonStatus);
			}
			driver.findElement(By.xpath("//div[@id='review-buttons-container']/button")).click();
			System.out.println("21.2.payment \n end");
		} catch (Exception e) {
			snapShot((TakesScreenshot) driver, map.get(21));
			driver.quit();
			throw new Exception();
		}
	}
}
