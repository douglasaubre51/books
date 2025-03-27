package com.library.repositories;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.models.Book;
public class BookRepository {

    public Book getBook(String name){
        Connection _conn;
		PreparedStatement preparedStatement;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/AyaneDb";
			String user="root";
			String password="password";

			_conn=(Connection)DriverManager.getConnection(url,user,password);

            String insertSql="select name,author,price from books where author=?";

            preparedStatement=_conn.prepareStatement(insertSql);
            preparedStatement.setString(1,name);
            preparedStatement.execute();

            ResultSet set=preparedStatement.executeQuery();

            if(set!=null){
                Book book=new Book();

            while(set.next()){
                book.name=set.getString("name");
                book.author=set.getString("author");
                book.price=set.getString("price");
            }

            System.out.println("name"+book.name);

            return book;

            }

    }
    catch(Exception e){
        e.printStackTrace();
    }
    return null;
}
}

//     public Book getBook(String name) {
//         String urlString = "http://localhost:8080/getBook?name="+name;

//         Book book = new Book();

//         try {
//             URL url = new URL(urlString);

//             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//             connection.setRequestMethod("GET");
//             System.out.println("opened connection to ayane!");

//             int status=connection.getResponseCode();
//             if(status==HttpURLConnection.HTTP_NOT_FOUND){
//                 System.out.println("book not found!");
//                 return new Book();
//             }

//             InputStreamReader reader = new InputStreamReader(connection.getInputStream());
//             System.out.println("got input stream!");

//             BufferedReader buffer = new BufferedReader(reader);

//             String data;
//             StringBuilder jsonString = new StringBuilder();



//             while ((data = buffer.readLine()) != null) {
//                 System.out.println("reading data stream from ayane!");
//                 jsonString.append(data);
//                 System.out.println(data);
//             }

//             reader.close();

//             ObjectMapper mapper = new ObjectMapper();
//             book = mapper.readValue(jsonString.toString(), Book.class);
//             System.out.println(book.name);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return book;
//     }
// }
