package co.com.screenplay.project.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ClickShortlistButton implements Task{

    private static final By TEXT_SUBTITLE = By.xpath("//h6[contains(@class, 'oxd-text oxd-text--h6 orangehrm-main-title')]");
    private static final By SHORTLIST_BUTTON_LOCATOR = By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--success')]");
    public static ClickShortlistButton now() {
        return Tasks.instrumented(ClickShortlistButton.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Hit.the(Keys.HOME).keyIn("//body")
        );
        actor.attemptsTo(
                //Scroll.to(TEXT_SUBTITLE),
                Click.on(SHORTLIST_BUTTON_LOCATOR)
        );
    }

}
