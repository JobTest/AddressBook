package com.service;

import com.dao.ContactDAO;
import com.dao.RoleDAO;
import com.domain.Contact;
import com.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Lazarchuk Alex
 * @version 1.0
 */

@Service
public class ContactServiceImpl implements ContactService {
 
    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    private RoleDAO roleDAO;
 
    @Transactional
    public List<Contact> listContact(String sort) {
        List<Contact> myListContact = contactDAO.listContact();

        Collections.sort(myListContact, new Comparator() {
            public int compare(Object o1, Object o2) {
                Contact contact1 = (Contact) o1;
                Contact contact2 = (Contact) o2;
                return contact1.getFio().compareTo(contact2.getFio());
            }
        });
        if(sort.equals("email")) {
            Collections.sort(myListContact, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Contact contact1 = (Contact) o1;
                    Contact contact2 = (Contact) o2;
                    return contact1.getEmail().compareTo(contact2.getEmail());
                }
            });
        }
        if(sort.equals("address")) {
            Collections.sort(myListContact, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Contact contact1 = (Contact) o1;
                    Contact contact2 = (Contact) o2;
                    return contact1.getAddress().compareTo(contact2.getAddress());
                }
            });
        }
        if(sort.equals("telephone")) {
            Collections.sort(myListContact, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Contact contact1 = (Contact) o1;
                    Contact contact2 = (Contact) o2;
                    return contact1.getTelephone().compareTo(contact2.getTelephone());
                }
            });
        }
        if(sort.equals("organization")) {
            Collections.sort(myListContact, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Contact contact1 = (Contact) o1;
                    Contact contact2 = (Contact) o2;
                    return contact1.getOrganization().compareTo(contact2.getOrganization());
                }
            });
        }
        if(sort.equals("position")) {
            Collections.sort(myListContact, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Contact contact1 = (Contact) o1;
                    Contact contact2 = (Contact) o2;
                    return contact1.getPosition().compareTo(contact2.getPosition());
                }
            });
        }

        return myListContact;
    }

    @Transactional
    public List<Contact> searchContact(String value) {
        List<Contact> myListContact = contactDAO.searchContact(value);

        return myListContact;
    }

    @Transactional
    public List<Contact> filterContact(String[] filters, String value) {
        List<Contact> myListContact = contactDAO.filterContact(filters, value);

        return myListContact;
    }

    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
//        Role role = new Role();
//        role.setRole("ROLE_USER");
//        role.setUsername(contact.getUsername());
//        roleDAO.addRole(role);
    }

    @Transactional
    public Contact viewContact(String username) {
        return contactDAO.viewContact(username);
    }

    @Transactional
    public Contact editContact(String username) {
        return contactDAO.editContact(username);
    }

    @Transactional
    public void updateContact(Contact contact) {
        contactDAO.updateContact(contact);
//        roleDAO.updateRole(role);
    }

    @Transactional
    public void removeContact(String username) {
        contactDAO.removeContact(username);
    }

    /**
     * @return (array)String
     */
    public String[] getPositions() {
        String[] aPositions = new String[position.values().length];
        int i = 0;
        for (Position aPosition : position.values()) {
            aPositions[i++] = aPosition.toString();
        }

        return aPositions;
    }

    private Position position;
}
