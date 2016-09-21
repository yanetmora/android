package mx.edu.utng.singleton3;

/**
 * Created by Yanet Mora on 09/09/2016.
 */
public class Policia {

    private String nombrePolicia;
    private  String apellido;
    private int numeroPlaca;

    private  static Policia policia ;




    private Policia() {
        this.nombrePolicia = "";
        this.apellido = "";
        this.numeroPlaca =0;

    }

    public void setNombrePolicia(String nombrePolicia) {
        this.nombrePolicia = nombrePolicia;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumeroPlaca(int numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public static void setPolicia(Policia policia) {
        Policia.policia = policia;
    }

    public String getNombrePolicia() {
        return nombrePolicia;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumeroPlaca() {
        return numeroPlaca;
    }

    public  static Policia getPolicia(){
        if (policia==null){
            policia=new Policia();
        }
        return policia;

    }
}
