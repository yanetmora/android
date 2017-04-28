package utng.edu.mx.wsclientes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class ClientesWS extends AppCompatActivity implements View.OnClickListener{
    private EditText etApellido;
    private EditText etName;
    private EditText etNameCompleto;
    private EditText etCorreoEletronico;
    private EditText etCompania;
    private EditText etCargo;
    private EditText etTelTrab;
    private EditText etTelPart;
    private EditText etTelMov;
    private EditText etNumFax;
    private EditText etDireccion;
    private EditText etCiudad;
    private EditText etEstado;
    private EditText etCodigoPostal;

    private Button btGuardar;
    private Button btListar;

    private Cliente cliente = null;
    final String NAMESPACE =
            "http://ws.utng.edu.mx";
    final SoapSerializationEnvelope envelope =
            new SoapSerializationEnvelope(SoapEnvelope.VER11);
    static String URL =
            "http://192.168.24.239:8080/WSClientes/services/ClienteWS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_ws);
        components();
    }

    private void components() {
        etApellido = (EditText) findViewById(R.id.et_apellido);
        etName = (EditText) findViewById(R.id.et_nombre);
        etNameCompleto = (EditText) findViewById(R.id.et_nombre_completo);
        etCorreoEletronico = (EditText) findViewById(R.id.et_correo_electronico);
        etCompania = (EditText) findViewById(R.id.et_compania);
        etCargo = (EditText) findViewById(R.id.et_cargo);
        etTelTrab = (EditText) findViewById(R.id.et_tel_trab);
        etTelPart = (EditText) findViewById(R.id.et_tel_part);
        etTelMov = (EditText) findViewById(R.id.et_tel_mov);
        etNumFax = (EditText) findViewById(R.id.et_num_fax);
        etDireccion = (EditText) findViewById(R.id.et_direccion);
        etCiudad = (EditText) findViewById(R.id.et_ciudad);
        etEstado = (EditText) findViewById(R.id.et_estado);
        etCodigoPostal = (EditText) findViewById(R.id.et_codigo_postal);

        btGuardar = (Button) findViewById(R.id.bt_save);
        btListar = (Button) findViewById(R.id.bt_list);
        btGuardar.setOnClickListener(this);
        btListar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_consume_w, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        String apellido = etApellido.getText().toString();
        String nombre = etName.getText().toString();
        String nombreComp = etNameCompleto.getText().toString();
        String correo = etCorreoEletronico.getText().toString();
        String compania = etCompania.getText().toString();
        String cargo = etCargo.getText().toString();
        String telTrab = etTelTrab.getText().toString();
        String telPart = etTelPart.getText().toString();
        String telMov = etTelMov.getText().toString();
        String numFax = etNumFax.getText().toString();
        String direccion = etDireccion.getText().toString();
        String ciudad = etCiudad.getText().toString();
        String estado = etEstado.getText().toString();
        String codigoPostal = etCodigoPostal.getText().toString();


        if (v.getId() == btGuardar.getId()) {
            if (apellido != null && !apellido.isEmpty() &&
                    nombre != null && !nombre.isEmpty() &&
                    nombreComp != null && !nombreComp.isEmpty() &&
                    correo != null && !correo.isEmpty() &&
                    compania != null && !compania.isEmpty() &&
                    cargo != null && !cargo.isEmpty()&&
                    telTrab != null && !telTrab.isEmpty() &&
                    telPart != null && !telPart.isEmpty() &&
                    telMov != null && !telMov.isEmpty() &&
                    numFax != null && !numFax.isEmpty() &&
                    direccion != null && !direccion.isEmpty() &&
                    ciudad != null && !ciudad.isEmpty() &&
                    estado!= null && !estado.isEmpty() &&
                    codigoPostal != null && !codigoPostal.isEmpty()) {
                try {
                    if (getIntent().getExtras().getString("accion")
                            .equals("modificar")) {
                        updateCliente tarea = new updateCliente();
                        tarea.execute();
                    }

                } catch (Exception e) {
                    //Cuando no se haya mandado una accion por defecto es insertar.
                    InsertCliente tarea = new InsertCliente();
                    tarea.execute();
                }
            } else {
                Toast.makeText(this, "llenar todos los campos", Toast.LENGTH_LONG).show();
            }

        }
        if (btListar.getId() == v.getId()) {
            startActivity(new Intent(ClientesWS.this, ListClientes.class));
        }
    }//fin conClick

    private void cleanEditTex() {
        etApellido.setText("");
        etName.setText("");
        etNameCompleto.setText("");
        etCorreoEletronico.setText("");
        etCompania.setText("");
        etCargo.setText("");
        etTelTrab.setText("");
        etTelPart.setText("");
        etTelMov.setText("");
        etNumFax.setText("");
        etDireccion.setText("");
        etCiudad.setText("");
        etEstado.setText("");
        etCodigoPostal.setText("");
    }


    private class InsertCliente extends
            AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = true;
            final String METHOD_NAME = "addCliente";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

            SoapObject request =
                    new SoapObject(NAMESPACE, METHOD_NAME);

            cliente = new Cliente();
            cliente.setProperty(0, 0);
            obtenerDatos();

            PropertyInfo info = new PropertyInfo();
            info.setName("cliente");
            info.setValue(cliente);
            info.setType(cliente.getClass());
            request.addProperty(info);
            envelope.setOutputSoapObject(request);
            envelope.addMapping(NAMESPACE, "Cliente", Cliente.class);

            /* Para serializar flotantes y otros tipos no cadenas o enteros*/
            MarshalFloat mf = new MarshalFloat();
            mf.register(envelope);

            HttpTransportSE transporte = new HttpTransportSE(URL);
            try {
                transporte.call(SOAP_ACTION, envelope);
                SoapPrimitive response =
                        (SoapPrimitive) envelope.getResponse();
                String res = response.toString();
                if (!res.equals("1")) {
                    result = false;
                }

            } catch (Exception e) {
                Log.e("Error ", e.getMessage());
                result = false;
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                Toast.makeText(getApplicationContext(),
                        "Registro exitoso.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Error al insertar.",
                        Toast.LENGTH_SHORT).show();

            }
            cleanEditTex();
        }
    }//fin tarea insertar

    private class updateCliente extends
            AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean result = true;

            final String METHOD_NAME = "UpdateCliente";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            cliente = new Cliente();
            cliente.setProperty(0, getIntent().getExtras().getString("valor0"));
            obtenerDatos();

            PropertyInfo info = new PropertyInfo();
            info.setName("cliente");
            info.setValue(cliente);
            info.setType(cliente.getClass());

            request.addProperty(info);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);

            envelope.setOutputSoapObject(request);

            envelope.addMapping(NAMESPACE, "Cliente", cliente.getClass());

            MarshalFloat mf = new MarshalFloat();
            mf.register(envelope);

            HttpTransportSE transporte = new HttpTransportSE(URL);

            try {
                transporte.call(SOAP_ACTION, envelope);

                SoapPrimitive resultado_xml = (SoapPrimitive) envelope
                        .getResponse();
                String res = resultado_xml.toString();

                if (!res.equals("1")) {
                    result = false;
                }

            } catch (HttpResponseException e) {
                Log.e("Error HTTP", e.toString());
            } catch (IOException e) {
                Log.e("Error IO", e.toString());
            } catch (XmlPullParserException e) {
                Log.e("Error XmlPullParser", e.toString());
            }

            return result;

        }

        protected void onPostExecute(Boolean result) {

            if (result) {
                Toast.makeText(getApplicationContext(), "Actualizado OK",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Error al actualizar",
                        Toast.LENGTH_SHORT).show();

            }
            cleanEditTex();
        }
    }

    private void obtenerDatos() {
        cliente.setProperty(1, etApellido.getText().toString());
        cliente.setProperty(2, etName.getText().toString());
        cliente.setProperty(3, etNameCompleto.getText().toString());
        cliente.setProperty(4, etCorreoEletronico.getText().toString());
        cliente.setProperty(5, etCompania.getText().toString());
        cliente.setProperty(6, etCargo.getText().toString());
        cliente.setProperty(7, etTelTrab.getText().toString());
        cliente.setProperty(8, etTelPart.getText().toString());
        cliente.setProperty(9, etTelMov.getText().toString());
        cliente.setProperty(10, etNumFax.getText().toString());
        cliente.setProperty(11, etDireccion.getText().toString());
        cliente.setProperty(12, etCiudad.getText().toString());
        cliente.setProperty(13, etEstado.getText().toString());
        cliente.setProperty(14, etCodigoPostal.getText().toString());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle datosRegreso = this.getIntent().getExtras();
        try {
            etApellido.setText(datosRegreso.getString("valor1"));
            etName.setText(datosRegreso.getString("valor2"));
            etNameCompleto.setText(datosRegreso.getString("valor3"));
            etCorreoEletronico.setText(datosRegreso.getString("valor4"));
            etCompania.setText(datosRegreso.getString("valor5"));
            etCargo.setText(datosRegreso.getString("valor6"));
            etTelTrab.setText(datosRegreso.getString("valor7"));
            etTelPart.setText(datosRegreso.getString("valor8"));
            etTelMov.setText(datosRegreso.getString("valor9"));
            etNumFax.setText(datosRegreso.getString("valor10"));
            etDireccion.setText(datosRegreso.getString("valor11"));
            etCiudad.setText(datosRegreso.getString("valor12"));
            etEstado.setText(datosRegreso.getString("valor13"));
            etCodigoPostal.setText(datosRegreso.getString("valor14"));
        } catch (Exception e) {
            Log.e("Error al Recargar", e.toString());
        }

    }
}
