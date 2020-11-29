package kr.hs.emirim.s2019w04.sora;

public class Memberinfo {

    private String name;
    private String phone;
    private String data;
    private String address;

    public Memberinfo(String name, String phone, String data, String address){
        this.name = name;
        this.phone = phone;
        this.data = data;
        this.address = address;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String name){
        this.phone = phone;
    }

    public String getData(){
        return this.data;
    }
    public void setData(String name){
        this.data = data;
    }

    public String getAddress(){
        return this.address;
    }
    public void setAddress(String name){
        this.address = address;
    }

}
