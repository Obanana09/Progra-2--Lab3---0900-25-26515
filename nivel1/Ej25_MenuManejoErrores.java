import java.util.Scanner;

// 25. Crear pequeño menú con manejo de errores.
public class Ej25_MenuManejoErrores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Dividir dos números");
            System.out.println("2. Validar edad");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el dividendo: ");
                        int a = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese el divisor: ");
                        int b = Integer.parseInt(sc.nextLine());
                        try {
                            System.out.println("Resultado: " + (a / b));
                        } catch (ArithmeticException e) {
                            System.out.println("Error: no se puede dividir entre cero.");
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese su edad: ");
                        int edad = Integer.parseInt(sc.nextLine());
                        if (edad < 0) {
                            System.out.println("Error: la edad no puede ser negativa.");
                        } else {
                            System.out.println("Edad válida: " + edad);
                        }
                        break;
                    case 3:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Error: opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un valor numérico.");
            }
        }

        sc.close();
    }
}
