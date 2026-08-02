// 14. Crear excepción personalizada simple.
public class Ej14_ExcepcionPersonalizadaSimple {

    static class MiExcepcion extends Exception {
        public MiExcepcion(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {
        try {
            throw new MiExcepcion("Esta es mi excepción personalizada.");
        } catch (MiExcepcion e) {
            System.out.println("Se capturó: " + e.getMessage());
        }
    }
}
