package lab2;

import java.sql.*;

public class AddAuthorAction{
	private String AuthorID;
	private String Name;
	private String Country;
	private int Age;
	
	public void setAuthorID(String AuthorID){
		this.AuthorID=new String(AuthorID);
	}
	public String getAuthorID(){
		return AuthorID;
	}
	
	public void setName(String Name){
		this.Name = new String(Name);
	}
	public String getName(){
		return Name;
	}
	
	public void setCountry(String Country){
		this.Country = new String(Country);
	}
	public String getCountry(){
		return Country;
	}
	
	public void setAge(int Age){
		this.Age=Age;
	}
	public int getAge(){
		return Age;
	}
	
	Connection con;
	Statement st;
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","coding");
		}catch(Exception e){
			System.out.println("Connect Fail:"+e.getMessage());
		}
		return con;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		try{
			String sql = "INSERT INTO author(AuthorID,Name,Age,Country)"+"VALUES("+"'"+AuthorID+"','"+Name+"','"+Age+"','"+Country+"')";
			st = (Statement)con.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("Insert Successful.DataNum:"+count);
			con.close();
			return "Success";
		}catch(SQLException e){
			return "Failed";
		}
	}
}
