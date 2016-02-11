package es.fabricaweb.www.miscitas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private RecyclerView miContenedor;
    private RecyclerView.Adapter miAdaptador;
    private RecyclerView.LayoutManager miManejador;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);

        String url = "http://www.fabricaweb.es/ws/quoteGetUser.php";

        HashMap<String, String> params = new HashMap<>();
        params.put("id_usuario", "1");

        /*RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);



        customRequest jsObjRequest = new customRequest(Request.Method.POST,
                url, params, this.createRequestSuccessListener(), this.createRequestErrorListener());

        requestQueue.add(jsObjRequest);
        */



        final List citas = new ArrayList();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject mCita = (JSONObject) response.get(i);

                                String mGestor = mCita.getString("nombre_comercial");
                                String mAgenda = mCita.getString("nombre");
                                String mFecha = mCita.getString("cita_fecha");
                                String mHora = mCita.getString("cita_hora");
                                String mNota = mCita.getString("nota");

                                Toast.makeText(MainActivity.this,mFecha,Toast.LENGTH_SHORT).show();

                                //citas.add(new cita(mNota, mHora, mFecha, mAgenda, mGestor));

                            }

                        } catch (JSONException e){

                        }

                    }
                }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }


        });


        miContenedor = (RecyclerView) findViewById(R.id.contenedorTarjetas);
        miContenedor.setHasFixedSize(true);

        miManejador = new LinearLayoutManager(this);
        miContenedor.setLayoutManager(miManejador);

        miAdaptador = new citaAdaptador(citas);
        miContenedor.setAdapter(miAdaptador);



    }
}
