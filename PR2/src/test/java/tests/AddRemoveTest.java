package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemovePage;

public class AddRemoveTest extends BaseTest {

    @Test
    public void testAddAndRemoveElements() {
        AddRemovePage page = new AddRemovePage(driver, wait);
        page.open();

        page.clickAddElement(2);
        Assert.assertEquals(page.getDeleteButtonsCount(), 2, "Количество элементов должно быть 2");

        page.clickDeleteElement(0);
        Assert.assertEquals(page.getDeleteButtonsCount(), 1, "Количество элементов должно стать 1");
    }
}
