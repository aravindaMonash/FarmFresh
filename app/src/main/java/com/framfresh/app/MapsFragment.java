package com.framfresh.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MapsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapsFragment newInstance(String param1, String param2) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_maps, container, false);

        // Initialize map fragment
        SupportMapFragment supportMapFragment=(SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);

        // Async map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // When map is loaded
                googleMap.clear();

//                LatLng latLng1 = new LatLng(-37.825016,145.0119305);
//                MarkerOptions markerOptions1=new MarkerOptions();
//                markerOptions1.position(latLng1);
//                markerOptions1.title(latLng1.latitude+" : "+latLng1.longitude);
//                googleMap.addMarker(markerOptions1);

                addmarker(-37.825016,145.0119305,googleMap);
                addmarker(-37.804481,144.921904,googleMap);
                addmarker(-37.805768,144.966843,googleMap);
                addmarker(-37.8115401,144.9530611,googleMap);
                addmarker(-37.8261241,144.979587,googleMap);
                addmarker(-37.8132847,144.9654165,googleMap);
                addmarker(-37.8010658,145.0049799,googleMap);
                addmarker(-37.8206455,144.9487556,googleMap);
                addmarker(-37.8185892,144.9532972,googleMap);
                addmarker(-37.8090287,144.9426335,googleMap);

                //addmarker(-37.8037783,145.0052396,googleMap);
//                addmarker(-37.8236457,144.9750312,googleMap);
//                addmarker(37.8036257,144.951795,googleMap);
//                addmarker(-37.80626,144.9593691,googleMap);

                addmarkerLast(-37.824845,144.9576466,googleMap);



                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        // When clicked on map
                        // Initialize marker options
                        MarkerOptions markerOptions=new MarkerOptions();
                        // Set position of marker
                        markerOptions.position(latLng);
                        // Set title of marker
                        markerOptions.title(latLng.latitude+" : "+latLng.longitude);
                        // Remove all marker
                        googleMap.clear();
                        // Animating to zoom the marker
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
                        // Add marker on map
                        googleMap.addMarker(markerOptions);
                    }
                });
            }
        });

        return view;

    }

    public void addmarker(double lat, double lng,GoogleMap googleMap){

        LatLng latLng1 = new LatLng(lat,lng);
        MarkerOptions markerOptions1=new MarkerOptions();
        markerOptions1.position(latLng1);
        markerOptions1.title(latLng1.latitude+" : "+latLng1.longitude);
        googleMap.addMarker(markerOptions1);
    }
    public void addmarkerLast(double lat, double lng,GoogleMap googleMap){

        LatLng latLng1 = new LatLng(lat,lng);
        MarkerOptions markerOptions1=new MarkerOptions();
        markerOptions1.position(latLng1);
        markerOptions1.title(latLng1.latitude+" : "+latLng1.longitude);
        googleMap.addMarker(markerOptions1);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng1,15));

    }
}