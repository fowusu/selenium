package testpackage;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Test_sel {
	
	static String url = "https://www.google.com";
	static String url2 = "https://www.youidraw.com/apps/painter/";
	
	static WebDriver driver; 
	
	@BeforeClass 
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\external apps/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void teardown() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void methodTest1() {
		driver.get(url2);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"brush\"]"));
		we.click();
		Actions action  = new Actions(driver); 
		we = driver.findElement(By.xpath("//*[@id=\"catch\"]"));
		action.moveToElement(we).moveByOffset(-300, -100).perform();
		action.clickAndHold().moveByOffset(50, 0).release().perform();
		action.moveByOffset(-50, 0).clickAndHold().moveByOffset(0,50).clickAndHold().moveByOffset(50,0).release().moveByOffset(-50, 0).clickAndHold().moveByOffset(0, 50).release().perform();
		

	}
	
	@Ignore
	@Test
	public void methodTest() {
		driver.get(url);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		
		we.sendKeys("Cute kittens");
		//we.sendKeys(Keys.ENTER);
		we.submit();
		we = driver.findElement(By.xpath("//*[@id=\"imagebox_bigimages\"]/g-section-with-header/div[1]/h3/a"));
		assertEquals("Images for Cute kittens", we.getText());
	}

}
