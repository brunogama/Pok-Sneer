package org.brunogama.pokesneer.model;

import com.google.gson.annotations.Expose;

public class Pokemon {

    @Expose
    private String attack;

    @Expose
    private String defense;

    @Expose
    private String name;

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("I choose you %s!\n Attack %s\n Defense %s", name, attack, defense);
    }
}
