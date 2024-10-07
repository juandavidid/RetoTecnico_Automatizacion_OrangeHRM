package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME = Target.the("campo de username")
            .located(By.name("username"));
    public static final Target PASSWORD = Target.the("campo de password")
            .located(By.name("password"));
    public static final Target LOGIN_BUTTON = Target.the("botón de login")
            .located(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
}
