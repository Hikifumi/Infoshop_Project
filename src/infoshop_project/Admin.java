package infoshop_project;

class Admin {
    private String user, pw;
    
    public Admin(String user, String pw){
        this.user = user;
        this.pw = pw;
    }

    public String getUser() {
        return user;
    }

    public String getPw() {
        return pw;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    
    
}
