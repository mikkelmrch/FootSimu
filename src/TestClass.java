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
        System.out.println("Stats:                              Name:");
        
        ArrayList<Player> sortedList = new ArrayList<>();
        
            for(UUID plr : club.getPlayers()){
                Player p = (Player) PF.getPersonByID(plr);
                sortedList.add(p);
            }
            
        sortedList = PF.getSortedPlayerList(sortedList);
            for(Player plr : sortedList){
                System.out.print(plr.getShooting()+ " | ");
                System.out.print(plr.getPassing()+ " | ");
                System.out.print(plr.getMarking()+ " | ");
                System.out.print(plr.getTackling()+ " | ");
                System.out.print(plr.getPace()+ " | ");
                System.out.print(plr.getStrength()+ " | ");
                System.out.print(plr.getStamina()+ " |  |  | ");
                System.out.print(plr.getName());
                System.out.print(" | ");
                System.out.print(plr.getAge());
                System.out.println(" | ");
            }
        
        System.out.println("-------------------------------------------------");
        System.out.print("The manager in " + club.getName() + " is: ");
        Manager m = (Manager) PF.getPersonByID(club.getManagerID());
        System.out.println(m.getName());
        System.out.println("-------------------------------------------------");
        System.out.println("The overall rating of "+ club.getName() + " is: " + club.getTeamRating());
        System.out.println("-------------------------------------------------");
        }
        System.out.println(PF.namesCombinations(PF.firstNames, PF.surNames));
        
        Club agf = PF.getAllClubs().get(0);
        Club aab = PF.getAllClubs().get(1);
        Club fck = PF.getAllClubs().get(2);
        
        League league = new League();
        // Simulation of j amount of matches (The max seems to be around 7.000.000 simulations)
        for(int j = 0; j < 22; j++){
        Match match = new Match(agf, aab);/*
            System.out.println("Match number " + (j+1) +" is played between "+match.getHomeName()+" and "+match.getAwayName());
            System.out.println(match.getHomeName()+"'s rating is " + match.getHomeRating() + ". "+ match.getAwayName() + "'s rating is " + match.getAwayRating());
            System.out.println("-------------------------------------------------");
            System.out.println("The better team is " + ((match.overallTeamEvaluation() - 1)*100)+ " percentage better than the other team.");
            System.out.println("-------------------------------------------------");
            System.out.println("HomeRating / AwayRating: " + match.getHomeRating() / match.getAwayRating());
            System.out.println("-------------------------------------------------");*/

            // Simulation of chance of scoring every 10th minute
            for(int i = 9; i > 0; i--){
                //match.amountOfChancesCreated();
                match.chanceOfScoring();
            }
            match.matchIsPlayed();
            match.informClubPerformance();
            // Add match to the league results and the table overview
            league.addMatch(match);
            /*
            System.out.println("The match has been played: ");
            System.out.println(match.getHomeName() +" "+match.getHomeGoals() + " - " + match.getAwayGoals() + " "+match.getAwayName());
            System.out.println("-------------------------------------------------");
            System.out.println(" ");*/
        }
        /*
        for(Match match : league.getResults()){
            System.out.print(match.getHomeName() + " - " + match.getAwayName());
            System.out.print(" | ");
            System.out.println(match.getScore());
        }*/
        System.out.println("-------------------------------------------------");
        // Display League table (via ClubPerformance objects)
        System.out.print("GA | ");
        System.out.print("W | ");
        System.out.print("L | ");
        System.out.print("D | ");
        System.out.print("G  | ");
        System.out.print("GA | ");
        System.out.print("Name| ");
        System.out.println("Rating| ");
        
        for(UUID cp : league.getCPList()){
            ClubPerformance CP = league.getCP(cp);
            System.out.print(CP.getGP()+ " | ");
            System.out.print(CP.getWins()+ " | ");
            System.out.print(CP.getLosses()+ " | ");
            System.out.print(CP.getDraws()+ " | ");
            System.out.print(CP.getGoals()+ " | ");
            System.out.print(CP.getGoalsAgains()+ " | ");
            System.out.print(CP.getClub().getName()+ " | ");
            System.out.println(CP.getClub().getTeamRating()+ " | ");
        }
    }
}
