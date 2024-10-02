package co.com.screenplay.project.stepdefinition.hook;

import co.com.screenplay.project.hook.OpenWeb;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Constants.TITLE;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} abre el sitio web de pruebas")
    public void openTheTestWebsite(String actor) {

        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL()
        );

        waiting(TIME_SHORT);     // Pausar la prueba mientras carga nuestra pagina web

        // Condicio para validar el Titulo de la Pagina web
        theActorInTheSpotlight().should(

                GivenWhenThen.seeThat(

                        TheWebPage.title(),   // Pregunta al sistema o obtiene el titulo de  la pagina

                        Matchers.containsString(TITLE)  // aqui compara titulo real con el titulo esperado o guardado
                )

        );


    }

}
