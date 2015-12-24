/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkelmoerch
 */
public class Manager extends Person {
    
    /**
     * Eventually manager stats as instance variables.
     * 
     * String favouriteFormation
     * String personality
     * 
     * 
     * Skills:
     * int Tactical
     * int Judgement of player's potential 
     * int Judgement of player's current abilities
     * etc.
     */
    
    /**
     * 
     * @param age
     * @param firstname
     * @param surname
     * @param club 
     */
    public Manager(int age, String firstname, String surname, Club club){
        super(age, firstname, surname, club);
    }
    
    /**
     * 
     * @param firstname
     * @param lastname 
     */
    public Manager(String firstname, String lastname){
        super(firstname, lastname);
    }
    
}
