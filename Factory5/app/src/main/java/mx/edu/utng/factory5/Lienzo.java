package mx.edu.utng.factory5;


         import android.content.Context;
         import android.graphics.Canvas;
         import android.view.View;


         /**
   * Created by qas on 31/08/16.
  */
         public class Lienzo extends View {
         private Figura figura;


                 public Lienzo(Context context, Figura figura){
                super(context);
                this.figura = figura;
             }


                @Override
         protected void onDraw(Canvas canvas) {
                 if(figura!=null){
                        figura.dibujar(canvas);
                   }
            }


                 public Figura getFigura() {
                 return figura;
             }


                 public void setFigura(Figura figura) {
                this.figura = figura;
            }
     }

