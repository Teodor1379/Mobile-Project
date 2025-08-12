package Languages;



import java.util.Map    ;
import java.util.HashMap;

import java.io.FileReader       ;
import java.io.BufferedReader   ;
import java.io.IOException      ;



public class LanguageTranslator {
    private final Map<String, String> map;



    public LanguageTranslator() {
        this.map = new HashMap<>();
    }



    public String getMessage(String key) {
        return map.get(key);
    }



    public void changeLanguage(Integer value) {
        this.map.clear();

        this.readLanguage(LanguageType.fromValue(value));
    }



    private void readLanguage(LanguageType type) {
        String file = String.format("src/Resources/LanguagePack_%s.txt", type.name().toUpperCase());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(line -> {
                String[] args = line.split("=");

                if (args.length == 2) {
                    this.map.put(args[0], args[1]);
                }
            });
        } catch (IOException exception) {
            System.err.println("Error while reading language file for " + type + "!");
        }
    }
}
