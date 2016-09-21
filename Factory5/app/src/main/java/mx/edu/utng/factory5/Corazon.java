package mx.edu.utng.factory5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Yanet Mora on 14/09/2016.
 */

    public class Corazon implements Figura {

    @Override
    public void dibujar(Canvas canvas) {
        Paint paint = new Paint();
        Paint ojos = new Paint();

        float ancho = canvas.getWidth() / 2;
        float alto = canvas.getHeight() / 2;

        Path trinagulo = new Path();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        ojos.setColor(Color.BLACK);
        ojos.setStyle(Paint.Style.FILL);

        float mitad = canvas.getWidth() / 2;
        float min = Math.min(canvas.getWidth(), canvas.getHeight());
        float half = min / 2;

        canvas.drawCircle(ancho - 80, alto, 80, paint);
        canvas.drawCircle(ancho + 80, alto, 80, paint);

        trinagulo.moveTo(ancho - 137, alto + 56);
        trinagulo.lineTo(ancho - 137, alto);
        trinagulo.lineTo(ancho + 137, alto);

        trinagulo.lineTo(ancho + 137, alto + 56);
        trinagulo.lineTo(ancho, alto + 193);
        trinagulo.close();

        canvas.drawPath(trinagulo, paint);

    }
}