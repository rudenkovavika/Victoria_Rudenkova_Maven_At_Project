package classwork.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BookingTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.booking.com");

        driver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']")).click();

        WebElement inputCity = driver.findElement(By.xpath("//input[@name='ss']"));
        inputCity.clear();
        inputCity.sendKeys("Париж");
        driver.findElement(By.xpath("//div[text()='Париж']")).click();

        driver.findElement(By.xpath("//span[@data-date='2023-12-04']")).click();
        driver.findElement(By.xpath("//span[@data-date='2023-12-11']")).click();

        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div[2]/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div[2]/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='no_rooms']/following-sibling::div[2]/button[2]")).click();
        driver.findElement(By.xpath("//div[@data-testid='occupancy-popup']/button")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement scrollToFilter = driver.findElement(By.xpath("//div[@data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']//div[@data-filters-item='review_score:review_score=90']"));
        new Actions(driver)
                .scrollToElement(scrollToFilter)
                .perform();
        driver.findElement(By.xpath("//div[@data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']//div[@data-filters-item='review_score:review_score=90']")).click();

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[@data-id='class_asc']")).click();




    }
}
