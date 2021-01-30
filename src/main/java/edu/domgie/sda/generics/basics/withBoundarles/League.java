package edu.domgie.sda.generics.basics.withBoundarles;

import edu.domgie.sda.generics.basics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// klasa zawier
public class League<T extends Team> {
    private String leagueName;
    private List<T> teams;

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }
    //metoda przyjmuje druzyne dowolnego typu
    public boolean addTeam (T team){
        if (!teams.contains(team)){
            return  teams.add(team);
        }
        return false;
    }
    // nie wymusza rzutowania bo wiadomo ze pochodna jest klasy Team
    public void printTable(){
        Collections.sort(teams);
        System.out.println(leagueName+" tab: ");
        teams.forEach(x-> System.out.println(x.getName()+ ", "+x.getPoints()));
    }
}