package edu.upc.eetac.dsa.griverola.libros_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.upc.eetac.dsa.griverola.libros_android.api.Libros;

/**
 * Created by Miranda on 07/12/2014.
 */

public class LibrosAdapter extends BaseAdapter {
    ArrayList<Libros> data;
    LayoutInflater inflater;

    public LibrosAdapter(Context context, ArrayList<Libros> data) {
        super();
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    private static class ViewHolder {
        TextView tvTitulo;
        TextView tvAutor;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Libros) getItem(position)).getIdlibros();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row_libros, null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitulo = (TextView) convertView
                    .findViewById(R.id.tvTitulo);
            viewHolder.tvAutor = (TextView) convertView
                    .findViewById(R.id.tvAutor);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String titulo = data.get(position).getTitulo();
        String autor = data.get(position).getAutor();
        viewHolder.tvTitulo.setText(titulo);
        viewHolder.tvAutor.setText(autor);
        return convertView;
    }


}
