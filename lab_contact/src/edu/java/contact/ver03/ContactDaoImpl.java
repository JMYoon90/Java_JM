package edu.java.contact.ver03;

import java.util.ArrayList;
import java.util.List;

import edu.java.contact.ver02.Contact;

public class ContactDaoImpl implements ContactDao {
    // 연락처 정보를 저장할 list.
    public ArrayList<Contact> contactList = new ArrayList<>();
    
    // Singleton 설계
    private static ContactDaoImpl instance = null;
    private ContactDaoImpl() {}
    public static ContactDaoImpl getInstance() {
        if(instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }
    
    @Override
    public int create(Contact contact) {
        contactList.add(contact);
        return 1;
    }
    
    @Override
    public List<Contact> read() {
            return contactList;
    }
    
    @Override
    public Contact read(int index) {
        if(!isValidindex(index)) {
            return null;
        }
        return contactList.get(index);
    }
    
    @Override
    public int update(int index, Contact contact) {
        if (!isValidindex(index)) {
            return 0;            
        } 
        contactList.set(index, contact);
        return 1;  
    }
    
    @Override
    public int delete(int index) {
        if (!isValidindex(index)) {
            return 0;
        }
        contactList.remove(index);
        return 1;
    }
    
    public boolean isValidindex(int index) {
        return (index >= 0) && (index < contactList.size());
    }
}
