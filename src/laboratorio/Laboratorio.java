package laboratorio;

import java.io.File;
import Utilidades.TecladoIn;
import Utilidades.Pila;

public class Laboratorio {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        
        Pila visitados =new Pila();
        Carpeta raiz = cargaInicial();
        int opcion = -1;

        
        while (opcion != 3) {

            opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    
                    accederSubcarpeta(raiz);
                    break;
                case 2:
    
                    break;
                case 3:
                    System.out.println(ANSI_RED + "Saliendo.." + ANSI_RESET);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    public static Carpeta cargaInicial() {

        Carpeta raiz = null;

        //Se especifica la ruta de la carpeta padre
        String path = "C:\\Users\\MARTIN\\Desktop";

        //Se crea un item de tipo File, que será una carpeta o archivo
        File item = new File(path, "Prueba");

        //Se verifica si existe el item
        if (item.exists()) {

            raiz = cargaPublica(item);

            System.out.println(raiz.toString());

        } else {
            System.out.println("ERROR: No existe archivo-carpeta en la ruta dada.");
        }

        return raiz;

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

    private static boolean accederSubcarpeta(Carpeta padre) {

        boolean exito = false;
        
        String nombreCarpeta;

        System.out.print("Ingrese el nombre de la carpeta a la que quiere ingresar: ");
        nombreCarpeta = TecladoIn.readLine();

        Carpeta subcarpeta = padre.obtenerSubcarpeta(nombreCarpeta);
        
        if (subcarpeta != null) {
            System.out.println(subcarpeta.toString());
            exito = true;
        } else {
        
            System.out.println(ANSI_RED + "No se encontró ninguna carpeta con ese nombre " + ANSI_RESET);
              
        }

        return exito;
    }

    private static Carpeta cargaPublica(File item) {
        Carpeta raiz;

        raiz = new Carpeta(item.getName());
        cargaAux(raiz, item);

        return raiz;
    }

    private static void cargaAux(Carpeta visitado, File item) {

        for (File subElem : item.listFiles()) {

            //Si el subelemento es una carpeta, se crea una instancia de Carpeta
            if (subElem.isDirectory()) {

                Carpeta nuevaCarpeta = new Carpeta(subElem.getName());

                cargaAux(nuevaCarpeta, subElem);

                //Se añade la Carpeta a la Carpeta padre
                visitado.añadirItem(nuevaCarpeta);

            } else {
                //Si el subelemento es un archivo, se crea una instancia de Archivo
                Archivo nuevoArchivo = new Archivo(subElem.getName(), subElem.length());

                //Se añade el Archivo a la Carpeta
                visitado.añadirItem(nuevoArchivo);
            }
        }
    }

}
