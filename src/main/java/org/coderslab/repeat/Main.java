package org.coderslab.repeat;

import org.coderslab.repeat.model.Person;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/public?" +
                            "user=root&password=my-secret-pw");

            String query = "SELECT count(*) FROM users";
            PreparedStatement pstmt = conn.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            System.out.println("User in db: " + rs.getInt(1));

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("stała się tragedia");

        }

        Person[] persons = new Person[3];

        try {
            InputStream in = Main.class.getClassLoader().getResourceAsStream("data.txt");

//            File file = new File("C:\Users\krzgo\IdeaProjects\CL_JEE_W_13_R\src\main\resources\data.txt");
//            InputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                persons[i] = new Person(data[0], data[1], data[2]);
                i++;
            }
            br.close();
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (Person person : persons) {
                String query = "INSERT INTO users(first_name, last_name, course) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, person.getFirstName());
                pstmt.setString(2, person.getLastName());
                pstmt.setString(3, person.getCourseName());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Integer numberOfUsers = 0;

        try {
            String query = "SELECT count(*) FROM users";
            PreparedStatement pstmt = conn.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            numberOfUsers = rs.getInt(1);
            System.out.println("User in db: " + numberOfUsers);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("stała się tragedia");
        }

        Person[] personsFromDb = new Person[numberOfUsers];

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/public?" +
                            "user=root&password=my-secret-pw");

            String query = "SELECT * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                personsFromDb[i] = new Person(rs.getString(1), rs.getString(2), rs.getString(3));

            }
            System.out.println("User in db: " + rs.getInt(1));

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.out.println("stała się tragedia");

        }

        try {

            // plik musi istnieć
            URL resourceUrl = Main.class.getClassLoader().getResource("data_out.txt");
            File file = new File(resourceUrl.toURI());

            OutputStream fos = new FileOutputStream(file);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Person person : personsFromDb) {
                bw.write(person.getFirstName() + "," + person.getLastName() + "," + person.getCourseName());
                bw.newLine();
            }

            bw.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
