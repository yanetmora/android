package mx.edu.utng.factory5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Yanet Mora on 14/09/2016.
 */
public class Plato implements Figura{


    @Override
    public void dibujar(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        path.moveTo(50, 75);//1
        path.lineTo(75, 75);//2
        path.lineTo(75, 100);//3
        path.lineTo(175, 100);//4
        path.lineTo(175, 75);//5
        path.lineTo(200, 75);//6
        path.lineTo(200, 50);//7
        path.lineTo(50, 50);//9
        path.lineTo(50, 75);//7

        path.close();

        canvas.drawPath(path,paint);
    }




    }