package br.edu.unisep.contacts.usecase;

import br.edu.unisep.contacts.model.dao.ContactDao;
import br.edu.unisep.contacts.model.entity.Contact;

import java.util.List;

public class ListContactsUseCase {
    public List<Contact> execute(){
        var dao = new ContactDao();
        return dao.findAll();
    }
}
