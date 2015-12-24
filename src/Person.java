
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
public class Person {
    private int age;
    private String firstName;
    private String lastName;
    private Club club;
    private String nationality;
    private UUID id;
    /** The age range of a auto-generated person */
    private int[] ages = {11, 12, 13, 14, 15, 16, 17, 18, 19};
    
    public Person(int age, String firstname, String lastname, Club club){
        this.age = age;
        this.firstName = firstname;
        this.lastName = lastname;
        this.club = club;
        this.nationality = "Danish";
        this.id = UUID.randomUUID();
    }
    
    public Person(String firstname, String lastname){
        this.age = this.ages[new Random().nextInt(ages.length)];
        this.firstName = firstname;
        this.lastName = lastname;
        this.club = null;
        this.nationality = "Danish";
        this.id = UUID.randomUUID();
    }

    public UUID getID(){
        return this.id;
    }
    
    public String getName(){
        return this.firstName+" "+this.lastName;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public Club getClub(){
        return this.club;
    }
    
    public String getNationality(){
        return this.nationality;
    }
    
    public void setClub(Club club){
        this.club = club;
    }
    
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
}
