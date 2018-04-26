package Sample.Demo;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Alerts {
	
	WebDriver driver;
	@BeforeTest
	public void startbrowser() throws InterruptedException
	{
		File pathBinary = new File("C:\\Users\\chaitra\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary Binary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxPro = new FirefoxProfile();       
		driver = new FirefoxDriver(Binary,firefoxPro);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);	

	}
	
	@Test
 	public void javaScriptAlert1() throws InterruptedException
	{
	
       List<WebElement> list= driver.findElements(By.cssSelector("#content>ul>li>a"));	
       WebElement e = list.get(24);
       System.out.println(e.getText());
       e.click();
       
      
     
      //Alert JS Alert and click Ok
      driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[1]/button")).click();     
      Alert alert=driver.switchTo().alert();
      Thread.sleep(5000);
      alert.accept();
      System.out.println(driver.findElement(By.xpath(".//*[@id='result']")).getText());
      Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='result']")).getText(), "You successfuly clicked an alert");
      
      

      //Alert JS Confirm click Ok
      driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[2]/button")).click();
      Alert alert1=driver.switchTo().alert();
      Thread.sleep(5000);
      alert.accept();
      System.out.println(driver.findElement(By.xpath(".//*[@id='result']")).getText());
      Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='result']")).getText(), "You clicked: Ok");
      
      Thread.sleep(5000);
      
      //Alert JS Confirm click Dismiss
      driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[2]/button")).click();
      Thread.sleep(5000);
      Alert alert2=driver.switchTo().alert();
      Thread.sleep(5000);
      alert.dismiss();
     
      System.out.println(driver.findElement(By.xpath(".//*[@id='result']")).getText());
      Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='result']")).getText(), "You clicked: Cancel");
      
      Thread.sleep(3000);
      
    //Alert JS Prompt click Dismiss
      driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[3]/button")).click();
      Thread.sleep(5000);
      Alert alert3=driver.switchTo().alert();
      Thread.sleep(5000);
      alert.dismiss();
      Thread.sleep(2000);
      System.out.println(driver.findElement(By.xpath(".//*[@id='result']")).getText());
      Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='result']")).getText(), "You entered: null");
      
      Thread.sleep(5000);
    
      //Alert JS Prompt click OK
      driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[3]/button")).click();
      Thread.sleep(5000);
      Alert alert4=driver.switchTo().alert();
      alert4.sendKeys("Test");
      Thread.sleep(5000);
      alert4.accept();
      Thread.sleep(5000);
      System.out.println(driver.findElement(By.xpath(".//*[@id='result']")).getText());
    //  Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='result']")).getText(), "You entered: null");
      Thread.sleep(5000);
        
	}

@AfterTest
public void stopSession()	
{
	
	driver.quit();
}

}
