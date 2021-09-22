/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio;

import Utilidades.Pila;
import Utilidades.TecladoIn;
import java.io.File;

/**
 *
 * @author Fernando
 */
public class Explorador {

    //Variables globales para prints
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    Pila visitados;
    Carpeta carpetaActual;
    Carpeta raiz;
    String path, filename;

    public Explorador(String path, String filename) {
        visitados = new Pila();
        this.path = path;
        this.filename = filename;
    }

    public Carpeta cargaInicial() {

        //Se crea un item de tipo File, que será una carpeta o archivo
        File item = new File(path, filename);

        //Se verifica si existe el item
        if (item.exists()) {

            System.out.println("Se esta escaneando la carpeta, por favor espere...");
            raiz = cargaPublica(item);
            System.out.println("Escaneo completo. \n\n");
        } else {
            System.out.println("ERROR: No existe archivo-carpeta en la ruta dada.");
        }

        return raiz;
    }

    private Carpeta cargaPublica(File item) {
        raiz = new Carpeta(item.getName());
        cargaAux(raiz, item);

        this.carpetaActual = raiz;
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

    public Carpeta accederSubcarpeta() {
        String nombreCarpeta;
        Carpeta aux;

        System.out.print("Ingrese el nombre de la carpeta a la que quiere ingresar: ");
        nombreCarpeta = TecladoIn.readLine();

        aux = carpetaActual.obtenerSubcarpeta(nombreCarpeta);

        //Si existe la subcarpeta requerida
        if (aux != null) {
            //Se apila la carpeta padre 
            visitados.apilar(carpetaActual);
            carpetaActual = aux;
        } else {
            //Si no existe subcarpeta, da error y desapila la carpeta actual
            System.out.println(ANSI_RED + "No se encontró ninguna carpeta con ese nombre " + ANSI_RESET);
        }

        return carpetaActual;
    }
}
