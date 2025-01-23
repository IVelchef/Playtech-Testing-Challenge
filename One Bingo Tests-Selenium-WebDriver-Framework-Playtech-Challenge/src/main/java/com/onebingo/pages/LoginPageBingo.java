package com.onebingo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageBingo extends BingoHomePage {


    private final By usernameLocator = By.xpath("//input[@name='user_name']");
    private final By passwordLocator = By.xpath("//input[@type='password']");
    private final By acceptButtonLocator = By.xpath("//div[text()='Accept']");

    public LoginPageBingo() {
        super("/");

    }


    public void submitLoginForm(String username, String pass) {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        usernameInput.sendKeys(username);

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        password.sendKeys(pass);

        password.sendKeys(Keys.ENTER);

        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptButtonLocator));
        acceptButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptButtonLocator));
    }
}

