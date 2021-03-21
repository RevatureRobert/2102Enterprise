import ninja.models.Ninja;
import ninja.tools.Shuriken;
import org.mockito.Mockito;
import util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestDriver {
    public static void main(String[] args) throws SQLException {
        Connection c = ConnectionUtility.getConnection();
        System.out.println(c);

        String sql = "create table ninja(name text);";
        String sql1 = "insert into NINJA values (?)";
        String sql2 = "select * from ninja";

        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.executeUpdate(); // execute the create table query

        stmt = c.prepareStatement(sql1); // prepare the insert
        stmt.setString(1,"Naruto");
        stmt.executeUpdate(); // execute the insert

        stmt = c.prepareStatement(sql2); // prepare the select
        ResultSet rs = stmt.executeQuery(); // execute the select
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
    }
}