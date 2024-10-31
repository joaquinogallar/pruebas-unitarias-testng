package org.example.entity;

public class Almacen {

    /**
     * Aumenta el stock de un ingrediente en la cantidad especificada.
     * @param ingrediente El ingrediente cuyo stock será incrementado.
     * @param cantidad La cantidad a agregar al stock.
     */
    public static void IngresarConsumibles(Ingrediente ingrediente, int cantidad) {
        ingrediente.incrementarStock(cantidad);
    }

    /**
     * Disminuye el stock de un ingrediente en la cantidad especificada.
     * @param ingrediente El ingrediente cuyo stock será decrementado.
     * @param cantidad La cantidad a quitar del stock.
     */
    public static void QuitarConsumibles(Ingrediente ingrediente, int cantidad) {
        ingrediente.decrementarStock(cantidad);
    }
}
