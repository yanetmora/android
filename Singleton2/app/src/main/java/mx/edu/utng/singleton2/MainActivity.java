package mx.edu.utng.singleton2;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText edtNombrepol;
    private EditText edtApellido;
    private EditText edtnumeroplaca;


    private Button btnCrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNombrepol = (EditText) findViewById(R.id.edt_nombrepol);
        edtApellido = (EditText) findViewById(R.id.edt_apellido);
        edtnumeroplaca = (EditText) findViewById(R.id.edt_numeroplaca);
        btnCrear = (Button) findViewById(R.id.btn_crear);


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Policia policia = Policia.getPolicia();
                policia.setNombrepol(edtNombrepol.getText().toString());
                policia.setApellido(edtnumeroplaca.getText().toString());


                Toast.makeText(MainActivity.this, "Policia: "
                                + "\nNombrepol: " + policia.getNombrepol()
                                + "\nNumero de Alumnos: " + policia.getApellido(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}