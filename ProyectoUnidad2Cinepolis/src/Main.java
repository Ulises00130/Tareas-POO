import cine.Cine;
import menu.Menu;


public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine();
        Menu menu = new Menu(cine);
        menu.login();
    }
}