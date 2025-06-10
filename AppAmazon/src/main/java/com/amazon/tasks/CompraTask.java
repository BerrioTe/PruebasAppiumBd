package com.amazon.tasks;

import com.amazon.db.Connections;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.amazon.UI.HomeUI.*;
import static com.amazon.UI.ListaProductosUI.CART_BUTTON;
import static com.amazon.UI.ListaProductosUI.LST_PRODUCTOS;
import static com.amazon.tasks.SeleccionarBusquedaTask.seleccionarBusqueda;
import static com.amazon.tasks.SeleccionarProductoTask.seleccionarProducto;
import java.util.List;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompraTask {

    public static Performable comprarProducto() {
        List<String> valoresDeBusqueda = Connections.leerValoresDeColumna();
        return Task.where(
                actor -> {
                    for (String valor : valoresDeBusqueda) {
                    actor.attemptsTo(
                            WaitUntil.the(TXT_BUSCAR, isVisible()).forNoMoreThan(30).seconds(),
                            Click.on(TXT_BUSCAR),
                            WaitUntil.the(TXT_BUSCAR2, isVisible()).forNoMoreThan(30).seconds(),
                            Enter.theValue(valor).into(TXT_BUSCAR2),
                            WaitUntil.the(LST_BUSQUEDA, isVisible()).forNoMoreThan(30).seconds(),
                            seleccionarBusqueda(),
                            WaitUntil.the(LST_PRODUCTOS, isVisible()).forNoMoreThan(30).seconds(),
                            seleccionarProducto()
                    );
                    }

                    actor.attemptsTo(
                            Click.on(CART_BUTTON)
                    );

                }
        );
    }
}