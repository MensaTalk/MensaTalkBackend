package de.htw.berlin.MensaTalk.MensaTalkBackend.jwt.request;

public class VerifyRequest {

    private String userName;
    private String jwtToken;

    public VerifyRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
