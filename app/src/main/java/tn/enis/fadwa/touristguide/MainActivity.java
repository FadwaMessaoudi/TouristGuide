package tn.enis.fadwa.touristguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.AsyncTask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import junit.framework.Test;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity {
    EditText t1,t2,ip;

    Button b1,b2;
    View n;
    String nom="admin";
    String pass="admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

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
                String r1 = t1.getText().toString();
                String r2 = t2.getText().toString();
                Boolean test = true;
                try {

                    FileReader f;

                    BufferedReader br=new BufferedReader(new
                            InputStreamReader(getAssets().open("file.txt")));

                    //BufferedReader br = new BufferedReader(f);
                    String line;
                    while ((line = br.readLine()) != null) {
                        Toast.makeText(getApplicationContext(), "err", Toast.LENGTH_LONG).show();
                        for (int i = 1; i <= 2; i++) {
                            if ((i == 1) && (!(line.equals(r1)))) {

                                test = false;
                                break;
                            } else {
                                if ((i == 2) && (!(line.equals(r2)))) {
                                    test = false;
                                    break;
                                }
                            }
                        }
                        if (test) {
                            Intent intent = new Intent(MainActivity.this, ListeView.class);
                            startActivity(intent);
                        } else {
                            t1.setError("Donnée incorrecte");
                        }
                    }
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "err2222", Toast.LENGTH_LONG).show();

                }
             /*   AssetManager assetmanager=getAssets();
                try {
                    String[] files=assetmanager.list("Files");
                    for(int i=0;i<files.length;i++)
                    {
                        t1.append("\n Files=>"+i+"Name"+files);

                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                AssetFileDescriptor input;
                try
                {
                    input=assetmanager.openFd("file.txt");
                    BufferedReader bufferedReader=new BufferedReader(input);
                   // int size=input.available();



                   byte[] buffer=new byte[size];
              input.read(buffer);
                   //int ra= input.read(buffer);

                    input.close();
                    String text=new String(buffer);
                    t1.setText(text); */







              /*  new AsyncTask<String,Void, String>(){
                    String l=t1.getText().toString();
                    String p=t2.getText().toString();
                    String url="http://52.35.10.152/seconnecter.php";
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
                                Intent i = new Intent(MainActivity.this, ListeView.class);
                                startActivity(i);
                               // i.putExtra("ip",ip.getText().toString());

                            } else {
                                t1.setError("Donnée incorrecte");
                                //ou
                                //Toast.makeText(MainActivity.this, "Login ou mot de passe incorrectes", Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.execute();  */
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
                Toast.makeText(MainActivity.this, "Vous etes les bienvenus", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alert= alertedialoguebuilder.create();
        alert.show();
    }



}
}