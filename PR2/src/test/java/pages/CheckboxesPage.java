package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage {
    private WebDriver driver;
    private By checkboxes = By.cssSelector("[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public boolean isCheckboxSelected(int index) {
        return driver.findElements(checkboxes).get(index).isSelected();
    }

    public void clickCheckbox(int index) {
        driver.findElements(checkboxes).get(index).click();
    }
}
