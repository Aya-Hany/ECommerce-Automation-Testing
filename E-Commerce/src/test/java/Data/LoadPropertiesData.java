package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesData {
	
	
	static String Path1=System.getProperty("user.dir")+"\\src\\test\\java\\LoginData\\LoginValidDate.properties";
	static String Path2=System.getProperty("user.dir")+"\\src\\test\\java\\LoginData\\LoginInvalidDate.properties";
	static String Path3=System.getProperty("user.dir")+"\\src\\test\\java\\ReviewData\\reviewInvalidDate.properties";
	static String Path4=System.getProperty("user.dir")+"\\src\\test\\java\\ReviewData\\reviewValidDate.properties";
	static String Path5=System.getProperty("user.dir")+"\\src\\test\\java\\QuantityData\\QValidDate.properties";
	static String Path6=System.getProperty("user.dir")+"\\src\\test\\java\\QuantityData\\QInvalidDate.properties";
	static String Path7=System.getProperty("user.dir")+"\\src\\test\\java\\SearchData\\searchValidDate.properties";
	static String Path8=System.getProperty("user.dir")+"\\src\\test\\java\\SearchData\\searchInvalidDate.properties";
	static String Path9=System.getProperty("user.dir")+"\\src\\test\\java\\PropertiesRegester\\RegesterInvalidDate2.properties";
	static String Path10=System.getProperty("user.dir")+"\\src\\test\\java\\PropertiesCreateAccount\\CreateAccount.properties";
	static String Path11=System.getProperty("user.dir")+"\\src\\test\\java\\PropertiesRegester\\RegesterValidDate.properties";
	static String Path12=System.getProperty("user.dir")+"\\src\\test\\java\\LoginData\\LoginValidDate2.properties";
	static String Path13=System.getProperty("user.dir")+"\\src\\test\\java\\ContactUs\\ContactInvalidDate.properties";
	static String Path14=System.getProperty("user.dir")+"\\src\\test\\java\\ContactUs\\ContactValidDate.properties";
	static String Path15=System.getProperty("user.dir")+"\\src\\test\\java\\PropertiesCreateAccount\\CreateAccountNegative.properties";
	
	public static Properties creatNData = getData(Path15);	
	public static Properties RegisterNData = getData(Path9);	
	public static Properties NewAccountData = getData(Path10);	
	public static Properties RegisterPData = getData(Path11);	
	public static Properties validLogInData = getData(Path1);	
	public static Properties invalidLogInData = getData(Path2);
	public static Properties invalidRewiewData = getData(Path3);
	public static Properties validRewiewData = getData(Path4);
	public static Properties validQData = getData(Path5);
	public static Properties invalidQData = getData(Path6);
	public static Properties validSearchData = getData(Path7);
	public static Properties invalidSearchData = getData(Path8);
	public static Properties validlogData = getData(Path12);
	public static Properties ContactInvalidDate = getData(Path13);
	public static Properties ContactValidDate = getData(Path14);
	
	
	static public Properties getData(String Path) {
		
		Properties p = new Properties();
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			p.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	
}