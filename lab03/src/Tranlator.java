import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tranlator {
    private HashMap<String, ArrayList<TranslateUnit>> dictionary = new HashMap<>();

    private ArrayList<TranslateUnit> currentUnits = null;
    private TranslateUnit lastFullMatch = null;
    private String fullInput = "";

    private ArrayList<TranslateUnit> getTranslationUnits(String input) {
        return dictionary.get(input.toLowerCase().substring(0, 1));
    }

    private ArrayList<TranslateUnit> getRefinedTranslationUnits(String input, ArrayList<TranslateUnit> units) {
        ArrayList<TranslateUnit> result = null;

        for (TranslateUnit unit: units) {
            if (unit.match(input)) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(unit);
            }
        }
        
        return result;
    }

    private void translateRound(String input, PrintStream outStream) {
        fullInput = (fullInput + " " + input).trim();

        if (currentUnits == null) {
            currentUnits = getTranslationUnits(fullInput);
        } else {
            currentUnits = getRefinedTranslationUnits(fullInput, currentUnits);
        }

        if (currentUnits == null) {
            if (lastFullMatch == null) {
                outStream.print(" " + fullInput);
                fullInput = "";
            } else {
                outStream.print(" " + lastFullMatch.getToText());
                lastFullMatch = null;
                fullInput = input;
                translateRound("", outStream);
            }
        } else {
            for (TranslateUnit unit : currentUnits) {
                if (unit.fullMatch(fullInput)) {
                    lastFullMatch = unit;
                }
            }
        }
    }

    public void load(String filepath) throws IOException {
        dictionary.clear();

        FileReader fileReader = new FileReader(filepath);
        Scanner scanner = new Scanner(fileReader);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            int indexOfSeparator = line.indexOf('|');
            if (indexOfSeparator == -1) {
                continue;
            }

            String fromText = line.substring(0, indexOfSeparator);
            String toText = line.substring(indexOfSeparator + 1);
            String key = fromText.substring(0, 1).toLowerCase();

            ArrayList<TranslateUnit> units = dictionary.get(key);

            if (units == null) {
                units = new ArrayList<>();
            }

            units.add(new TranslateUnit(fromText, toText));

            dictionary.put(fromText.substring(0, 1).toLowerCase(), units);
        }

    }

    public void translate(String filepath, PrintStream outStream) throws IOException {
        FileReader fileReader = new FileReader(filepath);
        Scanner scanner = new Scanner(fileReader);

        while (scanner.hasNext()) {
            translateRound(scanner.next(), outStream);
        }

        if (lastFullMatch == null) {
            outStream.print(" " + fullInput);
        } else {
            outStream.print(" " + lastFullMatch.getToText());
        }
    }

}
