package org.jzs.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * 通用dialog
 */
public class MyDialog implements OnClickListener {

    private Dialog dialog;

    private Context context;

    private DialogCallBack mCallBack;

    public Dialog showDialog(Context context) {
        this.context = context;
        dialog = new Dialog(context, R.style.loading_dialog);
        dialog.setContentView(R.layout.dialog_my);
        dialog.findViewById(R.id.btn_other_cancel).setOnClickListener(this);
        dialog.findViewById(R.id.btn_other_ok).setOnClickListener(this);
        dialog.show();
        return dialog;
    }

    public void setTitleText(String str) {
        ((TextView) dialog.findViewById(R.id.tv_other_title)).setText(str);
    }

    public void setCancleGone() {
        dialog.findViewById(R.id.btn_other_cancel).setVisibility(View.GONE);
    }

    public void setSureGone() {
        dialog.findViewById(R.id.btn_other_ok).setVisibility(View.GONE);
    }

    public void setSureText(String str) {
        ((Button) dialog.findViewById(R.id.btn_other_ok)).setText(str);
    }

    public void setCancleText(String str) {
        ((Button) dialog.findViewById(R.id.btn_other_cancel)).setText(str);
    }

    public void setCancleBackground(int res) {
        ((Button) dialog.findViewById(R.id.btn_other_cancel)).setBackgroundResource(res);
    }

    public void visiblityCheckcode() {
        dialog.findViewById(R.id.et_checkcode).setVisibility(View.VISIBLE);
    }

    public String getCheckCode() {
        String code = ((EditText) dialog.findViewById(R.id.et_checkcode)).getText().toString().trim();
        return code;
    }

    public void setCallBack(MyDialog.DialogCallBack dialogCallBack) {
        this.mCallBack = dialogCallBack;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_other_cancel:
                if (mCallBack != null) {
                    mCallBack.cancelHandle();
                }
                dialog.dismiss();
                break;
            case R.id.btn_other_ok:

                if (mCallBack != null) {
                    mCallBack.handle();
                }
                dialog.dismiss();
                break;
        }
    }

    public interface DialogCallBack {

        void handle();

        void cancelHandle();
    }
}
