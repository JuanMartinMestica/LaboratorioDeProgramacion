package laboratorio;

import java.io.File;

public class Laboratorio {

    public static void main(String[] args) {

        cargaInicial();

    }

    public static void cargaInicial() {

        //Se especifica la ruta de la carpeta padre
        String path = "C:\\Users\\MARTIN\\Desktop";

        //Se crea un item de tipo File, que será una carpeta o archivo
        File item = new File(path, "Prueba");

        //Se verifica si existe el item
        if (item.exists()) {

            Carpeta principal = cargaPublica(item);

            System.out.println(principal.toString());
            System.out.println("Cant hijos inmediatos: " + principal.getCantHijos());

        } else {
            System.out.println("ERROR: No existe archivo-carpeta en la ruta dada.");
        }

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
