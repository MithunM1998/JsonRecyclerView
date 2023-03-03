package com.example.jsonrecyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {

    private Context mContext;
    private List<Model> mEmplist;
    Model emp=new Model();
    AlertDialog.Builder builder;
    public EmployeeAdapter(Context mContext, List<Model> mEmplist) {
        this.mContext = mContext;
        this.mEmplist = mEmplist;
    }

    @Override
    public int getCount() {
        return mEmplist.size();
    }

    @Override
    public Model getItem(int i) {
        return mEmplist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View empView=inflater.inflate(R.layout.list_item_employee,viewGroup,false);
        TextView name=empView.findViewById(R.id.name);
        TextView empDetails=empView.findViewById(R.id.employee_details);
       Button show=empView.findViewById(R.id.button_get);
       // builder = new AlertDialog.Builder(mContext.getApplicationContext());
       // builder.setCancelable(true);
       // builder.setView(empView);
        //final AlertDialog dialog= builder.create();
        Model employee=mEmplist.get(i);
        name.setText(mEmplist.get(i).getName());
        empDetails.setText("Date of Birth: "+employee.getDob()+"\nDesignation: "+employee.getDesignation()+"\nCompany Name: "+employee.getCompanyName());

        /*show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                                dialog.cancel();
                            }
                        });

                    dialog.show();
            }
        });*/

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogue();

            }
            @SuppressLint("SetTextI18n")
            private void openDialogue() {
                Dialog dialog=new Dialog(viewGroup.getContext());
                LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
                View custom_dialogue=layoutInflater.inflate(R.layout.employee_dialoguebox,null);
                TextView name=custom_dialogue.findViewById(R.id.name1);
                TextView empDetails=custom_dialogue.findViewById(R.id.employee_details1);
                Button ok=custom_dialogue.findViewById(R.id.button_get1);
                name.setText(employee.getName());
                empDetails.setText("Date of Birth: "+employee.getDob()+"\nDesignation: "+employee.getDesignation()+"\nCompany Name: "+employee.getCompanyName());

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.setContentView(custom_dialogue);
                dialog.show();

            }

        });
        return empView;
    }




}
