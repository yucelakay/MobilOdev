package com.example.animasyon;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

ListView list;
String url;
ImageView ımge;
List<filminfo> filminfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ımge=findViewById(R.id.filmresmi);
        list=findViewById(R.id.lstw);
        filminfos=new ArrayList<filminfo>();
        url="https://raw.githubusercontent.com/HerocypheR/andoridClass/main/filmJSON";
        getvolley(new volleycallback() {
            @Override
            public void bitince() {
                filmadapter filmadapter = new filmadapter(filminfos,MainActivity2.this);
                list.setAdapter(filmadapter);
                
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent git=new Intent(MainActivity2.this,fragman.class);
                git.putExtra("link",filminfos.get(position).filmurl);
                startActivity(git);
            }
        });
    }
    public interface volleycallback{
        void bitince();
    }
    public void getvolley(volleycallback callback){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String _fadı = jsonObject.getString("filmAdi");
                        String _fyılı = jsonObject.getString("filmYil");
                        String _fthumb= jsonObject.getString("filmThumb");
                        filminfos.add(new filminfo(_fadı,_fyılı,_fthumb));

                    }
                    callback.bitince();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

        });
        requestQueue.add(jor);
    }
}
