import java.util.ArrayList;
import java.util.List;

// Polimorfismo: crear clase Gato que herede de Animal, sobrescribir sonido(),
// crear lista de animales y ejecutar el mismo método en distintos objetos.
public class Ej02_Polimorfismo {

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

    static class Gato extends Animal {
        public Gato(String nombre) {
            super(nombre);
        }

        @Override
        public String sonido() {
            return "maúlla: ¡Miau!";
        }
    }

    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Perro("Rex"));
        animales.add(new Gato("Michi"));
        animales.add(new Animal("Genérico"));

        for (Animal animal : animales) {
            System.out.println(animal.nombre + " " + animal.sonido());
        }
    }
}
