package br.edu.unisep.contacts.usecase;

import br.edu.unisep.contacts.model.dao.ContactDao;
import br.edu.unisep.contacts.model.entity.Contact;

public class FindContactByIdUseCase {

    public Contact execute(Integer id){
        var dao = new ContactDao();
        return dao.findById(id);


    }
}
