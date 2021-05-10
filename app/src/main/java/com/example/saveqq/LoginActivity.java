package com.example.saveqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editAccount = findViewById(R.id.edit_account);
        final EditText editPassword = findViewById(R.id.edit_password);

        TextView btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editAccount.getText().toString();
                String password = editPassword.getText().toString();
                login(id, password);
            }
        });

        TextView btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void login(String id, String password) {
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "请输入账号id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!AccountManager.isAccountExist(id)) {
            Toast.makeText(this, "账号不存在", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!AccountManager.checkPassword(id, password)) {
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    private void register() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
