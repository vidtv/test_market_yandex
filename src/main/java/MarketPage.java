import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MarketPage {
    public static WebDriver driver;

    public MarketPage (WebDriver driver) {
        this.driver = driver;
    }

    int minPrice = 20000;

    private By yandexMarketButton = By.xpath("//a[@data-id='market']");
    private By electronicaButton = By.xpath("//li[@data-department='Электроника']");
    private By electronicaButtonOther = By.xpath("//div[@class='n-navigation-horizontal__inner']/div[2]/a[text()='Электроника']");
    private By televisors = By.xpath("//a[text()='Аудио- и видеотехника']/following-sibling::div/a[text()='Телевизоры']");
    private By minPriceInputField = By.xpath("//input[@id='glf-pricefrom-var']");
    private By chooseSamsung = By.xpath("//label[contains(text(),'Samsung')]/../..");
    private By chooseLG = By.xpath("//label[contains(text(),'LG')]/../..");
    private By applyButton = By.xpath("//span[@class='button__text'][contains(text(),'Применить')]/..");
    private By itemCard = By.xpath("//div[contains(@class, 'n-snippet-list')]/div[contains(@class, 'n-snippet-card2')]");
    private By itemLink = By.xpath("//div[contains(@class, 'n-snippet-list')]/div[contains(@class, 'n-snippet-card2')][1]//div[@class='n-snippet-card2__title']/a");
    private By itemSearch = By.xpath("//input[@id='header-search']");
    private By suggestItem = By.xpath("//div[@class='suggest2__group'][1]//span[@class='suggest2-rich-item__text']/b");

    /* метод возвращает true или false в зависимости от отрисовки списка категорий Маркета */
    public static boolean isElectronicaButtonExists(By electronica) {
        try {
             driver.findElement(electronica);
             return true;
            }
            catch (NoSuchElementException a) {
                return false;
            }
    }

    /* метод возвращает ссылку на пункт "Электроника" в зависимости от отрисовки списка категорий Маркета */
    public By electronicaButtonFind() {
        if (isElectronicaButtonExists(electronicaButton)) {
            return electronicaButton;
        }
        else return electronicaButtonOther;
    }

    public void yandexMarketButtonClick() {
        driver.findElement(yandexMarketButton).click();
    }

    public void electronicaChoose() {
        driver.findElement(this.electronicaButtonFind()).click();
    }

    public void televisorsChoose() {
        driver.findElement(televisors).click();
    }

    public void minPriceInput() {
        driver.findElement(minPriceInputField).sendKeys(String.valueOf(minPrice));
    }

    public void brandChoose() {
        driver.findElement(chooseSamsung).click();
        driver.findElement(chooseLG).click();
    }

    public void toApply() {
        driver.findElement(applyButton).click();
    }

    public void getTVsList() {
        this.yandexMarketButtonClick();
        this.electronicaChoose();
        this.televisorsChoose();
        this.minPriceInput();
        this.brandChoose();
        this.toApply();
    }

    /* массив карточек товаров */
    private List<WebElement> itemsList;

    public void setItemsList() {
        itemsList = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']/a"));
    }

    /* подсчет кол-ва карточек товаров на странице */
    public int numOfItems() {
        return itemsList.size();
    }

    /* название марки товара в первой карточке */
    public String getNameOfFirstItem() {
        WebElement firstItem = itemsList.get(0);
        String itemTitle = firstItem.getAttribute("title");
        return itemTitle;
    }

}
