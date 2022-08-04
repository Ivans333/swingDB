import java.sql.*;

public class DBlogic {
    String DB = "jdbc:mysql://localhost:3306/swingDB";
    String USER = "root";
    String password = "qwerty12345";
    String name = "hello";
    //insert

    public void insert (){
        try (
            Connection connection = DriverManager.getConnection(DB,USER,password);
        ) {
            PreparedStatement prst = connection.prepareStatement("INSERT INTO users (username, name) VALUES (?, ?)");
            prst.setString(1,  name);
            prst.setString(2, "IvansZarickis" );
            prst.executeUpdate();

            System.out.println("Data inserted.");


        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(){
        try(Connection connection = DriverManager.getConnection(DB,USER,password)){
            PreparedStatement prst = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            prst.setInt(1, 1);
            prst.executeUpdate();
            System.out.println("User Deleted");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update (){
        try(Connection connection = DriverManager.getConnection(DB,USER,password)){
            PreparedStatement prst = connection.prepareStatement("UPDATE users SET name = ? WHERE id = ?");
            prst.setString(1, "UpdatedName");
            prst.setInt(2, 2);
            prst.executeUpdate();
            System.out.println("User updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}





















//    // Select
//    public void select(){
//        try{
//            Connection connection = DriverManager.getConnection(DB, USER, PASS);
//            Statement statement = connection.createStatement();
//
//            ResultSet rs = statement.executeQuery("SELECT id, email, name FROM users");
//
//            String sql = "SELECT FROM users WHERE id = 1";
//            //poka estj zna4enije sleduju6ee - next()
//            while(rs.next()){
//                System.out.println("id: " + rs.getInt("id") + ". Email: " + rs.getString("email") + ". Name: " + rs.getString("name"));
//                System.out.println("*******************************");
//            }
//
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
