import java.util.Scanner;

// 3. Manejar error al convertir texto a número.
public class Ej03_ConvertirTextoNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un texto para convertir a número: ");
        String texto = sc.nextLine();

        try {
            double valor = Double.parseDouble(texto);
            System.out.println("Conversión exitosa: " + valor);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + texto + "\" no se pudo convertir a número.");
        }

        sc.close();
    }
}
