package screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import createfile.CreateFile;

public class Screenshot {
	static CreateFile cf = new CreateFile();
	static String imgName = cf.ImageName("NewCustomer");
	public static void snapshot(TakesScreenshot  drivername, String filename)
	  {
	      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	    String currentPath = System.getProperty("user.dir"); // 获取用户当前路径
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
	    String time = sdf.format(new Date()); 
	    
	        // Now you can do whatever you need to do with it, for example copy somewhere
	        try {
	            System.out.println("save snapshot path is:"+currentPath+ "\\image"+ "\\"+imgName+"\\"+filename);
	            FileUtils.copyFile(scrFile, new File(currentPath+ "\\image"+ "\\"+imgName+"\\"+time+filename));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("Can't save screenshot");
	            e.printStackTrace();
	        } 
	        finally
	        {
	           
	            System.out.println("screen shot finished");
	        }
	  }
	
	
	
}
