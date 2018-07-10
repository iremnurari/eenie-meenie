/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

public class dataBase {
    String msg="";
    boolean bool=false;
    String m="";
    private Connection con;
    private Statement statement;
    private ResultSet resultSet;
    enum MYTABLE
    {
        ID,USERNAME,PASSWORD;
    }
    enum MESSAGES
    {
        MSG;
    }
   
    
    public dataBase()
    {
    }
    
      
    public void register(String username,String password)
    {
        
        String sql=String.format
                 ("insert into mytable values(default,'%s','%s');",username,password);
        String check=String.format("select * from mytable where username='%s'", username);
        
        try
        {   
            //deploy
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydatabase","root","root");
            statement=con.createStatement();
            resultSet=statement.executeQuery(check);
            if(resultSet.next()){
                bool=false;
            }
            else{
                bool=true;
            statement.executeUpdate(sql);
            }
        }
        catch(Exception e)
        {
            System.out.print("error2"+e.getLocalizedMessage());
        }
    }
    public boolean valid(String uname,String pass) //valid user from login
    {
       boolean st =false;
        String sql1=String.format
                ("select username from mytable where username = '%s' and password='%s'", uname,pass);
          
        try {
            //deploy
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydatabase","root","root");
            //create sql statement
            statement=con.createStatement();
            resultSet = statement.executeQuery(sql1);
            st = resultSet.next();
        } 
        catch (Exception e)
        {
         System.out.print("error3"+e.getLocalizedMessage());
        }
      return st;
    }
    public void postnot(String mesg)
    {
        String sql=String.format("insert into messages values('%s');",mesg);
        try
        {   
            //deploy
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydatabase","root","root");
            statement=con.createStatement();
            statement.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.print("error2"+e.getLocalizedMessage());
        }
    }
    public ArrayList display(){
        String sql=String.format("select msg from messages;");
        ArrayList<String> incoming=new ArrayList<String>();
        String message="";
        try
        {   
            //deploy
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydatabase","root","root");
            statement=con.createStatement();
            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
            message=resultSet.getString(MESSAGES.MSG.toString());
            incoming.add(message);
            }
            return incoming;
        }
        catch(Exception e)
        {
            System.out.print("error2"+e.getLocalizedMessage());
        }
      return incoming;
    }
    
}
