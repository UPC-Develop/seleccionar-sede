package com.upc.apppichanguito;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.util.Log;

public class VerUbicacionActivity extends AppCompatActivity implements OnMapReadyCallback {
    String  campusid ;
    String  coordx, coordy;
    String district;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ubicacion);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null){
            campusid  = parametros.getString("campusid");
            coordx  = parametros.getString("coordx");
            coordy  = parametros.getString("coordy");
            district  = parametros.getString("district");
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        double x = Double.parseDouble(coordx);
        double y = Double.parseDouble(coordy);

        LatLng campus = new LatLng(x,y);
        googleMap.addMarker(new MarkerOptions()
                .position(campus)
                .title(district));

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(campus));
    }
}