package cine;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import cine.Horarios;

import boletos.Boleto;
import dulceria.Producto;
import peliculas.Pelicula;
import salas.Sala;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.clientes.Cliente;
import usuarios.utils.Rol;

public class Cine {
private Scanner scanner = new Scanner(System.in);
public ArrayList <Cliente> listaClientes = new ArrayList<>();
public ArrayList <Pelicula> listaPeliculas = new ArrayList <>();
public ArrayList <Sala> listaSalas = new ArrayList<>();
public ArrayList <Administrador> listaAdministradores=new ArrayList<>();
public ArrayList <Usuario> listaUsuarios = new ArrayList<>();
public ArrayList <Horarios> listaHorarios = new ArrayList<>();
public ArrayList <Boleto> listaBoletos = new ArrayList<>();
 public ArrayList<Producto> listaProductos = new ArrayList<>();
 public ArrayList<String> boletos = new ArrayList<>(); // Lista de boletos reservados
 private ArrayList<Producto> productosAdicionales = new ArrayList<>(); // Lista de productos adicionales
 private double precioTotal = 0; // Total de la reservación
 private String tipoPago; // Tipo de pago seleccionado
 private boolean esReservacionCompleta = false; 

 public Cine() {
    this.listaSalas = new ArrayList<>();
    inicializarSalas();
}
private void inicializarSalas() {
    for (int i = 1; i <= 5; i++) {  // Crear 5 salas
        Sala nuevaSala = new Sala("Sala " + i, 10, 10);  // Cada sala tiene 10 filas y 10 columnas
        listaSalas.add(nuevaSala);
    }
}




 public String generarIdCliente() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudPacientesMasUno=this.listaClientes.size();
        int numeroAleatorio= random.nextInt(10000);
        String id=String.format("C%d%d%d%d",anoActual,mesActual,longitudPacientesMasUno,numeroAleatorio);
        return id;
    }

    public String generarIdHorario (){
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudHorariosMasUno=this.listaHorarios.size();
        int numeroAleatorio= random.nextInt(10000);
        String id=String.format("H%d%d%d%d",anoActual,mesActual,longitudHorariosMasUno,numeroAleatorio);
        return id;
    }

    public String generarIdPelicula() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudPacientesMasUno=this.listaPeliculas.size();
        int numeroAleatorio= random.nextInt(10000);
        String id=String.format("P%d%d%d%d",anoActual,mesActual,longitudPacientesMasUno,numeroAleatorio);
        return id;
    }

    public String generarIdBoleto (){
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudBoletosMasUno=this.listaBoletos.size();
        int numeroAleatorio= random.nextInt(1000);
        String id=String.format("B%d%d%d%d",anoActual,mesActual,longitudBoletosMasUno,numeroAleatorio);
        return id;
    }
    public String generarIdProducto(){
        Random random = new Random();
        //LocalDate fecha= LocalDate.now();
        int longitudProductosMasUno=this.listaProductos.size();
        int numeroAleatorio= random.nextInt(20);
        String id=String.format("PD%d%d",longitudProductosMasUno,numeroAleatorio);
        return id;
    }

    public void eliminarPelicula (String idPelicula){
        for(Pelicula pelicula : this.listaPeliculas){
            if(pelicula.getId().equals(idPelicula)){
                this.listaPeliculas.remove(pelicula);
                return;
            }
        }
    }
    public void eliminarProductoDulceria (String idProducto){
        int longitudOriginal = this.listaProductos.size();
        this.listaProductos.removeIf((producto) -> producto.getIdProducto() == idProducto);
        if (longitudOriginal != this.listaProductos.size()){
            System.out.println("Se elimino el producto con el ID: "+idProducto); 
        } else {
            System.out.println("No existe producto con el id: "+idProducto);
        }

    }

    public void agregarHorario(Horarios horario) {
        this.listaHorarios.add(horario);  // Asegúrate de tener una lista de horarios en la sala
    }
    


    public void aniadirCliente (Cliente cliente){
        this.listaClientes.add(cliente);
        this.listaUsuarios.add(cliente);
    }
    public void aniadirProductoADulceria(Producto producto){
        this.listaProductos.add(producto);
    }

    public void aniadirPelicula (Pelicula pelicula){
        this.listaPeliculas.add(pelicula);
            }

            public void mostrarClientes() {
                if (this.listaClientes.isEmpty()){
                    System.out.println("No hay clientes registrados: ");
                    return;
                }
                System.out.println("\n----LISTA DE CLIENTES: ");
                for (Cliente cliente : this.listaClientes){
                    System.out.println(cliente.mostrarInformacion());
                }
            }


            public void mostrarPeliculas (){
                if (this.listaPeliculas.isEmpty()){
                    System.out.println("No hay peliculas registradas: ");
                    return;
                }
                System.out.println("\n---LISTA DE PELICULAS: -----");
                for (Pelicula pelicula : this.listaPeliculas){
                    System.out.println(pelicula.mostrarDatosPelicula());
                }
            }


            public Producto buscarProductoPorId(String idProducto) {
                for (Producto producto : listaProductos) {
                    if (producto.getIdProducto().equals(idProducto)) {
                        return producto;
                    }
                }
                return null; // Si no se encuentra el producto
            }
            


 public void mostrarCatalogoPeliculas() {
    if (this.listaPeliculas.isEmpty()) {
        System.out.println("No hay películas en el catálogo.");
        return;
    }
    System.out.println("\n----CATÁLOGO DE PELÍCULAS: ");
    for (Pelicula pelicula : this.listaPeliculas) {
        System.out.println(pelicula);
    }
}

