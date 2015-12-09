package com.frameworksystem.starwars.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.api.PlacesApi;
import com.frameworksystem.starwars.model.Place;
import com.frameworksystem.starwars.ui.activity.PlaceActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;

/**
 * Created by felipe.arimateia on 12/4/2015.
 */
public class PlacesFragment extends Fragment {

    private GoogleMap googleMap;
    private HashMap<Marker, Place> markerPlaces = new HashMap<>();

    public static Fragment newInstance() {
        PlacesFragment fragment = new PlacesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.google_maps);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                PlacesFragment.this.googleMap = googleMap;
                setup();
                getPlaces();
            }
        });
    }

    private void setup() {

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnInfoWindowClickListener(onInfoWindowClickListener);

        UiSettings settings = googleMap.getUiSettings();
        settings.setMyLocationButtonEnabled(true);
        settings.setZoomControlsEnabled(true);
        settings.setCompassEnabled(true);
    }

    private void getPlaces() {
        PlacesApi api = new PlacesApi(getActivity());
        api.locations(new PlacesApi.OnPlacesListener() {
            @Override
            public void onPlaces(final List<Place> places, int errorCode) {

               getActivity().runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       if (places != null) {
                           addMarkes(places);
                       }
                   }
               });
            }
        });
    }

    private void addMarkes(List<Place> places) {

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (Place place: places) {

            LatLng position = new LatLng(place.getLatitude(), place.getLongitude());
            builder.include(position);

            MarkerOptions markerOptions = new MarkerOptions()
                    .title(place.getTitle())
                    .snippet(place.getDescription())
                    .position(position);

            Marker marker = googleMap.addMarker(markerOptions);
            markerPlaces.put(marker,place);
        }

        LatLngBounds bounds = builder.build();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 50);
        googleMap.moveCamera(cameraUpdate);
    }

    private GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            Place place = markerPlaces.get(marker);

            Intent intent = new Intent(getActivity(), PlaceActivity.class);
            intent.putExtra("place",place);
            startActivity(intent);

        }
    };
}
