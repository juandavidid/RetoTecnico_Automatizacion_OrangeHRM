package co.com.screenplay.project.questions;

import co.com.screenplay.project.ui.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;



public class VerifyDashboard implements Question<Boolean> {
    public static VerifyDashboard isDisplayed() {
        return new VerifyDashboard();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return DashboardPage.MAIN_PANEL.resolveFor(actor).isVisible();
    }
}
