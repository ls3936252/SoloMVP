package com.solo.myapplication.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: My Application
 * @Package: com.solo.myapplication.base
 * @ClassName: BasePresenter
 * @Description: java类作用描述
 * @Author: LS
 * @CreateDate: 13/4/2021 下午2:25
 * @UpdateUser: 更新者
 * @UpdateDate: 13/4/2021 下午2:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T>{

    public T rootView;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    public void attachView(T rootView) {
        this.rootView = rootView;
    }

    /***
     * 检测是否绑定
     */
    public void checkView(){
        if(rootView==null){
            throw  new RuntimeException("Please First Use attachView() in your project");
        }
    }

    /***
     *
     * @param disposable
     */
    public void addDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

    @Override
    public void detachView() {
        this.rootView = null;
        if(!compositeDisposable.isDisposed()){//取消Rxjava所有订阅
            compositeDisposable.clear();
        }
    }

}
