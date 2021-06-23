/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby;
import java.sql.*;
public class userdata {
           public static String id,duration,age;
           public static String name,email,password,gender,date,time,place;
           public static String mobile;
           public static String cid,cname,cemail,cage,cgender,cduration,ccost,cexp,cavail,cmobile,cplace,cstatus;
           public static String w1,w2,w3,workstatus;
           public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                        
		}catch(Exception e){System.out.println(e);}
		return con;
	}
    public static int firstsave(user u){
        int status=0;
        try{
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("insert into user(u_email,u_password,u_id,u_name,u_age,u_gender,u_place,u_date,u_time,u_duration,u_mobile) values(?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1,u.getEmail());
            ps.setString(2,u.getPassword());
            ps.setInt(3,u.getId());
            ps.setString(4,u.getName());
            ps.setInt(5,u.getAge());
            ps.setString(6,u.getGender());
            ps.setString(7,u.getPlace());
            ps.setString(8,u.getDate());
            ps.setString(9,u.getTime());
            ps.setInt(10,u.getDuration());
            ps.setLong(11,u.getMobile());
            status=ps.executeUpdate();
            con.close();
            
        }
        catch(Exception e){System.out.println(e);}
		return status;
    }
    
    public static int display(String email1)
    {
        int status=0;
        try
        {
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("select * from user where u_email=?");
            ps.setString(1,email1);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {  
                email=rs.getString(1);
                password=rs.getString(2);
                id=rs.getString(3);
                name=rs.getString(4);
                age=rs.getString(5);
                gender=rs.getString(6);
                place=rs.getString(7);
                date=rs.getString(8);
                time=rs.getString(9);
                duration=rs.getString(10);
                mobile=rs.getString(11);
                
                             
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static int edit(user u)
    {
	int status=0;
	try
        {
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("update user set u_name=?,u_age=?,u_gender=?,u_place=?,u_date=?,u_time=?,u_duration=?,u_mobile=? where u_email=?");
            
       	    ps.setString(1,u.getName());
       	    ps.setInt(2,u.getAge());
            ps.setString(3,u.getGender());
	    ps.setString(4,u.getPlace());
            ps.setString(5,u.getDate());
            ps.setString(6,u.getTime());
            ps.setInt(7,u.getDuration());
            ps.setLong(8,u.getMobile());         
            ps.setString(9,u.getEmail());
	    status=ps.executeUpdate();
	    con.close();
	}
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static int login(String email1,String password1)
    {  email=email1;
       password=password1;
       int status=0;
        try
        {
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("select * from user where u_email=? AND u_password=?");
            
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {   
                email=rs.getString(1);
                password=rs.getString(2);
                id=rs.getString(3);
                name=rs.getString(4);
                age=rs.getString(5);
                gender=rs.getString(6);
                place=rs.getString(7);
                date=rs.getString(8);
                time=rs.getString(9);
                duration=rs.getString(10);
                mobile=rs.getString(11);
                          
            }
            con.close();
            if(email1==null)
            {
                status=0;
            }
            else
            {
                status=2;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static void  urequest(String id1){
        try{
            Connection con=getCon();
            PreparedStatement p=con.prepareStatement("select * from u_requestlist where u_id=?");
            p.setString(1,id1);
            ResultSet r=p.executeQuery();
            while(r.next()){
                cid=r.getString(2);
                cname=r.getString(3);
                cage=r.getString(4);
                cgender=r.getString(5);
                cplace=r.getString(6);
                cduration=r.getString(7);
                ccost=r.getString(8);
                cmobile=r.getString(9);
                cexp=r.getString(10);
                cavail=r.getString(11);
                cemail=r.getString(12);
                cstatus=r.getString(13);
            }
            
        }
        catch(Exception e){
            System.out.print(e);
        }
        
    }
    
    public static int userrequest(){
        int status=0;
        try{
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("select * from u_requestllist where u_id=?");
  
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                cid=rs.getString(2);
                cname=rs.getString(3);
                cage=rs.getString(4);
                cgender=rs.getString(5);
                cplace=rs.getString(6);
                cduration=rs.getString(7);
                ccost=rs.getString(8);
                cmobile=rs.getString(9);
                cexp=rs.getString(10);
                cavail=rs.getString(11);
                cemail=rs.getString(12);
                cstatus=rs.getString(13);
            }
            con.close();
            if(id==null){
                status=0;
            }
            else{
                status=2;
            }
            
        }
        catch(Exception e){
            System.out.print(e);
        }
        return status;
    }
    public static int userwork(String wk1,String wk2,String wk3)
    {
        int status=0,stat=0;
        w1=wk1;
        w2=wk2;
        w3=wk3;
        try{
	    Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("insert into u_workassign(u_id,c_id,work1,work2,work3,workstatus)values(?,?,?,?,?,?)");
            PreparedStatement p=con.prepareStatement("insert into c_workstodo(c_id,u_id,work1,work2,work3,workstatus)values(?,?,?,?,?,?)");
            ps.setInt(1,Integer.parseInt(id));
            ps.setInt(2,Integer.parseInt(cid));
            ps.setString(3,w1);
            ps.setString(4,w2);
            ps.setString(5,w3);
            ps.setString(6,"pending");
            p.setInt(1,Integer.parseInt(cid));
            p.setInt(2,Integer.parseInt(id));
            p.setString(3,w1);
            p.setString(4,w2);
            p.setString(5,w3);
            p.setString(6,"pending");
            status=ps.executeUpdate();
            stat=p.executeUpdate();
            con.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
        return status;
    }
    public static void work(){
        try{
            Connection con=getCon();
            PreparedStatement p=con.prepareStatement("select * from u_workassign where u_id=?");
            p.setInt(1,Integer.parseInt(id));
            ResultSet r=p.executeQuery();
            while(r.next()){
                cid=String.valueOf(r.getInt(2));
                w1=r.getString(3);
                w2=r.getString(4);
                w3=r.getString(5);
                workstatus=r.getString(6);
            }
            con.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}