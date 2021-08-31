package laboratorio;

import java.util.ArrayList;

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

        String msg = "[CARPETA] " + this.nombre + "\n";

        for (ItemArchivo item : items) {
            msg += item.toString() + "\n";
        }

        msg += "Peso total: " + this.getPeso();
        
        return msg;
    }
    
    @Override
    public double getPeso() {
        
        double pesoTotal = 0;
        
        for (ItemArchivo item: items) {
            pesoTotal += item.getPeso();
        }
        
        return pesoTotal;
    }
    

    public void añadirItem(ItemArchivo item) {
        items.add(item);
    }

    

}
