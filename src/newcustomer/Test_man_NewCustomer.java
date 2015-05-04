package newcustomer;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenshot.Screenshot;
import selectdriver.DriverTools;

public class Test_man_NewCustomer {
    static WebDriver driver;

    // 随机生成数字0-100
    public static int getrandomnum() {
	final long l = System.currentTimeMillis();
	final int i = (int) (l % 100);
	return i;
    }

    // 随机生成26个英文字母
    public static char getrandomletter() {
	char paramChar = (char) (Math.random() * 26 + 'A');
	return paramChar;
    }

    // 滑动滚动条
    public static void setScroll(WebDriver driver, int height) {
	try {
	    String setscroll = "document.documentElement.scrollTop=" + height;
	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript(setscroll);
	} catch (Exception e) {
	    System.out.println("Add: Fail to set the scroll.");
	}
    }

    // 打开网页，如果出现异常截图
    public static void openurl(String url) throws Exception {
	try {

	    // driver = new FirefoxDriver();
	    DriverTools d = new DriverTools();
	    driver = d.getDriver();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.manage().window().maximize(); // 窗口最大化

	    // 如果判断浏览器为2=chrome，则执行防火墙验证步骤
	    if (DriverTools.Judge1() == 2) {
		driver.get(url);
		driver.findElement(
			By.xpath("//*[@id='uform']/table/tbody/tr[1]/td/table/tbody/tr[5]/td/table/tbody/tr[2]/td/input"))
			.sendKeys("jeff.shi@decathlon.com");
		driver.findElement(
			By.xpath("//*[@id='uform']/table/tbody/tr[1]/td/table/tbody/tr[5]/td/table/tbody/tr[4]/td/input"))
			.click();
		Thread.sleep(6000);

		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(
			"jshi02");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(
			"11111111");
		driver.findElement(
			By.xpath("/html/body/div[1]/div/div/form/button"))
			.click();
		driver.get(url);
	    } else {
		driver.get(url);
	    }
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_OpenBrowser.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 在首页搜索框搜索，如果出现异常截图
    public static void typesearchbar() throws Exception {
	try {
	    driver.findElement(By.id("search")).clear(); // 清除搜索框
	    driver.findElement(By.id("search")).sendKeys("跑步鞋");// 在搜索框输入“跑步鞋”
	    driver.findElement(By.id("btn-search")).sendKeys(Keys.ENTER); // 点击搜索按钮

	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_TypeSearchBar.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 按条件筛选，如果出现异常截图
    public static void searchshoe() throws Exception {
	try {

	    Thread.sleep(3000);
	    // driver.navigate().refresh();
	    // 价格区间
	    driver.findElement(By.id("price-from")).sendKeys("0");
	    driver.findElement(By.id("price-to")).sendKeys("100");
	    driver.findElement(By.id("btn-range")).click();
	    Thread.sleep(5000);
	    // 颜色筛选
	    // driver.findElement(By.id("toggleSelectPanel")).click();
	    // driver.findElement(By.xpath("//ul[@id='narrow-by-list']/li[1]/ul/div/div/li[1]/a")).click();
	    // Thread.sleep(2000);
	    // 性别筛选
	    driver.findElement(By.id("toggleSelectPanel")).click();
	    driver.findElement(
		    By.xpath("//ul[@id='narrow-by-list']/li[2]/ul/li[4]/a"))
		    .click();
	    Thread.sleep(5000);
	    // 产品类型筛选
	    driver.findElement(By.id("toggleSelectPanel")).click();
	    driver.findElement(
		    By.xpath("//ul[@id='narrow-by-list']/li[3]/ul/li[2]/a"))
		    .click();
	    Thread.sleep(5000);
	    // 运动筛选
	    driver.findElement(By.id("toggleSelectPanel")).click();
	    driver.findElement(
		    By.xpath("//ul[@id='narrow-by-list']/li[4]/ul/li[2]/a"))
		    .click();
	    Thread.sleep(2000);

	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_SearchShoe.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 选择男士跑步鞋，并跳转至新的窗口，如果出现异常截图
    public static void selectshoe() throws Exception {
	try {

	    driver.findElement(By.xpath("//img[@alt='EKIDEN ONE 男式健身跑步鞋']"))
		    .click();
	    Thread.sleep(3000);
	    // 选择尺码 39
	    driver.findElement(
		    By.xpath("//div[@id='product-options-wrapper']/dl/dd[2]/div/div/label"))
		    .click();
	    driver.findElement(By.xpath("//a[@id='swatch16785']/span")).click();
	    // 选择数量 1
	    driver.findElement(
		    By.xpath("//form[@id='product_addtocart_form']/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/label"))
		    .click();
	    driver.findElement(
		    By.xpath("//form[@id='product_addtocart_form']/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/ul/li[2]"))
		    .click();
	    // 加入购物车
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_SelectShoe.png");
	    driver.quit();
	    throw new Exception();
	}

    }

    // 判断鞋子是否缺货
    public static void isoutofstock_shoe() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
	    public WebElement apply(WebDriver d) {
		return d.findElement(By
			.xpath("id('messages_product_view')/ul/li/ul/li/span"));
	    }
	});
	if (webElement.getText().trim().equals("该产品目前缺货。")) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "OutOfStock_shoes.png");
	    System.out.println("shoe is out of stock");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 搜索T-shirt，如果出现异常截图
    public static void searchtshirt() throws Exception {
	try {
	    Thread.sleep(3000);
	    driver.findElement(By.id("search")).clear();// 清除搜索框的值
	    driver.findElement(By.id("search")).sendKeys("T-shirt");// 输入搜索框的值为“T-shirt”
	    driver.findElement(By.id("btn-search")).sendKeys(Keys.ENTER); // .click();//
									  // 点击搜索
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_SearchTshirt.png");
	    driver.quit();
	    throw new Exception();
	}

    }

    // 选择T-shirt，如果出现异常截图
    public static void selecttshirt() throws Exception {
	try {
	    driver.findElement(
		    By.xpath("//img[@alt='户外运动 保暖 青少年T恤 QUECHUA T-SHIRT WARM JR']"))
		    .click();
	    Thread.sleep(3000);
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_SelectTshirt.png");
	    driver.quit();
	    throw new Exception();
	}

    }

    // 将T-shirt加入购物车，出现异常截图
    public static void addintoshoppingcart() throws Exception {
	try {
	    // 选择尺码
	    driver.findElement(
		    By.xpath("//div[@id='product-options-wrapper']/dl/dd[2]/div/div/label"))
		    .click();
	    driver.findElement(By.xpath("//a[@id='swatch16779']/span[1]"))
		    .click();
	    // 选择数量
	    driver.findElement(
		    By.xpath("//form[@id='product_addtocart_form']/div[3]/div/div[2]/div/div[2]/div[2]/div/label"))
		    .click();
	    driver.findElement(
		    By.xpath("//form[@id='product_addtocart_form']/div[3]/div/div[2]/div/div[2]/div[2]/div/ul/li[2]"))
		    .click();
	    // 加入购物车
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_AddInToShippingCart.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 判断T-shirt是否缺货
    public static void isoutofstock_tshirt() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
	    public WebElement apply(WebDriver d) {
		return d.findElement(By
			.xpath("//div[@id='messages_product_view']/ul[@class='messages']/li/ul/li"));
	    }
	});
	if (webElement.getText().trim().equals("该产品目前缺货。")) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "OutOfStock__T-shirt.png");
	    System.out.println("T-shirt is out of stock");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 进入购物车页面,修改购物车内容,出现异常截图
    public static void editshoppingcart() throws Exception {
	try {
	    Thread.sleep(3000);
	    driver.findElement(
		    By.xpath("//a[@href='http://cn-v2-p0.dkn.ext.bluecomdev.net/zh/checkout/cart/']"))
		    .click();
	    Thread.sleep(3000);
	    driver.findElement(
		    By.xpath("//tbody[@id='shopping-cart-list']/tr[2]/td[2]/a"))
		    .click();// 删除T-shirt
	    Thread.sleep(3000);
	    driver.findElement(
		    By.xpath("//tbody[@id='shopping-cart-list']/tr/td[2]/div[3]/button[1]"))
		    .click();// 增加鞋子数量到2
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='coupon_code']"))
		    .sendKeys("W0KG3KCIWOLY");
	    driver.findElement(By.xpath("//button[@value='应用优惠券']")).click();
	    Thread.sleep(3000);
	    driver.findElement(
		    By.xpath("//div[@id='checkoutbutton']/ul/li[1]/button"))
		    .click();// 点击去结算

	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_EditShippingCart.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 注册新用户,出现异常截图
    public static void registernewcustomer(String useradd, String userpassword)
	    throws Exception {
	try {
	    // 注册新用户
	    driver.findElement(By.xpath("//button[@id='defaut.Carte']"))
		    .click();
	    Thread.sleep(3000);
	    // 注册邮箱
	    driver.findElement(
		    By.xpath("//div[@id='compteIdentifiants01']/div/table/tbody/tr[2]/td/table/tbody/tr/td/div/div/input"))
		    .sendKeys(useradd);
//	    // 邮箱认证
//	    driver.findElement(
//		    By.xpath("//div[@id='compteIdentifiants01']/div/table/tbody/tr[4]/td/table/tbody/tr/td/div/div/input"))
//		    .sendKeys(useradd);
	    // 输入密码
	    driver.findElement(
		    By.xpath("//div[@id='compteIdentifiants01']/div/table/tbody/tr[6]/td/table/tbody/tr/td/div/div/input"))
		    .sendKeys(userpassword);
	    // 重复密码
	    driver.findElement(
		    By.xpath("//div[@id='compteIdentifiants01']/div/table/tbody/tr[9]/td/table/tbody/tr/td/div/div/input"))
		    .sendKeys(userpassword);
	    // 同意并注册
	    driver.findElement(
		    By.xpath("//button[@id='creationCompte1.Valid']")).click();
	    // // 点击取消优惠券
	    // driver.findElement(By.xpath("//button[@value='取消优惠券']")).click();
	    // // 点击去结算
	    // driver.findElement(By.xpath("(//button[@type='button'])[8]"))
	    // .click();
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_RegisterNewCustomer.png");
	    driver.quit();
	    throw new Exception();
	}
	Thread.sleep(3000);

    }

    // 新用户填写信息，出现异常截图
    public static void fillinformation() throws Exception {
	try {
	    // 性别：男
	    driver.findElement(By.xpath("//input[@id='gwt-uid-16']")).click();
	    // 姓
	    driver.findElement(By.xpath("//input[@name='nom']")).sendKeys("张");
	    // 名
	    driver.findElement(By.xpath("//input[@name='prenom']")).sendKeys("三");
	    // 出生日期
	    new Select(driver.findElement(By
		    .cssSelector("select.mydkt-listboxcrm")))
		    .selectByVisibleText("1997");
	    new Select(
		    driver.findElement(By
			    .xpath("//div[@id='identite01']/div/div[2]/div/div/div[4]/div/div/div[2]/select")))
		    .selectByVisibleText("01");
	    new Select(
		    driver.findElement(By
			    .xpath("//div[@id='identite01']/div/div[2]/div/div/div[4]/div/div/div[3]/select")))
		    .selectByVisibleText("01");
	    // 手机
	    driver.findElement(By.xpath("//input[@name='telPortable']"))
		    .sendKeys("13988988998");
	    // 我的运动
	    driver.findElement(By.id("creationCompte2.Recherche")).click();
	    driver.findElement(
		    By.xpath("//div[@id='listesportpratique01']/div/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/span"))
		    .click();
	    // 喜好选择
	    // 我最常光顾的商店
	    new Select(driver.findElement(By.cssSelector("select.gwt-ListBox")))
		    .selectByVisibleText("22 - 上海/Shanghai");
	    new Select(
		    driver.findElement(By
			    .xpath("//div[@id='preference01']/div/fieldset/div/div/div[2]/div[2]/div[2]/div/span/span/select")))
		    .selectByVisibleText("上海市/Shanghai");
	    new Select(
		    driver.findElement(By
			    .cssSelector("div.mydkt-field > span.mydkt-controls > span.mydkt-generic-control > select.gwt-ListBox")))
		    .selectByVisibleText("上海花木店");
	    // 我的迪卡侬互动
	    driver.findElement(By.id("gwt-uid-3")).click();
	    driver.findElement(By.id("gwt-uid-5")).click();
	    // 我已阅读并同意
	    driver.findElement(By.id("gwt-uid-10")).click();
	    // 保存
	    driver.findElement(By.id("BtnSauvegarder")).click();
	    // 点击购物车
	    driver.findElement(
		    By.xpath("//html[@id='top']/body/div/div/div/div[2]/div/div/div/div/div/div[2]/div/a"))
		    .click();
	    driver.findElement(By.xpath("//button[@value='取消']")).click();
	    Thread.sleep(3000);
	    // 点击去结算
	    driver.findElement(
		    By.xpath("//div[@id='checkoutbutton']/ul/li[1]/button"))
		    .click();
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_FillInformation.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    public static void delivery() throws Exception {
	try {
	    driver.findElement(By.xpath("//input[@name='nom']")).sendKeys("张");
	    driver.findElement(By.xpath("//input[@name='telPortable']"))
		    .sendKeys("13988988998");
	    new Select(driver.findElement(By
		    .xpath("//select[@name='province']")))
		    .selectByVisibleText("北京");
	    new Select(driver.findElement(By
		    .xpath("//select[@name='district']")))
		    .selectByVisibleText("东城区");
	    driver.findElement(By.xpath("//input[@name='ligne2']")).sendKeys(
		    "人民路1弄1号");
	    driver.findElement(By.id("BtnSauvegarder")).click();
	    
	    String buttonStatus = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button")).getAttribute("class");
	    while(!buttonStatus.equals("button")){
		Thread.sleep(3000);
	    buttonStatus = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button")).getAttribute("class");
	    }
	    driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button")).click();
	    
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver, "Error_Delivery.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 选择物流方式，出现异常截图
    public static void shippingmethod() throws Exception {
	try {
	    /*-------------------------以下是物流信息部分-------------------------*/
	    Thread.sleep(3000);
	    driver.findElement(
		    By.xpath("//div[@id='checkout-shipping-method-load']/dl/dd[2]/ul/li"))
		    .click();// 选择圆通速递
	    driver.findElement(
		    By.xpath("//div[@id='shipping-method-buttons-container']/button"))
		    .click();// 物流信息填写完成，下一步
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver,
		    "Error_ShippingMethod.png");
	    driver.quit();
	    throw new Exception();
	}
    }

    // 选择支付信息及发票 ，出现异常截图
    public static void fapiao() throws Exception {
	try {
	    /*-------------------------以下是支付信息部分-------------------------*/
	    Thread.sleep(3000);
	    // 需要发票
	    driver.findElement(By.xpath("//div[@id='fapiao-box']/div/span"))
		    .click();
	    // 发票内容为服
	    new Select(driver.findElement(By.id("fapiao-normal")))
		    .selectByVisibleText("服装");
	    // 支付信息填写完成，下一步
	    driver.findElement(
		    By.cssSelector("#payment-buttons-container > button.button"))
		    .click();// 点击下一步
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver, "Error_FaPiao.png");
	    driver.quit();
	    throw new Exception();
	}

    }

    // 最后核对价格，点击提交订单，出现异常截图
    public static void checkout() throws InterruptedException {
	try {
	    /*-------------------------以下是确认购物清单部分-------------------------*/
	    // 点击支付
	    Thread.sleep(3000);
	    setScroll(driver, 500);
	    
//	    driver.findElement(By.xpath("//div[@id='review-buttons-container']/button")).click();
	    
	  //对支付按钮进行判断
	    String buttonStatus = driver.findElement(By.xpath("//div[@id='review-buttons-container']/button")).getAttribute("class");
	    while(!buttonStatus.equals("button")){
		Thread.sleep(3000);
	    buttonStatus = driver.findElement(By.xpath("//div[@id='review-buttons-container']/button")).getAttribute("class");

	    }
	    driver.findElement(By.xpath("//div[@id='review-buttons-container']/button")).click();


	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver, "Error_CheckOut.png");
	    driver.quit();
	}
	Thread.sleep(3000);// 休眠3秒
    }

    // 选择银联在线支付，出现异常截图
    public static void payment() throws Exception {
	try {
	    driver.findElement(By.id("opt-chinapay")).click();// 选择在线支付
	} catch (Exception e) {
	    Screenshot.snapshot((TakesScreenshot) driver, "Error_PayMent.png");
	    driver.quit();
	    throw new Exception();
	}
	Thread.sleep(3000);// 休眠3秒
    }

    // 退出浏览区
    public static void closebrowser() {
	driver.quit();
    }
}
