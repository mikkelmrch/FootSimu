
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkelmoerch
 */
public class Factory {
    /** List of all registered persons. */
    static ArrayList<Person> PERSONS = new ArrayList<Person>();
    /** List of all registred clubs. */
    static ArrayList<Club> CLUBS = new ArrayList<Club>();
    /** List of all registered seasons */
    static ArrayList<League> SEASONS = new ArrayList<League>();
    
    static int seasonCount = 0;
    /** List of all firstnames and surnames */
    ArrayList<String> firstNames;
    ArrayList<String> surNames;
    ArrayList<String> fNTest;
    ArrayList<String> sNTest;
    
    /** Enumeration of the types of Persons that can be generated */
    public enum PersonType {PLAYER, MANAGER};

    public Factory() {
        this.firstNames = new ArrayList<>(Arrays.asList("Anders", "Andreas", "Albert", 
            "William", "Noah", "Emil", "Frederik", "Oliver", "Magnus", 
            "Elias", "Anton", "Alfred", "Alexander", 
            "Malthe", "Mikkel", "Liam", "August", "Valdemar", 
            "Lucas", "Felix", "Victor", "Mads", "Villads", "Benjamin", 
            "Mathias", "Johan", "Sebastian", "Oscar", "Marius", 
            "Christian", "Carl", "Oskar", "Storm", "Adam", "Tobias", 
            "Lukas", "Aksel", "Viktor", "Theodor", "Arthur", "Elliot", 
            "Bertram", "Asger", "Daniel", "Jonas", "Laurits", "Karl", "Karl", 
            "Viggo", "David", "Jonathan", "Thor", "Tristan", "Johannes", 
            "Villum", "Otto", "Simon", "Theo", "Malte", "Jeppe", "Marcus", 
            "Sigurd", "Lauge", "Silas", "Julius", "Magne", "Hjalte", "Rasmus", 
            "Rasmus", "Bastian", "Ludvig", "Milas", "Jacob", "Nohr", "Erik", 
            "Gabriel", "Hugo", "Jakob", "Axel", "Nor", "Max", "Vincent", 
            "Charlie", "Philip", "Samuel", "Sander", "Lasse", "Milo", "Birk", 
            "Sofus", "Vitus", "Adrian", "Bjørn", "Konrad", "Kristian", 
            "Nikolaj", "Thomas", "Silvester", "Malik", "Nicklas", "Pelle", 
            "Jens", "Louis"));
        this.surNames = new ArrayList<>(Arrays.asList( 
            "Ahmed", "Andersson", "Andresen", "Ali", "Andersen", "Andreasen",
            "Andreassen", "Asmussen", "Bach", "Bak", "Bang", "Bech",
            "Beck", "Bendtsen", "Berg", "Berthelsen", "Berhelsen", "Bisgård",
            "Bisgaard", "Bjerre", "Bjerregård", "Bonde", "Brandt", "Brodersen",
            "Bruun", "Buch", "Bundgård", "Bundgaard", "Carlsen", "Carstensen",
            "Christensen", "Christiansen", "Christoffersen", "Clausen", "Dahl",
            "Dalgård", "Dalgaard", "Dalsgård", "Dam", "Damgård", "Danielsen", 
            "Davidsen", "Enevoldsen", "Eriksen", "Eskildsen", "Fischer", "Frandsen",
            "Frederiksen", "Friis", "Frost", "Gade", "Gregersen", "Hald", "Hansen",
            "Hassan", "Hedegård", "Hjort", "Hoffman", "Holst", "Jacobsen", "Jensen",
            "Jespersen", "Jessen", "Johannesen", "Johansen", "Johnsen",
            "Juhl", "Justesen", "Juul", "Jønsson", "Jørgensen", "Karlsen",
            "Kirkegård", "Kjeldsen", "Kjær", "Kjærgård", "Kjærgaard",
            "Klausen", "Knudsen", "Koch", "Kofoed", "Kragh", "Kristensen", "Krog",
            "Kruse", "Lange", "Larsen", "Lassen", "Lauridsen", "Leth", "Lorentzen",
            "Lund", "Madsen", "Markussen", "Meyer", "Michelsen", "Mogensen", "Munch", 
            "Møller", "Nguyen", "Nielsen", "Nygård", "Olesen", "Olsson", "Overgård",
            "Paulsen", "Pedersen", "Persson", "Petersen", "Poulsen", "Ravn", "Riis",
            "Schmidt", "Schou", "Schrøder", "Schultz", "Simonsen", "Sloth", "Skov",
            "Steffensen", "Svensson", "Søgård", "Sørensen", "Thomassen", "Thorsen",
            "Thygesen", "Thøgersen", "Toft", "Vestergård", "Villadsen", "Vinther",
            "Winther", "Østergård", "Ågård", "Aagård"));
        
                this.fNTest = new ArrayList<>(Arrays.asList("Anders", "Bjarne", "Carsten","Rasmus", "Bastian", "Ludvig", "Milas", "Jacob"));
                this.sNTest = new ArrayList<>(Arrays.asList("Andersen", "Curth", "Jeppesen","Winther", "Østergård","Lund", "Madsen", "Villadsen"));
                
                League league = new League();
                SEASONS.add(league);
    }
    
    public void registerPlayer(int age, String firstname, String lastname, Club club){
        Player p = new Player(age, firstname, lastname, club);
        PERSONS.add(p);
    }
    
    /** Registers a new Club.
     * 
     * @param name The name of the Club.
     * @param year The year the club was founded.
     */
    public void registerClub(String name, int year){
        Club c = new Club(name, year);
        CLUBS.add(c);
    }
    
