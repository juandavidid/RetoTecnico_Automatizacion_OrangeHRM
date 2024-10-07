package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.questions.Text;

public class VerifyApplicationStage implements Question<Boolean>{

    private static final By FIRST_NAME_LOCATOR = By.xpath("//input[@name='firstName']");
    private static final By MIDDLE_NAME_LOCATOR = By.xpath("//input[@name='middleName']");
    private static final By LAST_NAME_LOCATOR = By.xpath("//input[@name='lastName']");
    private static final By JOB_VACANCY_LOCATOR = By.xpath("//div[contains(@class, 'oxd-select-text-input')]");

    private final String expectedFirstName;
    private final String expectedMiddleName;
    private final String expectedLastName;
    private final String expectedJobVacancy;
    public VerifyApplicationStage(String expectedFirstName, String expectedMiddleName, String expectedLastName, String expectedJobVacancy) {
        this.expectedFirstName = expectedFirstName;
        this.expectedMiddleName = expectedMiddleName;
        this.expectedLastName = expectedLastName;
        this.expectedJobVacancy = expectedJobVacancy;
    }
    public static VerifyApplicationStage withData(String expectedFirstName, String expectedMiddleName, String expectedLastName ,String expectedJobVacancy ) {
        return new VerifyApplicationStage(expectedFirstName, expectedMiddleName, expectedLastName, expectedJobVacancy);
    }
    @Override
    public Boolean answeredBy(Actor actor) {

        String firstName = Attribute.of(FIRST_NAME_LOCATOR).named("value").answeredBy(actor).toString();
        String middleName = Attribute.of(MIDDLE_NAME_LOCATOR).named("value").answeredBy(actor).toString();
        String lastName = Attribute.of(LAST_NAME_LOCATOR).named("value").answeredBy(actor).toString();
        String jobVacancy = Text.of(JOB_VACANCY_LOCATOR).answeredBy(actor).toString();

        return firstName.equals(expectedFirstName)  && middleName.equals(expectedMiddleName) && lastName.equals(expectedLastName) && jobVacancy.equals(expectedJobVacancy);
    }



}
