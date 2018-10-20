package com.example.michal.contextmenuapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Double f,mh;
    Boolean tf;
    Switch sw;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        sw=(Switch)findViewById(R.id.sw);
        btn=(Button)findViewById(R.id.btn);
    }

    public void Next(View view) {
        String str1=et1.getText().toString();
        String str2=et2.getText().toString();
        if ((str1!="")||(str1!=".")||(str1!="-")||(str1!="-.")||(str1!=".-")||(str2!="")||(str2!=".")||(str2!="-")||(str2!="-.")||(str2!=".-")){
            f=Double.parseDouble(str1);
            mh=Double.parseDouble(str2);
            Intent t=new Intent (this,SecondActivity.class);
            t.putExtra("True/False",tf);
            t.putExtra("f",f);
            t.putExtra("mh",mh);
            startActivity(t);
        }
        else{
            Toast.makeText(this,"Wrong Input",Toast.LENGTH_SHORT).show();
        }
    }

    public void choice(View view) {
        if (sw.isChecked()) {
            tf = true;
        }
        else {
            tf = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String st=item.getTitle().toString();
        if (st.equals("Credits"))
            Toast.makeText(this,"The Application Of Michal Leybovich",Toast.LENGTH_LONG).show();
        return true;
    }
}
