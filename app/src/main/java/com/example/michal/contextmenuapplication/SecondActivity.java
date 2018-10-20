package com.example.michal.contextmenuapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnCreateContextMenuListener {

    boolean none = true;
    ListView lv;
    Double SN;
    Double [] data = new Double[20];
    TextView tv;
    int i=0,j=1;
    Boolean tf;
    Double f,mh;
    int po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv=(ListView)findViewById(R.id.lv);
        tv=(TextView)findViewById(R.id.tv);
        Intent gi=getIntent();
        tf=gi.getBooleanExtra("True/False",false);
        mh=gi.getDoubleExtra("mh",0);
        f=gi.getDoubleExtra("f",0);

        if (tf==false) {
            while (i < 20) {
                data[i] = f + (j - 1) * mh;
                i++;
                j++;
            }
        }
        if (tf==true){
            while (i<20){
                data[i]=f*(Math.pow(mh,j-1));
                j++;
                i++;
            }
        }

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnCreateContextMenuListener(this);

        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this, R.layout.support_simple_spinner_dropdown_item, data);
        lv.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        po=position+1;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String str = item.getTitle().toString();
        if (str=="מיקום"){
            tv.setText(""+po);
            return true;
        }
        if (str=="סכום") {
            if (tf == false) {
                SN = ((po) * (2 * f + ((po) - 1) * mh)) / 2;
            }
            if (tf == true) {
                SN = (f * ((Math.pow(mh, (po))) - 1)) / (mh - 1);
            }
            tv.setText(SN + "");
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        menu.add("מיקום");
        menu.add("סכום");
    }
}
