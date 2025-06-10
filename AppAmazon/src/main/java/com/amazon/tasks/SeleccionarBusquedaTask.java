package com.amazon.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import java.util.List;
import static com.amazon.UI.HomeUI.LST_BUSQUEDA;
import static com.amazon.iterations.SeleccionarElementosIteration.en;

public class SeleccionarBusquedaTask {
    public static Performable seleccionarBusqueda() {
        return Task.where(
                actor -> {
                    List<WebElementFacade> elementos = LST_BUSQUEDA.resolveAllFor(actor);
                    actor.attemptsTo(en(elementos)
                    );
                }
        );
    }
}


