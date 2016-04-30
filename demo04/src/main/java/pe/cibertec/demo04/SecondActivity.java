package pe.cibertec.demo04;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pe.cibertec.demo04.entities.Persona;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private TextInputLayout tilSecondName, tilSecondLast, tilSecondAge, tilSecondDoc, tilSecondPhone;
    private Button btSecondSave;
    private Persona mPersona = null;
    private int personaId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        if (getIntent().getExtras().containsKey("arg_persona"))
            mPersona = getIntent().getParcelableExtra("arg_persona");

        if (getIntent().getExtras().containsKey("arg_list_size"))
            personaId = getIntent().getIntExtra("arg_list_size", 0);

        tilSecondName = (TextInputLayout) findViewById(R.id.tilSecondName);
        tilSecondLast = (TextInputLayout) findViewById(R.id.tilSecondLast);
        tilSecondAge = (TextInputLayout) findViewById(R.id.tilSecondAge);
        tilSecondDoc = (TextInputLayout) findViewById(R.id.tilSecondDoc);
        tilSecondPhone = (TextInputLayout) findViewById(R.id.tilSecondPhone);
        btSecondSave = (Button) findViewById(R.id.btSecondSave);

        btSecondSave.setOnClickListener(btSecondSaveOnClickListener);

        if (mPersona != null)
            setData();
    }

    private void setData() {
        tilSecondName.getEditText().setText(mPersona.getName());
        tilSecondLast.getEditText().setText(mPersona.getLast());
        tilSecondPhone.getEditText().setText(mPersona.getPhone());
        tilSecondDoc.getEditText().setText(mPersona.getDoc());
        tilSecondAge.getEditText().setText(String.valueOf(mPersona.getAge()));
    }

    View.OnClickListener btSecondSaveOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isOK = true;

            tilSecondName.setError(null);
            tilSecondLast.setError(null);
            tilSecondAge.setError(null);
            tilSecondDoc.setError(null);
            tilSecondPhone.setError(null);
            tilSecondName.setErrorEnabled(false);
            tilSecondLast.setErrorEnabled(false);
            tilSecondAge.setErrorEnabled(false);
            tilSecondDoc.setErrorEnabled(false);
            tilSecondPhone.setErrorEnabled(false);

            if (tilSecondName.getEditText().getText().toString().trim().isEmpty()) {
                tilSecondName.setError("Ingrese su nombre");
                tilSecondName.setErrorEnabled(true);
                isOK = false;
            }

            if (tilSecondLast.getEditText().getText().toString().trim().isEmpty()) {
                tilSecondLast.setError("Ingrese su apellido");
                tilSecondLast.setErrorEnabled(true);
                isOK = false;
            }
            if (tilSecondAge.getEditText().getText().toString().trim().isEmpty()) {
                tilSecondAge.setError("Ingrese su edad");
                tilSecondAge.setErrorEnabled(true);
                isOK = false;
            }
            if (tilSecondDoc.getEditText().getText().toString().trim().isEmpty()) {
                tilSecondDoc.setError("Ingrese su documento");
                tilSecondDoc.setErrorEnabled(true);
                isOK = false;
            } else {
                if (tilSecondDoc.getEditText().getText().toString().trim().length() < 8) {
                    tilSecondDoc.setError("El documento es de 8 caracteres");
                    tilSecondDoc.setErrorEnabled(true);
                    isOK = false;
                }
            }

            if (tilSecondPhone.getEditText().getText().toString().trim().isEmpty()) {
                tilSecondPhone.setError("Ingrese su teléfono");
                tilSecondPhone.setErrorEnabled(true);
                isOK = false;
            } else {
                if (tilSecondPhone.getEditText().getText().toString().trim().length() != 9 && tilSecondPhone.getEditText().getText().toString().trim().length() != 7) {
                    tilSecondPhone.setError("Su número debe ser de 7 o 9 digitos");
                    tilSecondPhone.setErrorEnabled(true);
                    isOK = false;
                }
            }

            if (isOK) {
                if (mPersona == null) {
                    mPersona = new Persona();
                    mPersona.setId(personaId);
                }

                mPersona.setName(tilSecondName.getEditText().getText().toString().trim());
                mPersona.setLast(tilSecondLast.getEditText().getText().toString().trim());
                mPersona.setDoc(tilSecondDoc.getEditText().getText().toString().trim());
                mPersona.setPhone(tilSecondPhone.getEditText().getText().toString().trim());
                mPersona.setAge(Integer.parseInt(tilSecondAge.getEditText().getText().toString().trim()));

                Intent intent = new Intent();
                intent.putExtra("arg_persona", mPersona);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    };
}
