package com.solo.myapplication.base;

/**
 * @ProjectName: My Application
 * @Package: com.solo.myapplication.base
 * @ClassName: BaseBean
 * @Description: java类作用描述
 * @Author: LS
 * @CreateDate: 13/4/2021 下午2:19
 * @UpdateUser: 更新者
 * @UpdateDate: 13/4/2021 下午2:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BaseBean<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
