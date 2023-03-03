package com.example.jsonrecyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Actvity extends AppCompatActivity {
List<Model> emplist=new ArrayList<>();
ListView emplistView;
Button button;
    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity);

        emplistView=findViewById(R.id.listView);
       // button=findViewById(R.layout.list_item_employee);
        Model emp=new Model("Mithun","12/11/1998","Software engineer","Samartha info solution");
        emplist.add(emp);

        emp=new Model("Uday Kumar","12/11/1998","Software engineer","Samartha info solution");
        emplist.add(emp);

        emp=new Model("Arjun Kumar","12/11/1998","Software engineer","Samartha info solution");
        emplist.add(emp);

        EmployeeAdapter employeeAdapter=new EmployeeAdapter(this,emplist);
        emplistView.setAdapter(employeeAdapter);

        /*AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setView(emplistView);
        final AlertDialog dialog=builder.create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });*/
    }
}