package club.banyuan.demo.authorization.common;

public enum  ResponCode {
    SUCCESS(200,"操作成功"),
    FORBIDDEN(403, "用户未授权"),
    ;
    private final int code;
    private final String message;

    ResponCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
