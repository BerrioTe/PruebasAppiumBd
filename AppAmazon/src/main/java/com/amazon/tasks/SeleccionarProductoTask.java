package com.amazon.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import java.util.List;
import static com.amazon.UI.ListaProductosUI.LST_PRODUCTOS;
import static com.amazon.iterations.SeleccionarElementosIteration.en;

public class SeleccionarProductoTask {
    public static Performable seleccionarProducto() {
        return Task.where(
                actor -> {
                    List<WebElementFacade> elementos = LST_PRODUCTOS.resolveAllFor(actor);
                    actor.attemptsTo(en(elementos)
                    );
                }
        );
    }
}

