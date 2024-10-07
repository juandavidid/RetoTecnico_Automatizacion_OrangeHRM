package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import co.com.screenplay.project.ui.CandidatePage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillCandidateForm implements Task {

    private final Map<String, String> candidateData;

    public FillCandidateForm(Map<String, String> candidateData) {
        this.candidateData = candidateData;
    }

    public static FillCandidateForm withData(Map<String, String> candidateData) {
        return Tasks.instrumented(FillCandidateForm.class, candidateData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(candidateData.get("Nombre")).into(CandidatePage.FIRST_NAME),

                Enter.theValue(candidateData.get("Segundo Nombre")).into(CandidatePage.MIDDLE_NAME),

                Enter.theValue(candidateData.get("Apellido")).into(CandidatePage.LAST_NAME),


                Click.on(CandidatePage.VACANCY_DROPDOWN),
                WaitUntil.the(CandidatePage.VACANCY, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CandidatePage.VACANCY),


                Enter.theValue(candidateData.get("Email")).into(CandidatePage.EMAIL),
                Enter.theValue(candidateData.get("Contacto")).into(CandidatePage.CONTACT_NUMBER),





                Scroll.to(CandidatePage.BTN_SAVE),


                WaitUntil.the(CandidatePage.BTN_SAVE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CandidatePage.BTN_SAVE)


        );


    }
}
