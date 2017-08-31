package com.applicaion.pharmacie.testv4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public static final String APPLICATION_ID = "E9948615-A739-DB28-FFE2-0EB029885900";
    public static final String API_KEY = "D3E0D42D-9BE8-E55D-FFC9-CEF8E8E32300";

    ArrayList<Personne> listPersonne;
    ListView lvPersonne;
    ArrayAdapterPersonne adapterPersonne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Backendless.initApp( this,
                APPLICATION_ID,
                API_KEY);

        lvPersonne = (ListView) findViewById(R.id.lvPersonne);
        listPersonne = new ArrayList<>();
        adapterPersonne = new ArrayAdapterPersonne(this, listPersonne);
        lvPersonne.setAdapter(adapterPersonne);

        IDataStore<Map> personneStorage = Backendless.Data.of( "Personne" );
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        personneStorage.find(new AsyncCallback<List<Map>>() {

            @Override
            public void handleResponse(List<Map> response) {
                adapterPersonne.addAll(Personne.fromListMap(response));
                Log.d("DEBUG", listPersonne.toString());
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

    }
}
