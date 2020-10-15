package Db;

import items.BookItem;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDb {
    Connection connection;
    static String host = "jdbc:mysql://localhost:3306/book-shop";
    static String user = "akon";
    static String password = "19091978Mama";


    public ConnectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(host, user, password);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addBook(BookItem book) {
        try {
            String sql = "INSERT INTO books(title,description,image,price) " +
                         "VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getDesc());
            stmt.setString(3, book.getImg());
            stmt.setInt(4, book.getPrice());
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }


}
