package mx.edu.utng.prototypew;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.DataFormatException;


public class MainActivity extends AppCompatActivity {
    private EditText edtNumero;
    private EditText edtNombre;
    private EditText edtFecha;
    private EditText edtApellido;
    private Button btnClonar;
    private GridView grvCheque;


    private ArrayList<Cheque> cheques;
    private Cheque cheque;
    private ChequeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNumero = (EditText)findViewById(R.id.edt_nuemro);
        edtNombre = (EditText)findViewById(R.id.edt_nombre);
        edtFecha = (EditText)findViewById(R.id.edt_fecha);
        edtApellido = (EditText)findViewById(R.id.edt_apellido);
        btnClonar = (Button)findViewById(R.id.btn_clonar);
        grvCheque = (GridView) findViewById(R.id.grv_cheques);



        cheques = new ArrayList<Cheque>();
        cheque = new Cheque();


        btnClonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheque.setNumero(
                        Integer.parseInt(
                                edtNumero.getText().toString()));
                cheque.setNombre(edtNombre.getText().toString());
                try {
                    cheque.setFecha(
                            new SimpleDateFormat().parse(
                                    edtFecha.getText().toString()));
                }catch(ParseException e){
                    cheque.setFecha(new Date());
                }


                Cheque clon = (Cheque) cheque.clonar();
                cheques.add(clon);
                adapter = new ChequeAdapter(
                        MainActivity.this, cheques);
                grvCheque.setAdapter(adapter);


            }
        });




    }
}



