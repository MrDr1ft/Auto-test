package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testPositiveLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);
        InventoryPage inventoryPage = new InventoryPage(driver, wait);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(inventoryPage.getTitleText(), "Products", "Заголовок страницы должен быть 'Products'");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "URL должен содержать inventory.html");
    }

    @Test
    public void testLockedOutUserLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.login("locked_out_user", "secret_sauce");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface: Sorry, this user has been locked out."), 
                "Должно отображаться сообщение о заблокированном пользователе");
    }
}
