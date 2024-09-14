public class Main {
    public static void main(String[] args) {
        // cursos
        Curso curso1 = new Curso("Progamacion orientada a objetos", "AED-1286", "Rivera Cisneros Eder ");
        Curso curso2 = new Curso("Algebra Lineal", "ACF-0903", "Gonzalez Pedraza Oskar Javier");
        Curso curso3 = new Curso("Calculo Integral", "ACF-0902", "Hernandez Medina Gerardo");

        // estudiantes
        Estudiante estudiante1 = new Estudiante("Ulises Ochoa", "E6472688");
        Estudiante estudiante2 = new Estudiante("Daniel Velediaz", "E3778452");

        estudiante1.agregarCurso(curso1);
        estudiante1.agregarCurso(curso3);
        estudiante2.agregarCurso(curso2);
        estudiante2.agregarCurso(curso3);

        estudiante1.mostrarInformacion();

        estudiante2.mostrarInformacion();
    }
}
