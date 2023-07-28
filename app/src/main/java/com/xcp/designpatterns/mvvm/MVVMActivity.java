package com.xcp.designpatterns.mvvm;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.xcp.designpatterns.R;
import com.xcp.designpatterns.databinding.ActivityMvvmBinding;

/**
 * UI界面，只参与处理界面逻辑，负责并显示由viewmodel提供的数据，不参与业务逻辑。
 */
public class MVVMActivity extends AppCompatActivity implements LoginModel.OnLoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        LoginModel model = new LoginModel(this);
        binding.setModel(model);
    }

    @Override
    public void success() {
        Toast.makeText(MVVMActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail() {
        Toast.makeText(MVVMActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
