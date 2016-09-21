package mx.edu.utng.prototypew;


import java.util.Date;


/**
 * Created by yanet on 5/09/16.
 */
public class Cheque implements Clonable {
    private int numero;
    private String nombre;
    private String apellido;
    private Date fecha;


    public Cheque(){}


    public Cheque(int numero, String nombre,
                          Date fecha, String apellido) {
        this.numero = numero;
        this.nombre = nombre;
        this.fecha = fecha;
        this.apellido= apellido;
    }


    @Override
    public Clonable clonar() {
        Cheque clon =
                new Cheque(numero, nombre, fecha,apellido);
        return clon;
    }


    public int getNumero() {
        return numero;
    }




    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getNombre() {
        return nombre;
    }



    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}