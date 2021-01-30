package edu.domgie.sda.generics.basics.fullGeneric;

import edu.domgie.sda.generics.basics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// klasa zawier
public class League<T> {
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
    // metoda wymusz rzutowanie typu generycznego - NIE OK
    // metoda nie nadaje sie do klasy generycznej
    public void printTable(){
        //musimy rzutowac bo kompilator nie wie
        //czy typ T da sie sortowac, a klasa
        //Team implementuje Comparable wiec wiadomo
        //ze sie uda
        Collections.sort((List<Team>)teams);
        System.out.println(leagueName+" tab: ");
        //analogicznie poniżej, typ T  nie koniecznie ma metody
        //getName, getPoints, dlatego trzeba okreslic to rpzed kompilacja
        teams.forEach(x-> System.out.println(((Team )x).getName()+ ", "+((Team) x).getPoints()));
    }
}