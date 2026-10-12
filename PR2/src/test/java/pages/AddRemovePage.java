package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AddRemovePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By addElementButton = By.xpath("//button[text()='Add Element']");
    private By deleteButtons = By.xpath("//button[text()='Delete']");

    public AddRemovePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void clickAddElement(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(addElementButton).click();
        }
    }

    public void clickDeleteElement(int index) {
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(deleteButtons));
        buttons.get(index).click();
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButtons).size();
    }
}
