package mx.edu.utng.singleton3;


         import android.support.v7.app.AppCompatActivity;
         import android.os.Bundle;
         import android.view.View;
         import android.widget.Button;
         import android.widget.EditText;
         import android.widget.Toast;


         public class MainActivity extends AppCompatActivity {


                private EditText edtNombrePolicia;
                private EditText edtApellido;
                private EditText edtNumeroPlaca;

             private Button btnCrear;


                @Override
       protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_main);

                    edtNombrePolicia = (EditText) findViewById(R.id.edt_nombrepolicia);
                    edtApellido = (EditText) findViewById(R.id.edt_apellido);
                    edtNumeroPlaca = (EditText) findViewById(R.id.edt_numeroplaca);

                    btnCrear = (Button) findViewById(R.id.btn_crear);


            btnCrear.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                               Policia policia = Policia.getPolicia();
                               policia.setNombrepolicia(edtNombrePolicia.getText().toString());
                             policia.setApellido(edtApellido.getText().toString());
                           policia.setNumeroplaca(Integer.parseInt(edtNumeroPlaca.getText().toString()));

                            Toast.makeText(MainActivity.this, "Policia: "
                                                   +"\nNombrePolicia: "+policia.getNumeroplaca()
                                                    +"\nApellido: "+policia.getApellido()
                                                    +"\nNombrePlaca: "+policia.getNumeroplaca(),Toast.LENGTH_SHORT).show();
                           }
                     });

           }
}

