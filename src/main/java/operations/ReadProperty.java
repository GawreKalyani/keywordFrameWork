package operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	FileInputStream fis=null;
	Properties prop=null;
	
	public String getProperty(String key) throws Exception{
		
		fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/com/config/config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public Properties getObjectRepository() throws IOException{
		//Read object repository file
		fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/com/config/config.properties");
		prop=new Properties();
		prop.load(fis);
		 return prop;
	}
}
