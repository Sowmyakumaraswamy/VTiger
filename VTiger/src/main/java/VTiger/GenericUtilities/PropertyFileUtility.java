package VTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author sowmy
 *
 */
public class PropertyFileUtility {
	/**
	 * This method will read data from property file 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDatafromPropertyFile (String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
