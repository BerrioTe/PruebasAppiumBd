package com.amazon.UI;

import net.serenitybdd.screenplay.targets.Target;

public class ValidarProductosUI {
    public static final Target LBL_VALIDAR1 = Target.the("Lista de busqueda").locatedBy("//android.widget.TextView[contains(@text, 'Refrigerator')]");
    public static final Target LBL_VALIDAR2 = Target.the("Lista de busqueda").locatedBy("//android.widget.TextView[contains(@text, 'Printer')]");
}
