import java.util.ArrayList;
import java.util.Random;

public class Categoria {
    public static final Random RANDOM = new Random();

    public int id;
    public String nombre;
    public ArrayList<Producto> listaProductos;

    public Categoria(String nombre) {
        this.id = generarIdUnico();
        this.nombre = nombre;
        this.listaProductos = new ArrayList<>();
    }

    private int generarIdUnico() {
        return RANDOM.nextInt(1, 10001); 
    }

    public void registrarProductoEnCategoria(Producto producto) {
        if (!listaProductos.contains(producto)) {
            this.listaProductos.add(producto);
            producto.idCategoria = this.id; 
        } else {
            System.out.println("El producto ya está registrado en esta categoría.");
        }
    }

    public void eliminarProducto(Producto producto) {
        if (listaProductos.remove(producto)) {
            System.out.println("Producto eliminado de la categoría: " + producto.mostrarProducto());
        } else {
            System.out.println("El producto no se encuentra en la categoría.");
        }
    }

    public void mostrarCategoria() {
        System.out.println(String.format("Id: %d, Nombre: %s", this.id, this.nombre));
    }

    public void mostrarCategoriaConProductos() {
        System.out.println("\nCategoría: " + this.nombre);
        System.out.println("Id: " + this.id);
        System.out.println("Productos existentes: " + listaProductos.size());

        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos en esta categoría.");
            return;
        }

        for (Producto producto : listaProductos) {
            System.out.println(producto.mostrarProducto());
        }
    }

    public void agregarProducto(Producto producto) {
    }


    public void agregarProducto() {
    }

    public void mostrarConProductos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

