package upm.etsit.isst.p2p.test;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class SearchTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    System.setProperty( "webdriver.chrome.driver", "/Users/Arri/ISST/point2point/chromedriver.exe");
    driver = new ChromeDriver();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void search() {
    driver.get("http://localhost:8080/Point2point/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("test@gmail.com");
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.cssSelector(".btn-login")).click();
    driver.findElement(By.id("autocomplete1")).click();
    driver.findElement(By.id("autocomplete1")).sendKeys("madrid");
    {
      WebElement element = driver.findElement(By.cssSelector(".col:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
  }
}
