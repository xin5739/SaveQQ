package com.example.saveqq;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.saveqq.bean.AccountBean;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText editAccount = findViewById(R.id.edit_account);
        final EditText editPassword = findViewById(R.id.edit_password);
        final EditText editPasswordConfirm = findViewById(R.id.edit_password_confirm);
        final EditText editname = findViewById(R.id.edit_name);


        TextView btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editAccount.getText().toString();
                String password = editPassword.getText().toString();
                String confirm = editPasswordConfirm.getText().toString();
                String name = editname.getText().toString();
//                AccountBean accountBean = new AccountBean(name,id,password);
                register(name,id, password, confirm);
            }
        });
    }

    private void register(String name, String id, String password, String confirm) {
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "请输入账号id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(confirm)) {
            Toast.makeText(this, "密码前后不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("password",password);
        setResult(1,intent);

        AccountManager.addAccount(name, id, password);
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

        // 关闭当前页面
        finish();
    }
}
