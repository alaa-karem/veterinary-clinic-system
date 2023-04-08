package sample;

public class viewAdmin {


    String id, user,password,type,email;
    public viewAdmin(String id,String user,String password,String type,String email){
        this.id=id;
        this.user=user;
        this.password=password;
        this.type=type;
        this.email=email;

    }
    public String getId(){
        return id;

    }
    public String getUser(){
        return user;

    } public String getPassword(){
        return password;

    } public String getType(){
        return type;

    } public String getEmail(){
        return email;

    }
}
