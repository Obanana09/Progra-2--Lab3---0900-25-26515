import java.util.Scanner;

// 17. Manejar error al acceder a charAt.
public class Ej17_ErrorCharAt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un texto: ");
        String texto = sc.nextLine();
        System.out.print("Ingrese la posición a consultar: ");
        int posicion = sc.nextInt();

        try {
            char caracter = texto.charAt(posicion);
            System.out.println("El caracter en la posición " + posicion + " es: " + caracter);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: la posición " + posicion + " está fuera del rango del texto.");
        }

        sc.close();
    }
}
