package cs2b01.utec.chat_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onBtnLoginClicked(View view){


        EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
        EditText txtPassword = (EditText)findViewById(R.id.lblPassword);//revisar

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        Toast.makeText(this, username+"--"+password, Toast.LENGTH_LONG).show();

    }

}
