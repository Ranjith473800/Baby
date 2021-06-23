
package baby;
public class caretaker 
{
       private int id,age,duration,cost,exp;
       private String name,date,gender,place,time,mail,password,avail;
       private long mobile;
       public caretaker(int id,String name,int age,String gender,String place,int duration,int cost,long mobile,int exp,String avail,String mail,String password)
       {
           super();
           this.id=id;
           this.name=name;
           this.age=age;
           this.gender=gender;
           this.place=place;
           this.duration=duration;
           this.cost=cost;
           this.mobile=mobile;
           this.exp=exp;
           this.avail=avail;
           this.mail=mail;
           this.password=password;
        }
        public int getId()
        {
            return id;
        }
        public void setId(int id)
        {
            this.id=id;
        }
        public String getname()
        {
            return name;
        }
        public void setname(String name)
        {
            this.name=name;
        }
        public int getage()
        {
            return age;
        }
        public void setage(int age)
        {
            this.age=age;
        }
        public String getgender()
        {
            return gender;
        }
        public void setgender(String gender)
        {
            this.gender=gender;
        }
        public String getplace()
        {
            return place;
        }
        public void setplace(String place)
        {
            this.place=place;
        }
        public int getduration()
        {
            return duration;
        }
        public void setduration(int duration)
        {
            this.duration=duration;
        }
        public int getcost()
        {
            return cost;
        }
        public void setcost(int cost)
        {
            this.cost=cost;
        }
        public long getmobile()
        {
            return mobile;
        }
        public void setmobile(long mobile)
        {
            this.mobile=mobile;
        }
        public int getexp()
        {
            return exp;
        }
        public void setexp(int exp)
        {
            this.exp=exp;
        }
        public String getavail()
        {
            return avail;
        }
        public void setavail(String avail)
        {
            this.avail=avail;
        }
        public String getmail()
        {
            return mail;
        }
        public void setmail(String mail)
        {
            this.mail=mail;
        }
        public String getpassword()
        {
            return password;
        }
        public void setpassword(String password)
        {
            this.password=password;
        }
}