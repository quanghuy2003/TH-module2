package service;

import model.Phonebook;

import java.util.ArrayList;

public class ManagePhonebook implements Manage<Phonebook> {
    private ArrayList<Phonebook> listPhonebook;

    public ManagePhonebook() {
        listPhonebook = new ArrayList<>();
    }

    public ManagePhonebook(ArrayList<Phonebook> listPhonebook) {
        this.listPhonebook = listPhonebook;
    }

    public ArrayList<Phonebook> getListPhonebook() {
        return listPhonebook;
    }

    public void setListPhonebook(ArrayList<Phonebook> listPhonebook) {
        this.listPhonebook = listPhonebook;
    }


    @Override
    public void add(Phonebook phonebook) {
        listPhonebook.add(phonebook);
    }

    @Override
    public void delete(String name) {
        int index = findByName(name);
        if (index == -1) {
            System.out.println("không có mục này");
        } else {
            listPhonebook.remove(index);
        }
    }

    @Override
    public void update(String name, Phonebook phonebook) {
        int index = findByName(name);
        listPhonebook.set(index, phonebook);
    }

    @Override
    public void display() {
        for (Phonebook phonebook : listPhonebook) {
            System.out.println(phonebook);
        }
    }

    @Override
    public int findByName(String name) {
        for (int i = 0; i < listPhonebook.size(); i++) {
            if (listPhonebook.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
