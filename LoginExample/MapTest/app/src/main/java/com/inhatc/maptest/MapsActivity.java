package com.inhatc.maptest;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    List<Toilet> toiletList;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initLoadDB();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Location location = new Location("");
        Geocoder geocoder = new Geocoder(this);
        List<Address> address;
        try {
            for (int i = 0; i < toiletList.size(); i++) {

                double latitude = toiletList.get(i).getLatitude();
                double longitude = toiletList.get(i).getLongitude();

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions
                        .position(new LatLng(latitude, longitude))
                        .title(toiletList.get(i).getName());
                mMap.addMarker(markerOptions);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude)));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    private void initLoadDB() {
        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        toiletList = mDbHelper.getTableData();

        // db 닫기
        mDbHelper.close();
    }
}