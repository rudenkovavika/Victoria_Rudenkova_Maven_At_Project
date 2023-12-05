package homework.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WildberriesSecondTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://wildberries.by");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-text='strAgree']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Главное меню']")).click();

        WebElement zooStaff = driver.findElement(By.xpath("//li[@data-ind='14']/span"));
        new Actions(driver)
                .scrollToElement(zooStaff)
                .perform();
        driver.findElement(By.xpath("//li[@data-ind='14']/span")).click();

        driver.findElement(By.xpath("//li[@data-ind='5']/span")).click();
        driver.findElement(By.xpath("//li[@data-ind='2']/span")).click();
        Thread.sleep(1000);

        String beginningStr = driver.findElement(By.xpath("//div[@class='total-goods']")).getText();
        beginningStr = beginningStr.replaceAll("[^0-9]","");
        int beginningInt = Integer.parseInt(beginningStr);

        driver.findElement(By.xpath("//div[@class='filter-more']//span[@class='filter-more__text']")).click();
        driver.findElement(By.xpath("//div[@data-id='3214']")).click();
        Thread.sleep(500);

        WebElement price = driver.findElement(By.xpath("//div[@data-id='70']"));
        new Actions(driver)
                .scrollToElement(price)
                .perform();

        driver.findElement(By.xpath("//input[@data-tag='inputMax']")).click();
        driver.findElement(By.xpath("//input[@data-tag='inputMax']")).clear();
        //не получается удалить введённые символы в макс цене
        driver.findElement(By.xpath("//input[@data-tag='inputMax']")).sendKeys("100");
        Thread.sleep(500);

        WebElement packaging = driver.findElement(By.xpath("//span[@data-count='84']"));
        new Actions(driver)
                .scrollToElement(packaging)
                .perform();

        driver.findElement(By.xpath("//div[@data-id='125595']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@data-id='129699']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='filters-sidebar__close']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='total-goods']")).getText());
        driver.findElement(By.xpath("//div[@class='chip chip--reset-button']")).click();

        String endStr = driver.findElement(By.xpath("//div[@class='total-goods']")).getText();
        endStr = endStr.replaceAll("[^0-9]","");
        int endInt = Integer.parseInt(endStr);

        if (beginningInt < endInt) {
            System.out.println("В начале меньше товаров, чем в конце");
        } else if (beginningInt > endInt) {
            System.out.println("В начале больше товаров, чем в конце");
        } else {
            System.out.println("В начале и в конце одинаковое количество товаров");
        }
    }
}
