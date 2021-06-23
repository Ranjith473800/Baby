/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby;
public class user {
    public String email,password;
    public int id,age,duration;
    public long mobile;
    public String name,date,gender,place,time;
    public String wk1,wk2,wk3;
    public user(){
        
    }
    public user(String email,String password){
        super();
        this.email=email;
        this.password=password;
    }
    
    public user(String email,String password,int id,String name,int age,String gender,String place,String date,String time,int duration,long mobile){
    super();
    this.email=email;
    this.password=password;
    this.id=id;
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.place=place;
    this.date=date;
    this.time=time;
    this.duration=duration;
    this.mobile=mobile;
    }
    public user(int id,String name,int age,String gender,String place,String date,String time,int duration,long mobile){
    super();
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.place=place;
    this.date=date;
    this.time=time;
    this.duration=duration;
    this.mobile=mobile;
    }
     public user(String name,int age,String gender,String place,String date,String time,int duration,long mobile){
    super();
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.place=place;
    this.date=date;
    this.time=time;
    this.duration=duration;
    this.mobile=mobile;
    }

   public user(String email, String password, String name, int age, String gender, String place, String date, String time, int duration, long mobile) {
        super();
        this.email=email;
        this.password=password;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.place=place;
        this.date=date;
        this.time=time;
        this.duration=duration;
        this.mobile=mobile;
    }
  
   
   
   
   
   
   
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getPlace(){
        return place;
    }
    public void setPlace(String place){
        this.place=place;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time=time;
    }
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration=duration;
    }
    public long getMobile(){
        return mobile;
    }
    public void setMobile(long mobile){
        this.mobile=mobile;
    }
}