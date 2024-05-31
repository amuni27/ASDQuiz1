package com.aman;

import com.aman.model.Contact;
import com.aman.model.Email;
import com.aman.model.Phone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        List<Email> emails = new ArrayList<>();
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("240-133-0011", "Home"));
        phones.add(new Phone("240-112-0123", "Mobile"));
        emails.add(new Email("dave.sang@gmail.com", "Home"));
        emails.add(new Email("dsanger@argos.com", "Work"));
        contacts.add(new Contact("David", "Sanger", "Argos LLC", "Sales Manager", emails, phones));
        contacts.add(new Contact("Carlos", "Jimenez", "Zappos", "Director", null, null));
        emails = new ArrayList<>();
        phones = new ArrayList<>();
        phones.add(new Phone("412-116-9988", "Work"));
        emails.add(new Email("ali@bmi.com", "Work"));
        contacts.add(new Contact("Ali", "Gafar", "BMI Services", "HR Manager", emails, phones));

        contacts.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                int res =  o1.getLastName().compareToIgnoreCase(o2.getLastName());
                if (res != 0)
                    return res;
                return o2.getLastName().compareToIgnoreCase(o2.getLastName());
            }
        });
        System.out.println("[");
        for (Contact contact : contacts) {
            System.out.print("{ FIRSTNAME:" + contact.getFirstName() + " LASTNAME:" + contact.getLastName() + " COMPANY:" + contact.getCompany() + " JOBTITLE:" + contact.getJobTitle() + " ");
            if(contact.getEmails()!=null){
                for(Email email : contact.getEmails()){
                    System.out.print("EMAIL:" + email.getEmail() + "LABEL: " + email.getLabel() + "");
                }
            }
            if(contact.getPhones()!=null){
                for(Phone phone : contact.getPhones()){
                    System.out.print("PHONENUMBER:" + phone.getNumber() + "LABEL: " + phone.getLabel() + "");
                }
            }
            System.out.println("}");
        }
        System.out.println("]");


    }
}