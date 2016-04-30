package pe.cibertec.demo03.adapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pe.cibertec.demo03.R;
import pe.cibertec.demo03.entities.Persona;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public class LVFirstAdapter extends ArrayAdapter<Persona> {
    public LVFirstAdapter(Context context) {
        super(context, 0, new ArrayList<Persona>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.first_item, parent, false);

        TextView tvFirstItemName = (TextView) view.findViewById(R.id.tvFirstItemName);
        TextView tvFirstItemLast = (TextView) view.findViewById(R.id.tvFirstItemLast);
        TextView tvFirstItemAge = (TextView) view.findViewById(R.id.tvFirstItemAge);
        TextView tvFirstItemDoc = (TextView) view.findViewById(R.id.tvFirstItemDoc);
        TextView tvFirstItemPhone = (TextView) view.findViewById(R.id.tvFirstItemPhone);

        Persona persona = getItem(position);
        tvFirstItemName.setText(persona.getName());
        tvFirstItemLast.setText(persona.getLast());
        tvFirstItemAge.setText(String.valueOf(persona.getAge()));
        tvFirstItemDoc.setText(persona.getDoc());
        tvFirstItemPhone.setText(persona.getPhone());

        return view;
    }
}
