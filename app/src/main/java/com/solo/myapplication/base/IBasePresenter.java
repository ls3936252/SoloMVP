package com.solo.myapplication.base;

/**
 * @ProjectName: My Application
 * @Package: com.solo.myapplication.base
 * @ClassName: IBasePresenter
 * @Description: java类作用描述
 * @Author: LS
 * @CreateDate: 13/4/2021 下午2:24
 * @UpdateUser: 更新者
 * @UpdateDate: 13/4/2021 下午2:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IBasePresenter<T extends IBaseView> {
    void attachView(T rootView);
    void detachView();
}
