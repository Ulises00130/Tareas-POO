package dulceria;

import java.util.ArrayList;

public class Dulceria {

    public ArrayList<Producto> productos = new ArrayList<>();
    private void inicializarProductos() {
        productos.add(new Producto(20,"Palomitas", 50.00));
        productos.add(new Producto(10,"Refresco", 30.00));
        productos.add(new Producto(30,"Nachos", 40.00));

    }
}
