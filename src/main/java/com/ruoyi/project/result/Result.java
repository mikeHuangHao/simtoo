package com.ruoyi.project.result;

public class Result<T> {

    private int code;

    private String msg;

    private T data;

    private Result(T data) {
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if(codeMsg != null){
            this.msg = codeMsg.getMsg();
            this.code = codeMsg.getCode();
        }
    }

    public int getCode() {
        return code;
    }

    /**
     * 成功的时候调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 失败时候调用
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
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
