package com.amazon.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class HomeUI {

    public static final Target LST_BUSQUEDA = Target.the("Lista de busqueda").locatedBy("//android.view.View[@resource-id=\"attach-to-me\"]/android.view.View");

    public static final Target TXT_BUSCAR = Target.the("").located(By.id("chrome_search_hint_view"));
    public static final Target TXT_BUSCAR2 = Target.the("").located(By.id("rs_search_src_text"));


}
