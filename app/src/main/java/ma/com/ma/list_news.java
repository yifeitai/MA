package ma.com.ma;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;


public class list_news extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        new HttpREST().execute();
    }

    private class HttpREST extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {

            Log.i("===>", "Dentro de doInBackground()");
            try {

                final ListView lstProductos = (ListView)findViewById(R.id.lista);

                HttpRequest httpRequest = HttpRequest.get("http://steemen.com/rest_tienda/index.php/news");

                String respuesta = httpRequest.body().toString();

                Log.i("===>", respuesta);

                Gson gson = new Gson();
                Type stringStringMap = new TypeToken<ArrayList<Map<String, Object>>>() {
                }.getType();
                final ArrayList<Map<String, Object>> retorno = gson.fromJson(respuesta, stringStringMap);

                final String[] matriz = new String[retorno.size()];
                int i = 0;

                for (Map<String, Object> x : retorno) {
                    matriz[i++] = (String) (x.get("title") + " \n " + x.get("content"));
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                                list_news.this,
                                android.R.layout.simple_list_item_1,
                                matriz);
                        lstProductos.setAdapter(adaptador);
                    }
                });

            } catch (Exception ex) {
                Log.e("===>", "Error: " + ex);
            }
            return null;
        }
    }


}
