package pe.cibertec.demo03;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pe.cibertec.demo03.entities.Persona;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private TextInputLayout tilSecondName, tilSecondLast, tilSecondAge, tilSecondDoc, tilSecondPhone;
    private Button btSecondSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        tilSecondName = (TextInputLayout) findViewById(R.id.tilSecondName);
        tilSecondLast = (TextInputLayout) findViewById(R.id.tilSecondLast);
        tilSecondAge = (TextInputLayout) findViewById(R.id.tilSecondAge);
        tilSecondDoc = (TextInputLayout) findViewById(R.id.tilSecondDoc);
        tilSecondPhone = (TextInputLayout) findViewById(R.id.tilSecondPhone);
        btSecondSave = (Button) findViewById(R.id.btSecondSave);

        btSecondSave.setOnClickListener(btSecondSaveOnClickListener);
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
                Persona persona = new Persona();
                persona.setName(tilSecondName.getEditText().getText().toString().trim());
                persona.setLast(tilSecondLast.getEditText().getText().toString().trim());
                persona.setDoc(tilSecondDoc.getEditText().getText().toString().trim());
                persona.setPhone(tilSecondPhone.getEditText().getText().toString().trim());
                persona.setAge(Integer.parseInt(tilSecondAge.getEditText().getText().toString().trim()));

                Intent intent = new Intent();
                intent.putExtra("arg_persona", persona);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    };
}
