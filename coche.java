 public class Coche {
        private String marca;
        private String modelo;
        private int año;

        // Constructor
        public Coche(String marca, String modelo, int año) {
            this.marca = marca;
            this.modelo = modelo;
            this.año = año;
        }

        //información del coche
        public void mostrarInfocoche() {
            System.out.println("Marca: " + marca);
            System.out.println("Modelo: " + modelo);
            System.out.println("Año: " + año);
        }

        //Edad del coche
        public int calcularEdadDelCoche(int añoActual) {
            return añoActual - this.año;
        }
    }
