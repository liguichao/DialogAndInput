package com.android.lgc.dialogandinput;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openInterfaceDialog(View view) {
        TextView msg = new TextView(this);
        msg.setText(R.string.text_view_dialog_view);
        msg.setPadding(10, 10, 10, 10);
        msg.setGravity(Gravity.CENTER);
        msg.setTextSize(18);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(getString(R.string.text_view_dialog_title))
                .setView(msg)
                .setNegativeButton(getString(R.string.text_view_cancel), null)
                .setPositiveButton(getString(R.string.text_view_confirm), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

    public void loginDialog(View view) {
        View viewGroup = LayoutInflater.from(MainActivity.this).inflate(R.layout.login_dialog, null);
        final EditText editTextAccount = (EditText) viewGroup.findViewById(R.id.editTextAccount);
        final EditText editTextPassword = (EditText) viewGroup.findViewById(R.id.editTextPassword);
        final EditText editTextPasswordPrompt = (EditText) viewGroup.findViewById(R.id.editTextPasswordPrompt);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.text_view_dialog_title));
        builder.setView(viewGroup);
        builder.setCancelable(false);//设置这个对话框不能被用户按[返回键]而取消掉
        builder.setNegativeButton(getString(R.string.text_view_cancel), null);
        builder.setPositiveButton(getString(R.string.text_view_confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String account = editTextAccount.getText().toString();
                String password = editTextPassword.getText().toString();
                String passwordPrompt = editTextPasswordPrompt.getText().toString();
                Log.d(TAG, "account:" + account);
                Log.d(TAG, "password:" + password);
                Log.d(TAG, "passwordPrompt:" + passwordPrompt);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        // 横竖屏切换时不自动退出对话框
        WindowManager.LayoutParams layoutParams = alertDialog.getWindow().getAttributes();
//        layoutParams.width=350;//定义宽度
//        layoutParams.height=300;//定义高度
        alertDialog.getWindow().setAttributes(layoutParams);
    }

    public void searchDialog(View view) {
        final EditText editText = new EditText(this);
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        new AlertDialog.Builder(this)
                .setTitle("搜索")
                .setView(editText)
                .setNegativeButton("取消", null)
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
