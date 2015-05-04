package test;

import java.util.HashMap;
import java.util.Map;
import newcustomer.Test_man_NewCustomer;
import org.testng.annotations.Test;
import circulation.Loop;

public class TestCase_man_NewCustomer {

    // static final int timec = 1;
    static int count;
    // 错误信息
    Map<String, String> map = new HashMap<String, String>();
    {
	map.put("1", "can not open url");
	map.put("2", "can not type in search bar");
	map.put("3", "can not find shoe");
	map.put("4", "can not select shoe");
	map.put("5", "Shoe is out of stock");
	map.put("6", "can not type in search bar");
	map.put("7", "can not select T-shirt");
	map.put("8", "can not add into shipping cart");
	map.put("9", "T-shirt is out of stock");
	map.put("10", "can not edit shipping cart");
	map.put("11", "can not register a new customers");
	map.put("12", "can not fill information");
	map.put("13", "can not fii delivery");
	map.put("14", "can not select shipping method");
	map.put("15", "can not select fapiao");
	map.put("16", "can not check out");
	map.put("17", "can not select payment");
    }

    //@Parameters({ "url","useradd","userpassword"})
    @Test(invocationCount = Loop.Times)
    public void TestNewCustomer() throws Exception {
	++count;
	System.out.println("Loop " + count);
	String url = "http://cn-v2-p0.dkn.ext.bluecomdev.net/zh/";
	String useradd = "newcustomer" + Test_man_NewCustomer.getrandomletter()
		+ Test_man_NewCustomer.getrandomnum() + "@dec.com";
	String userpassword = "111111";

	try {
	    Test_man_NewCustomer.openurl(url);
	} catch (Exception e) {
	    throw new Exception(map.get("1"));
	}
	System.out.println("newcustomer step one is ok");
	try {
	    Test_man_NewCustomer.typesearchbar();
	} catch (Exception e) {
	    throw new Exception(map.get("2"));
	}
	System.out.println("newcustomer step two is ok");
	try {
	    Test_man_NewCustomer.searchshoe();
	} catch (Exception e) {
	    throw new Exception(map.get("3"));

	}
	System.out.println("newcustomer step three is ok");
	try {
	    Test_man_NewCustomer.selectshoe();
	} catch (Exception e) {
	    throw new Exception(map.get("4"));
	}
	System.out.println("newcustomer step four is ok");
	try {
	    Test_man_NewCustomer.isoutofstock_shoe();
	} catch (Exception e) {
	    throw new Exception(map.get("5"));
	}
	System.out.println("newcustomer step five is ok");
	try {
	    Test_man_NewCustomer.searchtshirt();
	} catch (Exception e) {
	    throw new Exception(map.get("6"));
	}
	System.out.println("newcustomer step six is ok");
	try {
	    Test_man_NewCustomer.selecttshirt();
	} catch (Exception e) {
	    throw new Exception(map.get("7"));
	}
	System.out.println("newcustomer step seven is ok");
	try {
	    Test_man_NewCustomer.addintoshoppingcart();
	} catch (Exception e) {
	    throw new Exception(map.get("8"));
	}
	System.out.println("newcustomer step eight is ok");
	try {
	    Test_man_NewCustomer.isoutofstock_tshirt();
	} catch (Exception e) {
	    throw new Exception(map.get("9"));
	}
	System.out.println("newcustomer step nine is ok");
	try {
	    Test_man_NewCustomer.editshoppingcart();
	} catch (Exception e) {
	    throw new Exception(map.get("10"));
	}
	System.out.println("newcustomer step ten is ok");
	try {
	    Test_man_NewCustomer.registernewcustomer(useradd, userpassword);
	} catch (Exception e) {
	    throw new Exception(map.get("11"));
	}
	System.out.println("newcustomer step eleven is ok");
	try {
	    Test_man_NewCustomer.fillinformation();
	} catch (Exception e) {
	    throw new Exception(map.get("12"));
	}
	System.out.println("newcustomer step twelve is ok");
	try {
	    Test_man_NewCustomer.delivery();
	} catch (Exception e) {
	    throw new Exception(map.get("13"));
	}
	System.out.println("newcustomer step thirteen is ok");

	try {
	    Test_man_NewCustomer.shippingmethod();
	} catch (Exception e) {
	    throw new Exception(map.get("14"));
	}
	System.out.println("newcustomer step fourteen is ok");
	try {
	    Test_man_NewCustomer.fapiao();
	} catch (Exception e) {
	    throw new Exception(map.get("15"));
	}
	System.out.println("newcustomer step fifteen is ok");
	 try {
	 Test_man_NewCustomer.checkout();
	 } catch (Exception e) {
	 throw new Exception(map.get("16"));
	 }
	 System.out.println("newcustomer step sixteen is ok");
	 try {
	 Test_man_NewCustomer.payment();
	 } catch (Exception e) {
	 throw new Exception(map.get("17"));
	 }
	 System.out.println("newcustomer step seventeen is ok");	
	 System.out.println("All passed");
	 System.out.println("Loop "+count+" end");
	 Test_man_NewCustomer.closebrowser();
    }
}
