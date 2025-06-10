package com.amazon.stepdefinitions;

import com.amazon.questions.ValidarProductosQuestion;
import com.amazon.tasks.CompraTask;
import io.cucumber.java.es.*;
import static com.amazon.UI.ValidarProductosUI.LBL_VALIDAR1;
import static com.amazon.UI.ValidarProductosUI.LBL_VALIDAR2;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraAmazonStepDef {
    @Dado("que el usuario se encuentra en la App de Amazon")
    public void queElUsuarioSeEncuentraEnLaAppDeAmazon() {

    }
    @Cuando("agregue productos al carrito")
    public void agregueProductosAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                CompraTask.comprarProducto()
        );
    }
    @Entonces("verificara los productos agregados")
    public void verificaraLosProductosAgregados() {
        theActorInTheSpotlight().should(seeThat(ValidarProductosQuestion.validacion(LBL_VALIDAR1, "Refrigerator", LBL_VALIDAR2, "Printer")));
    }
}
