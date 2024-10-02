package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.questions.ValidateElementsTextBtn;
import co.com.screenplay.project.tasks.ChooseRandomTask;
import co.com.screenplay.project.tasks.FuntionsElementsTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.screenplay.project.utils.Constants.ACTOR;
import static co.com.screenplay.project.utils.Constants.REMEMBER_TEXT_BTN_SUB_ELEMENTS;
import static co.com.screenplay.project.utils.DataFaker.fakerNumberOneAndNine;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Slf4j
public class OpenWebStep {

    @Before
    public void setTheStage() { OnStage.setTheStage(new OnlineCast());}


    @And("desea validar la funcion de la carte de elementos")
    public void wantValidateTheFunctionOfTheChartOfElements() {
        OnStage.theActorCalled(ACTOR).attemptsTo(FuntionsElementsTask.choose());
    }

    @When("selecciona aleatoriamente alguna de las subfunciones")
    public void randomlySelectsSomeOfTheSubfunctions() {
        OnStage.theActorCalled(ACTOR).attemptsTo(ChooseRandomTask.witchParams(fakerNumberOneAndNine()));
    }

    @Then("visualizara en la cabecera el nombre de la opcion elegida")
    public void willDisplayInTheHeaderTheNameOfTheChosenOption() {
        String validateText = OnStage.theActor(ACTOR).recall(REMEMBER_TEXT_BTN_SUB_ELEMENTS);
        if (validateText != null){
            log.info(validateText);
        }

        theActorInTheSpotlight().should(seeThat(
                ValidateElementsTextBtn.witchParams(validateText))
        );
    }
}
