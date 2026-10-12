package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

@Epic("Alerts, Frame & Windows")
@Feature("Alerts")
public class AlertsTest extends BaseTest {

    @Test(description = "Alert: простая модальная панель обрабатывается корректно")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Student")
    public void shouldAcceptSimpleAlert() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.openAlertAndAccept();
        // Успешный проход без исключений означает корректность обработки алерты
        Assert.assertTrue(true);
    }

    @Test(description = "Confirm: dismiss выводит корректный результат")
    @Severity(SeverityLevel.MINOR)
    @Owner("Student")
    public void shouldDismissConfirm() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.openConfirmAndDismiss();
        String result = page.confirmText().toLowerCase();
        Assert.assertTrue(result.contains("cancel") || result.contains("cancelled"),
                "Ожидался текст о выборе Cancel в результате.");
    }

    @Test(description = "Prompt: введённый текст отражается в результате")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Student")
    public void shouldAcceptPromptWithText() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.openPromptAndSend("demo-test");
        String result = page.promptText().toLowerCase();
        Assert.assertTrue(result.contains("demo-test"),
                "Ожидалось отображение введённого текста в результате.");
    }
}
