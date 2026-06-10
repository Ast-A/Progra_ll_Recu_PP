package Entidades;

import java.util.Objects;


public class Hamburguesa extends Producto implements IVendible {
    
    private TipoHamburguesa tipoHamburguesa;
    private TamanioHamburguesa tamanio;
    
    public Hamburguesa(String codigoProducto, String nombre, double precio, Proveedor proveedor, TipoHamburguesa tipoHamburguesa, TamanioHamburguesa tamanio){
        super(codigoProducto, nombre, precio, proveedor);
        this.tipoHamburguesa = tipoHamburguesa;
        this.tamanio = tamanio;
    }
    
    public double getPrecioTotal(){
        switch(tamanio){
            case CHICA:
                return precio * 1.05;
            case MEDIANA:
                return precio * 1.10;
            case GRANDE: 
                return precio * 1.20;
            default:
                return precio;
        }
    }
    
    public String toString(){
        return super.toString() + ", Tipo Hamburguesa: " + tipoHamburguesa + ", tamanio: " + tamanio + ", precio total: $" + getPrecioTotal();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.tipoHamburguesa);
        hash = 29 * hash + Objects.hashCode(this.tamanio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Hamburguesa)){
            return false;
        }
        Hamburguesa otra = (Hamburguesa) obj;
        return super.equals(otra) && this.tipoHamburguesa == otra.tipoHamburguesa && this.tamanio == otra.tamanio; 
    }
}
