import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void registrarProducto(Producto producto) {
        Categoria categoria = buscarCategoriaPorId(producto.idCategoria);
        if (categoria != null) {
            categoria.agregarProducto(producto);
            productos.add(producto);
        } else {
            System.out.println("Categoría no encontrada. Producto no registrado.");
        }
    }

    public void registrarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void eliminarProducto(int idProducto) {
        Producto productoAEliminar = buscarProductoPorId(idProducto);
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            for (Categoria categoria : categorias) {
                categoria.eliminarProducto(productoAEliminar);
            }
            System.out.println("Se eliminó el producto con el ID: " + idProducto);
        } else {
            System.out.println("No existe un producto con el ID: " + idProducto);
        }
    }

    public void mostrarProductos() {
        System.out.println("*** PRODUCTOS EN EL SISTEMA ***");
        if (productos.isEmpty()) {
            System.out.println("No existen productos en el sistema");
            return;
        }
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("\nProducto " + (i + 1) + ": " + productos.get(i));
        }
    }

    public void mostrarCategorias() {
        System.out.println("\n*** CATEGORÍAS EN EL SISTEMA ***");
        if (categorias.isEmpty()) {
            System.out.println("No existen categorías en el sistema");
            return;
        }
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println("\nCategoría " + (i + 1) + ": " + categorias.get(i));
        }
    }

    public void mostrarCategoriasConProductos() {
        System.out.println("\n*** CATEGORÍAS CON PRODUCTOS ***");
        if (categorias.isEmpty()) {
            System.out.println("No existen categorías en el sistema");
            return;
        }
        for (Categoria categoria : categorias) {
            categoria.mostrarConProductos();
        }
    }

    public boolean tieneCategorias() {
        return !categorias.isEmpty();
    }

    private Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    private Categoria buscarCategoriaPorId(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

}
