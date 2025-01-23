package oneBingotests.web;
import org.junit.jupiter.api.Test;
import oneBingotests.core.OneBingoBaseWebTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class testBingoNumberCheck extends OneBingoBaseWebTest {

    @Test
    public void markedBingoNumbersCheckTest()  {

        loginPageBingo.navigate();
        loginPageBingo.submitLoginForm("Wanko12", "1234");

        bingoPage.buyTicketsGame();
        bingoPage.startBingoGame();
        int markedCount = bingoPage.getMarkedCount();

        assertTrue(markedCount >= 20, "The test failed - less than 20 numbers were marked.");

    }
}
