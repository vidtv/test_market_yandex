import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Никита\\IdeaProjects\\test_market_yandex\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Задаем неявное ожидание 3 секунды для поиска товаров
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://yandex.ru");

        MarketPage marketPage = new MarketPage(driver);

        marketPage.getTVsList();
    }
}
