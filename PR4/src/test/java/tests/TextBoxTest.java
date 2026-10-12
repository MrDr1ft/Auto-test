package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;

@Epic("Elements")
@Feature("Text Box")
public class TextBoxTest extends BaseTest {

    @Test(description = "Позитив: валидные данные приводят к отображению блока результата")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Student")
    public void shouldSubmitValidData() {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "ivan.petrov@example.com", "Current Address", "Permanent Address");
        Assert.assertTrue(page.isOutputVisible(), "Ожидалось появление блока результатов.");
    }

    @Test(description = "Негатив: невалидный email подсвечивается как ошибка")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Student")
    public void shouldHighlightInvalidEmail() {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "not-an-email", "Current Address", "Permanent Address");
        String cssClass = page.emailFieldClass();
        Assert.assertTrue(cssClass.contains("error") || cssClass.contains("field-error") || cssClass.contains("invalid"),
                "Ожидалась индикация ошибки для поля email.");
    }
}
