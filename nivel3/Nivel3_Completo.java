import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Nivel 3: POO (Herencia, Polimorfismo, Abstracción, Integración)
 * Contiene los 4 bloques de ejercicios, accesibles desde un menú.
 */
public class Nivel3_Completo {

    // ---------- Herencia / Polimorfismo ----------
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

    // ---------- Abstracción ----------
    abstract static class Figura {
        public abstract double area();
    }

    static class Cuadrado extends Figura {
        private double lado;

        public Cuadrado(double lado) {
            this.lado = lado;
        }

        @Override
        public double area() {
            return lado * lado;
        }
    }

    static class Circulo extends Figura {
        private double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double area() {
            return Math.PI * radio * radio;
        }
    }

    // ---------- Integración ----------
    interface Vehiculo {
        String moverse();
    }

    static class Carro implements Vehiculo {
        @Override
        public String moverse() {
            return "El carro se mueve sobre 4 ruedas.";
        }
    }

    static class Moto implements Vehiculo {
        @Override
        public String moverse() {
            return "La moto se mueve sobre 2 ruedas.";
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            String entrada = sc.nextLine();

            try {
                int opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1: menuHerencia(); break;
                    case 2: menuPolimorfismo(); break;
                    case 3: menuAbstraccion(); break;
                    case 4: menuIntegracion(); break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Error: opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número de opción válido.");
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== NIVEL 3: POO =====");
        System.out.println("1. Herencia (Animal / Perro)");
        System.out.println("2. Polimorfismo (Animal / Perro / Gato)");
        System.out.println("3. Abstracción (Figura / Cuadrado / Circulo)");
        System.out.println("4. Integración (Figuras + Vehículo)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Herencia.
    private static void menuHerencia() {
        System.out.print("Ingrese el nombre del perro: ");
        String nombre = sc.nextLine();

        Perro perro = new Perro(nombre);
        System.out.println(perro.nombre + " " + perro.sonido());
    }

    // Polimorfismo.
    private static void menuPolimorfismo() {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Perro("Rex"));
        animales.add(new Gato("Michi"));
        animales.add(new Animal("Genérico"));

        for (Animal animal : animales) {
            System.out.println(animal.nombre + " " + animal.sonido());
        }
    }

    // Abstracción.
    private static void menuAbstraccion() {
        Figura cuadrado = new Cuadrado(4);
        Figura circulo = new Circulo(3);

        System.out.println("Área del cuadrado: " + cuadrado.area());
        System.out.println("Área del círculo: " + circulo.area());
    }

    // Integración.
    private static void menuIntegracion() {
        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Cuadrado(5));
        figuras.add(new Circulo(2));

        System.out.println("--- Áreas de las figuras ---");
        for (Figura figura : figuras) {
            System.out.println(figura.getClass().getSimpleName() + " -> Área: " + figura.area());
        }

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Carro());
        vehiculos.add(new Moto());

        System.out.println("\n--- Vehículos ---");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.moverse());
        }
    }
}
