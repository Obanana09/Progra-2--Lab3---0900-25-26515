import java.util.Scanner;

/*
 * Nivel 1: Fundamentos de Java + Excepciones
 * Ejecuta los 25 ejercicios de forma corrida (uno tras otro), sin menú.
 */
public class Nivel1_Corrido {

    // ---------- Excepción personalizada (ejercicios 14 y 15) ----------
    static class MiExcepcion extends Exception {
        public MiExcepcion(String mensaje) {
            super(mensaje);
        }
    }

    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ej01_DivisionCero();
        ej02_ValidarEntradaNumerica();
        ej03_ConvertirTextoNumero();
        ej04_MensajePersonalizado();
        ej05_UsarFinally();
        ej06_ValidarNumeroPositivo();
        ej07_MetodoLanzaExcepcionNegativo();
        ej08_ManejarExcepcionEnMetodo();
        ej09_ValidarEdad();
        ej10_ValidarContrasenaMinima();
        ej11_IndiceFueraDeRango();
        ej12_MultiplesExcepciones();
        ej13_UsarThrowManualmente();
        ej14_ExcepcionPersonalizadaSimple();
        ej15_LanzarExcepcionPersonalizada();
        ej16_ValidarTextoNoVacio();
        ej17_ErrorCharAt();
        ej18_DivisionSegura();
        ej19_ValidarNumeroMayor100();
        ej20_SimularErrorControladoThrow();
        ej21_ValidarEmailSimple();
        ej22_ValidarLongitudTexto();
        ej23_ControlarErrorEntradaUsuario();
        ej24_ReintentarLectura();
        ej25_MenuManejoErrores();

