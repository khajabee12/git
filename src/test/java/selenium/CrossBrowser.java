package selenium;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class CrossBrowser {
WebDriver driver;
//EdgeOptions edge=new EdgeOptions();
//ChromeOptions chrome=new ChromeOptions();
//@BeforeTest
@Parameters("browser")

public void initialize(String browser) throws Exception {
	if(browser.equalsIgnoreCase("edge")) {
		//WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.edge.driver", 
				//"C:\\Users\\Dell\\Downloads\\edgedriver_win64"));
		driver=new EdgeDriver();
		System.out.println("edge is open");
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver");
		driver =new ChromeDriver();
		System.out.println("chrome is open");
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		//WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println("firefox is open");
	}
	else {
		throw new Exception("browser not support");
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
@Test
public void method() {
   driver.navigate().to("https://www.google.com.in/");
   String actual =driver.getTitle();
   String expect ="google";
   Assert.assertEquals(actual.contains("google"),expect.contains("bank"));
   driver.close();
}

}
