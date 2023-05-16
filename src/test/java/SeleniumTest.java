import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class SeleniumTest {

    @Test
    void buscarNoGoogle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
//        chromeOptions.addArguments("--headless=new");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://google.com");
        assumeTrue(webDriver.getTitle().equals("Google"));
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        var elementFound = webDriver.findElement(By.name("q"));
        elementFound.sendKeys("Java" + Keys.ENTER);
//        elementFound.submit();// Ana
//        Thread.sleep(2000);
//        var btnFound = webDriver.findElement(By.name("btnK"));
//        btnFound.click();
        var textBoxFound = webDriver.findElement(By.name("q"));
        var pathElement = webDriver.findElement(By.xpath("/html/body/div[*]/div/div[*]/div[*]/div[*]/div[*]/div/div/div[*]/div/div/div/div/div/div/div/div[*]/a/h3"));
        var pathElements = webDriver.findElements(By.xpath("//a/h3"));

//        /html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/a/h3


        System.out.println("##### " + pathElement.getText());
        System.out.println( "333333 " + pathElements.get(6).getText());

        assertEquals("Java",textBoxFound.getText());

//        webDriver.quit();
    }

    @Test
    void exercicioXPathTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
//        chromeOptions.addArguments("--headless=new");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://chercher.tech/practice/dynamic-table");
//        assumeTrue(webDriver.getTitle().equals("Google"));
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        var elementFound = webDriver.findElement(By.name("q"));
//        elementFound.sendKeys("Java" + Keys.ENTER);
//        elementFound.submit();// Ana
//        Thread.sleep(2000);
//        var btnFound = webDriver.findElement(By.name("btnK"));
//        btnFound.click();
//        var textBoxFound = webDriver.findElement(By.name("q"));
        var pathElement = webDriver.findElement(By.xpath("//*[@id=\"blue\"]"));
        var pathElement2 = webDriver.findElement(By.xpath("//*[@id=\"output\"]"));
        var pathSelectionElement = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/table/tbody/tr[2]/td[1]/input"));
        pathElement.click();
        pathSelectionElement.click();
        assertEquals("Blueberry", pathElement2.getText());
        assertTrue(pathSelectionElement.isSelected());

//        var pathElements = webDriver.findElements(By.xpath("//a/h3"));

//        /html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/a/h3


//        System.out.println("##### " + pathElement.getText());
//        System.out.println( "333333 " + pathElements.get(6).getText());

//        assertEquals("Java",textBoxFound.getText());

//        webDriver.quit();
    }


}
