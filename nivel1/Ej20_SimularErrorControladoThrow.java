import java.util.Scanner;

// 20. Simular error controlado con throw.
public class Ej20_SimularErrorControladoThrow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su código de acceso (debe ser 1234): ");
        String codigo = sc.nextLine();

        try {
            if (!codigo.equals("1234")) {
                throw new RuntimeException("Código de acceso incorrecto.");
            }
            System.out.println("Acceso concedido.");
        } catch (RuntimeException e) {
            System.out.println("Error simulado: " + e.getMessage());
        }

        sc.close();
    }
}
