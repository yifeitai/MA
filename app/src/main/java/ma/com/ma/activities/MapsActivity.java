package ma.com.ma.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tecsup.com.municipalalerts.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        // Add a marker in Sydney and move the camera
        LatLng PoliceStation = new LatLng(-12.0464372,-76.9725975);
        mMap.addMarker(new MarkerOptions().position(PoliceStation).title("Marker of Police Station").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).snippet("Bolognesi 282, Santa Anita 15008"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PoliceStation));

        LatLng Hospital = new LatLng(-12.0475008,-76.9473745);
        mMap.addMarker(new MarkerOptions().position(Hospital).title("Marker of Hospital").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("Carr. Central, Distrito de Lima 15011"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Hospital));

        LatLng FireDepartment = new LatLng(-12.0495149,-77.0079198);
        mMap.addMarker(new MarkerOptions().position(FireDepartment).title("Marker of FireDepartment ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).snippet("Cotrina 203, El Agustino 15006"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(FireDepartment));

        LatLng Tecsup = new LatLng(-12.0441629,-76.9550872);
        mMap.addMarker(new MarkerOptions().position(Tecsup).title("Marker of Tecsup").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).snippet("Santa Anita, Avenida Cascanueces 2221, Lima 15011"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tecsup));

    }

}
