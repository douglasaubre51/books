package com.library.repositories;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.models.Book;

public class BookRepository {
    public BookRepository() {
    }

    public Book getBook(String name) {
        String urlString = "http://localhost:8080/getBook?name=" + name;

        Book book = new Book();

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("opened connection to ayane!");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            System.out.println("got input stream!");

            BufferedReader buffer = new BufferedReader(reader);

            String data;
            StringBuilder jsonString = new StringBuilder();

            connection.getResponseCode();

            while ((data = buffer.readLine()) != null) {
                if (data == null) {
                    return null;
                }

                System.out.println("reading data stream from ayane!");
                jsonString.append(data);
                System.out.println(data);
            }

            reader.close();

            ObjectMapper mapper = new ObjectMapper();
            book = mapper.readValue(jsonString.toString(), Book.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
}
