package pe.cibertec.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

import pe.cibertec.demo01.adapter.spinner.SPFirstAdapter;
import pe.cibertec.demo01.entities.Persona;

public class FirstActivity extends AppCompatActivity {

    private Spinner spFirstPerson;
    private SPFirstAdapter mSPFirstAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        spFirstPerson = (Spinner) findViewById(R.id.spFirstPerson);
        mSPFirstAdapter = new SPFirstAdapter(FirstActivity.this);
        mSPFirstAdapter.add(new Persona(1, "Luis Alonso", "Rios", "963963963", "12345678", 27));

        spFirstPerson.setAdapter(mSPFirstAdapter);
    }
}
