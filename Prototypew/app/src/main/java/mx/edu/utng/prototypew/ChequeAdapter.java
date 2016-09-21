package mx.edu.utng.prototypew;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;


/**
 * Created by yanet Mora on 11/09/16.
 */
public class ChequeAdapter extends ArrayAdapter<Cheque>{


    public ChequeAdapter(Context context,
                          ArrayList<Cheque> cheques){
        super(context, 0, cheques);
    }


    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        Cheque cheque = getItem(position);


        if(convertView==null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.cheque_layout, parent, false);
        }


        TextView txvCheque = (TextView)
                convertView.findViewById(R.id.txv_cheque);
        txvCheque.setText(cheque.getNumero()+" "+
                cheque.getNombre());


        return convertView;
    }
}
