import java.util.Scanner;

// 1-5. Clase Persona con atributos privados, getters/setters, validación de edad,
// constructor básico y método para mostrar datos.
public class Ej01_Persona {

    static class Persona {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            setEdad(edad);
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            if (edad < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa.");
            }
            this.edad = edad;
        }

        public void mostrarDatos() {
            System.out.println("Nombre: " + nombre + " | Edad: " + edad);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        try {
            Persona persona = new Persona(nombre, edad);
            persona.mostrarDatos();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
