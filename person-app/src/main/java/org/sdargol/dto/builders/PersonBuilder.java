package org.sdargol.dto.builders;

import org.sdargol.dto.Person;

public class PersonBuilder{
    private String firstName;
    private String lastName;

    private PersonBuilder() {
    }

    public static PersonBuilder getBuilder(){
        return new PersonBuilder();
    }

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person build(){
        return new Person(firstName,lastName);
    }
}