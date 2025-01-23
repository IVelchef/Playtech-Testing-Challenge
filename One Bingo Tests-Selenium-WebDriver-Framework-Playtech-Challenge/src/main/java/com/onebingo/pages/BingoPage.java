package com.onebingo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class BingoPage extends BingoHomePage {

    private final By Game = By.xpath("//div[text()='Yankee Bingo']");
    private final By ByTicketsGame = By.xpath("//div[text()='Buy Tickets']");
    private final By confButtonLocator = By.xpath("//div[text()='Confirm']");
    private final By parentLocatorCtd = By.cssSelector(".sales-close-countdown");
    private final By countdownLocatorCtd = By.cssSelector(".countdown");
    private final By drawnNumberElementLocator = By.cssSelector(".ball-value.z-10");
    private final By bingoCellsLocator = By.cssSelector(".ticket-cell");
    private final By numberElementsLocator = By.cssSelector(".z-10");
    private final By bingoCellsLocators = By.cssSelector(".ticket-cell");



    public BingoPage() {
        super("/");
    }

    public void buyTicketsGame() {
        WebElement game = driverWait().until(ExpectedConditions.elementToBeClickable(Game));
        game.click();

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        WebElement buyTicketsButton = wait.until(ExpectedConditions.elementToBeClickable(ByTicketsGame));
        buyTicketsButton.click();

        WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(confButtonLocator));
        confirmBtn.click();
    }

    public void startBingoGame() {
        try {
            WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(30));

            WebElement parentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(parentLocatorCtd));


            boolean timerReachedZero = false;
            while (!timerReachedZero) {
                WebElement countdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(countdownLocatorCtd));
                String countdownText = countdownElement.getText();
                //System.out.println("Current timer time: " + countdownText);

                if ("00:00".equals(countdownText)) {
                    timerReachedZero = true;
                } else {
                    Thread.sleep(1000);
                }
            }

            System.out.println("Waiting for 18 seconds after 00:00...");
            Thread.sleep(18000);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        int maxIterations = 75;
        int iterations = 0;
        int markedCount = 0;
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(60));

        String lastDrawnNumber = "";

        while (iterations < maxIterations) {
            String drawnNumber = "";

            try {
                WebElement drawnNumberElement = wait.until(ExpectedConditions.presenceOfElementLocated(drawnNumberElementLocator));
                drawnNumber = drawnNumberElement.getText().trim();

                if (drawnNumber.equals(lastDrawnNumber)) {
                    continue;
                }

                System.out.println("Drawn number: " + drawnNumber);
                lastDrawnNumber = drawnNumber;
            } catch (Exception e) {
                System.err.println("Error while getting the drawn number: " + e.getMessage());
                continue;
            }

            List<WebElement> bingoCells = driver().findElements(bingoCellsLocator);
            boolean numberFoundAndMarked = false;

            for (WebElement cell : bingoCells) {
                List<WebElement> numberElements = cell.findElements(numberElementsLocator);
                if (!numberElements.isEmpty()) {
                    WebElement numberElement = numberElements.get(0);
                    String cellNumber = numberElement.getText().trim();

                    if (cellNumber.equals("*")) {
                        continue;
                    }

                    if (cellNumber.equals(drawnNumber)) {
                        boolean isMarked = cell.getAttribute("class").contains("dabbed");
                        if (isMarked) {
                            markedCount++;
                            System.out.println("The number " + drawnNumber + " was found and marked: " + isMarked);}
                        numberFoundAndMarked = true;
                        break;
                    }
                }
            }

            if (!numberFoundAndMarked) {
                System.out.println("The number " + drawnNumber + " was not found and marked.");
            }

            if (markedCount >= 20) {
                break;
            }

            iterations++;
        }

        System.out.println("The bingo number cycle has finished.");
    }


    public int getMarkedCount() {
        List<WebElement> bingoCells = driver().findElements(bingoCellsLocators);
        int markedCount = 0;

        for (WebElement cell : bingoCells) {
            if (cell.getAttribute("class").contains("dabbed")) {
                markedCount++;
            }
        }

        return markedCount;
    }
}


