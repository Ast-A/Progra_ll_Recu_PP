package Entidades;

import java.util.Objects;


public class PapasFritas extends Producto implements IVendible{
    
    private TipoPapas tipoPapas;

    public PapasFritas(String codigoProducto, String nombre, double precio, Proveedor proveedor) {
        super(codigoProducto, nombre, precio, proveedor);
    }

    public PapasFritas(String codigoProducto, String nombre, double precio, Proveedor proveedor, TipoPapas tipoPapas) {
        super(codigoProducto, nombre, precio, proveedor);
        this.tipoPapas = tipoPapas;
    }
    
    @Override
    public double getPrecioTotal() {
        switch(tipoPapas){
            case CLASICAS:
                return precio * 1.10;
            case CON_CHEDDAR:
                return precio * 1.15;
            case CON_BACON:
                return precio * 1.20;
            default:
                return precio;
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + ", tipo papas: " + tipoPapas + ", precio total: $" + getPrecioTotal();
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof PapasFritas)){
            return false;
        }
        PapasFritas otras = (PapasFritas) obj;
        return super.equals(otras) && this.tipoPapas == otras.tipoPapas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.tipoPapas);
        return hash;
    }
}
