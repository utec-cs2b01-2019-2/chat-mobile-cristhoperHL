package cs2b01.utec.chat_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void showMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void onBtnLoginClicked(View view){

        //1.
        EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
        EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();


        //2.
        Map<String,String> message =new HashMap<>();
        message.put("username",username);
        message.put("password",password);

        //3.
        JSONObject jsonMessage=new JSONObject(message);
        Toast.makeText(this, jsonMessage.toString(), Toast.LENGTH_LONG).show();

        //4.
            //4.1
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                "http://10.0.2.2:8000/authenticate",
                jsonMessage,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //TODO que hacer cuando el server responda
                        showMessage("autherized!");
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        //Todo que hacer cuando ocurra un error
                        showMessage("Unauthorized!!!");
                    }
                }

        );

        //5.Send Request to the Server
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }

}
