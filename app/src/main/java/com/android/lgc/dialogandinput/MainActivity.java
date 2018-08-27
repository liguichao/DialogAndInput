package com.android.lgc.dialogandinput;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openInterfaceDialog(View view) {
        TextView msg = new TextView(this);
        msg.setText(R.string.dialog_view);
        msg.setPadding(10, 10, 10, 10);
        msg.setGravity(Gravity.CENTER);
        msg.setTextSize(18);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(getString(R.string.dialog_title))
                .setView(msg)
                .setNegativeButton(getString(R.string.cancel), null)
                .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

    public void loginDialog(View view) {
        View viewGroup = LayoutInflater.from(MainActivity.this).inflate(R.layout.login_dialog, null);
        final EditText editTextAccount = (EditText) viewGroup.findViewById(R.id.editTextAccount);
        final EditText editTextPassword = (EditText) viewGroup.findViewById(R.id.editTextPassword);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle(getString(R.string.dialog_title))
                .setView(viewGroup)
                .setCancelable(false)//设置这个对话框不能被用户按[返回键]而取消掉
                .setNegativeButton(getString(R.string.cancel), null)
                .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String account = editTextAccount.getText().toString();
                        String password = editTextPassword.getText().toString();
                        Log.d(TAG, "account:" + account);
                        Log.d(TAG, "password:" + password);
                    }
                })
                .show();
    }

    public void searchDialog(View view) {
        final EditText editText = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("搜索")
                .setView(editText)
                .setNegativeButton("取消",null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = editText.getText().toString();
                        Log.d(TAG, "input:" + input);
                    }
                })
                .show();
    }
}
