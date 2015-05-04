package test;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


import returncustomer.Test_women_ReturnCustomer;

public class TestCase_women_ReturnCustomer {
	Test_women_ReturnCustomer demo;
	Map<Integer, String> errorMsg = new HashMap<Integer, String>();	//错误信息
	Map<String, String> userInfo = new HashMap<String, String>();	//用户信息
	Map<String, String> shoesPrice = new HashMap<String, String>();	//鞋子价格区间
	private static String URL = "http://cn-v2-p0.dkn.ext.bluecomdev.net/zh";
	private static String COUPON = "W0KG3KCIWOLY";
	public TestCase_women_ReturnCustomer(){
		//错误信息
		errorMsg.put(1, "1.Unable to open the Decathlon website");
		errorMsg.put(2, "2.Unable to local the Women shoes");
		errorMsg.put(3, "3.Unable to local the Range of Sport");
		errorMsg.put(4, "4.Unable to input price");
		errorMsg.put(5, "5.Unable to local certain Wo	men shoes");
		errorMsg.put(6, "6.Unable to choice the shoes size");
		errorMsg.put(7, "7.Unable to increase shoes quantity");
		errorMsg.put(8, "8.Unable to join to cart of shoes");
		errorMsg.put(9, "9.Unable to select T-shirt");
		errorMsg.put(10, "10.Unable to choice T-shirt");
		errorMsg.put(11, "11.Unable to join to cart of T-shirt");
		errorMsg.put(12, "12.Unable to enter the cart");
		errorMsg.put(13, "13.Unable to add the quanity of shoes");
		errorMsg.put(14, "14.Unable to remove the T-shirt");
		errorMsg.put(15, "15.Unable to use coupon");
		errorMsg.put(16, "16.Unable to payment");
		errorMsg.put(17, "17.Unable to login");
		errorMsg.put(19, "19.Unable to alert express");
		errorMsg.put(20, "20.Unable to payment on delivery");
		errorMsg.put(21, "21.Unable to payment");
		//用户信息
		userInfo.put("name", "test@123.com");
		userInfo.put("password", "1234asdf");
		//鞋子价格区间
		shoesPrice.put("frome", "0");
		shoesPrice.put("to", "150");
	}
	@Test(invocationCount = 1) //Loop.Times
	public void TestReturnCustomer() throws Exception {
		System.out.println("Loop start");
		demo = new Test_women_ReturnCustomer(); // 实例化
		try {//1.打开网站
			demo.openURL(URL);
		} catch (Exception e) {
			throw new Exception(errorMsg.get(1));
		}
		try {//2.选择女士跑步鞋
			demo.choiceWomenShoes();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(2));
		}
		try {//3.选择运动范围
			demo.choiceSportRange();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(3));
		}
		try {//4.确定价格范围
			demo.inputPrice(shoesPrice.get("frome"),shoesPrice.get("to"));
		} catch (Exception e) {
			throw new Exception(errorMsg.get(4));
		}
		try {//5.选择女士跑步鞋
			demo.choiceCertainShoes();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(5));
		}
		try {//6.选择鞋子尺码
			demo.choiceShoesSize();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(6));
		}
		try {//7.增加鞋子数量
			demo.increaseShoesNum();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(7));
		}
		try {//8.加入购物车
			demo.joinToCartShoes();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(8));
		}
		try {//9.搜索T-shirt
			demo.selectTshirt();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(9));
		}
		try {//10.选择T-shirt
			demo.choiceCertainTshirt();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(10));
		}
		try {//11.T-shirt加入购物车
			demo.joinToCartTshirt();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(11));
		}
		try {//12.查看购物车
			demo.enterCart();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(12));
		}
		try {//13.增加鞋子的数量
			demo.addShoesQuanity();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(13));
		}
		try {//14.删除T-shirt
			demo.removeTshirt();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(14));
		}
		try {//15.使用优惠券
			demo.useCoupon(COUPON);
		} catch (Exception e) {
			throw new Exception(errorMsg.get(15));
		}
		try {//16.去结算
			demo.toPayment();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(16));
		}
		try {//17.用户登录
			demo.userLogin(userInfo.get("name"),userInfo.get("password"));
		} catch (Exception e) {
			throw new Exception(errorMsg.get(17));
		}	
		try {//18.去结算
			demo.toPayment();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(16));
		}
		try {//19.更改物流
			demo.alertExpress();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(19));
		}
		try {//20.付款方式
			demo.paymentOnDelivery();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(20));
		}
		try {//21.支付
			demo.payment();
		} catch (Exception e) {
			throw new Exception(errorMsg.get(21));
		}
	}
}
