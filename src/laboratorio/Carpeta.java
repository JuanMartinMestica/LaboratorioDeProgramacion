package laboratorio;

import java.util.ArrayList;

/*Laboratorio de Programación - Fernando Iraira - Juan Mestica*/
public class Carpeta implements ItemArchivo {

    String nombre;
    ArrayList<ItemArchivo> items;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        items = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {

        String msg = "[Carpeta] " + this.nombre + "\n";

        for (ItemArchivo item : items) {
            msg += "--------" + item.mostrar() + "\n";
        }

        msg += "Peso total de carpeta: " + this.getPeso();

        return msg;
    }

    @Override
    public double getPeso() {

        double pesoTotal = 0;

        for (ItemArchivo item : items) {
            pesoTotal += item.getPeso();
        }

        return pesoTotal;
    }

    public void añadirItem(ItemArchivo item) {
        items.add(item);
    }

    public int getCantHijos() {
        return this.items.size();
    }

    public Carpeta obtenerSubcarpeta(String nombreSubcarpeta) {

        int i = 0;
        boolean seguir = true;
        Carpeta subcarpeta = null;

        while (i < items.size() && seguir) {

            if (items.get(i).getNombre().equals(nombreSubcarpeta)) {

                seguir = false;
                subcarpeta = (Carpeta) items.get(i);

            }
            i++;
        }

        return subcarpeta;
    }

    public ArrayList<ItemArchivo> getHijos() {
        return this.items;
    }

    public String mostrar() {
        return "[Carpeta] " + this.nombre;
    }
}
