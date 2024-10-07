package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class VerifyCandidatesTitle implements Question<Boolean> {
    private static final By TITLE_LOCATOR = By.xpath("//h5[contains(@class, 'oxd-text') and text()='Candidates']");


    @Override
    public Boolean answeredBy(Actor actor) {
        String titleText = Text.of(TITLE_LOCATOR).answeredBy(actor).toString();
        return titleText.equals("Candidates");
    }

    public static VerifyCandidatesTitle isVisible() {
        return new VerifyCandidatesTitle();
    }


}
