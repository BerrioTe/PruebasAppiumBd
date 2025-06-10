package com.amazon.iterations;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import java.util.List;
import java.util.Random;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class SeleccionarElementosIteration implements Interaction {

    private final List<WebElementFacade> elementos;

    public SeleccionarElementosIteration(List<WebElementFacade> elementos) {
        this.elementos = elementos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int index = new Random().nextInt(elementos.size());
        WebElementFacade elementoSeleccionado = elementos.get(index);
        elementoSeleccionado.click();
    }

    public static SeleccionarElementosIteration en(List<WebElementFacade> elementos) {
        return instrumented(SeleccionarElementosIteration.class, elementos);
    }
}