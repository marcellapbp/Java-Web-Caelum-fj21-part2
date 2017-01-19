package dao;

import beans.Contact;
import persistence.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author marcella
 */
public class ContactDAO {
    
    
    private Connection conn;
    
    public ContactDAO()
    {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void addContact(Contact contact)
    {
        try
        {
        String sql = "insert into contatos (nome, email, endereco, datanasc)"
                   + "values(?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, contact.getName());
        pstmt.setString(2, contact.getEmail());
        pstmt.setString(3, contact.getAddress());
        pstmt.setDate(4, new Date( contact.getBirthDate().getTimeInMillis()));
        
        pstmt.execute();
        pstmt.close();
        
       
        conn.close();
        }catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    
    }
    
    public Contact selectContact(int id)
    {
        Contact contact = new Contact();
        try
        {
        
            String sql = "select * from contatos where id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next())
            {
                
                contact.setName(rs.getString("nome"));
                contact.setEmail(rs.getString("email"));
                contact.setAddress(rs.getString("endereco"));
                
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("datanasc"));
                contact.setBirthDate(data);
                
            }
            
            rs.close();
            pstmt.close();;
            conn.close();
            
        }catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return contact;
    }
    
    
    public List<Contact> getContactList()
    {
        List<Contact> contacts = new ArrayList<Contact>();
        try
        {
        
            String sql = "select * from contatos";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next())
            {
                Contact contact = new Contact();
                contact.setName(rs.getString("nome"));
                contact.setEmail(rs.getString("email"));
                contact.setAddress(rs.getString("endereco"));
                
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("datanasc"));
                contact.setBirthDate(data);
                
                contacts.add(contact);
            }
            
            rs.close();
            pstmt.close();;
            conn.close();
            
        }catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return contacts;
    }
    
    public void deleteContact (int id)
    {
        try
        {
        
            String sql = "delete from contatos where id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            
            pstmt.execute();
            pstmt.close();
            conn.close();
        }catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public void updateContact (Contact contact)
    {
        try
        {
            String sql = "update contatos set "
                + "nome = ?"
                + ",email = ?"
                + ",endereco = ?"
                + ",datanasc = ?"
                + "where id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3, contact.getAddress());
            pstmt.setDate(4, new Date( contact.getBirthDate().getTimeInMillis()));
            pstmt.setLong(5, contact.getId());

            pstmt.execute();
            pstmt.close();

            System.out.print("Updated!");

            conn.close();
        }catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    
}
