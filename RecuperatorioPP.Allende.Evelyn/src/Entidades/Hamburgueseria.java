package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Hamburgueseria implements Iterable<Producto> {
     
    private String nombre;
    private int capacidad;
    private Collection<Producto> productos;
    
    public Hamburgueseria(String nombre){
        this(nombre, 3);
    }

    public Hamburgueseria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        productos = new ArrayList<>();
    }
    
    private boolean sonIguales(Producto p){
        for(Producto prod : productos){
            if(prod.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    public void agregar(Producto p){
        if(productos.size() >= capacidad){
            System.out.println("No hay capacidad para agregar el producto");
        }
        else if (sonIguales(p)){
            System.out.println("Producto existente");
        }
        else{
            productos.add(p);
        }
    }
    
    private double getPrecioDeHamburguesas(){
        double total = 0;
        for(Producto p : productos){
            if(p instanceof Hamburguesa){
                total += ((Hamburguesa) p).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioDePapas(){
        double total = 0;
        for(Producto p : productos){
            if(p instanceof PapasFritas){
                total += ((PapasFritas) p).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioTotal(){
        double total = 0;
        for(Producto p : productos){
            if(p instanceof IVendible){
                total += ((IVendible) p).getPrecioTotal();
            }
        }
        return total;
    }

    
    private double getPrecioProductos(TipoProducto tipo){
        switch(tipo){
            case HAMBURGUESAS:
                return getPrecioDeHamburguesas();
            case PAPAS:
                return getPrecioDePapas();
            case AMBAS:
                return getPrecioTotal();
            default: 
                return 0;
        }
    } 
    
    @Override
    public Iterator<Producto> iterator(){
        return productos.iterator();
    }
    
    public Producto getProductoMasCaro(){
        if(productos.isEmpty()){
            return null;
        }
        Producto masCaro = null;
        double mayorPrecio = 0;
        for(Producto p : productos){
            double precio = ((IVendible) p).getPrecioTotal();
            if(masCaro == null || precio > mayorPrecio){
                masCaro = p;
                mayorPrecio = precio;
            }
        }
        return masCaro;
    }
    

    public String toString(){
        String salida = "Hamburgueseria: " + nombre + "\nCapacidad: " + capacidad + "\nCant. de Productos: " + productos.size() +"\nProductos\n";
        for(Producto p : productos){
            salida += p.toString() + "\n";
        }
        salida += "\nPrecio total hamburguesas: $" + getPrecioDeHamburguesas() + "\nPrecio total de papas: $" + getPrecioDePapas() + "\nPrecio total general: $" + getPrecioTotal();
        return salida;
    }
    
    
}
