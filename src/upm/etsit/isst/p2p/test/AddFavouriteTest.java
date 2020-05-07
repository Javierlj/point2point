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
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class AddFavouriteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void addFavourite() throws InterruptedException {
    driver.get("http://localhost:8080/Point2point/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("upm.etsit.isst.p2p.test@gmail.com");
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.cssSelector(".btn-login")).click();
    driver.findElement(By.cssSelector(".fas")).click();
    driver.findElement(By.id("fav-name")).click();
    driver.findElement(By.id("fav-name")).sendKeys("1");
    driver.findElement(By.id("autocomplete1")).click();
    driver.findElement(By.id("autocomplete1")).sendKeys("e");
    Thread.sleep(1000);
    List <WebElement> listItems2 = driver.findElements(By.xpath(".//div[contains(@class, 'pac-container')]/div[contains(@class, 'pac-item')]"));
    System.out.println(listItems2);
    listItems2.get(0).click();
    driver.findElement(By.id("autocomplete2")).click();
    driver.findElement(By.id("autocomplete2")).sendKeys("rom");
    Thread.sleep(1000);
    List <WebElement> listItems = driver.findElements(By.xpath(".//div[contains(@class, 'pac-container')]/div[contains(@class, 'pac-item')]"));
    System.out.println(listItems);
    listItems.get(0).click();
    driver.findElement(By.cssSelector(".btn")).click();
  }
}
