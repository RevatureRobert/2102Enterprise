package org.example.jdbc.prepared;

import org.example.jdbc.ConnectionSession;

import java.sql.*;

//hitting the membership table
public class PreparedExample implements Dao<String, Integer> {

    @Override
    public int create(String s) {
        try (ConnectionSession sess = new ConnectionSession()) {
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:postgresql://postgresql-class.cks98gmxels6.us-west-1.rds." +
//                            "amazonaws.com:5432/enterprise?currentSchema=cool_stuff", "robert", "password");
//            Statement st = conn.createStatement();
//            int i = st.executeUpdate("insert into membership_type values (9, '" + s + "')");
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("insert into membership_type values (12,?)");
            ps.setString(1, s);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public String findById(Integer id) {
        String sql = "select * from membership_type where id=?";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String result = "";
            rs.next();  // since next only needs to be called once to get a single result, a while loop does not
            // have to be used.
            result = rs.getString(2);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(String s) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}