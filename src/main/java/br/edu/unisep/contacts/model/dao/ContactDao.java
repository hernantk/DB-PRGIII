package br.edu.unisep.contacts.model.dao;

import br.edu.unisep.contacts.model.entity.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {
    private Connection connect() throws  ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contatos",
                "postgres","jdfnil54");
    return connection;
    }
    public void save(Contact contact ){
        try {
            var connection = connect();
            var ps = connection.prepareStatement("insert into contats(nome, email) values (?,?)");
            ps.setString(1,contact.getNome());
            ps.setString(2,contact.getEmail());

            ps.execute();
            ps.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        }
        public List<Contact> findAll(){
        var allContacts = new ArrayList<Contact>();
        try {
            var connection= connect();
            var st = connection.createStatement();
            var result= st.executeQuery  ("select * from contats");

            while (result.next()){
                var contact =new Contact();
                contact.setId(result.getInt("id_contato"));
                contact.setNome(result.getString("nome"));
                contact.setEmail(result.getString("email"));

                allContacts.add(contact);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return allContacts;

        }
        public void exclude(Integer id){
        try {
            var connection= connect();
            var ps = connection.prepareStatement("delete from contats where id_contato= ?");
            ps.setInt(1,id);
            ps.execute();
            ps.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        }
}
