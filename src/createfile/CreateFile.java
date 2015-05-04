package createfile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFile {
	public String ImageName(String suffix){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String fileName = sdf.format(new Date()) + suffix;
		File dir = new File("image//"+fileName);
		dir.mkdirs();
		return dir.getName();
	}
}
