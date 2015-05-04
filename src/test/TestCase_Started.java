package test;

import java.util.HashMap;
import java.util.Map;
import getstarted.Test_GetStarted;
import org.testng.annotations.Test;

public class TestCase_Started {   
    // 错误信息
    Map<String, String> map = new HashMap<String, String>();
    {
	map.put("1", "can not open url");
	map.put("2", "can not type in search bar");
    }

  @Test
  public void TestStarted() throws Exception {
      // url变量赋值
      String url = "http://cn-v2-p0.dkn.ext.bluecomdev.net/zh/";
      try{
	  // 调用打开页面function
	  Test_GetStarted.openURL(url);
      } catch (Exception e) {
	  // 如果捕获异常就获取错误信息并且抛出
	  throw new Exception(map.get("1"));
      }
      // 如果没有捕获异常，就打印第一步成功信息
      System.out.println("newcustomer step one is ok");
      try{
	  // 调用搜索function
	  Test_GetStarted.search();
      }catch (Exception e){
	// 如果捕获异常就获取错误信息并且抛出
	  throw new Exception(map.get("2"));
      }
      // 如果没有捕获异常，就打印第二步成功信息
      System.out.println("newcustomer step two is ok");
  }
}
