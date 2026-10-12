package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelection() {
        DropdownPage page = new DropdownPage(driver);
        page.open();

        page.selectByValue("1");
        Assert.assertEquals(page.getSelectedOptionText(), "Option 1", "Должна быть выбрана Option 1");

        page.selectByValue("2");
        Assert.assertEquals(page.getSelectedOptionText(), "Option 2", "Должна быть выбрана Option 2");
    }
}
