import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class _038_TransactionsManagementUsingJDBC
{
    /*
    - con.setAutoCommit(false)   ----> changes won't be committed in database automatically after running query
    - con.commit()               ----> after completion of all operations explicitly we can commit
    - con.rollback()             ----> To rollback operations if any sql query fails
     */
    public static void main(String[] args) throws SQLException
    {
        MysqlConnectionPoolDataSource mcon=new MysqlConnectionPoolDataSource();
        mcon.setURL("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Connection con=mcon.getConnection();
        Statement st=con.createStatement();
        System.out.println("Data before Transaction");
        System.out.println(".......................");
        ResultSet rs=st.executeQuery("select * from account");
        System.out.println("NAME \t BALANCE");
        System.out.println(".......................");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t"+rs.getFloat(2) );
        }
        System.out.println();
        System.out.println("Transaction Begin..");
        con.setAutoCommit(false);
        st.executeUpdate("update account set balance=balance-10000 where name='etisha'");
        st.executeUpdate("update account set balance=balance+10000 where name='vanshi'");
        System.out.println("Can you please confirm this transaction of 10000..[yes/no]");
        Scanner sc=new Scanner(System.in);
        String choice=sc.next();
        if(choice.equalsIgnoreCase("yes"))
        {
            con.commit();
            System.out.println("Transaction Completed..");
        }
        else
        {
            con.rollback();
            System.out.println("Transaction Roll backed..");
        }
        System.out.println();
        System.out.println("Data After Transaction");
        System.out.println(".......................");
        ResultSet rs1=st.executeQuery("select * from account");
        System.out.println("NAME \t BALANCE");
        System.out.println(".......................");
        while(rs1.next())
        {
            System.out.println(rs1.getString(1)+"\t"+rs1.getFloat(2) );
        }
        con.close();
    }
}
