package com.library.repositories;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AccountRepository {
    String name;
    String email;
    String password;

    String siteUrl = "http://localhost:8080/addUser";
    String payload = "{\"name\":\"%s\",\"email\":\"%s\",\"password\":\"%S\"}";

    String getUrl = "http://localhost:8080/getUserByEmail?email=%s&password=%s";

    public AccountRepository(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountRepository(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean login() {
        try {
            String connectionString = String.format(getUrl, email, password);
            URL url = new URL(connectionString);
            URLConnection connection = url.openConnection();
            System.out.println("opened connection to ayane!");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            System.out.println("got input stream!");

            BufferedReader buffer = new BufferedReader(reader);

            String data;

            while ((data = buffer.readLine()) != null) {
                System.out.println("reading data stream from ayane!");
                System.out.println(data);

                if(data=="false"){
                    return false;
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createNewAccount() {
        try {
            System.out.println("connecting to ayane!");

            URL url = new URL(siteUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            try (DataOutputStream stream = new DataOutputStream(connection.getOutputStream())) {
                System.out.println("connected! sending payload");

                payload = String.format(payload, name, email, password);
                System.out.println(payload);
                stream.writeBytes(payload);
                stream.flush();
            }

            if (connection.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
                System.out.println("account successfully created!");
            }

            else {
                System.out.println(connection.getResponseCode() + " - error:account was not created!");
                System.out.println(name);
                System.out.println(email);
                System.out.println(password);

                connection.disconnect();
                return false;
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}

