package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class oneAStepDefs {
    private WebDriver driver;
    private final By PRICE_FROM = By.id("attr-from-price");
    private final By PRICE_TO = By.id("attr-to-price");

    @Given("opened browser")
    public void initialize_browser() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("page: {string}")
    public void go_to_page(String url) {
        driver.get(url);
    }

    @When("we are setting price from {string} to {string}")
    public void set_from_price(String priceFrom, String priceTo) {
        String url = "https://www.1a.lv/c/datortehnika-preces-birojam/portativie-datori-un-aksesuari/portativie-datori/2t6?plb=" + priceFrom + "&pub=" + priceTo;
        driver.get(url);
    }

    @When("something happens")
    public void checks_here() {
        driver.close();
    }
}
