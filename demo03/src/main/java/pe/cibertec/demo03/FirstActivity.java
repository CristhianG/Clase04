package pe.cibertec.demo03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import pe.cibertec.demo03.adapter.listview.LVFirstAdapter;
import pe.cibertec.demo03.entities.Persona;

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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            mLVFirstAdapter.add(data.<Persona>getParcelableExtra("arg_persona"));
        }
    }

    View.OnClickListener btFirstAddOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivityForResult(intent, 99);
        }
    };
}
