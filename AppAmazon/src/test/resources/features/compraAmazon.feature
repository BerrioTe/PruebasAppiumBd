#language: es
Característica: Realizar compra en Amazon
@Compra
  Escenario: Compra Exitosa
    Dado que el usuario se encuentra en la App de Amazon
    Cuando agregue productos al carrito
    Entonces verificara los productos agregados