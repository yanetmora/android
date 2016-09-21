package mx.edu.utng.factory5;


         import android.graphics.Canvas;
         import android.graphics.Color;
         import android.graphics.Paint;


         /**
  * Created by yanet on 14/08/16.
   */
         public class Circulo implements Figura {


                 @Override
        public void dibujar(Canvas canvas) {
                 Paint paint = new Paint();
                 paint.setColor(Color.RED);
                paint.setStyle(Paint.Style.FILL);


                 float mitadX = canvas.getWidth()/2;
                float mitadY = canvas.getHeight()/2;

                canvas.drawCircle(mitadX, mitadY, 200, paint);


             }
     }

