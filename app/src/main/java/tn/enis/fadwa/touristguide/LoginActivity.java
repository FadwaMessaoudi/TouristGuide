package tn.enis.fadwa.touristguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Amine on 21/01/2016.
 */
public class LoginActivity extends Activity {
    EditText t1,t2,ip;
    Button b1,b2;
    View n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        ip=(EditText)findViewById(R.id.ip);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                open(n);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String,Void, String>(){
                    String l=t1.getText().toString();
                    String p=t2.getText().toString();
                    String url="http://"+ip.getText().toString()+"/connect_db.php";
                    @Override
                    protected String doInBackground(String... arg0) {

                        JsonParser jParser=new JsonParser();
                        ArrayList<NameValuePair> param=new ArrayList<NameValuePair>();
                        param.add(new BasicNameValuePair("l",l));
                        param.add(new BasicNameValuePair("p",p));
                        String s = "";
                        try {

                            JSONObject jsonObject=jParser.makeHttpRequest(url,"GET",param);
                            s=jsonObject.toString();
                        }catch (Exception e){
                            s="{'code':0}";
                        }


                        return s;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);

                        try {

                            JSONObject js = new JSONObject(s);


                            String rl = js.getString("nom");

                            if (!(rl.equals("null"))) {
                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                i.putExtra("ip",ip.getText().toString());
                                startActivity(i);
                            } else {
                                t1.setError("Donnée incorrecte");
                                //ou
                                //Toast.makeText(MainActivity.this, "Login ou mot de passe incorrectes", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.execute();
            }
        });

    }
    public void open(View v) {
        AlertDialog.Builder alertedialoguebuilder= new AlertDialog.Builder(this);
        alertedialoguebuilder.setMessage("vous etes sur de quitter?");
        alertedialoguebuilder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        alertedialoguebuilder.setNegativeButton("Non", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(LoginActivity.this, "Vous etes les bienvenus", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alert= alertedialoguebuilder.create();
        alert.show();
    }

}
