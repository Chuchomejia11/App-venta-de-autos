// AutoListAdapter.java

package com.example.appventadeauotos;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.appventadeautos.R;

public class AutoListAdapter extends CursorAdapter {

    public AutoListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_auto, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView modeloTextView = view.findViewById(R.id.modeloTextView);
        TextView precioTextView = view.findViewById(R.id.precioTextView);

        String modelo = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        double precio = cursor.getDouble(cursor.getColumnIndexOrThrow("precio"));

        modeloTextView.setText(modelo);
        precioTextView.setText(String.format("$%.2f", precio));
    }
}
