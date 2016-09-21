package mx.edu.utng.factory5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Yanet Mora on 14/09/2016.
 */
public class Flecha implements Figura{


    @Override
    public void dibujar(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        path.moveTo(50, 150);//1
        path.lineTo(150, 150);//2
        path.lineTo(150, 175);//3
        path.lineTo(200, 125);//4
        path.lineTo(150, 75);//5
        path.lineTo(150, 100);//6
        path.lineTo(50, 100);//7
        path.lineTo(50, 150);//9



        path.close();

        canvas.drawPath(path,paint);
    }




}
