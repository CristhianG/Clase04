package pe.cibertec.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import pe.cibertec.demo01.adapter.spinner.SPFirstAdapter;
import pe.cibertec.demo01.entities.Persona;

public class FirstActivity extends AppCompatActivity {

    private Spinner spFirstPerson;
    private SPFirstAdapter mSPFirstAdapter;
    private TextView tvFirstName, tvFirstLast, tvFirstPhone, tvFirstAge, tvFirstDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        spFirstPerson = (Spinner) findViewById(R.id.spFirstPerson);
        tvFirstName = (TextView) findViewById(R.id.tvFirstName);
        tvFirstLast = (TextView) findViewById(R.id.tvFirstLast);
        tvFirstPhone = (TextView) findViewById(R.id.tvFirstPhone);
        tvFirstAge = (TextView) findViewById(R.id.tvFirstAge);
        tvFirstDoc = (TextView) findViewById(R.id.tvFirstDoc);

        mSPFirstAdapter = new SPFirstAdapter(FirstActivity.this);
        mSPFirstAdapter.add(new Persona(1, "Luis Alonso", "Rios", "963963963", "12345678", 27));
        mSPFirstAdapter.add(new Persona(2, "Alonso", "Aguilar", "951951951", "23456789", 26));
        mSPFirstAdapter.add(new Persona(3, "Franco", "Castellano", "998998998", "34567890", 22));
        mSPFirstAdapter.add(new Persona(4, "Luis Miguel", "Burgos", "987987987", "45678901", 27));
        mSPFirstAdapter.add(new Persona(6, "Adrian", "Rodriguez", "942942942", "56789012", 25));

        spFirstPerson.setAdapter(mSPFirstAdapter);
        spFirstPerson.setOnItemSelectedListener(spFirstPersonOnItemSelectedListener);
    }

    AdapterView.OnItemSelectedListener spFirstPersonOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Persona persona = (Persona) parent.getSelectedItem();
            tvFirstName.setText(persona.getName());
            tvFirstLast.setText(persona.getLast());
            tvFirstPhone.setText(persona.getPhone());
            tvFirstAge.setText(String.valueOf(persona.getAge()));
            tvFirstDoc.setText(persona.getDoc());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
