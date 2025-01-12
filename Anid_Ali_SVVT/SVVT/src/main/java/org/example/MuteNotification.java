package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MuteNotification {
    private WebDriver webDriver;
    private final String baseUrl = "https://x.com/?mx=2";

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the window
        options.addArguments("--disable-blink-features=AutomationControlled"); // Disable animations
        options.addArguments("--remote-allow-origins=*"); // Allow all origins

        webDriver = new ChromeDriver(options);
        webDriver.get(baseUrl);
        System.out.println("Testing the Login for X");
    }

    @Test
    public void testLoginToX() {
        System.out.println("Muting the notifications :  X ...");

        String currentUrl = webDriver.getCurrentUrl();
        if (!currentUrl.equals(baseUrl)) {
            webDriver.get(baseUrl);
        }

        // Wait for the "Sign In" button to be clickable
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div/div/div[3]/div[4]/a/div")));

        // Click the "Sign In" button
        signInButton.click();

        WebElement MailOrUsernameButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[4]/label/div/div[2]/div/input")));
        MailOrUsernameButton.click();
        MailOrUsernameButton.sendKeys("StudentB881221");

        WebElement NextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/button[2]/div")));
        NextButton.click();
        WebElement PassButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")));
        PassButton.click();
        PassButton.sendKeys("BurchStudent123456");
        WebElement LoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/button/div")));
        LoginButton.click();

       WebElement MmoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/button")));
       MmoreButton.click();
       WebElement SettingsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div[2]/div/div[3]/div/div/div/div/div[8]/a")));
       SettingsButton.click();
       WebElement NotificationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/section[1]/div[2]/div[2]/div[7]/a")));
       NotificationButton.click();
       //works okay
       WebElement FilterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/section[2]/div[2]/div/a[1]")));
       FilterButton.click();
       WebElement MutedNotifButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/section[2]/div[2]/a")));
       MutedNotifButton.click();
       WebElement MutedNotButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/section[2]/div[2]/div/div[2]/div")));
       MutedNotButton2.click();


    }

   /* @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }*/
}

