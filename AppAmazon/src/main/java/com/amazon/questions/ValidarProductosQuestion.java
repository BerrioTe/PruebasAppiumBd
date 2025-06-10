package com.amazon.questions;

import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.amazon.UI.ValidarProductosUI.LBL_VALIDAR1;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarProductosQuestion implements Question<Boolean> {

    private final Target primerElemento;
    private final String primerTextoEsperado;
    private final Target segundoElemento;
    private final String segundoTextoEsperado;

    public ValidarProductosQuestion(Target primerElemento, String primerTextoEsperado, Target segundoElemento, String segundoTextoEsperado) {
        this.primerElemento = primerElemento;
        this.primerTextoEsperado = primerTextoEsperado;
        this.segundoElemento = segundoElemento;
        this.segundoTextoEsperado = segundoTextoEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WaitUntil.the(LBL_VALIDAR1, isVisible()).forNoMoreThan(20).seconds();
         boolean S=LBL_VALIDAR1.resolveFor(actor).isDisplayed();
        WaitUntil.the(LBL_VALIDAR1, isVisible()).forNoMoreThan(100).seconds();
        return LBL_VALIDAR1.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> validacion(Target primerElemento, String primerTextoEsperado, Target segundoElemento, String segundoTextoEsperado) {
        return new ValidarProductosQuestion(primerElemento, primerTextoEsperado, segundoElemento, segundoTextoEsperado);
    }
}