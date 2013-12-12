package global;

import java.io.IOException;
import java.util.Properties;

import junit.framework.Test;

public class PropertiesHelper {
	private Properties configFile;
	public PropertiesHelper(String fileName)
	{
		/*configFile = new Properties();
		try {
			configFile.load(Test.class.getClassLoader().getResourceAsStream("/src/main/resources/"+fileName+".properties"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
	}
	public String getValue(String name)
	{
		/*return configFile.getProperty(name);*/
		if(name.equalsIgnoreCase("max_compare"));
		return "4";
	}
}
