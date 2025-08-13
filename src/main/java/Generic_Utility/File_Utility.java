package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	public String propertyData(String key) throws IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\vTigerData.properties");
     Properties ps=new Properties();
     ps.load(fis);
     String data = ps.getProperty(key);
     return data;
     

	}
}
