package Classes;

import Interfaces.IParticipant;

public class Participant implements IParticipant {
    private String firstName;
    private String lastName;
    private Integer id;

    Participant(String firstName, /*String lastName,*/ Integer id){
        this.firstName = firstName;
        //this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer newId){
        this.id = newId;
    }

    /*public String getLastName() {
        return lastName;
    }*/

    /*public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }*/

    /*public String getFullName() {
        return this.firstName + " " + this.lastName;
    }*/
}
