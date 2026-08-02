import java.util.Scanner;

// 11. Leer arreglo y capturar índice fuera de rango.
public class Ej11_IndiceFueraDeRango {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un índice a consultar: ");
        int indice = sc.nextInt();

        try {
            System.out.println("Valor en el índice " + indice + ": " + numeros[indice]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: el índice " + indice + " está fuera de rango.");
        }

        sc.close();
    }
}
