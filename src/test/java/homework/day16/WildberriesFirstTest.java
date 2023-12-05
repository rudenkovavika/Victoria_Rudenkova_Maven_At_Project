package homework.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WildberriesFirstTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://wildberries.by");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@aria-label='Главное меню']")).click();
        driver.findElement(By.xpath("//li[@data-ind='4']/span")).click();
        driver.findElement(By.xpath("//li[@data-ind='4']/span")).click();
        driver.findElement(By.xpath("//li[@data-ind='4']/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='filter-more']//span[@class='filter-more__text']")).click();
        driver.findElement(By.xpath("//div[@data-id='937']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@data-id='120']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@data-id='108439']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='filters-sidebar__close']")).click();
        driver.findElement(By.xpath("//div[@data-title='Сортировка']")).click();
        driver.findElement(By.xpath("//div[@data-id='3']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@data-title='Категория']/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@data-title='Бренд']/button")).click();
        Thread.sleep(500);
        System.out.println(driver.findElement(By.xpath("//div[@class='total-goods']")).getText());
    }
}
