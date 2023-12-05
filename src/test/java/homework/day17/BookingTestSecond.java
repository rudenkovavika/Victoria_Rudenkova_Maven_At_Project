package homework.day17;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BookingTestSecond {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.booking.com");

        driver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']")).click();

        WebElement inputCity = driver.findElement(By.xpath("//input[@name='ss']"));
        inputCity.clear();
        inputCity.sendKeys("London");
        driver.findElement(By.xpath("//div[text()='London']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement scrollToPosition = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));

//
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", scrollToPosition);
//
//        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", scrollToPosition);
//
//
//        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", element);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", scrollToPosition);
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click()," element);
    }
}
