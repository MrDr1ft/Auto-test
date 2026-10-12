package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public Select getDropdownSelect() {
        return new Select(driver.findElement(dropdown));
    }

    public void selectByValue(String value) {
        getDropdownSelect().selectByValue(value);
    }

    public String getSelectedOptionText() {
        return getDropdownSelect().getFirstSelectedOption().getText();
    }
}
