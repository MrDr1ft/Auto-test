package tests;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends BaseTest {

    @Test
    public void testInputArrowKeys() {
        InputsPage page = new InputsPage(driver);
        page.open();

        page.sendKeys("5");
        Assert.assertEquals(page.getInputValue(), "5");

        page.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(page.getInputValue(), "6");

        page.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(page.getInputValue(), "5");
    }
}
