package br.edu.unisep.contacts.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContactDao {
    private Connection connect() throws  ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contatos",
                "postgres","jdfnil54");
    return connection;
    }
}
