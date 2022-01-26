import java.sql.*;

public class _045_ParameterMetaData1
{
    /*
    ParameterMetaData
     */
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
        ParameterMetaData pmd=ps.getParameterMetaData();
        int count=pmd.getParameterCount();
        for (int i = 1; i <= count ; i++)
        {
            System.out.println("Parameter Number: "+i);
//            System.out.println("Parameter Mode: "+pmd.getParameterMode(i));
//            System.out.println("Parameter Type: "+pmd.getParameterType(i));
//            System.out.println("Parameter Precision: "+pmd.getPrecision(i));
//            System.out.println("Parameter Scale: "+pmd.getScale(i));
//            System.out.println("Parameter isSigned: "+pmd.isSigned(i));
//            System.out.println("Parameter isNullable: "+pmd.isNullable(i));
            System.out.println("...........................");
        }
        con.close();
    }
}
