package co.com.screenplay.project.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;



public class ClickAddButton implements Task {

    private String buttonName;

    public ClickAddButton(String buttonName) {
        this.buttonName = buttonName;
    }

    public static ClickAddButton named(String buttonName) {
        return Tasks.instrumented(ClickAddButton.class, buttonName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(8000); // Pausa de 10 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(

                // Desplazar al elemento
                Scroll.to(By.xpath("//div[contains(@class, 'oxd-autocomplete-wrapper')]")),

                Click.on(By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Add')]"))  // Selector para botón "Add"
        );
    }


}
