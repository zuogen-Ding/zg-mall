package club.banyuan.demo.authentication.dto;

public class AdminLoginResp {
    private String tokenHead;
    private String token;

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
