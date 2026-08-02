import java.util.Scanner;

// Herencia: crear clase Animal, clase Perro que herede, agregar método
// sonido(), sobrescribirlo y probar con un objeto.
public class Ej01_Herencia {

    static class Animal {
        protected String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public String sonido() {
            return "hace un sonido genérico";
        }
    }

    static class Perro extends Animal {
        public Perro(String nombre) {
            super(nombre);
        }

        @Override
        public String sonido() {
            return "ladra: ¡Guau!";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del perro: ");
        String nombre = sc.nextLine();

        Perro perro = new Perro(nombre);
        System.out.println(perro.nombre + " " + perro.sonido());

        sc.close();
    }
}
