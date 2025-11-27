package uz.pdp.project.service;

import uz.pdp.project.entity.User;
import uz.pdp.project.utils.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    public static boolean findAllUsers(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/g58", "postgres", "123");
            PreparedStatement prps = connection.prepareStatement("select * from users;");

            ResultSet resultSet = prps.executeQuery();
            DB.users.clear();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                DB.users.add(new User(id, firstName,lastName, email, password));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createUser(String firstName, String lastName,String email,String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/g58", "postgres", "123");
            PreparedStatement prps = connection.prepareStatement("insert into users(first_name, last_name, email, password) values (?, ?, ?, ?) returning id;");
            prps.setString(1, firstName);
            prps.setString(2, lastName);
            prps.setString(3, email);
            prps.setString(4, password);

            ResultSet resultSet = prps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                DB.users.add(new User(id, firstName, lastName,email,password));
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User findUserById(String id) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/g58", "postgres", "123");
            PreparedStatement prps = connection.prepareStatement("select first_name, last_name, email, password from users where id=?;");
            prps.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = prps.executeQuery();
            User user = null;
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = new User(Integer.valueOf(id), firstName,lastName, email, password);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

/*    public static boolean updateBook(String id, String name, Integer pages) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/g58", "postgres", "123");
            PreparedStatement prps = connection.prepareStatement("update books set name=?, pages=? where id=?;");
            prps.setString(1, name);
            prps.setInt(2,pages);
            prps.setInt(3, Integer.parseInt(id));

            prps.execute();
            Book book1 = DB.books.stream().filter(book -> book.getId().equals(Integer.valueOf(id))).findFirst().get();
            book1.setName(name);
            book1.setPages(pages);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteBookById(String id) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/g58", "postgres", "123");
            PreparedStatement prps = connection.prepareStatement("delete from books where id=?;");
            prps.setInt(1, Integer.parseInt(id));

            prps.execute();
            List<Book> collect = DB.books.stream().filter(book -> !book.getId().equals(Integer.valueOf(id))).collect(Collectors.toList());
            DB.books.clear();
            DB.books.addAll(collect);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
