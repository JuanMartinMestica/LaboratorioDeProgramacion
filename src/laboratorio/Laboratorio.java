package laboratorio;

import Utilidades.TecladoIn;

public class Laboratorio {

    //Variables globales para prints
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        String path = "C:\\Users\\Fernando\\Desktop", filename = "Prueba";
        Explorador exp = new Explorador(path, filename);
        Carpeta carpetaActual = exp.cargaInicial();
        int opcion = -1;

        if (carpetaActual != null) {
            while (opcion != 3) {

                System.out.println(carpetaActual.toString());
                opcion = mostrarMenu();

                switch (opcion) {
                    case 1:
                        carpetaActual = exp.accederSubcarpeta();
                        break;
                    case 2:
                        carpetaActual = exp.subirNivel();
                        break;
                    case 3:
                        System.out.println(ANSI_RED + "Saliendo.." + ANSI_RESET);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
    }

    private static int mostrarMenu() {

        int opcion;

        System.out.print(" \n1- Ingresar a sub-carpeta. \n"
                + "2- Volver a carpeta anterior \n"
                + "3- Salir. \n");

        System.out.print(ANSI_PURPLE + "Ingrese su opción: " + ANSI_RESET);
        opcion = TecladoIn.readLineInt();

        System.out.println("");

        return opcion;

    }
}
