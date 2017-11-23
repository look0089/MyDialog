package org.jzs.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * 通用dialog
 */
public class MyDialog implements OnClickListener {

    private Dialog dialog;

    private DialogCallBack mCallBack;

    public Dialog showDialog(Context context) {
        dialog = new Dialog(context, R.style.my_dialog_style);
        dialog.setContentView(R.layout.dialog_my);
        dialog.findViewById(R.id.btn_cancel).setOnClickListener(this);
        dialog.findViewById(R.id.btn_ok).setOnClickListener(this);
        dialog.show();
        return dialog;
    }

    /**
     * 设置标题文字
     *
     * @param str
     */
    public void setTitleText(String str) {
        ((TextView) dialog.findViewById(R.id.tv_dialog_title)).setText(str);
    }

    /**
     * 设置内容文字
     *
     * @param str
     */
    public void setContentText(String str) {
        ((TextView) dialog.findViewById(R.id.tv_dialog_content)).setText(str);
    }

    /**
     * 隐藏取消按钮
     */
    public void setCancleGone() {
        dialog.findViewById(R.id.btn_cancel).setVisibility(View.GONE);
    }

    /**
     * 隐藏确定按钮
     */
    public void setOkGone() {
        dialog.findViewById(R.id.btn_ok).setVisibility(View.GONE);
    }

    /**
     * 设置取消按钮文字
     *
     * @param str
     */
    public void setCancleText(String str) {
        ((Button) dialog.findViewById(R.id.btn_cancel)).setText(str);
    }

    /**
     * 設置确定按钮文字
     *
     * @param str
     */
    public void setOkText(String str) {
        ((Button) dialog.findViewById(R.id.btn_ok)).setText(str);
    }

    /**
     * 设置取消按钮背景
     *
     * @param res
     */
    public void setCancleBackground(int res) {
        ((Button) dialog.findViewById(R.id.btn_cancel)).setBackgroundResource(res);
    }

    public void setCallBack(MyDialog.DialogCallBack dialogCallBack) {
        this.mCallBack = dialogCallBack;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_cancel) {
            if (mCallBack != null) {
                mCallBack.cancelHandle();
            }
        }
        if (id == R.id.btn_ok) {
            mCallBack.handle();
        }
        dialog.dismiss();
    }

    public interface DialogCallBack {

        void handle();

        void cancelHandle();
    }
}
