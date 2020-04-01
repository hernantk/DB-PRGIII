package br.edu.unisep.contacts.beans;

import br.edu.unisep.contacts.model.entity.Contact;
import br.edu.unisep.contacts.usecase.SaveContactUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NewContactBean {
    private SaveContactUseCase useCase = new SaveContactUseCase();

    @Getter @Setter
    private Contact contact = new Contact();

    public String save(){
        useCase.execute(contact);

        return "index?faces-redirect=true";
    }


}
