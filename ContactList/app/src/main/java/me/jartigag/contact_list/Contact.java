package me.jartigag.contact_list;

import java.util.ArrayList;

public class Contact {
    public String id;
    public String name;
    public ArrayList<ContactEmail> emails;
    public ArrayList<ContactPhone> numbers;
    public ArrayList<ContactWebsite> websites;

    public Contact(String id, String name) {
        this.id = id;
        this.name = name;
        this.emails = new ArrayList<ContactEmail>();
        this.numbers = new ArrayList<ContactPhone>();
        this.websites = new ArrayList<ContactWebsite>();
    }

    public void addEmail(String address, String type) {
        emails.add(new ContactEmail(address, type));
    }

    public void addNumber(String number, String type) {
        numbers.add(new ContactPhone(number, type));
    }

    public void addWebsite(String url) {
        websites.add(new ContactWebsite(url));
    }
}
