package Character;

import GameEngine.GameEngine;

public class CharacterProperties {
    private int hp;
    private int exp;
    private int stamina;
    private int attack;
    private int damage;
    private int defence;
    private int luck;
    private int value;
    private int getX;
    private int getY;

    // String variables
    private String name;
    private String type;
    private String color;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {this.color = color; }

    public int getGetX() {
        return getX;
    }

    public void setGetX(int getX) {
        this.getX = getX;
    }

    public int getGetY() {
        return getY;
    }

    public void setGetY(int getY) {
        this.getY = getY;
    }

//    Battling methods
    public void attack(CharacterProperties target){
        int damage = this.attack - target.getDefence();
        target.receiveDamage(damage);
    }

    private void receiveDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0){
            GameEngine.removeCharacter(this);

        }
    }

}
