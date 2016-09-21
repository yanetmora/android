package mx.edu.utng.prototype7;


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
    private EditText edtPrecio;
    private EditText edtNombre;
    private EditText edtCompra;
    private Button btnClonar;
    private GridView grvLibro;


    private ArrayList<Libro> libros;
    private Libro libro;
    private LibroAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtPrecio = (EditText)findViewById(R.id.edt_precio);
        edtNombre = (EditText)findViewById(R.id.edt_nombre);
        edtCompra = (EditText)findViewById(R.id.edt_compra);
        btnClonar = (Button)findViewById(R.id.btn_clonar);
        grvLibro = (GridView) findViewById(R.id.grv_libros);


        libros = new ArrayList<Libro>();
        libro = new Libro();


        btnClonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                libro.setPrecio(
                        Integer.parseInt(
                                edtPrecio.getText().toString()));
                libro.setNombre(edtNombre.getText().toString());
                try {
                    libro.setFechaCompra(
                            new SimpleDateFormat().parse(
                                    edtCompra.getText().toString()));
                }catch(ParseException e){
                    libro.setFechaCompra(new Date());
                }


                Libro clon = (Libro) libro.clonar();
                libros.add(clon);
                adapter = new LibroAdapter(
                        MainActivity.this, libros);
                grvLibro.setAdapter(adapter);


            }
        });




    }
}
