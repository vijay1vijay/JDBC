import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Demo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/mydb";
        String uname= "root";
        String password="Esol@123";
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();
        ResultSet resultset = st.executeQuery("select * from employee");
        while(resultset.next()){
            System.out.println("Employee Id:    "+resultset.getInt(1));
            System.out.println("Employee name:  "+resultset.getString(2));
            System.out.println("Employee address:   "+resultset.getString(3));
            System.out.println("Change made in new branch of master branch");
        }

    }
}
