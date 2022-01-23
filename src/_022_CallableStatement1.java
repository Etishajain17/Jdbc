import java.sql.*;

public class _022_CallableStatement1
{
    public static void main(String[] args) throws SQLException
    {
        /*
        Stored Procedure

        create or replace procedure getemployee(emno IN int,emnane OUT varchar(10)) as
        BEGIN
              SELECT ename into emname FROM employee where eno=emno;
        END;
        /
         */

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        CallableStatement cst=con.prepareCall("{call getemployee(?,?)}");
        cst.setInt(1,1005);
        cst.registerOutParameter(2,Types.VARCHAR);
        cst.execute();
        System.out.println("Employee Name is-->"+cst.getString(2));
        con.close();
    }
}
