package StructuralPatterns.Flyweight;

import java.util.HashMap;

/*Применяет совместное использование для эффективной поддержки множества мелких объектов*/


abstract class CharacterStatement {
    protected String nameCharacter;
    protected int power;
    protected int charisma;
    public abstract void printStatement();
}
class ShrekStatement extends CharacterStatement {
    public ShrekStatement(){
        nameCharacter = "SHREK";
        power = 94129000;
        charisma = 20000;
    }
    @Override
    public void printStatement() {
        System.out.println("Name = " + nameCharacter + " Power = " + power + " Charisma = " + charisma);
    }
}
class AnatolyVassermanStatement extends CharacterStatement {
    public AnatolyVassermanStatement(){
        nameCharacter = "Anatoly Vasserman";
        power = 123443;
        charisma = 901213411;
    }
    @Override
    public void printStatement() {
        System.out.println("Name = " + nameCharacter + " Power = " + power + " Charisma = " + charisma);
    }
}
class YEStatement extends CharacterStatement {
    public YEStatement(){
        nameCharacter = "YE";
        power = 1341134;
        charisma = 15328475;
    }
    @Override
    public void printStatement() {
        System.out.println("Name = " + nameCharacter + " Power = " + power + " Charisma = " + charisma);
    }
}
class FlyweightFactory {
    private final HashMap<Integer, CharacterStatement> characters = new HashMap<>();
    public CharacterStatement getCharacter(int characterCode){
        CharacterStatement character = characters.get(characterCode);
        if (character == null){
            switch (characterCode) {
                case 1 -> character = new ShrekStatement();
                case 2 -> character = new AnatolyVassermanStatement();
                case 3 -> character = new YEStatement();
            }
            characters.put(characterCode, character);
        }
        return character;
    }
}

/*Реализация шаблона "Приспособленец"*/

public class FlyweightMain {
    public static void main (String [] args){
        FlyweightFactory factory = new FlyweightFactory();
        int [] characterCodes = {1,2,3};
        for (int nextCode : characterCodes){
            CharacterStatement character = factory.getCharacter(nextCode);
            character.printStatement();
        }
    }
}


