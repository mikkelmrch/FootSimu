import java.util.ArrayList;
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
public class TestClass {
    public static void main(String[] args){
        PersonFactory PF = new PersonFactory();
        PF.registerClub("AGF", 1905);

        PF.registerClub("Aab", 1920);

        PF.registerClub("FCK", 1925);
        
        PF.generatePersons(33, PersonFactory.PersonType.PLAYER);
        PF.generatePersons(3, PersonFactory.PersonType.MANAGER);
        
        for(Club club : PF.getAllClubs()){
        System.out.println("Club: " + club.getName());
        System.out.println("-------------------------------------------------");
        
        System.out.println(club.getName() + " has " + club.getPlayers().size() + " players.");
        System.out.println("-------------------------------------------------");
        System.out.println("The players are: ");
        
        ArrayList<Player> sortedList = new ArrayList<>();
        
            for(UUID plr : club.getPlayers()){
                Player p = (Player) PF.getPersonByID(plr);
                sortedList.add(p);
            }
            
        sortedList = PF.getSortedPlayerList(sortedList);
            for(Player plr : sortedList){
                System.out.print(plr.getName());
                System.out.print(" | ");
                System.out.print(plr.getAge());
                System.out.print(" | ");
                System.out.println(plr.getNationality() + " | ");
            }
        
        System.out.println("-------------------------------------------------");
        System.out.print("The manager in " + club.getName() + " is: ");
        Manager m = (Manager) PF.getPersonByID(club.getManagerID());
        System.out.println(m.getName());
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        }
        System.out.println(PF.namesCombinations(PF.firstNames, PF.surNames));
    }
    
}
