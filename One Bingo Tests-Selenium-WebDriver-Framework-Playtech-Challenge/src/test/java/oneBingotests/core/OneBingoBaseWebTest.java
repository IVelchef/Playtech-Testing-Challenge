package oneBingotests.core;
import com.onebingo.pages.BingoPage;
import com.onebingo.pages.LoginPageBingo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class OneBingoBaseWebTest extends BaseWebTest {

   protected LoginPageBingo loginPageBingo;
   protected BingoPage bingoPage;

    @BeforeEach
    public void beforeTests() {


        loginPageBingo = new LoginPageBingo();
        bingoPage = new BingoPage();

        driver().get(PropertiesManager.getConfigProperties().getProperty("demoBingoBaseUrl"));
    }



    @AfterAll
    public static void afterAll() {

        driver().close();
    }
}