package br.edu.unisep.contacts.beans;

import br.edu.unisep.contacts.model.entity.Contact;
import br.edu.unisep.contacts.usecase.FindContactByIdUseCase;
import br.edu.unisep.contacts.usecase.SaveContactUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class NewContactBean {
    private SaveContactUseCase useCase = new SaveContactUseCase();
    private FindContactByIdUseCase findByIdUseCase = new FindContactByIdUseCase();



    @Getter @Setter
    private Contact contact = new Contact();

    @Inject
    @RequestParameterMap
    private Map<String,String> params;

    @PostConstruct
    public void init(){
        // var context=   FacesContext.getCurrentInstance();
         //var contactId = context.getExternalContext().getRequestParameterMap().get("contactId");
        var contactId =params.get("id");
        if (contactId!= null) {
            contact=findByIdUseCase.execute(Integer.valueOf(contactId));
        }
    }


    public String save(){

        useCase.execute(contact);

        return "index?faces-redirect=true";}
    }





