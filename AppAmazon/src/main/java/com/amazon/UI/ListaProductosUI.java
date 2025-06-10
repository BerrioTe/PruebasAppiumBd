package com.amazon.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListaProductosUI {
    public static final Target LST_PRODUCTOS = Target.the("Lista de busqueda").locatedBy("//*[contains(@text,'Add to cart')]");
    public static final Target CART_BUTTON = Target.the("Select option Add to cart").located(By.id("com.amazon.mShop.android.shopping:id/cart_count"));
}
