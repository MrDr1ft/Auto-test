import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZipCodeTest {

    @Test
    public void checkZipCode4digits() {
        WebDriver driver = new ChromeDriver();
        // Добавляем неявное ожидание, чтобы элементы успевали прогрузиться
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value='Continue']")).click();

        // Исправленный локатор для сообщения об ошибке на Sharelane
        String errorMessage = driver.findElement(By.className("error_message")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");

        driver.quit();
    }

    @Test
    public void checkPositiveZipCode() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();

        // На следующем шаге регистрации кнопка называется "Register"
        boolean elementOnPage = driver.findElement(By.cssSelector("[value='Register']")).isDisplayed();
        Assert.assertTrue(elementOnPage);

        driver.quit();
    }
}