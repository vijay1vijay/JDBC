import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Demo2 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/mydb";
        String uname= "root";
        String password="Esol@123";
        ResultSet resultSet=null;
        Connection con = null;
        String query = "select * from employee";
        String insertquery="insert into employee values('27','Manish','Canada')";
        try{
            con = DriverManager.getConnection(url,uname,password);
            Statement st = con.createStatement();
            boolean execute= st.execute(insertquery);
            if(execute){
                ResultSet rs=st.getResultSet();
                rs.next();
                System.out.println(rs.getString(2));
            }
            else{
                System.out.println("no of rows update=   "+st.getUpdateCount());
            }
            int count=st.executeUpdate(insertquery);
            System.out.println("No of rows affected=    "+count);
        }
        finally {
            if(resultSet!=null)
                con.close();
                if(con!=null)
                    con.close();
        }

    }
}
