package Amazon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
public static WebDriver driver;

@Test
public static void Broweser_Plaunch()
{ 
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.thegoodguys.com.au/");
	driver.manage().window().maximize();
}
@Test

public static void product_select() throws AWTException, InterruptedException
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement findElement = driver.findElement(By.xpath("//span[text()='Products']"));
	Actions a=new Actions(driver);
	a.moveToElement(findElement).build().perform();
	
	
	WebElement findElement2 = driver.findElement(By.xpath("//div[@id='departmentMegaMenuWidget']/descendant::a/span[text()='Top Sellers']"));
	a.moveToElement(findElement2).build().perform();
	
	WebElement findElement3 = driver.findElement(By.xpath("(//div[@id='departmentMegaMenuWidget']/descendant::div/ul/li/ul/p/a/span/strong)[1]"));
		a.contextClick(findElement3).build().perform();
		Robot R=new Robot();
		R.keyPress(KeyEvent.VK_DOWN);
		R.keyRelease(KeyEvent.VK_DOWN);
		R.keyPress(KeyEvent.VK_ENTER);
		R.keyRelease(KeyEvent.VK_ENTER);
	Set<String> windowHandles = driver.getWindowHandles();
	System.out.println(windowHandles);
		
		for (String ID : windowHandles) {
			String window=driver.switchTo().window(ID).getCurrentUrl();
			System.out.println(window);
		}
			
			WebElement product = driver.findElement(By.xpath("//div[@class='product-tile-main clearfix']/descendant::h4[text()='Pacific Air White Silicone Appliance Mat']"));
			product.click();
			WebElement Addtocart = driver.findElement(By.xpath("//div[@id='ShopperActions']/descendant::div[@class='visible-lg']/button"));

			Addtocart.click();
			
			WebElement checkout=driver.findElement(By.id("GotoCartButton1"));
			checkout.click();

}

}



