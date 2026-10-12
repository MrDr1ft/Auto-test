package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void testCheckboxesState() {
        CheckboxesPage page = new CheckboxesPage(driver);
        page.open();

        Assert.assertFalse(page.isCheckboxSelected(0), "Первый чекбокс должен быть выключен");
        page.clickCheckbox(0);
        Assert.assertTrue(page.isCheckboxSelected(0), "Первый чекбокс должен быть включен");

        Assert.assertTrue(page.isCheckboxSelected(1), "Второй чекбокс должен быть включен");
        page.clickCheckbox(1);
        Assert.assertFalse(page.isCheckboxSelected(1), "Второй чекбокс должен быть выключен");
    }
}
