package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		step 1 => get the jro of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
//		step 2 => load all the keys by using load() of the Properties class
		Properties pObj = new Properties();
		pObj.load(fis);
//		step 3 => get the values by giving they keys, in the getProperty(key)
		String BROWSER = pObj.getProperty("bro");
		String USERNAME = pObj.getProperty("un");
		String URL = pObj.getProperty("url");
		String PASSWORD = pObj.getProperty("pwd");

		System.out.println(BROWSER); 
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
