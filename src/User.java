public class User{
    private String username, password, status;
    private String usernameCust, passwordCust;
    private String UsernameCust;

    public String getUsernameCust() {
        return UsernameCust;
    }

    public void setUsernameCust(String usernameCust) {
        this.UsernameCust = usernameCust;
    }

    public String getPasswordCust() {
        return passwordCust;
    }

    public void setPasswordCust(String passwordCust) {
        this.passwordCust = passwordCust;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

