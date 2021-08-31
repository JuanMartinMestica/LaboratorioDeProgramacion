package laboratorio;

import java.io.File;

public class Laboratorio {

    public static void main(String[] args) {

        cargaInicial();

    }

    public static void cargaInicial() {

        //Se obtiene la ruta de la carpeta padre
        String path = "C:\\Users\\MARTIN\\Desktop";

        //Se obtiene un item de tipo File, que será una carpeta o archivo
        File item = new File(path, "Prueba");

        //Se verifica si existe el item
        if (item.exists()) {

            Carpeta principal = new Carpeta(item.getName());

            cargaRecursiva(principal, item);

            System.out.println(principal);

        } else {
            System.out.println("ERROR: No existe archivo-carpeta en la ruta dada.");
        }

    }

    private static void cargaRecursiva(Carpeta x, File item) {

        //Si es una carpeta
        if (item.isDirectory()) {

            for (File items : item.listFiles()) {

                if (items.isDirectory()) {

                    Carpeta nuevaCarpeta = new Carpeta(items.getName());
                    x.añadirItem(nuevaCarpeta);
                }

                cargaRecursiva(x, items);
                
            }
        } else {

            //Si es un archivo, se crea una instancia de archivo
            Archivo nuevoArchivo = new Archivo(item.getName(), item.length());

            //Se agrega el archivo a la carpeta que lo contiene
            x.añadirItem(nuevoArchivo);

        }
    }

}
