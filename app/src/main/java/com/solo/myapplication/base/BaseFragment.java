package com.solo.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: My Application
 * @Package: com.solo.myapplication.base
 * @ClassName: BaseFragment
 * @Description: Fragment基类
 * @Author: LS
 * @CreateDate: 13/4/2021 下午2:02
 * @UpdateUser: 更新者
 * @UpdateDate: 13/4/2021 下午2:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseFragment extends RxFragment {

    protected Context mContext;
    protected Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext= context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(getLayoutId(),container,false);
        unbinder = ButterKnife.bind(this,view);
        initView(view,savedInstanceState);
        initData();
        initListener();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected abstract int getLayoutId();
    protected abstract void initView(View view, Bundle savedInstanceState);
    protected abstract void initData();
    protected abstract void initListener();

}
