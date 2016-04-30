package pe.cibertec.demo04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import pe.cibertec.demo04.adapter.listview.LVFirstAdapter;
import pe.cibertec.demo04.entities.Persona;

public class FirstActivity extends AppCompatActivity {

    private ListView lvFirstPerson;
    private LVFirstAdapter mLVFirstAdapter;
    private Button btFirstAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        lvFirstPerson = (ListView) findViewById(R.id.lvFirstPerson);
        btFirstAdd = (Button) findViewById(R.id.btFirstAdd);

        mLVFirstAdapter = new LVFirstAdapter(FirstActivity.this);

        lvFirstPerson.setAdapter(mLVFirstAdapter);

        btFirstAdd.setOnClickListener(btFirstAddOnClickListener);
        lvFirstPerson.setOnItemClickListener(lvFirstPersonOnItemClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 99)
                mLVFirstAdapter.add(data.<Persona>getParcelableExtra("arg_persona"));
            else {
                Persona persona = data.getParcelableExtra("arg_persona");
                for (int i = 0; i < mLVFirstAdapter.getCount(); i++) {
                    Persona personaOld = mLVFirstAdapter.getItem(i);
                    if (persona.getId() == personaOld.getId()) {
                        personaOld.setName(persona.getName());
                        personaOld.setLast(persona.getLast());
                        personaOld.setAge(persona.getAge());
                        personaOld.setDoc(persona.getDoc());
                        personaOld.setPhone(persona.getPhone());

                        mLVFirstAdapter.notifyDataSetChanged();
                        break;
                    }
                }
            }
        }
    }

    View.OnClickListener btFirstAddOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("arg_list_size", mLVFirstAdapter.getCount() + 1);
            startActivityForResult(intent, 99);
        }
    };

    AdapterView.OnItemClickListener lvFirstPersonOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Persona persona = (Persona) parent.getItemAtPosition(position);
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("arg_persona", persona);
            startActivityForResult(intent, 98);
        }
    };
}
