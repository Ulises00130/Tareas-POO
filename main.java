
        public class Main {
            public static void main(String[] args) {
                //COCHE 1
                System.out.println("Coche Uno");
                Coche cocheUno = new Coche("ford", "Raptor",  2024);
                cocheUno.mostrarInfocoche();
                System.out.println("Edad del coche Uno, " + cocheUno.calcularEdadDelCoche(2024) +  "Años");

                //COCHE 2
                System.out.println("Coche Dos");
                Coche cocheDos = new Coche("Ford", "Mustang",  2021);
                cocheDos.mostrarInfocoche();
                System.out.println("Edad del coche Dos, " + cocheDos.calcularEdadDelCoche(2024) +  "Años");

                //COCHE 3
                System.out.println("Coche Tres");
                Coche cocheTres = new Coche("toyota", "Tacoma",  2015);
                cocheTres.mostrarInfocoche();
                System.out.println("Edad del coche Tres, " + cocheTres.calcularEdadDelCoche(2024) +  "Años");

            }
        }


