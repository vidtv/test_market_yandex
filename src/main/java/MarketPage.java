import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MarketPage {

    public SelenideElement getBrandChoose(String brandName) {
        return $(By.xpath("//span[contains(text(), \'" + brandName + "\')]"));
    }

    public void getTVsList() {
        getYandexMarketButton().click();
        getElectronicaButton().click();
        getTelevisors().click();
        int MIN_PRICE = 20000;
        getMinPriceInputField().sendKeys(String.valueOf(MIN_PRICE));
        getBrandChoose("Samsung").click();
        getBrandChoose("LG").click();
        getItemsList();
    }

    /* ввод названия первого товара в строку поиска */
    public void searchItem(String item) {
        getItemSearch().sendKeys(item);
    }

    public SelenideElement getYandexMarketButton() {
        return $(By.xpath("//a[@data-id='market']"));
    }

    public SelenideElement getElectronicaButton() {
        return $$(".n-w-tab__control-caption").findBy(Condition.text("Электроника"));
    }

    public SelenideElement getTelevisors() {
        return $(By.xpath("//a[text()='Телевизоры']"));
    }

    public SelenideElement getMinPriceInputField() {
        return $("#glpricefrom");
    }

    /* массив карточек товаров */

    public SelenideElement getItemSearch() {
        return $(By.xpath("//input[@id='header-search']"));
    }

    public SelenideElement getSuggestItem() {
        return $(By.xpath("//div[@class='suggest2__group'][1]//span[@class='suggest2-rich-item__text']/b"));
    }

    public ElementsCollection getItemsList() {
        return $$(By.xpath("//div[@class='n-snippet-card2__title']/a"));
    }

    /* подсчет кол-ва карточек товаров на странице */
    public int getNumOfItems() {
        return getItemsList().size();
    }

    /* название марки товара в первой карточке */
    public String getNameOfFirstItem() {
        SelenideElement firstItem = getItemsList().get(0);
        return firstItem.getAttribute("title").substring("ЖК-телевизор ".length());
    }

    /* извлечение названия предложенного товара */
    public String getSuggestedItem() {
        return getSuggestItem().getText();
    }
}
