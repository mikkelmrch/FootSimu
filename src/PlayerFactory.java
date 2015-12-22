
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
public class PlayerFactory {
    static ArrayList<Player> PLAYERS = new ArrayList<Player>();
    static ArrayList<Club> CLUBS = new ArrayList<Club>();
    ArrayList<String> firstNames;
    ArrayList<String> surNames;
    ArrayList<String> fNTest;
    ArrayList<String> sNTest;

    public PlayerFactory() {
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
        
                this.fNTest = new ArrayList<>(Arrays.asList("Anders", "Bjarne", "Carsten"));
                this.sNTest = new ArrayList<>(Arrays.asList("Andersen", "Curth", "Jeppesen"));
    }
    
    public void registerPlayer(int age, String firstname, String lastname, Club club){
        Player p = new Player(age, firstname, lastname, club);
        PLAYERS.add(p);
    }
    
    /** Registers a new Club.
     * 
     * @param name The name of the Club.
     * @param year The year the club was founded.
     * @param title The JLabel of the Club.
     */
    public void registerClub(String name, int year, JLabel title){
        new Club(name, year);
        title.setText(name);
    }
    
    /** Generates a given amount of Player objects to each existing club.
     * 
     * @param numberOfPlayers The number of Player objects to be created and added to each existing club.
     */
    public void generatePlayers(int numberOfPlayers){
        
        //number of clubs
        int numOfClubs = this.CLUBS.size();
        System.out.println("The number of clubs is "+numOfClubs);
        
            //for(int i = 0; i < numOfClubs; i++){
                //System.out.println("The i is now at "+i);
                for(int j = 0; j < numberOfPlayers; j++){
                    System.out.println("The j is now at "+j);
                    // Player with unique name
                    Player p = generatePlayer();
                            try {
                            System.out.println("The Player "+p.getName()+" has been created.");
                            // Added to overall list
                            this.PLAYERS.add(p);
                            //System.out.println("And added to the list of all players.");
                            // Added to club at index i 

                            //this.CLUBS.get(i).getPlayers().add(p.getID());
                            //System.out.println("and added to the club "+this.CLUBS.get(i).getName());
                            } catch (Exception e){
                                System.out.println("The database has run out of available names.");
                                e.printStackTrace();
                            }
                }
            //}                  
    }
    
    /**
     * Generates a Player object with a unique name
     * @return A Player object
     */
    public Player generatePlayer(){
        try{
        String firstName = "";
        String surName = "";
        
        //for(int i = 0; i < fNTest.length; i++){
        //    firstName = firstNames.get(new Random().nextInt(fNTest.size()));
        //}
        
        //for(int i = 0; i < sNTest.length; i++){
        //    surName = surNames[new Random().nextInt(surNames.length)];
        //}
        do{
            firstName = fNTest.get(new Random().nextInt(fNTest.size()));
            //firstName = firstNames.get(new Random().nextInt(firstNames.size()));
            // Gets a random name from the list
            surName = sNTest.get(new Random().nextInt(sNTest.size()));
            //System.out.println(firstName + " "+ surName);

            //surName = surNames.get(new Random().nextInt(surNames.size()));
            
        } while(checkPlayerDublet(firstName, surName));
        
        // Checking if the first name generated in the do-loop exists.
        System.out.println(firstName + " "+ surName);
        if(checkPlayerDublet(firstName, surName)){
            System.out.println("generatePlayer() returned null.");
            return null;
        } else {
            return new Player(firstName, surName);
        }
        /*{
            // Gets a random name from the list
            firstName = firstNames.get(new Random().nextInt(firstNames.size()));

            // Gets a random name from the list
            surName = surNames.get(new Random().nextInt(surNames.size()));

        /*
        if(!checkPlayerDublet(firstName, surName)){
            return new Player(firstName, surName);
        } else {
            
        }
        System.out.println(firstName+" "+surName);
        }
        */
        //return p; //new Player("Karl", "Johan");
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    /** Checks whether an existing Player object's name matches the given name.
     * 
     * @param fName the firstname of the name to be checked
     * @param sName the surname of the name to be checked
     * @return TRUE if a Player with that name already exists.
     */
    public boolean checkPlayerDublet(String fName, String sName){
        String name = fName + " " + sName;
        for(int i = 0; i < this.PLAYERS.size(); i++){
            if(name.equals(this.PLAYERS.get(i).getName())){
                return true;
            }
        }
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
    
    public Player getPlayerByID(UUID id){
        for(Player player : PLAYERS){
            if(player.getID().equals(id)){
                return player;
            }
        }
        return null;
    }
    
    public ArrayList<Player> getAllPlayers(){
        return PlayerFactory.PLAYERS;
    }
    
    public ArrayList<Club> getAllClubs(){
        return PlayerFactory.CLUBS;
    }
}
