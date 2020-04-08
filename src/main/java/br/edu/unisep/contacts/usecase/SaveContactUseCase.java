package br.edu.unisep.contacts.usecase;

import br.edu.unisep.contacts.model.dao.ContactDao;
import br.edu.unisep.contacts.model.entity.Contact;

public class SaveContactUseCase {

    public void execute(Contact contact){
        var dao= new ContactDao();
        if(contact.getId()==null){
        dao.save(contact);}
        else{
            dao.update(contact);
        }
    }
}