    public void newSeason(){
        League l = new League();
        SEASONS.add(l);
        seasonCount = seasonCount + 1;
        for(Club c : CLUBS){
            c.newSeason();
        }
    }
    
    /** Generates a given amount of Person objects to each existing club.
     * 
     * @param type The object PersonType to be created.
     * @param numOfPersons The number of Player objects to be created and added to each existing club.
     */
    public void generatePersons(int numOfPersons, PersonType type){
        
        // possible name combinations
        //int NC = namesCombinations(fNTest, sNTest);
        int NC = namesCombinations(firstNames, surNames);
        //number of clubs
        int numOfClubs = this.CLUBS.size();
        int numOfPersonsInEachClub = numOfPersons/numOfClubs;
        int count = 0;
        
            // Generate players while the total amount of created players is less than 
            // the amount of available names
            while (PERSONS.size() < NC && count < numOfPersons){
                for(int i = 0; i < numOfClubs; i++){
                    //System.out.println("The i is now at "+i);
                    for(int j = 0; j < numOfPersonsInEachClub; j++){
                        //System.out.println("The j is now at "+j);
                        // Person with unique name
                        Person p = generatePerson(type);
                                
                                if(p instanceof Player){
                                    Player plr = (Player) p;
                                    this.PERSONS.add(plr);
                                    count++;
                                    // Added to club at index i
                                    this.CLUBS.get(i).getPlayers().add(plr.getID());
                                } else if(p instanceof Manager){
                                    Manager m = (Manager) p;
                                    // Added to overall list
                                    this.PERSONS.add(m);
                                    count++;
                                    // Added to club at index i
                                    this.CLUBS.get(i).setManager(m.getID());
                                } else {
                                    System.out.println("There was an error.");
                                }
                    }
                }
            }
        // In case more players are requested to be generated than there is available, a message is displayed
        if(numOfPersons > NC){
            System.out.println("You've requested to generate " + numOfPersons + " players, however there is only " + NC + " possible names combinations.");
            System.out.println("Therefore " + NC + " players has been generated.");
        }
    }
    
    /**
     * Generates a Person object with a unique name
     * @param type The object PersonType to be created
     * @return A Person object
     */
    public Person generatePerson(PersonType type){
        try{
            String firstName = "";
            String surName = "";
            do{
                // Gets a random name from the lists
                //firstName = fNTest.get(new Random().nextInt(fNTest.size()));
                //surName = sNTest.get(new Random().nextInt(sNTest.size()));
                firstName = firstNames.get(new Random().nextInt(firstNames.size()));
                surName = surNames.get(new Random().nextInt(surNames.size()));
            } while(checkPlayerDublet(firstName, surName));
            // If the generatePlayer() is called more times than there is available combinations
            // of names, the condition (checkPlayerDublet(firstName, surName)) will always
            // return true and the loop will never end. 

            // Solution 1: Count the number of possible combinations of firstnames + surnames 
            // and compare it to the amount of players created in the database. 
            Person person;
            switch(type){
                case PLAYER:
                    person = new Player(firstName, surName);
                    break;
                
                case MANAGER:
                    person = new Manager(firstName, surName);
                    break;
                default: person = null;
                break;
            }
            return person;
            
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    /** Checks whether an existing Person object's name matches the given name.
     * 
     * @param fName the firstname of the name to be checked
     * @param sName the surname of the name to be checked
     * @return TRUE if a Person with that name already exists.
     */
    public boolean checkPlayerDublet(String fName, String sName){
        String name = fName + " " + sName;
        for(int i = 0; i < this.PERSONS.size(); i++){
            if(name.equals(this.PERSONS.get(i).getName())){
                // returns true if the person exists
                return true;
            }
        }
        // returns false if no such person with that name exists
        return false;
    }
    
    public int getFNCount(){
        return this.firstNames.size();
    }
    
    public int getSNCount(){
        return this.surNames.size();
    }
    
    public ArrayList<Player> getSortedPlayerList(ArrayList<Player> list){
            // Clone the current list of scouting sessions
            ArrayList<Player> clonedList = (ArrayList<Player>)list.clone();

            // Perform the actual sorting of the list, based on date
            Collections.sort(clonedList);

            // Return the sorted list
            return clonedList;
    }
    
    public ArrayList<String> getRandomPlayerList(ArrayList<String> list){
        // Clone the current list of players
        ArrayList<String> clonedList = (ArrayList<String>)list.clone();
        
        Collections.shuffle(clonedList);
        
        return list;
    }
    
    public Person getPersonByID(UUID id){
        for(Person person : PERSONS){
            if(person.getID().equals(id)){
                return person;
            }
        }
        return null;
    }
    
    public ArrayList<Person> getAllPersons(){
        return Factory.PERSONS;
    }
    
    public ArrayList<Club> getAllClubs(){
        return Factory.CLUBS;
    }
    
    public League getSeason(){
        return SEASONS.get(seasonCount);
    }
    
    /** Computes the total amounts of possible name combinations
     * 
     * @param firstnames The list of all first names
     * @param surnames The list of all surnames
     * @return The total amount of possible name combinations
     */
    public int namesCombinations(ArrayList<String> firstnames, ArrayList<String> surnames){
        int amount = 0;
        
        // For each 'first name' loop through all 'surnames' and increment amount by 1
        for(String name : firstnames){
            for(int i = 0; i < surnames.size(); i ++){
                amount = amount + 1;
            }
        }
        // returns the total amount of name combinations
        return amount;
    }
}
