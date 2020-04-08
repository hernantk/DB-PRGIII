package br.edu.unisep.contacts.beans;


import br.edu.unisep.contacts.model.entity.Contact;
import br.edu.unisep.contacts.usecase.DeleteContactUseCase;
import br.edu.unisep.contacts.usecase.ListContactsUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named

public class ListContactsBean {

    private ListContactsUseCase listUseCase = new ListContactsUseCase();
    private DeleteContactUseCase deleteUseCase= new DeleteContactUseCase();




    @Getter @Setter
    private List<Contact> allContacts;

    @PostConstruct
    public void iniciate(){
        this.allContacts= listUseCase.execute();
    }

    public void delete(Integer id){
        this.deleteUseCase.execute(id);
        iniciate();
    }

    }











