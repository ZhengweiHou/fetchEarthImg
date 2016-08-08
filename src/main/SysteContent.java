package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 系统参数
 * 
 * @author houzw
 * 
 */
public class SysteContent {
	static Properties properties = null;

	public static String DEFULT_FORMATTER = "defultFormatter";
	public static String START_TIME = "startTime";
	public static String END_TIME = "endTime";
	public static String IMG_URL = "url";
	public static String SAVE_PATH = "path";
	public static String MINUTES_GRIT = "minutesGrit";
	
	static {
		SysteContent.init();
	}

	/**
	 * 读入配置文件
	 * 
	 * @throws IOException
	 */
	public static void init() {
		String configPath = System.getProperty("user.dir")
				+ "/config.properties";
		InputStream is = null;
		try {
			is = new FileInputStream(new File(configPath));
			properties = new Properties();
			properties.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 获取参数
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperties(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println();
		String configPath = System.getProperty("user.dir")
				+ "\\config.properties";
		System.out.println(configPath);
		InputStream is = null;
		try {
			is = new FileInputStream(new File(configPath));
			properties = new Properties();
			properties.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(properties.get("defultFormatter"));

	}

}
