package demoapp.SampleProject;

import org.testng.annotations.Test;
import java.util.Properties;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;


public class errorTest {
	
	 private Properties strings;
	    
	    @BeforeClass
	    public void setup() {
	        strings = new Properties();
	        try {
	            strings.load(getClass().getResourceAsStream("/test-strings.properties"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testBlankUsernameError() {
	        String actualContent = strings.getProperty("error_username_blank");
	        String expectedContent = "Username cannot be blank";
	        Assert.assertEquals(actualContent, expectedContent);
	    }
}
