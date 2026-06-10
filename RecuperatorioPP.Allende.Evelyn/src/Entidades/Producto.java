package Entidades;

import java.util.Objects;
import java.util.Random;


public abstract class Producto {
    protected Proveedor proveedor;
    protected String codigoProducto;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;
    
    static {
        generadorAleatorio = new Random();
    }

    public Producto(String codigoProducto, String nombre, double precio, Proveedor proveedor) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    public Producto(String codigoProducto, String nombre, double precio, String nombreProveedor, String ciudadProveedor, int antiguedadProveedor) {
        this(codigoProducto, nombre, precio, new Proveedor(nombreProveedor, ciudadProveedor, antiguedadProveedor));
    }

    public int getCalorias() {
        if(calorias == 0){
            calorias = generadorAleatorio.nextInt(601) + 200;
        }
        return calorias;
    }
    
    public int getTiempoPreparacion() {
        if(tiempoPreparacion == 0){
            tiempoPreparacion = generadorAleatorio.nextInt(19) + 2;
        }
        return tiempoPreparacion;
    }
    
    private static String mostrar(Producto p){
        return "Codigo: " + p.codigoProducto + ", Nombre: " + p.nombre + ", Precio: " + p.precio + ",  Calorias: " + p.getCalorias() + ", Tiempo de Preparacion: " + p.getTiempoPreparacion();
    }
    
    private static boolean sonIguales(Producto p1, Producto p2){
        if(p1 == null || p2 == null){
            return false;
        }
        return p1.codigoProducto.equals(p2.codigoProducto) && Proveedor.sonIguales(p1.proveedor, p2.proveedor);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Producto)){
            return false;
        }
        Producto otro = (Producto) obj;
        return sonIguales(this, otro);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.proveedor);
        hash = 97 * hash + Objects.hashCode(this.codigoProducto);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + this.calorias;
        hash = 97 * hash + this.tiempoPreparacion;
        return hash;
    }
    
    @Override
    public String toString(){
        return mostrar(this) + ", Proveedor: " + proveedor.toString();
    }
}
