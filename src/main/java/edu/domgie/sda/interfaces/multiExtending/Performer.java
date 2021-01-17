package edu.domgie.sda.interfaces.multiExtending;

/**
 * interfejs w przeciwenstwie do klasu
 * moze rozszerzac wiecej niz jeden interfejs
 */
public interface Performer extends Worker, Trainer,Student{
    void perform();
}
