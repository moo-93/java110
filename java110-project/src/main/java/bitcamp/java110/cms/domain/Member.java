package bitcamp.java110.cms.domain;

import java.io.Serializable;

public class Member implements Serializable{

    private static final long serialVersionUID = 1L;
    protected String name;
    protected String email;
    
    // transient 필드 : Serialize 대상 제외 
    protected transient String password;
    //인스턴스의 메모리를 다루는 operator = setter/gatter = accessor = property =message
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
