package edu.domgie.sda.homework2;

public enum TypeOfAccount {
    PERSONAL_ACCOUNT("PN"),
    SAVINGS_ACCOUNT("SN");

    private String shortCut;


    TypeOfAccount(String shortCut){
        this.shortCut=shortCut;
    }
    public String getShortCut(){
        return shortCut;
    }
    public static TypeOfAccount getByShortcut(String shortcut){
        for (TypeOfAccount type: TypeOfAccount.values()){
            if (shortcut.equals(type.getShortCut())){
                return  type;
            }
        }
        return  null;
    }
}
