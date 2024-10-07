package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import co.com.screenplay.project.ui.CandidatePage;


public class VerifySaveMessage implements Question<Boolean> {
    private final String message;

    public VerifySaveMessage(String message) {
        this.message = message;
    }

    public static VerifySaveMessage contains(String message) {
        return new VerifySaveMessage(message);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(CandidatePage.SAVE_MESSAGE).answeredBy(actor).toString().contains(message);
    }
}
