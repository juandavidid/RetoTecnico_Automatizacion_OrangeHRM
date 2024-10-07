package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
public class ScrollToCandidate implements Task {
    private static final By CANDIDATE_ROW_LOCATOR = By.xpath("//div[contains(@class, 'oxd-table-row') and .//div[text()='Juan David Carrillo'] and .//div[text()='Software Engineer']]");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CANDIDATE_ROW_LOCATOR)
        );

        try {
            Thread.sleep(8000); // Pausa de 10 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ScrollToCandidate toJuanDavidRow() {
        return new ScrollToCandidate();
    }
}
