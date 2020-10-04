import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.stream.Collectors;

public class JenkinsTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void someJenkinsTest() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.delfi.lv");
        List<WebElement> articles = driver.findElements(By.tagName("article"));

//        for (int i = 0; i < articles.size(); i++) {
//            System.out.println(i + ": " + articles.get(i).getText());
//        }

        List<String> articlesText = articles.stream()
                .map(WebElement::getText)
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(Collectors.toList());

        String firstText = articlesText.stream()
                .filter(t -> t.contains("ir"))
                .findFirst()
                .orElse("Nothing");
    }
}
