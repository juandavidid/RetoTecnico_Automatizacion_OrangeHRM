package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;


public class NavigateRecruitmentRegister implements Task {
    public static final By RECRUITMENT_BUTTON = By.xpath("//a[contains(@href, '/recruitment/viewRecruitmentModule')]");


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(RECRUITMENT_BUTTON));
    }

    public static NavigateRecruitmentRegister recruitmentPage() {
        return new NavigateRecruitmentRegister();
    }
}
