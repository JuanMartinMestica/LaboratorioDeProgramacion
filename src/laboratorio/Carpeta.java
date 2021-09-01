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
        return "----- [Carpeta] " + this.nombre ;
    }

    @Override
    public String toString() {

        String msg = "[CARPETA] " + this.nombre + "\n";

        for (ItemArchivo item : items) {
            msg += item.getNombre() + "\n";
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

}
