package utng.edu.mx.wsclientes;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class ListClientes extends ListActivity {

    final String NAMESPACE = "http://ws.utng.edu.mx";

    final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
            SoapEnvelope.VER11);

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private int idSeleccionado;
    private int posicionSeleccionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Clientes query = new Clientes();
        query.execute();
        registerForContextMenu(getListView());


    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_modificar:
                Cliente cliente = clientes.get(posicionSeleccionado);
                Bundle bundleLibro = new Bundle();
                for (int i = 0; i < cliente.getPropertyCount(); i++) {
                    bundleLibro.putString("valor" + i, cliente.getProperty(i)
                            .toString());
                }
                bundleLibro.putString("accion", "modificar");
                Intent intent = new Intent(ListClientes.this, ClientesWS.class);
                intent.putExtras(bundleLibro);
                startActivity(intent);

                return true;
            case R.id.item_eliminar:
                DeleteExam eliminar = new DeleteExam();
                eliminar.execute();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_regresar:
                startActivity(new Intent(ListClientes.this, ClientesWS.class));
                break;
            default:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(getListView().getAdapter().getItem(info.position).toString());
        idSeleccionado = (Integer) clientes.get(info.position).getProperty(0);
        posicionSeleccionado = info.position;
        inflater.inflate(R.menu.menu_options, menu);
    }




    private class Clientes extends AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean result = true;
            final String METHOD_NAME = "getClientes";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;
            clientes.clear();
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(ClientesWS.URL);
            try {
                transporte.call(SOAP_ACTION, envelope);
                Vector<SoapObject> response = (Vector<SoapObject>) envelope.getResponse();
                if (response != null) {
                    for (SoapObject objSoap : response) {
                        Cliente cliente = new Cliente();
                        cliente.setProperty(0, Integer.parseInt(objSoap.getProperty("id").toString()));
                        cliente.setProperty(1, objSoap.getProperty("apellidos").toString());
                        cliente.setProperty(2, objSoap.getProperty("nombre").toString());
                        cliente.setProperty(3, objSoap.getProperty("nombreCompleto").toString());
                        cliente.setProperty(4, objSoap.getProperty("correoElectronico").toString());
                        cliente.setProperty(5, objSoap.getProperty("compania").toString());
                        cliente.setProperty(6, objSoap.getProperty("cargo").toString());
                        cliente.setProperty(7, objSoap.getProperty("telefonoTrabajo").toString());
                        cliente.setProperty(8, objSoap.getProperty("telefonoParticular").toString());
                        cliente.setProperty(9, objSoap.getProperty("telefonoMovil").toString());
                        cliente.setProperty(10, objSoap.getProperty("numeroFax").toString());
                        cliente.setProperty(11, objSoap.getProperty("direccion").toString());
                        cliente.setProperty(12, objSoap.getProperty("ciudad").toString());
                        cliente.setProperty(13, objSoap.getProperty("estado").toString());
                        cliente.setProperty(14, objSoap.getProperty("codigoPostal").toString());
                        clientes.add(cliente);
                    }
                }

            } catch (XmlPullParserException e) {
                Log.e("Error XMLPullParser", e.toString());
                result = false;
            } catch (HttpResponseException e) {
                Log.e("Error HTTP", e.toString());

                result = false;
            } catch (IOException e) {
                Log.e("Error IO", e.toString());
                result = false;
            } catch (ClassCastException e) {
                try {
                    SoapObject objSoap = (SoapObject) envelope.getResponse();
                    Cliente cliente = new Cliente();
                    cliente.setProperty(0, Integer.parseInt(objSoap.getProperty("id").toString()));
                    cliente.setProperty(1, objSoap.getProperty("apellidos").toString());
                    cliente.setProperty(2, objSoap.getProperty("nombre").toString());
                    cliente.setProperty(3, objSoap.getProperty("nombreCompleto").toString());
                    cliente.setProperty(4, objSoap.getProperty("correoElectronico").toString());
                    cliente.setProperty(5, objSoap.getProperty("compania").toString());
                    cliente.setProperty(6, objSoap.getProperty("cargo").toString());
                    cliente.setProperty(7, objSoap.getProperty("telefonoTrabajo").toString());
                    cliente.setProperty(8, objSoap.getProperty("telefonoParticular").toString());
                    cliente.setProperty(9, objSoap.getProperty("telefonoMovil").toString());
                    cliente.setProperty(10, objSoap.getProperty("numeroFax").toString());
                    cliente.setProperty(11, objSoap.getProperty("direccion").toString());
                    cliente.setProperty(12, objSoap.getProperty("ciudad").toString());
                    cliente.setProperty(13, objSoap.getProperty("estado").toString());
                    cliente.setProperty(14, objSoap.getProperty("codigoPostal").toString());
                    clientes.add(cliente);
                } catch (SoapFault e1) {
                    Log.e("Error SoapFault", e.toString());
                    result = false;
                }
            }
            return result;
        }

        protected void onPostExecute(Boolean result) {

            if (result) {
                final String[] datos = new String[clientes.size()];
                for (int i = 0; i < clientes.size(); i++) {
                    datos[i] = clientes.get(i).getProperty(0) + " - "
                            + clientes.get(i).getProperty(1)+ " - "
                            + clientes.get(i).getProperty(2)+ " - "
                            + clientes.get(i).getProperty(3)+ " - "
                            + clientes.get(i).getProperty(4)+ " - "
                            + clientes.get(i).getProperty(5)+ " - "
                            + clientes.get(i).getProperty(6)+ " - "
                            + clientes.get(i).getProperty(7)+ " - "
                            + clientes.get(i).getProperty(8)+ " - "
                            + clientes.get(i).getProperty(9)+ " - "
                            + clientes.get(i).getProperty(10)+ " - "
                            + clientes.get(i).getProperty(11)+ " - "
                            + clientes.get(i).getProperty(12)+ " - "
                            + clientes.get(i).getProperty(13)+ " - "
                            + clientes.get(i).getProperty(14);
                }

                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                        ListClientes.this,
                        android.R.layout.simple_list_item_1, datos);
                setListAdapter(adaptador);
            } else {
                Toast.makeText(getApplicationContext(), "No se encontraron datos.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class DeleteExam extends AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean result = true;

            final String METHOD_NAME = "removeCliente";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;


            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("id", idSeleccionado);

            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(ClientesWS.URL);
            try {
                transporte.call(SOAP_ACTION, envelope);
                SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
                String res = resultado_xml.toString();

                if (!res.equals("0")) {
                    result = true;
                }

            } catch (Exception e) {
                Log.e("Error", e.toString());
                result = false;
            }
            return result;
        }

        protected void onPostExecute(Boolean result) {

            if (result) {
                Toast.makeText(getApplicationContext(),
                        "Eliminado", Toast.LENGTH_SHORT).show();
                Clientes consulta = new Clientes();
                consulta.execute();
            } else {
                Toast.makeText(getApplicationContext(), "Error al eliminar",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
