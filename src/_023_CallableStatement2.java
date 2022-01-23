import java.sql.*;

public class _023_CallableStatement2
{
    public static void main(String[] args) throws SQLException
    {
        /*
        Stored Procedure

        create or replace procedure getemployee(emps out SYS_REFCURSOR) as
        BEGIN
              open emps for
                   SELECT * FROM employee;
        END;
        /
         */

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        CallableStatement cst=con.prepareCall("{call getemployee(?)}");
        cst.registerOutParameter(1, Types.REF_CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        boolean f=false;
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        while(rs.next())
        {
            f=true;
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        if(f==false)
        {
            System.out.println("No Records Found");
        }
        System.out.println("...............................");
        con.close();
    }
}
