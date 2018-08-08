package com.ruoyi.project.result;

public class CodeMsg {

    private int code;

    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(0 , "成功");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常");

    //登录相关
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg MEMBER_NULL = new CodeMsg(500215, "暂无此用户");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500216, "密码错误");
    public static CodeMsg CODE_ERROR = new CodeMsg(500218, "验证码错误");
    public static CodeMsg MEMBER_REG = new CodeMsg(500217, "该用户已注册");
    public static CodeMsg MEMVER_NULL = new CodeMsg(500290, "请先登录");

    //购物和
    public static CodeMsg GOODS_NUMBER = new CodeMsg(500278,"库存不足");

    private CodeMsg( ) {
    }

    public CodeMsg(int code , String msg){
        this.code = code;
        this.msg = msg;
    }

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

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
