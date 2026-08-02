import java.util.ArrayList;
import java.util.List;

// Integración: usar varias figuras en una lista y calcular sus áreas con
// polimorfismo; crear interfaz Vehículo e implementarla en Carro y Moto.
public class Ej04_Integracion {

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

    public static void main(String[] args) {
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
