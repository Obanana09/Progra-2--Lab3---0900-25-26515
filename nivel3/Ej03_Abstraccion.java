// Abstracción: crear clase abstracta Figura con método abstracto area(),
// y las clases Cuadrado y Circulo que lo implementen.
public class Ej03_Abstraccion {

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

    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(4);
        Figura circulo = new Circulo(3);

        System.out.println("Área del cuadrado: " + cuadrado.area());
        System.out.println("Área del círculo: " + circulo.area());
    }
}
