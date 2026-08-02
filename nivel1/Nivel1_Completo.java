import java.util.Scanner;

/*
 * Nivel 1: Fundamentos de Java + Excepciones
 * Contiene los 25 ejercicios en un solo archivo, accesibles desde un menú.
 */
public class Nivel1_Completo {

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
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            String entrada = sc.nextLine();

            try {
                int opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1: ej01_DivisionCero(); break;
                    case 2: ej02_ValidarEntradaNumerica(); break;
                    case 3: ej03_ConvertirTextoNumero(); break;
                    case 4: ej04_MensajePersonalizado(); break;
                    case 5: ej05_UsarFinally(); break;
                    case 6: ej06_ValidarNumeroPositivo(); break;
                    case 7: ej07_MetodoLanzaExcepcionNegativo(); break;
                    case 8: ej08_ManejarExcepcionEnMetodo(); break;
                    case 9: ej09_ValidarEdad(); break;
                    case 10: ej10_ValidarContrasenaMinima(); break;
                    case 11: ej11_IndiceFueraDeRango(); break;
                    case 12: ej12_MultiplesExcepciones(); break;
                    case 13: ej13_UsarThrowManualmente(); break;
                    case 14: ej14_ExcepcionPersonalizadaSimple(); break;
                    case 15: ej15_LanzarExcepcionPersonalizada(); break;
                    case 16: ej16_ValidarTextoNoVacio(); break;
                    case 17: ej17_ErrorCharAt(); break;
                    case 18: ej18_DivisionSegura(); break;
                    case 19: ej19_ValidarNumeroMayor100(); break;
                    case 20: ej20_SimularErrorControladoThrow(); break;
                    case 21: ej21_ValidarEmailSimple(); break;
                    case 22: ej22_ValidarLongitudTexto(); break;
                    case 23: ej23_ControlarErrorEntradaUsuario(); break;
                    case 24: ej24_ReintentarLectura(); break;
                    case 25: ej25_MenuManejoErrores(); break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Error: opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número de opción válido.");
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== NIVEL 1: Fundamentos de Java + Excepciones =====");
        System.out.println(" 1. Capturar excepción al dividir entre cero");
        System.out.println(" 2. Validar entrada numérica con try-catch");
        System.out.println(" 3. Manejar error al convertir texto a número");
        System.out.println(" 4. Mostrar mensaje personalizado en excepción");
        System.out.println(" 5. Usar finally para mostrar mensaje final");
        System.out.println(" 6. Pedir número y validar que sea positivo");
        System.out.println(" 7. Método que lanza excepción si número es negativo");
        System.out.println(" 8. Manejar excepción en método");
        System.out.println(" 9. Validar edad (no negativa)");
        System.out.println("10. Validar contraseña mínima");
        System.out.println("11. Leer arreglo y capturar índice fuera de rango");
        System.out.println("12. Manejar múltiples excepciones");
        System.out.println("13. Usar throw manualmente");
        System.out.println("14. Crear excepción personalizada simple");
        System.out.println("15. Lanzar excepción personalizada");
        System.out.println("16. Validar que texto no esté vacío");
        System.out.println("17. Manejar error al acceder a charAt");
        System.out.println("18. Validar división segura con método");
        System.out.println("19. Validar número mayor a 100");
        System.out.println("20. Simular error controlado con throw");
        System.out.println("21. Crear método que valide email simple");
        System.out.println("22. Validar longitud de texto con excepción");
        System.out.println("23. Controlar error en entrada de usuario");
        System.out.println("24. Reintentar lectura si ocurre error");
        System.out.println("25. Pequeño menú con manejo de errores");
        System.out.println(" 0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // 1. Capturar excepción al dividir entre cero.
    private static void ej01_DivisionCero() {
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

    // 25. Crear pequeño menú con manejo de errores.
    private static void ej25_MenuManejoErrores() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- SUBMENÚ (Ejercicio 25) ---");
            System.out.println("1. Dividir dos números");
            System.out.println("2. Validar edad");
            System.out.println("3. Volver al menú principal");
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
                        break;
                    default:
                        System.out.println("Error: opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un valor numérico.");
            }
        }
    }
}
