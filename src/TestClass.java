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
        Factory PF = new Factory();
        
        // Superligaen
        
        PF.registerClub("AGF", 1905);
        PF.registerClub("Aab", 1920);
        PF.registerClub("FCK", 1925);
        PF.registerClub("FCM", 1932);
        PF.registerClub("SØN", 1902);
        PF.registerClub("OB ", 1805);
        PF.registerClub("RFC", 1940);
        PF.registerClub("FCN", 1920);
        PF.registerClub("BIF", 1900);
        PF.registerClub("EfB", 1920);
        PF.registerClub("VFF", 1926);
        PF.registerClub("HIK", 1883);
        
        int XIplayersForEachClub = 11 * PF.getAllClubs().size();
        int OneManagerForEachClub = PF.getAllClubs().size();
        
        PF.generatePersons(XIplayersForEachClub, Factory.PersonType.PLAYER);
        PF.generatePersons(OneManagerForEachClub, Factory.PersonType.MANAGER);
        
        /** Displaying clubs, players, their stats and manager. */
        /*
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
        
        /** Displaying the favourite team(s) to win and the expected team to relegated */
            int best = 0;
            String strBest = "";
            int worst = 500;
            String strWorst = "";
        for(Club c : PF.getAllClubs()){
            if(c.getTeamRating() > best){
                best = c.getTeamRating();
                strBest = c.getName();
            }
            if(c.getTeamRating() < worst){
                worst = c.getTeamRating();
                strWorst = c.getName();
            }
        }
        System.out.println("The favourite to win the league is " + strBest + " with a rating of "+ best);
        System.out.println("The favourite to be relegated is " + strWorst + " with a rating of "+ worst);
        
        /** Simulating seasons. */
        runSeasons(10, PF);
        
    }
    
    public static void displaySeason(Factory PF){
        
        League league = PF.getSeason();
        System.out.println("This is season number "+ (Factory.seasonCount+1));
        System.out.println("");
        //Every club plays each other twice - one home and one away.
            for(int home = 0; home < PF.getAllClubs().size(); home++){
                    for(int away = 0; away < PF.getAllClubs().size(); away++){
                        if(home != away){
                            Match match = new Match(PF.getAllClubs().get(home), PF.getAllClubs().get(away));
                    /*
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
                            //System.out.println(match.getHomeName() + " vs. " + match.getAwayName() + " in round " + j);
                            // Add match to the league results and the table overview
                            league.addMatch(match);
                        /*
                        System.out.println("The match has been played: ");
                        System.out.println(match.getHomeName() +" "+match.getHomeGoals() + " - " + match.getAwayGoals() + " "+match.getAwayName());
                        System.out.println("-------------------------------------------------");
                        System.out.println(" ");*/
                        }
                    }
            }
        
        System.out.println("-------------------------------------------------");
        // Display League table (via ClubPerformance objects)
        System.out.print("GA | ");
        System.out.print("P  | ");
        System.out.print("W  | ");
        System.out.print(" L | ");
        System.out.print(" D | ");
        System.out.print(" G | ");
        System.out.print("GA | ");
        System.out.print("Name| ");
        System.out.print("Rating| ");
        System.out.println("Morale| ");
        
        // Making an arrayList of ClubPerformances
        ArrayList<ClubPerformance> list = new ArrayList<>();
        for(UUID id : league.getCPList()){
            ClubPerformance CP = league.getCP(id);
            list.add(CP);
        }
        // Sorting the list after most points
        list = league.getSortedPlayerList(list);
        // Displaying the list
        for(ClubPerformance CP : list){
            System.out.print(CP.getGP()+ " | ");
            System.out.print(CP.getPoints()+ " | ");
            if(CP.getWins() > 9){System.out.print(CP.getWins()+ " | ");} else { System.out.print(" "+CP.getWins()+ " | ");}
            if(CP.getLosses() > 9){System.out.print(CP.getLosses()+ " | ");} else { System.out.print(" "+CP.getLosses()+ " | ");}
            if(CP.getDraws() > 9){System.out.print(CP.getDraws()+ " | ");} else { System.out.print(" "+CP.getDraws()+ " | ");}
            System.out.print(CP.getGoals()+ " | ");
            System.out.print(CP.getGoalsAgains()+ " | ");
            System.out.print(CP.getClub().getName()+ " | ");
            System.out.print(CP.getClub().getTeamRating()+ " | ");
            System.out.println(Math.round(CP.getClub().getTeamRatingWithMorale())+ " | ");
        }
        
        // Morale of player from the club at the top of the table.
        UUID id2 = list.get(0).getClub().getPlayers().get(0);
        Player p2 = (Player) list.get(list.size()-1).getClub().getPersonByID(id2);
        System.out.println(p2.getName() + " has a morale at: " +p2.getMorale());
        
        // Morale of player from the club at the middle of the table.
        UUID id3 = list.get(5).getClub().getPlayers().get(0);
        Player p3 = (Player) list.get(list.size()-1).getClub().getPersonByID(id3);
        System.out.println(p3.getName() + " has a morale at: " +p3.getMorale());
        
        // Morale of player from the club at the bottom of the table.
        UUID id = list.get(list.size()-1).getClub().getPlayers().get(0);
        Player p = (Player) list.get(list.size()-1).getClub().getPersonByID(id);
        System.out.println(p.getName() + " has a morale at: " +p.getMorale());
        
        System.out.println("                                              ");
        System.out.println("----------------------------------------------");
        System.out.println("                                              ");
           
        
    }
    
    public static void runSeasons(int a, Factory PF){
        for(int i = 0; i < a; i++){
            displaySeason(PF);
            PF.newSeason();
        }
    }
}
