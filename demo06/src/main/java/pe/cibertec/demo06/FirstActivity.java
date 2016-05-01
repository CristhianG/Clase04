package pe.cibertec.demo06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pe.cibertec.demo06.adapter.recyclerview.RVFirstAdapter;
import pe.cibertec.demo06.adapter.recyclerview.listeners.IRVFirstAdapterListener;
import pe.cibertec.demo06.entities.Persona;

public class FirstActivity extends AppCompatActivity implements IRVFirstAdapterListener{

    private RVFirstAdapter mRVFirstAdapter;
    private RecyclerView rvFirstPerson;
    private Button btFirstAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        rvFirstPerson = (RecyclerView) findViewById(R.id.rvFirstPerson);
        btFirstAdd = (Button) findViewById(R.id.btFirstAdd);

        mRVFirstAdapter = new RVFirstAdapter(FirstActivity.this);

        rvFirstPerson.setLayoutManager(new GridLayoutManager(FirstActivity.this,2));
//        rvFirstPerson.setLayoutManager(new LinearLayoutManager(FirstActivity.this));
        rvFirstPerson.setAdapter(mRVFirstAdapter);
        btFirstAdd.setOnClickListener(btFirstAddOnClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 99)
                mRVFirstAdapter.add(data.<Persona>getParcelableExtra("arg_persona"));
//            else {
//                Persona persona = data.getParcelableExtra("arg_persona");
//                for (int i = 0; i < mLVFirstAdapter.getCount(); i++) {
//                    Persona personaOld = mLVFirstAdapter.getItem(i);
//                    if (persona.getId() == personaOld.getId()) {
//                        personaOld.setName(persona.getName());
//                        personaOld.setLast(persona.getLast());
//                        personaOld.setAge(persona.getAge());
//                        personaOld.setDoc(persona.getDoc());
//                        personaOld.setPhone(persona.getPhone());
//
//                        mLVFirstAdapter.notifyDataSetChanged();
//                        break;
//                    }
//                }
//            }
        }
    }

    View.OnClickListener btFirstAddOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("arg_list_size", mRVFirstAdapter.getItemCount() + 1);
            startActivityForResult(intent, 99);
        }
    };

    @Override
    public void onItemClick(Persona persona) {
        Toast.makeText(FirstActivity.this,persona.getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemMapClick(Persona persona) {
        Toast.makeText(FirstActivity.this,persona.getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemPhoneClick(Persona persona) {
        Toast.makeText(FirstActivity.this,persona.getName(),Toast.LENGTH_SHORT).show();
    }
}
