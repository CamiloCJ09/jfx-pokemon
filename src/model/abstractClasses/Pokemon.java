package model.abstractClasses;

import model.classes.Attack;
import model.interfaces.Autoplaying;
import model.interfaces.Battle;

import java.io.Serializable;

public abstract class Pokemon implements Battle, Autoplaying, Serializable {

    private String img;
    private String name;
    private double exp;
    private int level;
    private double health;
    private boolean hasOwner;
    private String type;
    private Attack[] pokemonAttacks;

    public Pokemon(String img, String name, double exp, int level, double health, boolean hasOwner, String type, Attack[] pokemonAttacks) {
        this.img = img;
        this.name = name;
        this.exp = exp;
        this.level = level;
        this.health = health;
        this.hasOwner = hasOwner;
        this.type = type;
        this.pokemonAttacks = pokemonAttacks;
    }
    /*multipliers:
    health, defense,attack + 0.1
    level++
    */
    public void levelUp(){
        level++;
        health = health+(health*0.1);
        for(Attack attack : pokemonAttacks){
            attack.setDamage(attack.getDamage()+(attack.getDamage()*0.1));
            attack.setDefense(attack.getDefense()+(attack.getDefense() * 0.1));
            attack.setPp(attack.getPp()+2);
        }
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attack[] getPokemonAttacks() {
        return pokemonAttacks;
    }

    public void setPokemonAttacks(Attack[] pokemonAttacks) {
        this.pokemonAttacks = pokemonAttacks;
    }


    public String toString() {
        StringBuilder out = new StringBuilder(img + ";" + name + ";" + exp + ";" + level + ";" + health + ";" + hasOwner + ";" + type);
        for (int i = 0; i <pokemonAttacks.length ; i++) {
            out.append(pokemonAttacks[i].getName()).append(";").append(pokemonAttacks[i].getDamage()).append(";").append(pokemonAttacks[i].getDefense()).append(";").append(pokemonAttacks[i].getPp());
        }
        return out.toString();
    }
}
