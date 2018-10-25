package Model;

import java.util.ArrayList;

public class Unit {
    private final int person = 5;
    private ArrayList<Person> personArrayList;

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public int getPerson() {
        return person;
    }
}
