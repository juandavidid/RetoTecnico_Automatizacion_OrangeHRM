package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.By;

public class VerifySubTitle implements Question<Boolean> {

    private static final By SUBTITLE_LOCATOR = By.xpath("//h6[contains(@class, 'oxd-text oxd-text--h6 orangehrm-main-title')]");


    @Override
    public Boolean answeredBy(Actor actor) {
        String subtitleText = Text.of(SUBTITLE_LOCATOR).answeredBy(actor).toString();
        return subtitleText.equals("Shortlist Candidate");
    }

    public static VerifySubTitle isDisplayed() {
        return new VerifySubTitle();
    }
}
