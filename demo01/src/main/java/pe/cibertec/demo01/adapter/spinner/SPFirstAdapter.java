package pe.cibertec.demo01.adapter.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.cibertec.demo01.R;
import pe.cibertec.demo01.entities.Persona;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public class SPFirstAdapter extends ArrayAdapter<Persona> {
    public SPFirstAdapter(Context context) {
        super(context, 0, new ArrayList<Persona>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.first_item, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.tvFirstItemName);

        Persona persona = getItem(position);
        textView.setText(persona.getName() + " " + persona.getLast());

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.first_item, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.tvFirstItemName);

        Persona persona = getItem(position);
        textView.setText(persona.getName() + " " + persona.getLast());

        return view;
    }
}
