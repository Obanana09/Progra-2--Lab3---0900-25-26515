import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Nivel 2: POO Básica
 * Ejecuta los ejercicios (Persona, Cuenta, Producto, Estudiante, Empleado)
 * de forma corrida (uno tras otro), sin menú.
 */
public class Nivel2_Corrido {

    // ---------- Persona (ejercicios 1-5) ----------
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

    // ---------- Cuenta (ejercicios 6-10) ----------
    static class Cuenta {
        private double saldo;

        public Cuenta(double saldoInicial) {
            if (saldoInicial < 0) {
                throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
            }
            this.saldo = saldoInicial;
        }

        public void depositar(double monto) {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
            }
            saldo += monto;
        }

        public void retirar(double monto) {
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
            }
            if (monto > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente para retirar Q" + monto + ".");
            }
            saldo -= monto;
        }

        public void mostrarSaldo() {
            System.out.println("Saldo actual: Q" + saldo);
        }
    }

    // ---------- Producto (ejercicios 11-15) ----------
    static class Producto {
        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            setPrecio(precio);
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            if (precio <= 0) {
                throw new IllegalArgumentException("El precio debe ser positivo.");
            }
            this.precio = precio;
        }

        public void mostrarProducto() {
            System.out.println("Producto: " + nombre + " | Precio: Q" + precio);
        }
    }

    // ---------- Estudiante (ejercicios 16-20) ----------
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

    // ---------- Empleado (ejercicios 21-25) ----------
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

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejerciciosPersona();
        ejerciciosCuenta();
        ejerciciosProducto();
        ejerciciosEstudiante();
        ejerciciosEmpleado();

        sc.close();
    }

    // 1-5. Persona (atributos privados, getters/setters, validar edad).
    private static void ejerciciosPersona() {
        System.out.println("\n--- Ejercicios 1-5: Persona ---");
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
    }

    // 6-10. Cuenta (depositar, retirar, evitar saldo negativo).
    private static void ejerciciosCuenta() {
        System.out.println("\n--- Ejercicios 6-10: Cuenta ---");
        Cuenta cuenta = new Cuenta(100.0);
        cuenta.mostrarSaldo();

        System.out.print("Ingrese un monto a depositar: ");
        double deposito = Double.parseDouble(sc.nextLine());
        try {
            cuenta.depositar(deposito);
            cuenta.mostrarSaldo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Ingrese un monto a retirar: ");
        double retiro = Double.parseDouble(sc.nextLine());
        try {
            cuenta.retirar(retiro);
            cuenta.mostrarSaldo();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 11-15. Producto (encapsular precio, lista de productos).
    private static void ejerciciosProducto() {
        System.out.println("\n--- Ejercicios 11-15: Producto ---");
        List<Producto> productos = new ArrayList<>();

        System.out.print("¿Cuántos productos desea registrar? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("--- Producto " + i + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());
            try {
                productos.add(new Producto(nombre, precio));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\n--- Lista de productos ---");
        for (Producto p : productos) {
            p.mostrarProducto();
        }
    }

    // 16-20. Estudiante (notas privadas, promedio).
    private static void ejerciciosEstudiante() {
        System.out.println("\n--- Ejercicios 16-20: Estudiante ---");
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
    }

    // 21-25. Empleado (encapsular salario, varios objetos).
    private static void ejerciciosEmpleado() {
        System.out.println("\n--- Ejercicios 21-25: Empleado ---");
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
    }
}
