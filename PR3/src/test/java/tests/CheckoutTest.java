package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testBuyProductJourney() {
        LoginPage loginPage = new LoginPage(driver, wait);
        InventoryPage inventoryPage = new InventoryPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);

        // 1. Авторизация
        loginPage.login("standard_user", "secret_sauce");

        // 2. Добавление товара в корзину
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack", "Товар в корзине должен совпадать");

        // 3. Оформление заказа (Checkout)
        cartPage.clickCheckout();
        checkoutPage.fillCustomerInfo("Ivan", "Ivanov", "123456");
        checkoutPage.clickFinish();

        // 4. Проверка успешного завершения
        Assert.assertEquals(checkoutPage.getSuccessHeader(), "Thank you for your order!", 
                "Заказ должен быть успешно оформлен");
    }
}