        sc.close();
    }

    // 1. Capturar excepción al dividir entre cero.
    private static void ej01_DivisionCero() {
        System.out.println("\n--- Ejercicio 1: División entre cero ---");
        System.out.print("Ingrese el dividendo: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el divisor: ");
        int b = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Resultado: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }
    }

    // 2. Validar entrada numérica con try-catch.
    private static void ej02_ValidarEntradaNumerica() {
        System.out.println("\n--- Ejercicio 2: Validar entrada numérica ---");
        System.out.print("Ingrese un número entero: ");
        String entrada = sc.nextLine();
        try {
            int numero = Integer.parseInt(entrada);
            System.out.println("El número ingresado es válido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: la entrada no es un número entero válido.");
        }
    }

    // 3. Manejar error al convertir texto a número.
    private static void ej03_ConvertirTextoNumero() {
        System.out.println("\n--- Ejercicio 3: Convertir texto a número ---");
        System.out.print("Ingrese un texto para convertir a número: ");
        String texto = sc.nextLine();
        try {
            double valor = Double.parseDouble(texto);
            System.out.println("Conversión exitosa: " + valor);
        } catch (NumberFormatException e) {
            System.out.println("Error: \"" + texto + "\" no se pudo convertir a número.");
        }
    }

    // 4. Mostrar mensaje personalizado en excepción.
    private static void ej04_MensajePersonalizado() {
        System.out.println("\n--- Ejercicio 4: Mensaje personalizado ---");
        System.out.print("Ingrese un divisor: ");
        int divisor = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Resultado: " + (100 / divisor));
        } catch (ArithmeticException e) {
            System.out.println("Mensaje personalizado: no puedes dividir 100 entre cero, intenta con otro valor.");
        }
    }

    // 5. Usar finally para mostrar mensaje final.
    private static void ej05_UsarFinally() {
        System.out.println("\n--- Ejercicio 5: Usar finally ---");
        System.out.print("Ingrese un dividendo: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese un divisor: ");
        int b = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Resultado: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error: división entre cero no permitida.");
        } finally {
            System.out.println("Fin del proceso de división.");
        }
    }

    // 6. Pedir número y validar que sea positivo (con excepción).
    private static void ej06_ValidarNumeroPositivo() {
        System.out.println("\n--- Ejercicio 6: Validar número positivo ---");
        System.out.print("Ingrese un número positivo: ");
        int numero = Integer.parseInt(sc.nextLine());
        try {
            if (numero < 0) {
                throw new IllegalArgumentException("El número no puede ser negativo.");
            }
            System.out.println("Número válido: " + numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 7. Crear método que lance excepción si número es negativo.
    private static void validarNoNegativo(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número " + numero + " es negativo.");
        }
    }

    private static void ej07_MetodoLanzaExcepcionNegativo() {
        System.out.println("\n--- Ejercicio 7: Método lanza excepción si es negativo ---");
        System.out.print("Ingrese un número: ");
        int numero = Integer.parseInt(sc.nextLine());
        try {
            validarNoNegativo(numero);
            System.out.println("El número es válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 8. Manejar excepción en método.
    private static int dividirConManejo(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error dentro del método: no se puede dividir entre cero.");
            return 0;
        }
    }

    private static void ej08_ManejarExcepcionEnMetodo() {
        System.out.println("\n--- Ejercicio 8: Manejar excepción en método ---");
        System.out.print("Ingrese el dividendo: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el divisor: ");
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("Resultado: " + dividirConManejo(a, b));
    }

    // 9. Validar edad (no negativa).
    private static void validarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
    }

    private static void ej09_ValidarEdad() {
        System.out.println("\n--- Ejercicio 9: Validar edad ---");
        System.out.print("Ingrese su edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        try {
            validarEdad(edad);
            System.out.println("Edad válida: " + edad);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 10. Validar contraseña mínima (usar excepción).
    private static void validarContrasena(String contrasena) {
        if (contrasena.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
    }

    private static void ej10_ValidarContrasenaMinima() {
        System.out.println("\n--- Ejercicio 10: Validar contraseña mínima ---");
        System.out.print("Ingrese una contraseña: ");
        String contrasena = sc.nextLine();
        try {
            validarContrasena(contrasena);
            System.out.println("Contraseña válida.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 11. Leer arreglo y capturar índice fuera de rango.
    private static void ej11_IndiceFueraDeRango() {
        System.out.println("\n--- Ejercicio 11: Índice fuera de rango ---");
        int[] numeros = {10, 20, 30, 40, 50};
        System.out.print("Ingrese un índice a consultar: ");
        int indice = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Valor en el índice " + indice + ": " + numeros[indice]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: el índice " + indice + " está fuera de rango.");
        }
    }

    // 12. Manejar múltiples excepciones (catch múltiples).
    private static void ej12_MultiplesExcepciones() {
        System.out.println("\n--- Ejercicio 12: Múltiples excepciones ---");
        int[] numeros = {10, 20, 30};
        System.out.print("Ingrese un índice: ");
        String entradaIndice = sc.nextLine();
        System.out.print("Ingrese un divisor: ");
        String entradaDivisor = sc.nextLine();
        try {
            int indice = Integer.parseInt(entradaIndice);
            int divisor = Integer.parseInt(entradaDivisor);
            System.out.println("Resultado: " + (numeros[indice] / divisor));
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar valores numéricos válidos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: el índice está fuera de rango.");
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }
    }

    // 13. Usar throw manualmente.
    private static void ej13_UsarThrowManualmente() {
        System.out.println("\n--- Ejercicio 13: Usar throw manualmente ---");
        System.out.print("Ingrese un número del 1 al 10: ");
        int numero = Integer.parseInt(sc.nextLine());
        try {
            if (numero < 1 || numero > 10) {
                throw new IllegalArgumentException("El número debe estar entre 1 y 10.");
            }
            System.out.println("Número aceptado: " + numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 14. Crear excepción personalizada simple.
    private static void ej14_ExcepcionPersonalizadaSimple() {
        System.out.println("\n--- Ejercicio 14: Excepción personalizada simple ---");
        try {
            throw new MiExcepcion("Esta es mi excepción personalizada.");
        } catch (MiExcepcion e) {
            System.out.println("Se capturó: " + e.getMessage());
        }
    }

    // 15. Lanzar excepción personalizada.
    private static void retirar(double saldo, double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar Q" + monto);
        }
    }

    private static void ej15_LanzarExcepcionPersonalizada() {
        System.out.println("\n--- Ejercicio 15: Lanzar excepción personalizada ---");
        double saldo = 500.0;
        System.out.print("Ingrese el monto a retirar: ");
        double monto = Double.parseDouble(sc.nextLine());
        try {
            retirar(saldo, monto);
            System.out.println("Retiro exitoso de Q" + monto);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 16. Validar que texto no esté vacío.
    private static void validarNoVacio(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío.");
        }
    }

    private static void ej16_ValidarTextoNoVacio() {
        System.out.println("\n--- Ejercicio 16: Validar texto no vacío ---");
        System.out.print("Ingrese un texto: ");
        String texto = sc.nextLine();
        try {
            validarNoVacio(texto);
            System.out.println("Texto válido: " + texto);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 17. Manejar error al acceder a charAt.
    private static void ej17_ErrorCharAt() {
        System.out.println("\n--- Ejercicio 17: Error al acceder a charAt ---");
        System.out.print("Ingrese un texto: ");
        String texto = sc.nextLine();
        System.out.print("Ingrese la posición a consultar: ");
        int posicion = Integer.parseInt(sc.nextLine());
        try {
            char caracter = texto.charAt(posicion);
            System.out.println("El caracter en la posición " + posicion + " es: " + caracter);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: la posición " + posicion + " está fuera del rango del texto.");
        }
    }

    // 18. Validar división segura con método.
    private static double dividirSeguro(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }

    private static void ej18_DivisionSegura() {
        System.out.println("\n--- Ejercicio 18: División segura ---");
        System.out.print("Ingrese el dividendo: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el divisor: ");
        double b = Double.parseDouble(sc.nextLine());
        try {
            System.out.println("Resultado: " + dividirSeguro(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 19. Validar número mayor a 100.
    private static void validarMayorA100(int numero) {
        if (numero <= 100) {
            throw new IllegalArgumentException("El número debe ser mayor a 100.");
        }
    }

    private static void ej19_ValidarNumeroMayor100() {
        System.out.println("\n--- Ejercicio 19: Validar número mayor a 100 ---");
        System.out.print("Ingrese un número mayor a 100: ");
        int numero = Integer.parseInt(sc.nextLine());
        try {
            validarMayorA100(numero);
            System.out.println("Número válido: " + numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 20. Simular error controlado con throw.
    private static void ej20_SimularErrorControladoThrow() {
        System.out.println("\n--- Ejercicio 20: Simular error controlado con throw ---");
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
    }

    // 21. Crear método que valide email simple.
    private static void validarEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("El email \"" + email + "\" no tiene un formato válido.");
        }
    }

    private static void ej21_ValidarEmailSimple() {
        System.out.println("\n--- Ejercicio 21: Validar email simple ---");
        System.out.print("Ingrese un email: ");
        String email = sc.nextLine();
        try {
            validarEmail(email);
            System.out.println("Email válido: " + email);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 22. Validar longitud de texto con excepción.
    private static void validarLongitud(String texto, int longitudMaxima) {
        if (texto.length() > longitudMaxima) {
            throw new IllegalArgumentException(
                "El texto excede la longitud máxima de " + longitudMaxima + " caracteres.");
        }
    }

    private static void ej22_ValidarLongitudTexto() {
        System.out.println("\n--- Ejercicio 22: Validar longitud de texto ---");
        System.out.print("Ingrese un texto (máximo 20 caracteres): ");
        String texto = sc.nextLine();
        try {
            validarLongitud(texto, 20);
            System.out.println("Texto válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 23. Controlar error en entrada de usuario.
    private static void ej23_ControlarErrorEntradaUsuario() {
        System.out.println("\n--- Ejercicio 23: Controlar error en entrada de usuario ---");
        System.out.print("Ingrese su edad (número entero): ");
        try {
            String entrada = sc.nextLine();
            int edad = Integer.parseInt(entrada);
            if (edad < 0 || edad > 120) {
                throw new IllegalArgumentException("La edad debe estar entre 0 y 120.");
            }
            System.out.println("Edad registrada: " + edad);
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número entero válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 24. Reintentar lectura si ocurre error.
    private static void ej24_ReintentarLectura() {
        System.out.println("\n--- Ejercicio 24: Reintentar lectura si ocurre error ---");
        int numero = 0;
        boolean valido = false;
        int intentos = 0;
        final int MAX_INTENTOS = 3;

        while (!valido && intentos < MAX_INTENTOS) {
            System.out.print("Ingrese un número entero: ");
            String entrada = sc.nextLine();
            try {
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                intentos++;
                System.out.println("Error: entrada inválida. Intento " + intentos + " de " + MAX_INTENTOS + ".");
            }
        }

        if (valido) {
            System.out.println("Número ingresado correctamente: " + numero);
        } else {
            System.out.println("Se agotaron los intentos. No se pudo leer un número válido.");
        }
    }

    // 25. Dividir dos números y validar una edad, con manejo de errores.
    private static void ej25_MenuManejoErrores() {
        System.out.println("\n--- Ejercicio 25: Manejo de errores (división y edad) ---");

        System.out.print("Ingrese el dividendo: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el divisor: ");
        int b = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Resultado: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir entre cero.");
        }

        System.out.print("Ingrese su edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        if (edad < 0) {
            System.out.println("Error: la edad no puede ser negativa.");
        } else {
            System.out.println("Edad válida: " + edad);
        }
    }
}
