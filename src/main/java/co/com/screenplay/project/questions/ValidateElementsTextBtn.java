package co.com.screenplay.project.questions;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.screenplay.project.ui.HomeUI.TXT_RANDOM_NAME_BTN;

@AllArgsConstructor
@Slf4j
public class ValidateElementsTextBtn implements Question<Boolean> {

    private String validTextSubElementBtn;
    @Override
    public Boolean answeredBy(Actor actor) {

        boolean result;
        String validTextBtnHeader = TXT_RANDOM_NAME_BTN.resolveFor(actor).getText();

        if(validTextBtnHeader != null && validTextSubElementBtn.equals(validTextBtnHeader)){
           log.info(validTextSubElementBtn);
           result = true;
        }else{
            result = false;
        }
        return result;
    }


    public static ValidateElementsTextBtn witchParams(String validTextSubElementBtn){
        return new ValidateElementsTextBtn(validTextSubElementBtn);

    }




}
