import com.codeborne.selenide.Configuration;
import org.junit.*;

import static com.codeborne.selenide.Selenide.*;

public class TestPage {

    private MarketPage marketPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikita\\Documents\\test_market_yandex\\drivers\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("https://yandex.ru");
        marketPage = new MarketPage();
    }

    @Test
    public void numOfItemsCheck() {
        marketPage.getTVsList();
        int numOfItems = marketPage.getNumOfItems();
        int NUM_OF_ITEMS_EXPECTED = 48;
        Assert.assertEquals(numOfItems, NUM_OF_ITEMS_EXPECTED);
    }

    @Test
    public void firstItemCheck() {
        marketPage.getTVsList();
        marketPage.searchItem(marketPage.getNameOfFirstItem());
        String firstItemName = marketPage.getNameOfFirstItem().toLowerCase();
        String firstSuggestedName = marketPage.getSuggestedItem();
        Assert.assertEquals(firstItemName, firstSuggestedName);
    }
}
