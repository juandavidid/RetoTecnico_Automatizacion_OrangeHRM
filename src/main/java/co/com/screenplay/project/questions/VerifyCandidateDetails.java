package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.questions.Text;

public class VerifyCandidateDetails implements Question<Boolean> {
    private static final By NAME_LOCATOR = By.xpath("//div[text()='Juan David Carrillo']");
    private static final By VACANCY_LOCATOR = By.xpath("//div[text()='Software Engineer']");

    @Override
    public Boolean answeredBy(Actor actor) {
        String candidateName = Text.of(NAME_LOCATOR).answeredBy(actor).toString();
        String vacancy = Text.of(VACANCY_LOCATOR).answeredBy(actor).toString();

        return candidateName.equals("Juan David Carrillo") && vacancy.equals("Software Engineer");
    }

    public static VerifyCandidateDetails isCorrect() {
        return new VerifyCandidateDetails( );
    }
}
