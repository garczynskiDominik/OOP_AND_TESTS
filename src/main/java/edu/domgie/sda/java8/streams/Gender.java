package edu.domgie.sda.java8.streams;

public enum Gender {
   WOMAN (1,"K","W", "kobieta"),
    MAN(2,"M","M", "mezczyzna");

   private int index;
   private String shortcutPl;
   private String shortcutEn;
   private String translationPl;

    Gender(int index, String shortcutPl, String shortcutEn, String translationPl) {
        this.index = index;
        this.shortcutPl = shortcutPl;
        this.shortcutEn = shortcutEn;
        this.translationPl = translationPl;
    }


    public int getIndex() {
        return index;
    }

    public String getShortcutPl() {
        return shortcutPl;
    }

    public String getShortcutEn() {
        return shortcutEn;
    }

    public String getTranslationPl() {
        return translationPl;
    }
    // znajdziemy plec na podstawie przekazanego skrotu
    //czyli do metody przekażemy "M" a zworci nam element Man


    public static  Gender getByShortcutPl(String shortcutPL){
        for (Gender gender : Gender.values()){
            if (shortcutPL.equals(gender.getShortcutPl())){
                return  gender;
            }
        }
        return  null;

    }
}
