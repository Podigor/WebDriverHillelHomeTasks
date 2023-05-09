package hometasks.lesson13;

import configuration.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Lesson13 extends BaseClass {
    private static final String MAIN_URL = "https://ithillel.ua/";
    private static final By consultButton = By.id("btn-consultation-hero"),
            consultFormPopup = By.
                    xpath("//header[@class='form_header']/p[contains(text(),'Запит на консультацію')]"),
            nameField = By.id("input-name-consultation"),
            emailField = By.id("input-email-consultation"),
            phoneField = By.id("input-tel-consultation"),
            telegramButton =By.xpath("//button[@data-name='tg']"),
            telegramIdField =By.xpath("//input[@name='tg']"),
            viberButton =By.xpath("//button[@data-name='vb']"),
            viberIdField =By.xpath("//input[@name='db']"),
            courseDropdownButton = By.id("listbox-btn-input-course-consultation"),
            courseDropdownItems = By.className("listbox_option");

    private static final String name = "Ігор",
            email = "test@test.com",
            phone = "681112233",
            telegramId = "https://t.me/myid",
            viberId = "+380681112233",
            courseName = "QA Automation — Java";

    public static void main(String[] args) throws InterruptedException {
        driver.get(MAIN_URL);
        driver.findElement(consultButton).click();
        checkIfPopupIsDisplayed(consultFormPopup);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        messengerSelection(telegramButton,telegramIdField,telegramId);
        messengerSelection(viberButton,viberIdField,viberId);
        courseSelection(courseDropdownButton,courseDropdownItems,courseName);
        Thread.sleep(10000); //Pause to check if data is entered correctly
        driver.quit();
    }
    private static void checkIfPopupIsDisplayed(By popupLocator) {
        if (driver.findElement(popupLocator).isDisplayed()) {
            System.out.println("Popup is displayed");
        }
    }
    private static void messengerSelection(By messengerButton, By messengerIdField, String messengerId ) {
        driver.findElement(messengerButton).click();
        driver.findElement(messengerIdField).sendKeys(messengerId);
    }
    private static void courseSelection(By dropdownButton, By dropdownItems, String name ) {
        driver.findElement(dropdownButton).click();
        List<WebElement> elements = driver.findElements(dropdownItems);
        for (WebElement webElement : elements) {
            if (webElement.getText().equals(name)) {
                webElement.click();
                break;
            }
        }
    }
}
