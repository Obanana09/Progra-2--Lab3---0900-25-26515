import java.util.Scanner;

// 21-25. Clase Empleado con salario encapsulado, validación de salario positivo,
// método para mostrar datos y creación de varios objetos.
public class Ej05_Empleado {

    static class Empleado {
        private String nombre;
        private double salario;

        public Empleado(String nombre, double salario) {
            this.nombre = nombre;
            setSalario(salario);
        }

        public String getNombre() {
            return nombre;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            if (salario <= 0) {
                throw new IllegalArgumentException("El salario debe ser positivo.");
            }
            this.salario = salario;
        }

        public void mostrarDatos() {
            System.out.println("Empleado: " + nombre + " | Salario: Q" + salario);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos empleados desea registrar? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        Empleado[] empleados = new Empleado[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("--- Empleado " + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Salario: ");
            double salario = Double.parseDouble(sc.nextLine());
            try {
                empleados[i] = new Empleado(nombre, salario);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\n--- Lista de empleados ---");
        for (Empleado e : empleados) {
            if (e != null) {
                e.mostrarDatos();
            }
        }

        sc.close();
    }
}
