package sprint1_files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alaa_Ibrahim
 */

public class userModel {
    private String UserName;
    private String Email;
    private String Password;

    //***********************************************
    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String name)
    {
        this.UserName = name;
    }
    //***********************************************
    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email)
    {
        this.Email = email;
    }
    //***********************************************
    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Pass)
    {
        this.Password = Pass;
    }
    public Connection connect() {
    	
        Connection con=null;
        try{
        String host = "jdbc:mysql://localhost:3306/registration";
        String Uname = "root";
        String password = "12345678";
        con = DriverManager.getConnection(host, Uname, password);
        con.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
        
    }
    public ArrayList<userModel> getAlldata(){
        ArrayList<userModel> allusers=new ArrayList<userModel>();
        try {
            Connection con = this.connect();          
            Statement stmt = con.createStatement();
            String Sql = "SELECT * FROM user";
            ResultSet res = stmt.executeQuery(Sql);

            while (res.next()) {
                userModel u=new userModel();
                u.setUserName(res.getString(1));
                u.setEmail(res.getString(2));
                u.setPassword(res.getString(3));
                allusers.add(u);

                
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allusers;
    }
    public void addData(String user, String email, String pass) {
        Connection con=this.connect();
        String Sql="INSERT INTO user "+" VALUES('"+user+"','"+email+"','"+pass+"')";
        try
        {
        Statement stmt = con.createStatement();
        stmt.executeUpdate(Sql);
        con.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean checkIf_user_is_exist(String username,String pass)
    {
        
      boolean found=false;
      try
      {
      Connection con=this.connect();
      Statement stmt = con.createStatement();
      String sql="SELECT * FROM user";
      //System.out.println("1");
      ResultSet res = stmt.executeQuery(sql);
      while(res.next())
      {
          if(username.equals(res.getString("username")) && pass.equals(res.getString("password")))
          {
              found=true;
              break;
          }
      }
      }
      catch(Exception e)
      {
          e.getMessage();
      }
      return found;
    }
    
}

