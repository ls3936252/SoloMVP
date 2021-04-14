package com.solo.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.afollestad.materialdialogs.MaterialDialog;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: My Application
 * @Package: com.solo.myapplication.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: LS
 * @CreateDate: 12/4/2021 下午5:39
 * @UpdateUser: 更新者
 * @UpdateDate: 12/4/2021 下午5:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder unbinder;
    private MaterialDialog progress_Dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam(getIntent().getExtras());
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(progress_Dialog!=null){
            progress_Dialog =null;
        }
        if(unbinder!=null){
            unbinder.unbind();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                InputMethodManager imm =
                        (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS
                );
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    // Return whether touch the view.
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    protected void showLoading(){
        if(progress_Dialog==null){
            progress_Dialog = new MaterialDialog.Builder(this)
                    .content("Loading")
                    .progress(true,100,false)
                    .build();
        }
        progress_Dialog.show();
    }

    protected void dismissLoading(){
        if(progress_Dialog!=null){
            progress_Dialog.dismiss();
        }
    }

    protected abstract int getLayoutId();
    protected abstract void initParam(Bundle extras);
    protected abstract void initListener();
    protected abstract void initData();
    protected abstract void initView();
}
