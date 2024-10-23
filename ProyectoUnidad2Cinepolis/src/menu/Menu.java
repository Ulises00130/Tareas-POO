package menu;

import cine.Cine;
import java.util.Scanner;

public class Menu {
    public Scanner scanner = new Scanner(System.in);
    public static final String USUARIO_CLIENTE = "Cliente1";
    private final String CONTRASEÑA_CLIENTE = "123";
    private final String USUARIO_ADMINISTRADOR = "admin1";
    private final String CONTRASEÑA_ADMINISTRADOR = "1234";

    private Cine cine;

    public Menu(Cine cine) {
        this.cine = cine;
    }

    public void login () {
        int intentosMaximos = 5;
        int intentosUsuario = 0;

        while (intentosUsuario < intentosMaximos) {
            System.out.println("BIENVENIDO A CINEPOLIS");
            System.out.print("Inicia sesión para continuar:\nIngrese el usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese contraseña: ");
            String contrasena = scanner.nextLine();

            if (usuario.equals(USUARIO_CLIENTE) && contrasena.equals(CONTRASEÑA_CLIENTE)) {
                MenuCliente menuCliente = new MenuCliente(cine);
                menuCliente.MostrarMenuCliente();
                return;
            } else if (usuario.equals(USUARIO_ADMINISTRADOR) && contrasena.equals(CONTRASEÑA_ADMINISTRADOR)) {
                MenuAdmin menuAdmin = new MenuAdmin(cine); // Pasar cine a MenuAdmin
                menuAdmin.mostrarMenuAdmin();
                return;
            } else {
                intentosUsuario = mostrarErrorInicioSesion(intentosUsuario);
            }
        }
        System.out.println("Se han agotado los intentos de inicio de sesión.");
    }

    private int mostrarErrorInicioSesion(int intentosUsuario) {
        System.out.println("Usuario o contraseña incorrecta");
        return intentosUsuario + 1;
    }
}
