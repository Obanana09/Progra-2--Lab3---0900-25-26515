import java.util.Scanner;

// 12. Manejar múltiples excepciones (catch múltiples).
public class Ej12_MultiplesExcepciones {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30};
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un índice: ");
        String entradaIndice = sc.nextLine();
        System.out.print("Ingrese un divisor: ");
        String entradaDivisor = sc.nextLine();

        try {
            int indice = Integer.parseInt(entradaIndice);
            int divisor = Integer.parseInt(entradaDivisor);
            int resultado = numeros[indice] / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar valores numéricos válidos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: el índice está fuera de rango.");
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }

        sc.close();
    }
}
