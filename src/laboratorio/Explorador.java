/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio;

import Utilidades.Pila;
import java.io.File;

/**
 *
 * @author Fernando
 */
public class Explorador {

    Pila visitados;
    Carpeta carpetaActual;
    Carpeta raiz;

    public Explorador() {
        visitados = new Pila();
    }

    public Carpeta cargaInicial() {

        //Se especifica la ruta de la carpeta padre
        String path = "C:\\Users\\Fernando\\Desktop";

        //Se crea un item de tipo File, que será una carpeta o archivo
        File item = new File(path, "Prueba");

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
}
