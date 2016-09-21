package mx.edu.utng.prototype7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yanet Mora on 14/09/2016.
 */
public class LibroAdapter extends ArrayAdapter<Libro> {


    public LibroAdapter(Context context,
                          ArrayList<Libro> libros){
        super(context, 0, libros);
    }


    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        Libro libro = getItem(position);


        if(convertView==null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.libro_layout, parent, false);
        }


        TextView txvTarjeta = (TextView)
                convertView.findViewById(R.id.txv_libro);
        txvTarjeta.setText(libro.getPrecio()+" "+
                libro.getNombre());


        return convertView;
    }
}

