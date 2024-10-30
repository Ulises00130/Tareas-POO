import seguro.SeguroAuto;
import seguro.SeguroHogar;
import seguro.SeguroVida;
public class GestorSeguros {
    public static void main(String[] args) {
            SeguroAuto seguroAuto = new SeguroAuto("Ulises Ochoa", 20000, 24);
            SeguroHogar seguroHogar = new SeguroHogar("Jose Antonio ", 150000, true);
            SeguroVida seguroVida = new SeguroVida("Juan López", 100000, 65);



        System.out.println(seguroAuto.detallesSeguro());
        System.out.println();
        System.out.println(seguroHogar.detallesSeguro());
        System.out.println();
        System.out.println(seguroVida.detallesSeguro());


    }
    }
