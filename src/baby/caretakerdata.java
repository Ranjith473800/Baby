
package baby;
import java.sql.*;
public class caretakerdata 
{
    public static String id,age,duration,cost,exp;
    public static String name,date,gender,place,time,mail,password;
    public static String avail;
    public static String mobile;
    public static String uid,uname,uage,ugender,udate,uplace,utime,uduration,umobile,uemail;
    public static String w1,w2,w3,ws;
    
    public static Connection getCon()
    {
            Connection con=null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return con;
    }
    public static int save(caretaker c)
    {
	int status=0;
	try
        {
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("insert into caretaker(c_id,c_name,c_age,c_gender,c_place,c_duration,c_cost,c_mobile,c_exp,c_avail,c_mail,c_password) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            int a = (int)(Math.random() * (1000 - 100 + 1) + 100);
            ps.setInt(1,a+100);
       	    ps.setString(2,c.getname());
       	    ps.setInt(3,c.getage());
            ps.setString(4,c.getgender());
	    ps.setString(5,c.getplace());
            ps.setInt(6,c.getduration());
            ps.setInt(7,c.getcost());
            ps.setLong(8,c.getmobile());
            ps.setInt(9,c.getexp());
            ps.setString(10,c.getavail());
            ps.setString(11,c.getmail());
            ps.setString(12,c.getpassword());
	    status=ps.executeUpdate();
	    con.close();
	}
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static int display()
    {
        int status=0;
        try
        {
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("select * from caretaker where c_mail=?");
            ps.setString(1,mail);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {   
                id=rs.getString(1);
                name=rs.getString(2);
                age=rs.getString(3);
                gender=rs.getString(4);
                place=rs.getString(5);
                duration=rs.getString(6);
                cost=rs.getString(7);
                mobile=rs.getString(8);
                exp=rs.getString(9);
                avail=rs.getString(10);
                mail=rs.getString(11);
                password=rs.getString(12);              
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static int update(caretaker c)
    {
	int status=0;
	try
        {
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("update caretaker set c_name=?,c_age=?,c_gender=?,c_place=?,c_duration=?,c_cost=?,c_mobile=?,c_exp=?,c_avail=?,c_password=? where c_mail=?");
       	    ps.setString(1,c.getname());
       	    ps.setInt(2,c.getage());
            ps.setString(3,c.getgender());
	    ps.setString(4,c.getplace());
            ps.setInt(5,c.getduration());
            ps.setInt(6,c.getcost());
            ps.setLong(7,c.getmobile());
            ps.setInt(8,c.getexp());
            ps.setString(9,c.getavail());
            ps.setString(10,c.getpassword());
            ps.setString(11,c.getmail());
	    status =ps.executeUpdate();
	    con.close();
	}
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return status;
    }
    public int login(String mail1,String password1)
    {   
        int status=0;
        try
        {   
            int Id=0;
            String Mail=null;
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("select c_id, c_mail from caretaker where c_mail=? AND c_password=?");
            ps.setString(1,mail1);
            ps.setString(2,password1);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {   
                Id=rs.getInt(1);
                Mail=rs.getString(2);
            }
            con.close();
            if(Mail==null)
            {
                status=0;
            }
            else
            {
                status=2;
            }
            mail=Mail;
            id=String.valueOf(Id);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    public static void request(String id1)
    {
        int status=0;
        id=id1;
        try{
            Connection con=getCon();
            PreparedStatement p=con.prepareStatement("select * from c_requestlist where c_id=?");
            p.setString(1,id1);
            ResultSet r=p.executeQuery();
            while(r.next()){
                uid=String.valueOf(r.getInt(2));
                uname=(r.getString(3));
                uage=String.valueOf(r.getInt(4));
                ugender=r.getString(5);
                uplace=r.getString(6);
                udate=r.getString(7);
                utime=r.getString(8);
                uduration=String.valueOf(r.getInt(9));
                umobile=String.valueOf(r.getLong(10));
                uemail=r.getString(11);
            }
            con.close();
            
        }
        catch(Exception e){
            System.out.print(e);
        }
        
    }
    
    public static void works(){
        try{
            Connection con=getCon();
            PreparedStatement p=con.prepareStatement("select * from c_workstodo where c_id=?");
            p.setInt(1,Integer.parseInt(id));
            ResultSet r=p.executeQuery();
            while(r.next()){
                uid=r.getString(2);
                w1=r.getString(3);
                w2=r.getString(4);
                w3=r.getString(5);
                ws=r.getString(6);
            }
            con.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
    public static int workupdate(String wst){
       int status=0;
       try{
           Connection co=getCon();
           PreparedStatement p=co.prepareStatement("update c_workstodo set workstatus=? where c_id=? AND u_id=?");
           PreparedStatement p1=co.prepareStatement("update u_workassign set workstatus=? where c_id=? AND u_id=?");
           p.setString(1,wst);
           p.setInt(2,Integer.parseInt(id));
           p.setInt(3,Integer.parseInt(uid));
           p1.setString(1,wst);
           p1.setInt(2,Integer.parseInt(id));
           p1.setInt(3,Integer.parseInt(uid));
           p.executeUpdate();
           status=p1.executeUpdate();
           co.close();
       }
       catch(Exception e){
           System.out.print(e);
       }
       return status;
    }

}