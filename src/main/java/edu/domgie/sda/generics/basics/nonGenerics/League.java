package edu.domgie.sda.generics.basics.nonGenerics;

import edu.domgie.sda.generics.basics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
    private String leagueName;
    private List<Team> teams;

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }
    public boolean addTeam (Team team){
        if (!teams.contains(team)){
            return  teams.add(team);
        }
        return false;
    }
    public void printTable(){
        Collections.sort(teams);
        System.out.println(leagueName+" tab: ");
        teams.forEach(x-> System.out.println(x.getName()+ ", "+x.getPoints()));
    }
}