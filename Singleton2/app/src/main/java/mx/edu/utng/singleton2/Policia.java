package mx.edu.utng.singleton2;


         /**
   * Created by qas on 30/08/16.
   */
public class Policia {

             private String nombrepol;
             private String apellido;
             private int numeroplaca;

        private static Policia policia;


                 private Policia(){
                this.nombrepol = "";
                     this.apellido = "";
                this.numeroplaca = 0;
             }

             public static void setPolicia(Policia policia) {
                 Policia.policia = policia;
             }

             public void setNumeroplaca(int numeroplaca) {
                 this.numeroplaca = numeroplaca;
             }

             public void setApellido(String apellido) {
                 this.apellido = apellido;
             }

             public void setNombrepol(String nombrepol) {
                 this.nombrepol = nombrepol;
             }

             public String getNombrepol() {
                 return nombrepol;
             }

             public String getApellido() {
                 return apellido;
             }

             public int getNumeroplaca() {
                 return numeroplaca;
             }



             public static Policia getPolicia(){
                if(policia==null){
                         policia = new Policia();
                    }
                return policia;
             }
         }

