package mx.edu.utng.factory5;


         /**
  * Created by qas on 31/08/16.
  */
         public class FiguraFactory {
       private Figura figura;


               public Figura crearFigura(String tipo){
               if(tipo!=null){
                        if(tipo.equalsIgnoreCase("circulo")){
                                 figura = new Circulo();

                            }else if(tipo.equalsIgnoreCase("cuadrado")){
                               figura = new Cuadrado();


                        }else if(tipo.equalsIgnoreCase("plato")){
                            figura = new Plato();


                        }else if(tipo.equalsIgnoreCase("corazon")){
                            figura = new Corazon();



                        }else if(tipo.equalsIgnoreCase("flecha")){
                            figura = new Flecha();


                        }else {
                               return null;
                           }
                   }
               return figura;
           }
     }

