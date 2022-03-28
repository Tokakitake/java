package com.tests.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.WindowType.TAB;

public class SeleniumStart {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+https://www.google.com/bot.html)");
        //chromeOptions.addArguments("--headless"); //gui off

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(5000);

        //((JavascriptExecutor)driver).executeScript("window,open()"); //js для открытия новой вкладки
        driver.switchTo().newWindow(TAB);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.close();

        Thread.sleep(3000);

        /*
        WebDriverManager.firefoxdriver().setup();

        WebDriver ffDriver = new FirefoxDriver();
        ffDriver.get("https://ya.ru");
        Thread.sleep(5000);

        ffDriver.quit();
         */

        driver.quit();
    }
}
