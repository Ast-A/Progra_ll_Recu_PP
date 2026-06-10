package recuperatoriopp.allende.evelyn;

import Entidades.*;

public class RecuperatorioPPAllendeEvelyn {

    
    public static void main(String[] args) {
        // PROVEEDORES
    Proveedor prov1 = new Proveedor("Carnes Premium", "CABA", 15 );
    Proveedor prov2 = new Proveedor("Distribuidora Norte", "Buenos Aires", 10);
    Proveedor prov3 = new Proveedor("Alimentos del Centro", "Cordoba", 8 );
    // PRODUCTOS
    Hamburguesa h1 = new Hamburguesa("H001", "Hamburguesa Clásica", 3500, prov1, TipoHamburguesa.SIMPLE, TamanioHamburguesa.GRANDE);
    Hamburguesa h2 = new Hamburguesa("H002","Hamburguesa Doble Queso", 4200, prov2, TipoHamburguesa.DOBLE, TamanioHamburguesa.MEDIANA);
    Hamburguesa h3 = new Hamburguesa("H003", "Hamburguesa Bacon", 3900, prov1,TipoHamburguesa.SIMPLE, TamanioHamburguesa.CHICA);
    PapasFritas pf1 = new PapasFritas("P001", "Papas Clasicas", 1500, prov2,TipoPapas.CLASICAS);
    PapasFritas pf2 = new PapasFritas("P002", "Papas Cheddar", 1800, prov3,TipoPapas.CON_CHEDDAR);
    PapasFritas pf3 = new PapasFritas("P003", "Papas Bacon", 2000, prov1,TipoPapas.CON_BACON);
    // HAMBURGUESERIA
    Hamburgueseria hamburgueseria = new Hamburgueseria("Burger House", 5);
    hamburgueseria.agregar(h1);
    // Intento de agregar producto repetido
    Hamburguesa h4 = new Hamburguesa("H001", "Hamburguesa Clásica", 3500, prov1,TipoHamburguesa.SIMPLE, TamanioHamburguesa.GRANDE);
    hamburgueseria.agregar(h4);
    // Agrego más productos.
    hamburgueseria.agregar(h2);
    hamburgueseria.agregar(h3);
    hamburgueseria.agregar(pf1);
    hamburgueseria.agregar(pf2);
    // Intento de agregar superando capacidad
    hamburgueseria.agregar(pf3);
    // MOSTRAR INFORMACIÓN COMPLETA
    System.out.println("\n===== INFORMACIÓN COMPLETA DE LA HAMBURGUESERÍA=====" );
    System.out.println(hamburgueseria);
    // ITERACIÓN EXPLÍCITA DESDE Hamburgueseria
    System.out.println("\n===== ITERACIÓN EXPLÍCITA DESDE Hamburgueseria =====");
    for (Producto producto : hamburgueseria)
    {
    System.out.println(producto);
    }
    // PRODUCTO MÁS CARO
    System.out.println("\n===== PRODUCTO MÁS CARO =====");
    System.out.println(hamburgueseria.getProductoMasCaro());

    }
    
}
