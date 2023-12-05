package classwork.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoodleWidgetTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("погода минск");
        Thread.sleep(500);

        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();

        driver.findElement(By.xpath("//div[@class='wob_df'][1]")).click();

    }
}
