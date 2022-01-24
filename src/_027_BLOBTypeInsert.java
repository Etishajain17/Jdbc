import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _027_BLOBTypeInsert
{
    public static void main(String[] args) throws SQLException, FileNotFoundException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","");
        PreparedStatement ps=con.prepareStatement("insert into persons values(?,?)");
        ps.setString(1,"Vishu");
        File fi=new File("C:\\Users\\Etisha Jain\\Desktop\\pic23.jpeg");
        FileInputStream fis=new FileInputStream(fi);
        ps.setBinaryStream(2,fis);
        System.out.println("Inserting image from :"+fi.getAbsolutePath());
        int updateCount =ps.executeUpdate();
        if(updateCount==1)
        {
            System.out.println("Record Inserted");
        }
        else
        {
            System.out.println("Record not Inserted");
        }
    }
}
