package omy.boston.optionpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSaveNick;
    Button btnSettings;
    EditText edNick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dohvatimWidgete();
        postavimLisinere();
    }// onCreate

    private void dohvatimWidgete(){
        btnSaveNick = (Button) findViewById(R.id.btnNick);
        btnSettings = (Button) findViewById(R.id.btnSettings);
        edNick = (EditText) findViewById(R.id.editText);
    }

    private void postavimLisinere(){

        btnSaveNick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setPreference();
            }
        });


        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CustomPreferenceActivity.class);
                startActivity(i);
            }
        });
    }

    private void  setPreference(){
        String nickname = edNick.getText().toString();

        if (nickname.trim().length()==0){
            Toast zdravica = Toast.makeText(this, "Ajd unesi nickname!", Toast.LENGTH_LONG);
            zdravica.show();
            return;
        }

        nickname = nickname.trim();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nickname", nickname);
        editor.commit();

        Toast.makeText(this, "Nick je unesen", Toast.LENGTH_LONG).show();

    }

    private void getPreference(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        if(sp.contains("nickname")){
            edNick.setText(sp.getString("nickname", null));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreference();
    }
}
