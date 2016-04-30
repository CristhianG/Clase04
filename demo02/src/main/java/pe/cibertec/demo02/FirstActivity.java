package pe.cibertec.demo02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import pe.cibertec.demo02.entities.Persona;
import pe.cibertec.demo02.adapter.listview.LVFirstAdapter;

public class FirstActivity extends AppCompatActivity {

    private ListView lvFirstPerson;
    private LVFirstAdapter mLVFirstAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        lvFirstPerson = (ListView) findViewById(R.id.lvFirstPerson);

        mLVFirstAdapter = new LVFirstAdapter(FirstActivity.this);
        mLVFirstAdapter.add(new Persona(1, "Luis Alonso", "Rios", "963963963", "12345678", 27));
        mLVFirstAdapter.add(new Persona(2, "Alonso", "Aguilar", "951951951", "23456789", 26));
        mLVFirstAdapter.add(new Persona(3, "Franco", "Castellano", "998998998", "34567890", 22));
        mLVFirstAdapter.add(new Persona(4, "Luis Miguel", "Burgos", "987987987", "45678901", 27));
        mLVFirstAdapter.add(new Persona(6, "Adrian", "Rodriguez", "942942942", "56789012", 25));
        mLVFirstAdapter.add(new Persona(7, "Francisco", "Caceres", "942942942", "56789012", 25));

        lvFirstPerson.setAdapter(mLVFirstAdapter);
    }
}
