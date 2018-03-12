import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestPage {

    private WebDriver driver;
    private MarketPage marketPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Никита\\IdeaProjects\\test_market_yandex\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://yandex.ru");
        marketPage = new MarketPage(driver);
    }

    @Test
    public void numOfItemsCheck() {
        marketPage.getTVsList();
        int numOfItems = marketPage.getNumOfItems();
        int numOfItemsExpected = 12;
        Assert.assertEquals(numOfItems, numOfItemsExpected);
    }

    @Test
    public void firstItemCheck() {
        marketPage.getMarketPage();
        String firstItemName = marketPage.getNameOfFirstItem();
        String firstSuggestedName = marketPage.getSuggestedItem();
        String firstItemNameLow = firstItemName.toLowerCase();
        Assert.assertEquals(firstItemNameLow, firstSuggestedName);
    }
}
