package menu;

import cine.Cine;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();

    public void mostrarMenuPrincipal() {
        MenuAdmin menuAdmin = new MenuAdmin(cine);
        MenuCliente menuCliente = new MenuCliente(cine);
        System.out.println("-----BIENVENIDO-------");
        System.out.println("Seleccione una opcion");
        System.out.println("1.-Iniciar sesion como cliente");
        System.out.println("2.-Iniciar sesion como administrador: ");
        System.out.println("3.- Salir");
        int opcion =0;
        while(opcion != 3) {
            System.out.println("Ingrese una opcion(1.-Cliente, 2.-Administrador): ");
            opcion = scanner.nextInt();
            switch(opcion) {
                case 1:
                    menuCliente.menuCliente();
                    break;
                case 2:
                    menuAdmin.menuAdmin();
                    break;
                case 3:
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}
