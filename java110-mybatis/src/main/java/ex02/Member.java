package ex02;

import java.io.Serializable;

public class Member implements Serializable{

    private static final long serialVersionUID = 1L;
    protected String name;
    protected String email;
    protected int no;
    protected String password;
    protected String tel;
    protected String photo;
    
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    //인스턴스의 메모리를 다루는 operator = setter/gatter = accessor = property =message
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
 
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
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}
