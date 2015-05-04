package test;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import searchbar.Test_man_SearchBar;
import circulation.Loop;

public class TestCase_man_SearchBar {
	static int count = 1;
	Map<String, String> map = new HashMap<String, String>();
	{
		map.put("1", "can not open url");
		map.put("2", "can not type in search bar");
		map.put("3", "can not find shoe");
		map.put("4", "can not select shoe");
		map.put("5", "out of stock");
	}
	@Test(invocationCount = Loop.Times)
	public void dosearchbar() throws Exception {
		System.out.println("Loop " + count);
		String url = "http://cn-des-p0.dkn.ext.bluecomdev.net/zh";
		try {
			Test_man_SearchBar.openurl(url);
		} catch (Exception e) {
			throw new Exception(map.get("1"));
		}
		System.out.println("search step one is ok");
		try {
			Test_man_SearchBar.typesearchbar();

		} catch (Exception e) {
			throw new Exception(map.get("2"));
		}
		System.out.println("search step two is ok");
		try {
			Test_man_SearchBar.searchshoe();
		} catch (Exception e) {
			throw new Exception(map.get("3"));
		}
		System.out.println("search step three is ok");
		try {
			Test_man_SearchBar.selectshoe();
		} catch (Exception e) {
			throw new Exception(map.get("4"));
		}
		System.out.println("search step four is ok");
		try {
			Test_man_SearchBar.isoutofstock_shoe();
		} catch (Exception e) {
			throw new Exception(map.get("5"));
		}
		System.out.println("search step five is ok");
		Test_man_SearchBar.closebrowser();
		System.out.println("All passed");
		System.out.println("Loop " + count + " end");
	}
}
