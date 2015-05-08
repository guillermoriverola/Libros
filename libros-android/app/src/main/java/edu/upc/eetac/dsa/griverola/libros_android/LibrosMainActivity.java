package edu.upc.eetac.dsa.griverola.libros_android;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

import edu.upc.eetac.dsa.griverola.libros_android.api.AppException;
import edu.upc.eetac.dsa.griverola.libros_android.api.Libros;
import edu.upc.eetac.dsa.griverola.libros_android.api.LibrosAPI;
import edu.upc.eetac.dsa.griverola.libros_android.api.LibrosCollection;

public class LibrosMainActivity extends ListActivity {
    private class FetchStingsTask extends
            AsyncTask<Void, Void, LibrosCollection> {
        private ProgressDialog pd;

        @Override
        protected LibrosCollection doInBackground(Void... params) {
            LibrosCollection libros = null;
            try {
                libros = LibrosAPI.getInstance(LibrosMainActivity.this).getLibros();
            } catch (AppException e) {
                e.printStackTrace();
            }
            return libros;
        }

        @Override
        protected void onPostExecute(LibrosCollection result) {
            addLibros(result);
            Log.d(TAG, result.toString());
            if (pd != null) {
                pd.dismiss();
            }
        }


        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(LibrosMainActivity.this);
            pd.setTitle("Searching...");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Libros libros = librosList.get(position);
        Log.d(TAG, libros.getLinks().get("self").getTarget());

        Intent intent = new Intent(this, LibrosDetailActivity.class);
        intent.putExtra("url", libros.getLinks().get("self").getTarget());
        startActivity(intent);
    }


    private final static String TAG = LibrosMainActivity.class.toString();

    private LibrosAdapter adapter;
    private ArrayList<Libros> librosList;
    private void addLibros(LibrosCollection libros){
        Log.d(TAG, "hola2");
        librosList.addAll(libros.getLibros());
        adapter.notifyDataSetChanged();
    }


    /** Called when the activity is first created. */
    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_main);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_main);

        librosList = new ArrayList<Libros>();
        adapter = new LibrosAdapter(this, librosList);
        setListAdapter(adapter);

        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("alicia", "alicia"
                        .toCharArray());
            }
        });
        (new FetchStingsTask()).execute();
    }



}
