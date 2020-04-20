package club.banyuan.demo.authorization.common;


import cn.hutool.json.JSONUtil;

public class ResponResult {


    private int code;
    private String message;
    private Object data;

    public ResponResult() {
    }

    public ResponResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponResult(ResponCode code) {
        this(code.getCode(), code.getMessage(), "");
    }

    public ResponResult(ResponCode code, Object data) {
        this(code.getCode(), code.getMessage(), data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponResult success(Object data) {
        return new ResponResult(ResponCode.SUCCESS.getCode(), ResponCode.SUCCESS.getMessage(),
                data);
    }

    public static ResponResult forbidden() {
        return new ResponResult(ResponCode.FORBIDDEN);
    }

    public static ResponResult forbidden(Object data) {
        return new ResponResult(ResponCode.FORBIDDEN, data);
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }


}
