package co.com.screenplay.project.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import co.com.screenplay.project.ui.LoginPage;
public class LoginTask implements Task {



    private final String username;
    private final String password;

    // Constructor para inicializar username y password
    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static LoginTask conCredenciales(String username, String password) {
        return Tasks.instrumented(LoginTask.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }



}

