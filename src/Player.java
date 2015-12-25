import java.util.Random;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkelmoerch
 */
public class Player extends Person implements Comparable<Player> {

    /**
     * Eventually player stats as instance variables:
     * 
     * Basic:
     * String position
     * String footed
     * int height
     * int weight
     * 
     * Technical:
     * int finishing
     * int passing
     * int crossing
     */
    
    /** attacking **/
    int shooting;
    int passing;
    
    /** defending **/
    int marking;
    int tackling;
    
    /** physical **/
    int pace;
    int strength;
    int stamina;
    
    String position;
    
   /**
    * 
    * @param age
    * @param firstname
    * @param surname
    * @param club 
    */
    public Player(int age, String firstname, String surname, Club club){
        super(age, firstname, surname, club);
    }
    
    public Player(String firstname, String lastname){
        super(firstname, lastname);
        this.shooting = new Random().nextInt(9);
        this.passing = new Random().nextInt(9);
        this.marking = new Random().nextInt(9);
        this.tackling = new Random().nextInt(9);
        this.pace = new Random().nextInt(9);
        this.strength = new Random().nextInt(9);
        this.stamina = new Random().nextInt(9);
    }
    
    public int getOverallRating(){
        int overall = 0;
        overall = getShooting()+getPassing()+getMarking()+getTackling()+getPace()+getStrength()+getStamina();
        return overall;
    }
    
    public int getOffensiveRating(){
        int off = 0;
        off = getShooting()+getPassing();
        return off;
    }
    
    public int getDefensiveRating(){
        int def = 0;
        def = getMarking()+getTackling();
        return def;
    }
    
    public int getShooting(){
        return this.shooting;
    }
    
    public int getPassing(){
        return this.passing;
    }
    
    public int getMarking(){
        return this.marking;
    }
    
    public int getTackling(){
        return this.tackling;
    }
    
    public int getPace(){
        return this.pace;
    }
    
    public int getStrength(){
        return this.strength;
    }
    
    public int getStamina(){
        return this.stamina;
    }
    
    @Override
    public int compareTo(Player p){
        return this.getName().compareTo(p.getName());
    }
}
