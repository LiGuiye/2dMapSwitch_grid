package com.demo.liguiye.mobilegis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.view.LatitudeLongitudeGrid;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.portal.Portal;
import com.esri.arcgisruntime.portal.PortalItem;

public class EsriMap extends AppCompatActivity {
    private MapView mMapView;
    private ArcGISMap mMap;
    private Portal mPortal;
    private PortalItem mPortalItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esri_map);
        mMapView = findViewById(R.id.mapView);


        //create a grid for showing Latitude and Longitude (Meridians and Parallels)
        LatitudeLongitudeGrid grid = new LatitudeLongitudeGrid();
        //display the grid on the map view
        mMapView.setGrid(grid);

        // get the portal url for ArcGIS Online
        mPortal = new Portal(getResources().getString(R.string.portal_url));
        // get the pre-defined portal id and portal url
        mPortalItem = new PortalItem(mPortal, getResources().getString(R.string.webmap_houses_with_mortgages_id));
        // create a map from a PortalItem
        mMap = new ArcGISMap(mPortalItem);
        // set the map to be displayed in this view
        mMapView.setMap(mMap);


    }

    public void button1onclick(View v){
        // get the pre-defined portal id and portal url
        mPortalItem = new PortalItem(mPortal, getResources().getString(R.string.webmap_houses_with_mortgages_id));
        // create a map from a PortalItem
        mMap = new ArcGISMap(mPortalItem);
        // set the map to be displayed in this view
        mMapView.setMap(mMap);
    }

    public void button2onclick(View v){

        mPortalItem = new PortalItem(mPortal, getResources().getString(R.string.webmap_usa_tapestry_segmentation_id));
        // create a map from a PortalItem
        mMap = new ArcGISMap(mPortalItem);
        // set the map to be displayed in this view
        mMapView.setMap(mMap);
    }

    @Override
    protected void onPause(){
        mMapView.pause();
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mMapView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.dispose();
    }



}
