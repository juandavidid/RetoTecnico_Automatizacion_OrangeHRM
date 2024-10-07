package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.questions.*;
import co.com.screenplay.project.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static org.hamcrest.Matchers.is;

import co.com.screenplay.project.tasks.ScrollToCandidate;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@Slf4j
public class OpenWebStep {
    @Before
    public void setTheStage() { OnStage.setTheStage(new OnlineCast());}
    @When("el usuario ingresa el Username y el Password")
    public void theUserEntersTheUsernameAndPassword() {
        // Obtener el actor en el escenario y asignarle la tarea LoginTask
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.conCredenciales("Admin", "admin123")
        );
    }

    @Then("visualizara el panel principal de la aplicacion")
    public void willDisplayTheMainPanelOfTheApplication() {

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El panel principal es visible", VerifyDashboard.isDisplayed(), is(true))
        );
    }
    @When("^el usuario navega a la opción \"([^\"]*)\"$")
    public void navigateToOption(String option) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateToRecruitment.to(option)
        );
    }
    @And("^el usuario hace clic en el botón \"([^\"]*)\"$")
    public void clickOnButton(String button) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickAddButton.named(button)
        );
    }
    @And("llena el formulario de nuevo candidato con los datos:$")
    public void fillCandidateForm(DataTable table) {
        Map<String, String> candidateData = table.asMap(String.class, String.class);
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillCandidateForm.withData(candidateData)
        );
    }

    @Then("Validar el mensaje \"([^\"]*)\"$")
    public void shouldSeeMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VerifySaveMessage.contains(message))
        );
    }


    @Then("validar los datos en la pantalla \"Application Stage\":")
    public void validateDataInApplicationStage(io.cucumber.datatable.DataTable dataTable) {
        // Obtén los datos de la tabla de Gherkin
        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        String firstname = datos.get("First Name");
        String middle = datos.get("Middle");
        String lastName = datos.get("Last Name");
        String jobVacancy = datos.get("Job Vacancy");

        // Verificar los datos en la pantalla "Application Stage"
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerifyApplicationStage.withData(firstname, middle, lastName , jobVacancy))
        );
    }

    @Then("scroll y validar los campos \"Email\" y \"Contact Number\":")
    public void scrollAndValidateEmailAndContactNumber(io.cucumber.datatable.DataTable dataTable) {
        // Obtén los datos de la tabla de Gherkin
        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        String email = datos.get("Email");
        String contactNumber = datos.get("Contacto");

        // Scroll y verificar los datos de contacto
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerifyContactDetails.withData(email, contactNumber))
        );
    }


    @Then("hacer scroll y hacer clic en el botón \"Shortlist\"")
    public void scrollAndClickShortlistButton() {
        // Scroll hacia el botón "Shortlist" y hacer clic
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickShortlistButton.now()
        );
    }


    @Then("validar el subtítulo {string}")
    public void validarElSubtitulo(String subtituloEsperado) {
        OnStage.theActorInTheSpotlight().should(seeThat(VerifySubTitle.isDisplayed()));
    }

    @Then("dar clic en la opción {string}")
    public void darClicEnLaOpcion(String opcion) {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(NavigateRecruitmentRegister.RECRUITMENT_BUTTON));
    }

    @Then("validar el título {string}")
    public void validarEltitulo(String subtituloEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerifyCandidatesTitle.isVisible())
        );
    }



    @Then("hacer scroll hasta la información del candidato {string} y la vacante {string}")
    public void scrollAndValidateCandidateDetails(String candidateName, String vacancy) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ScrollToCandidate.toJuanDavidRow()
        );

        
    }


    @Then("validar los datos {string} y {string}")
    public void validarLosDatosDelCandidato(String candidateName, String vacancy) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerifyCandidateDetails.isCorrect())
        );
    }











}
