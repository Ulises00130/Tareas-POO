import java.util.Scanner;

public class Main {
    public static <CalculadoraImpuestos> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prueba de la clase Rectangulo
        System.out.println("Ingrese el largo y el ancho del rectángulo:");
        double largo = scanner.nextDouble();
        double ancho = scanner.nextDouble();
        Rectangulo rect = new Rectangulo(largo, ancho);
        System.out.println("Área (double): " + rect.calcularArea(largo, ancho));
        System.out.println("Perímetro (double): " + rect.calcularPerimetro(largo, ancho));

        // Prueba de la clase Empleado
        System.out.println("Ingrese el sueldo base del empleado:");
        double sueldoBase = scanner.nextDouble();
        System.out.println("Ingrese la bonificación del empleado (0 si no hay):");
        double bonificacion = scanner.nextDouble();
        System.out.println("Ingrese las horas extras del empleado (0 si no hay):");
        int horasExtras = scanner.nextInt();
        Empleado emp = new Empleado();
        System.out.println("Salario: " + emp.calcularSalario(sueldoBase, bonificacion, horasExtras));

        // Prueba de la clase CalculadoraImpuestos
        System.out.println("Ingrese los ingresos:");
        int ingresos = scanner.nextInt();
        System.out.println("Ingrese el porcentaje de impuestos:");
        double porcentajeImpuestos = scanner.nextDouble();
        System.out.println("Ingrese los dividendos:");
        double dividendos = scanner.nextDouble();
        System.out.println("Ingrese la exención:");
        double exencion = scanner.nextDouble();
        CalculadoraImpuestos calcImp = new CalculadoraImpuestos();
        System.out.println("Impuestos: " + calcImp.calcularImpuestos(dividendos, porcentajeImpuestos, exencion));

        scanner.close();
    }