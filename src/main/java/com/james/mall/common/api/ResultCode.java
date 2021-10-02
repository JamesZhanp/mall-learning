package com.james.mall.common.api;

/**
 * @author: JamesZhan
 * @create: 2021 - 02 - 15 15:45
 */
public enum ResultCode implements  IErrorCode{
    /**
     * enum: success -> 操作成功
     * failed -> 操作失败
     * validate_failed -> 参数校验
     * unauthorized -> token校验
     * forbidden -> 权限缺失
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;
    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
