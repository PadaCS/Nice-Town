package com.bupt.nicetown.pojo;


public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 无参构造器和全参构造器
    public Result() {}
    public Result(Integer code, String message, T data) {}


    // Getter 和 Setter 方法
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    // 静态方法，返回成功的结果
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", null);
    }

    // 静态方法，返回成功的结果，不带数据
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    // 静态方法，返回失败的结果
    public static Result error(String message) {
        return new Result(1, message, null);
    }



}