public void mostrarProductosDulceria (){
    if (this.listaPeliculas.isEmpty()){
        System.out.println("No hay productos en la dulcería");
        return;
    }
    System.out.println("---DULCERIA---");
    for (Producto producto : this.listaProductos){
        producto.mostrarProducto();
    }
}

public void mostrarSalas() {
    for (Sala sala : this.listaSalas) {
        System.out.println("Sala ID: " + sala.getSalaId() + " - Capacidad: " + sala.getCapacidad());
    }
}


public Sala buscarSalaPorId(String idSala) {
    for (Sala sala : this.listaSalas) {
        if (sala.getSalaId().equals(idSala)) {
            return sala;
        }
    }
    return null;
}

// Buscar una película por ID
public Pelicula buscarPeliculaPorId(String idPelicula) {
    for (Pelicula pelicula : listaPeliculas) {
        if (pelicula.getId().equals(idPelicula)) {
            return pelicula;
        }
    }
    return null;
}


    public void comprarBoletos(Cliente cliente, Sala salaSeleccionada) {
        // Mostrar la película actual de la sala
        salaSeleccionada.mostrarPeliculaActual();

        // Mostrar los asientos disponibles
        salaSeleccionada.mostrarAsientos();

        System.out.print("Ingresa el número de boletos que deseas comprar: ");
        int numeroBoletos = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        if (numeroBoletos <= 0) {
            System.out.println("El número de boletos debe ser mayor que cero.");
            return;
        }

        double totalAPagar = 0;

        for (int i = 0; i < numeroBoletos; i++) {
            boolean asientoSeleccionado = false;

            // Selección manual de asientos con validación
            while (!asientoSeleccionado) {
                System.out.print("Ingresa el ID del asiento que deseas reservar: ");
                String idAsiento = scanner.nextLine();

                if (salaSeleccionada.verificarDisponibilidadAsiento(idAsiento)) {
                    salaSeleccionada.ocuparAsiento(idAsiento); // Ocupar el asiento
                    System.out.println("Asiento " + idAsiento + " reservado correctamente.");
                    asientoSeleccionado = true;

                    Sala.Asiento asiento = salaSeleccionada.buscarAsientoPorId(idAsiento);
                    Rol categoriaAsiento = asiento.getCategoria();

                    double precioBoleto = 0;
                    if (categoriaAsiento == Rol.VIP) {
                        precioBoleto = 400.0;
                    } else if (categoriaAsiento == Rol.PREMIUM) {
                        precioBoleto = 200.0;
                    } else {
                        precioBoleto = 100.0;
                    }

                    // Aplicar descuentos si es el mes de cumpleaños
                    if (esMesDeCumpleaños(cliente)) {
                        if (categoriaAsiento == Rol.VIP) {
                            precioBoleto *= 0.65;  // Descuento del 35%
                        } else if (categoriaAsiento == Rol.PREMIUM) {
                            precioBoleto *= 0.40;  // Descuento del 60%
                        }
                    }

                    totalAPagar += precioBoleto;

                    // Generar boleto y agregarlo a la lista
                    String idBoleto = generarIdBoleto();
                    Boleto nuevoBoleto = new Boleto(idBoleto, salaSeleccionada.getPeliculaActual(), idAsiento, precioBoleto);
                    listaBoletos.add(nuevoBoleto);

                    System.out.println("Boleto generado: " + nuevoBoleto);
                } else {
                    System.out.println("El asiento " + idAsiento + " no está disponible. Intenta con otro.");
                }
            }
        }

        System.out.println("Total a pagar: $" + totalAPagar);
    }


    public boolean esMesDeCumpleaños(Cliente cliente) {
        LocalDate fechaActual = LocalDate.now();
        return cliente.getFechaDeNacimiento().getMonth() == fechaActual.getMonth();
    }




public void agregarProductoAdicional(Producto producto) {
    productosAdicionales.add(producto);
    precioTotal += producto.getPrecio(); // Sumar el precio del producto al total
    System.out.println("Producto " + producto.getNombre() + " agregado correctamente.");
}


    public void realizarPago() {
        if (this.listaBoletos.isEmpty()) {
            System.out.println("Debes reservar al menos 1 boleto para realizar una compra.");
            return;
        }

        calcularPrecioTotal(); // Calcular el precio total incluyendo boletos y productos adicionales

        System.out.println("Elige el método de pago: 1. Tarjeta de Crédito 2. Tarjeta de Débito 3. Efectivo");
        int opcionPago = scanner.nextInt();
        scanner.nextLine();

        switch (opcionPago) {
            case 1:
                tipoPago = "Tarjeta de Crédito";
                break;
            case 2:
                tipoPago = "Tarjeta de Débito";
                break;
            case 3:
                tipoPago = "Efectivo";
                break;
            default:
                System.out.println("Opción de pago no válida.");
                return;
        }

        esReservacionCompleta = true;
        System.out.println("Pago realizado con éxito utilizando " + tipoPago + ". Reservación completa.");

        // Reiniciar el precio total después de la compra
        precioTotal = 0; // Resetea el precio total a cero para la siguiente compra
    }

    private void calcularPrecioTotal() {
        double precioBoletos = this.listaBoletos.size() * obtenerPrecioBoleto(); // Asegúrate de tener un método para obtener el precio del boleto
        precioTotal += precioBoletos;
        System.out.println("Precio total de los boletos: $" + precioBoletos);
        System.out.println("Precio total (incluyendo productos adicionales): $" + precioTotal);
    }

    private double obtenerPrecioBoleto() {
        return 100; // Precio del boleto por defecto
    }


}
