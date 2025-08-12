package Languages;



public enum LanguageType {
    EN(1, "EN"),
    BG(2, "BG");



    private final   Integer value;
    private final   String  langs;



    LanguageType(Integer value, String langs) {
        this.value  =   value;
        this.langs  =   langs;
    }



    public Integer  getValue    ()  { return this.value;    }
    public String   getLangs    ()  { return this.langs;    }



    public static LanguageType fromValue(Integer value) {
        return LanguageType.values()[value - 1];
    }


    public static LanguageType fromLangs(String langs) {
        return LanguageType.valueOf(langs.toUpperCase());
    }
}
