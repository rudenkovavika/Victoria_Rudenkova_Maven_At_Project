package homework.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ActionTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.w3schools.com/java/");

        Actions make = new Actions(driver);
        WebElement tutorial = driver.findElement(By.xpath("//span[@class='color_h1']"));
        make
                .doubleClick(tutorial)
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .build().perform();

        driver.get("https://google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        make
                .click(searchField)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .build().perform();

        List<String> list = Arrays.asList("tutorial");
        boolean containsText = list.stream()
                .anyMatch(text -> {
                    List<WebElement> elements = driver.findElements(By.xpath(
                            String.format("//div[@id='rso']//h3[contains(text(), '%s')]", text)
                    ));
                    return !elements.isEmpty();
                });
        Assert.assertTrue(containsText);
        driver.quit();
    }
}
