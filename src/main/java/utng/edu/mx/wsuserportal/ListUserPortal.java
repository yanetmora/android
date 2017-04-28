package utng.edu.mx.wsuserportal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
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



public class ListUserPortal extends ListActivity {
    final String NAMESPACE = "http://ws.utng.edu.mx";

    final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
            SoapEnvelope.VER11);

    private ArrayList<UserPortal> userPortals = new ArrayList<UserPortal>();
    private int idSelected;
    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TaskWSSelect select=new TaskWSSelect();
        select.execute();
        registerForContextMenu(getListView());

    }//


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_modificar:

                UserPortal userPortal= userPortals.get(selectedPosition);
                Bundle bundleUserPortal = new Bundle();
                for (int i = 0; i < userPortal.getPropertyCount(); i++) {
                    bundleUserPortal.putString("valor" + i, userPortal.getProperty(i)
                            .toString());
                }
                bundleUserPortal.putString("accion", "modificar");
                Intent intent = new Intent(ListUserPortal.this, MainActivity.class);
                intent.putExtras(bundleUserPortal);
                startActivity(intent);

                return true;
            case R.id.item_eliminar:
                TaskWSDelete eliminar = new TaskWSDelete();
                eliminar.execute();

                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }


    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_regresar:
                startActivity(new Intent(ListUserPortal.this, MainActivity.class));
                break;
            default:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }//
    private class TaskWSSelect extends AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean result = true;

            final String METHOD_NAME = "getUserPortals";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

            userPortals.clear();
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            envelope.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(MainActivity.URL);

            try {
                transporte.call(SOAP_ACTION, envelope);

                Vector<SoapObject> response = (Vector<SoapObject>) envelope.getResponse();

                if (response != null) {

                    for (SoapObject objSoap : response) {
                        UserPortal userPortal = new UserPortal();

                        userPortal.setProperty(0, Integer.parseInt(objSoap
                                .getProperty("id").toString()));

                        userPortal.setProperty(1, objSoap.getProperty("portal")
                                .toString());

                        userPortal.setProperty(2, objSoap.getProperty("userPortall")
                                .toString());

                        userPortal.setProperty(3, objSoap.getProperty("createDate")
                                .toString());

                        userPortal.setProperty(4, objSoap.getProperty("autorised")
                                .toString());

                        userPortal.setProperty(5, objSoap.getProperty("isdeleted")
                                .toString());

                        userPortal.setProperty(6, objSoap.getProperty("refreshRoles")
                                .toString());



                        userPortals.add(userPortal);
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

                //Enviará aquí cuando exista un solo registro en la base.
                try {
                    SoapObject objSoap = (SoapObject) envelope.getResponse();
                    UserPortal userPortal= new UserPortal();

                    userPortal.setProperty(0, Integer.parseInt(objSoap
                            .getProperty("id").toString()));

                    userPortal.setProperty(1, objSoap.getProperty("portal")
                            .toString());

                    userPortal.setProperty(2, objSoap.getProperty("userPortall")
                            .toString());

                    userPortal.setProperty(3, objSoap.getProperty("createDate")
                            .toString());

                    userPortal.setProperty(4, objSoap.getProperty("autorised")
                            .toString());

                    userPortal.setProperty(5, objSoap.getProperty("isdeleted")
                            .toString());

                    userPortal.setProperty(6, objSoap.getProperty("refreshRoles")
                            .toString());



                    userPortals.add(userPortal);
                } catch (SoapFault e1) {
                    Log.e("Error SoapFault", e.toString());
                    result = false;
                }
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                final String[] datos = new String[userPortals.size()];
                for (int i = 0; i < userPortals.size(); i++) {
                    datos[i] = userPortals.get(i).getProperty(0) + " - "
                    + userPortals.get(i).getProperty(1) + " - "
                    + userPortals.get(i).getProperty(2) + " - "
                    + userPortals.get(i).getProperty(3) + " - "
                    + userPortals.get(i).getProperty(4) + " - "
                    + userPortals.get(i).getProperty(5) + " - "

                            + userPortals.get(i).getProperty(1);

                }
//////////////////////////////////este layout
                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                        ListUserPortal.this,
                        android.R.layout.simple_list_item_1, datos);
                setListAdapter(adaptador);
            } else {
                Toast.makeText(getApplicationContext(), "No se encontraron datos.",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }//

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(getListView().getAdapter().getItem(info.position)
                .toString());
        idSelected = (Integer) userPortals.get(info.position).getProperty(0);
        selectedPosition = info.position;

        inflater.inflate(R.menu.menu_contextual, menu);

    }//
    private class TaskWSDelete extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = true;

            final String METHOD_NAME = "removeUserPortal";
            final String SOAP_ACTION = NAMESPACE + "/" + METHOD_NAME;

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("id", idSelected);

            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(MainActivity.URL);
            try {
                transporte.call(SOAP_ACTION, envelope);
                SoapPrimitive resultado_xml = (SoapPrimitive) envelope
                        .getResponse();
                String res = resultado_xml.toString();

                if (!res.equals("0")){
                    result = true;}

            } catch (Exception e) {
                Log.e("Error", e.toString());
                result = false;
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                Toast.makeText(getApplicationContext(),
                        "Eliminado", Toast.LENGTH_SHORT).show();
                TaskWSSelect consulta = new TaskWSSelect();
                consulta.execute();
            } else {
                Toast.makeText(getApplicationContext(), "Error al eliminar",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }

}

