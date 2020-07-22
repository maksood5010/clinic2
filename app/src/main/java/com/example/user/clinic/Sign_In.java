package com.example.user.clinic;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Sign_In extends AppCompatActivity {
    HttpPostAsyncTask postAsyncTask;
    HashMap<String, String> postDataParams = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);
        final Button Signin=findViewById(R.id.button3);
        Button skip=findViewById(R.id.button5);
        postDataParams.put("name", "mak");
        postDataParams.put("salary", "567");
        postDataParams.put("age", "18");

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postAsyncTask != null){
                    if (postAsyncTask.getStatus() == AsyncTask.Status.RUNNING ||
                            postAsyncTask.getStatus() == AsyncTask.Status.PENDING){
                        postAsyncTask.cancel(true);
                    }
                }
                postAsyncTask=new HttpPostAsyncTask();
                postAsyncTask.execute("http://dummy.restapiexample.com/api/v1/employees");
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(Sign_In.this,Rcycle.class);

                startActivity(in);
            }
        });

        TextView signup=(TextView)findViewById(R.id.textView7);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(Sign_In.this,SignUp.class);
                startActivity(in);
            }
        });
    }
    public class HttpPostAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            URL url;
            String response = "";
            HttpURLConnection urlConnection=null;
            BufferedReader reader = null;

            try {
                String ur = strings[0];
                Log.d("MAK_TAG", "URl :" + ur);
                url = new URL(strings[0]);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

//                urlConnection.setReadTimeout(15000);
//                urlConnection.setConnectTimeout(15000);
//                urlConnection.setRequestMethod("GET");
//                urlConnection.setDoInput(true);
//                urlConnection.setDoOutput(true);

                InputStream stream = urlConnection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }
                Log.d("MAK_TAG ", "> " + buffer.toString());
                return buffer.toString();


            }
            catch (MalformedURLException e){
                Log.d("MAK_TAG", e.getLocalizedMessage());
                  e.printStackTrace();

            }
            catch (IOException e){
                Log.d("MAK_TAG", e.getLocalizedMessage());
                e.printStackTrace();
            }
            finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            if (aVoid == null){
                return;
            }
            Log.d("MAK_TAG", "Response : "+aVoid);

           Intent in=new Intent(Sign_In.this,Rcycle.class);
           in.putExtra("Response",aVoid);
            startActivity(in);
        }


     }

}
