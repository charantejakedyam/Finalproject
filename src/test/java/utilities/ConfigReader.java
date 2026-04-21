package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties pros=new Properties();
	
	public ConfigReader() throws Exception {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/bookshelves_config.properties");
		pros.load(fis);
	}
	
	public String getCategory() {
		return pros.getProperty("Category");
	}
	
	public String getUrl() {
		return pros.getProperty("url");
	}
	
	public String getAmount() {
	        return pros.getProperty("amount");
    }

    public String getQuantity() {
        return pros.getProperty("quantity");
    }

    public String getFirstName() {
        return pros.getProperty("firstName");
    }

    public String getLastName() {
        return pros.getProperty("lastName");
    }

    public String getEmailId() {
        return pros.getProperty("emailId");
    }

    public String getMobile() {
        return pros.getProperty("mobile");
    }
	
}
