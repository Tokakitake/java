package com.tests.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class EtternaTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://etternaonline.com");

        Cookie authCookie = new Cookie("ci_session", "b3g0djdto9k02ong5icqoq9pg1t6kdua");

        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();

        driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right navtop']//span[@id='nav-username']")).click();

        List<WebElement> scores = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));

        scores.stream().findFirst().get().findElement(By.xpath("//td//a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@aria-controls='topdX7e69930ad36e23da7c6f67b0be041ae02a35ce98']")).sendKeys("Tokakitake");
        Thread.sleep(10000);

        List<WebElement> sort = driver.findElements(By.xpath("//tr[@class='odd']"));

        sort.stream().findFirst().get().findElement(By.xpath("//td[@class='sorting_1']//a")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
