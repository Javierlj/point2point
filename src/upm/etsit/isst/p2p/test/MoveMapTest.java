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
import org.openqa.selenium.Keys;
import java.util.*;

public class MoveMapTest {
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
  public void moveMap() {
    driver.get("http://localhost:8080/Point2point/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("upm.etsit.isst.p2p.test@gmail.com");
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.linkText("Términos de uso"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".gm-style > div:nth-child(1) > div:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".gm-control-active:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".gm-control-active:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-control-active:nth-child(3)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".gm-control-active:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".gm-control-active:nth-child(3)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gmnoprint:nth-child(1) .gm-control-active:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".gmnoprint:nth-child(1) .gm-control-active:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".gmnoprint:nth-child(1) .gm-control-active:nth-child(1)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gmnoprint:nth-child(1) .gm-control-active:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".gmnoprint:nth-child(1) .gm-control-active:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".gmnoprint:nth-child(1) .gm-control-active:nth-child(1)")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".gm-fullscreen-control")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-fullscreen-control"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".gm-fullscreen-control")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".gm-fullscreen-control"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
  }
}
