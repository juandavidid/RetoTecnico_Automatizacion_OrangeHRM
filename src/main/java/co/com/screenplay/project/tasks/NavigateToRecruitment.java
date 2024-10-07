package co.com.screenplay.project.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class NavigateToRecruitment implements Task {
    private String option;

    public NavigateToRecruitment(String option) {
        this.option = option;
    }
    public static NavigateToRecruitment to(String option) {
        return Tasks.instrumented(NavigateToRecruitment.class, option);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(By.linkText(option))  // Asegúrate de usar un selector adecuado para "Recruitment"
        );
    }

}
