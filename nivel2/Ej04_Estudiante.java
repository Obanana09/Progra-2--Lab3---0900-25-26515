import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 16-20. Clase Estudiante con notas privadas, cálculo de promedio, método para
// mostrar resultado y validación de notas entre 0 y 100.
public class Ej04_Estudiante {

    static class Estudiante {
        private String nombre;
        private List<Double> notas = new ArrayList<>();

        public Estudiante(String nombre) {
            this.nombre = nombre;
        }

        public void agregarNota(double nota) {
            if (nota < 0 || nota > 100) {
                throw new IllegalArgumentException("La nota debe estar entre 0 y 100.");
            }
            notas.add(nota);
        }

        public double calcularPromedio() {
            if (notas.isEmpty()) {
                return 0;
            }
            double suma = 0;
            for (double nota : notas) {
                suma += nota;
            }
            return suma / notas.size();
        }

        public void mostrarResultado() {
            System.out.println("Estudiante: " + nombre + " | Promedio: " + calcularPromedio());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del estudiante: ");
        Estudiante estudiante = new Estudiante(sc.nextLine());

        System.out.print("¿Cuántas notas desea ingresar? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingrese la nota " + i + ": ");
            double nota = Double.parseDouble(sc.nextLine());
            try {
                estudiante.agregarNota(nota);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        estudiante.mostrarResultado();
        sc.close();
    }
}
