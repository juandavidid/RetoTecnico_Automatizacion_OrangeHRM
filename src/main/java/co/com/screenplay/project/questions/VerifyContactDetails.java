package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.interactions.Pause;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyContactDetails implements Question<Boolean>{
    private static final By EMAIL_LOCATOR = By.xpath("//label[contains(text(), 'Email')]/../following-sibling::div//input");
    private static final By CONTACT_NUMBER_LOCATOR = By.xpath("//label[contains(text(), 'Contact Number')]/../following-sibling::div//input");

    private static final By SHORTLIST_BUTTON_LOCATOR = By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--success')]");

    private static final By TEXT_SUBTITLE = By.xpath("//h6[contains(@class, 'oxd-text oxd-text--h6 orangehrm-main-title')]");

    private final String expectedEmail;
    private final String expectedContactNumber;

    public VerifyContactDetails(String expectedEmail, String expectedContactNumber) {
        this.expectedEmail = expectedEmail;
        this.expectedContactNumber = expectedContactNumber;
    }

    public static VerifyContactDetails withData(String expectedEmail, String expectedContactNumber) {
        return new VerifyContactDetails(expectedEmail, expectedContactNumber);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            Thread.sleep(8000); // Pausa de 10 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(

                Scroll.to(SHORTLIST_BUTTON_LOCATOR));

        String email = Attribute.of(EMAIL_LOCATOR).named("value").answeredBy(actor).toString();
        String contactNumber = Attribute.of(CONTACT_NUMBER_LOCATOR).named("value").answeredBy(actor).toString();

        return email.equals(expectedEmail) && contactNumber.equals(expectedContactNumber);
    }
}
