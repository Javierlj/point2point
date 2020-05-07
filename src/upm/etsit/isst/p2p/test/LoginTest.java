package upm.etsit.isst.p2p.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LoginTest {
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
  public void login() {
    driver.get("http://localhost:8080/Point2point/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("register-form-link")).click();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("Carlos");
    driver.findElement(By.id("apellidos")).sendKeys("Arriaga");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) > #email")).sendKeys("test@gmail.com");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) > #password")).sendKeys("1234");
    driver.findElement(By.id("confirm-password")).click();
    driver.findElement(By.id("confirm-password")).sendKeys("1234");
    driver.findElement(By.cssSelector(".btn-register")).click();
    driver.close();
  }
}
