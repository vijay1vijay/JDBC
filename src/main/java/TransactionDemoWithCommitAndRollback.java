import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDemoWithCommitAndRollback {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/mydb";
        String uname= "root";
        String password="Esol@123";
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();
        System.out.println("Before Transaction");
        System.out.println("-----------------------");
        ResultSet rs=st.executeQuery("select * from accounts");
        while(rs.next()){
            System.out.println(rs.getString(1)+"........"+rs.getString(2));
        }
        System.out.println("Transaction begins....");
        con.setAutoCommit(false);
        st.executeUpdate("update accounts set balance = balance-2000 where name='Milan'");
        st.executeUpdate("update accounts set balance = balance+2000 where name='Anushka'");
        System.out.println("can you please confirm this transaction of 2000.....[Yes/No]");
        Scanner sc=new Scanner(System.in);
        String option=sc.next();
        if(option.equalsIgnoreCase("yes")){
            con.commit();
            System.out.println("Transaction committed");
        }
        else{
            con.rollback();
            System.out.println("Transaction is rolled back");
        }
        System.out.println("After Transaction");
        System.out.println("-----------------------");
        ResultSet rs1 = st.executeQuery("select * from accounts");
        while(rs1.next()){
            System.out.println(rs1.getString(1)+"........"+rs1.getString(2));
        }
    }
}
