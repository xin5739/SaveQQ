package com.example.saveqq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.saveqq.bean.AccountBean;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView textView = findViewById(R.id.abac);
        TextView textView1 = findViewById(R.id.abad);
        Intent intent = getIntent();
        String id=intent.getStringExtra("Extra_id");
        AccountBean accountBean = AccountManager.findAccount(id);
        textView.setText(accountBean.getName());
        textView1.setText(id.toString());

    }
}
