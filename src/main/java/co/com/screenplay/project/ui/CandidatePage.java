package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CandidatePage {

    public static final Target FIRST_NAME = Target.the("campo de primer nombre")
            .located(By.name("firstName"));
    public static final Target MIDDLE_NAME = Target.the("campo de segundo nombre")
            .located(By.name("middleName"));
    public static final Target LAST_NAME = Target.the("campo de apellido")
            .located(By.name("lastName"));
    public static final Target VACANCY_DROPDOWN = Target.the("dropdown de vacante")
            .located(By.cssSelector(".oxd-select-text.oxd-select-text--active"));  // Ajusta este selector según lo que funcione mejor

    public static final Target VACANCY = Target.the("campo de vacante")
            .located(By.xpath("//div[contains(@class, 'oxd-select-dropdown')]//span[text()='Software Engineer']"));
    public static final Target EMAIL = Target.the("campo de email")
            .located(By.xpath("//label[text()='Email']//following::input[@class='oxd-input oxd-input--active']"));
    public static final Target CONTACT_NUMBER = Target.the("campo de contacto")
            .located(By.xpath("//label[text()='Contact Number']//following::input[@class='oxd-input oxd-input--active']"));
    public static final Target SAVE_MESSAGE = Target.the("mensaje de guardado")
            .located(By.id("oxd-toaster_1"));

    public static final Target BTN_SAVE = Target.the("Boton de guardar")
            .located(By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Save')]"));
}
