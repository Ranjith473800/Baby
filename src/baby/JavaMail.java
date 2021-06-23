
package baby;

public class JavaMail 
{
    public void accept(String mail,String msg) 
    {
        try
        {
            Send.SendMail(mail,msg);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void reject(String mail,String msg) 
    {
        try
        {
            Send.SendMail(mail,msg);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

