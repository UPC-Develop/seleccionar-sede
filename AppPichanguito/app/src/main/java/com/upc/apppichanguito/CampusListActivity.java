package com.upc.apppichanguito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CampusListActivity extends AppCompatActivity {


    List<Campus> campusList = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_list);
        listCampusResponse();

    }


    private void  listCampusResponse(){
        String apiUrl = CommonHelper.getMetaData(this, "api_url");
        String apiKey = CommonHelper.getMetaData(this, "api_key");
        String url    =  apiUrl +"?auth="+ apiKey+ "&print=pretty";

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    List<String> items = new ArrayList<>();
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        items.add(object.getString("district"));
                        Campus  campus = new Campus();
                        campus.setCampusid(object.getString("campusid"));
                        campus.setName(object.getString("name"));
                        campus.setDistrict(object.getString("district"));
                        campus.setDirection(object.getString("direction"));
                        campus.setCoordx(object.getString("coordx"));
                        campus.setCoordy(object.getString("coordy"));
                        campusList.add(campus);
                 }

                    ListView lstCampus = findViewById(R.id.lista);
                    ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                            CampusListActivity.this,
                            android.R.layout.simple_list_item_1,
                            items);
                    lstCampus.setAdapter(adaptador);
                    lstCampus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Campus objeto =campusList.get(position);

                            Intent i = new Intent(getBaseContext(), VerUbicacionActivity.class);
                            i.putExtra("campusid", objeto.getCampusid());
                            i.putExtra("district", objeto.getDistrict());
                            i.putExtra("coordx", objeto.getCoordx());
                            i.putExtra("coordy", objeto.getCoordy());

                            startActivity(i);
                        }
                    });
                } catch (JSONException e) {
                    Log.i("======>er excep", e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>error resp", error.toString());
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


}
