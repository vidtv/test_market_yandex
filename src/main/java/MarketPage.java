import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketPage {
    public static WebDriver driver;

    public MarketPage (WebDriver driver) {
        this.driver = driver;
    }

    private By yandexMarketButton = By.xpath("//a[@data-id='market']");
    private By electronicaButton = By.xpath("//a[contains(text(),'Электроника')]");
    private By televisors = By.xpath("//a[contains(text(), 'Телевизоры') and @class='link topmenu__subitem']");
    private By extendedSearch = By.xpath("//a[@class='link i-bem link_js_inited' and contains(text(),'Перейти ко всем фильтрам')]");
    private By minPrice = By.xpath("//input[@id='glf-pricefrom-var']");
    private By chooseSamsung = By.xpath("//label[contains(text(),'Samsung')]/../..");
    private By chooseLG = By.xpath("//label[contains(text(),'LG')]/../..");
    private By itemCard = By.xpath("//div[contains(@class, 'n-snippet-list')]/div[contains(@class, 'n-snippet-card2')]");
    private By itemLink = By.xpath("//div[contains(@class, 'n-snippet-list')]/div[contains(@class, 'n-snippet-card2')][1]//div[@class='n-snippet-card2__title']/a");
    private By itemSearch = By.xpath("//input[@id='header-search']");
    private By suggestItem = By.xpath("//div[@class='suggest2__group'][1]//span[@class='suggest2-rich-item__text']/b");

}
