package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

	public Properties getProperty() throws Exception {
		FileInputStream inputStream = null;
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("user.dir")+"/resources/config.properties"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return properties;
	}
	
}
