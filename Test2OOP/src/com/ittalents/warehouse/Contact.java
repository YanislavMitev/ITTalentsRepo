package com.ittalents.warehouse;

//TODO:EXCEPTION HANDLING
//TODO:Move widespread methods and fields from inheritors
//TODO:Improve the hierarchy
public abstract class Contact {

    private String name;

    public Contact(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (Utils.checkString(name)) {
            this.name = name;
        } else {
            this.name = "";
            System.out.println("Invalid name.");
        }
    }
}


