package com.bhailal.sony.mapmarker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleApiClient mGoogleApiClient;




    private GoogleMap mMap;
    private Marker mMarker1,mMarker2,mMarker3,mMarker4,mMarker5,mMarker6,mMarker7,mMarker8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.setBuildingsEnabled(true);



//        mMap.setOnMarkerClickListener(this);
//        mMap.setOnInfoWindowClickListener(this);


        // Add a marker in Sydney and move the camera

        LatLng taj = new LatLng(27.173891, 78.042068);
        mMarker1 = mMap.addMarker(new MarkerOptions().position(taj).title("Taj Mahal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(taj));





        LatLng pyramid = new LatLng(29.97416777,31.1339477975);
        mMarker2 =mMap.addMarker(new MarkerOptions().position(pyramid).title("Great Pyramid Giza Necropolis (Giza, Egypt)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pyramid));

        LatLng petra = new LatLng(30.3285, 35.4444 );
        mMarker3 =mMap.addMarker(new MarkerOptions().position(petra).title("Petra (Ma’an Governorate, Republic of Jordan)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(petra));

        LatLng Colosseum = new LatLng( 41.890251,12.492373);
        mMarker4 =mMap.addMarker(new MarkerOptions().position(Colosseum).title("Colosseum (Rome, Itlay)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Colosseum));

        LatLng Itza  = new LatLng( 20.6843, -88.5678);
        mMarker5 =mMap.addMarker(new MarkerOptions().position(Itza ).title("Chichen Itza (Yucatan, Mexico)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Itza ));

        LatLng Machu  = new LatLng( -13.1631, -72.5450);
        mMarker6 =mMap.addMarker(new MarkerOptions().position(Machu ).title("Machu Picchu (Cuzco, Peru)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Machu ));

        LatLng GreatWallChina = new LatLng( 40.431908,116.570374);
        mMarker7 =mMap.addMarker(new MarkerOptions().position(GreatWallChina).title("Great Wall of China (China)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GreatWallChina));

        LatLng Christ = new LatLng( 22.9519, 43.2105);
        mMarker8 =mMap.addMarker(new MarkerOptions().position(Christ).title("Christ the Redeemer (Rio de Janeiro, Republic of Brazil)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Christ));


        String placeId = null;
        Places.GeoDataApi.getPlaceById(mGoogleApiClient, placeId)
                .setResultCallback(new ResultCallback<PlaceBuffer>() {
                    @Override
                    public void onResult(PlaceBuffer places) {
                        if (places.getStatus().isSuccess() && places.getCount() > 0) {
                            final Place myPlace = places.get(0);
                            Log.i("tag", "Place found: " + myPlace.getName());
                        } else {
                            Log.e("tag", "Place not found");
                        }
                        places.release();
                    }
                });

    }
//    @Override
//    public void onInfoWindowClick(Marker marker) {
//        String name1 =mMarker1.getTitle();
//        if(name1.equalsIgnoreCase("Taj Mahal")){
//            Toast.makeText(this, "my Tajjjj", Toast.LENGTH_SHORT).show();
//        }
//        String name2 = mMarker2.getTitle();
//        if (name2.equalsIgnoreCase("Great Pyramid Giza Necropolis (Giza, Egypt)")){
//            Toast.makeText(this, "Great Pyramid Giza Necropolis (Giza, Egypt)", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this, " Not", Toast.LENGTH_SHORT).show();
//
//        }
//
//    }
}
