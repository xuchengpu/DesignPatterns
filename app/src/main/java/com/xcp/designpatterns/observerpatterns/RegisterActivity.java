package com.xcp.designpatterns.observerpatterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.xcp.designpatterns.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtAge;
    private DataBaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtName=findViewById(R.id.edt_name);
        edtAge=findViewById(R.id.edt_age);
        manager=DataBaseManager.getManager();
    }

    public void addInfo(View view) {
        manager.insert(new UserInfo(edtName.getText().toString(),edtAge.getText().toString()));
    }

    public void finishAdd(View view) {
        finish();
    }
}
