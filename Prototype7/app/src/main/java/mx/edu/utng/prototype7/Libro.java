package mx.edu.utng.prototype7;

import java.util.Date;

/**
 * Created by Yanet Mora on 14/09/2016.
 */
public class Libro implements Clonable {
    private int precio;
    private String nombre;
    private Date fechaCompra;


    public Libro(){}


    public Libro(int precio, String nombre,
                          Date fechaCompra) {
        this.precio = precio;
        this.nombre = nombre;
        this.fechaCompra = fechaCompra;
    }


    @Override
    public Clonable clonar() {
        Libro clon =
                new Libro(precio, nombre, fechaCompra);
        return clon;
    }


    public int getPrecio() {
        return precio;
    }


    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}

