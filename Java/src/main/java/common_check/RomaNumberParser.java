package common_check;

import java.util.HashMap;
import java.util.Map;

public class RomaNumberParser {
    
    Map<Character, Integer> romaCharactorMap = new HashMap<>();

    {
        romaCharactorMap.put('I', 1);
        romaCharactorMap.put('V', 5);
        romaCharactorMap.put('X', 10);
    }

    public int convertRomaNumToArabicNumber(String romaNum) {
        int count = 0;

        Character preCh = romaNum.charAt(0);
        for (int i=0; i<romaNum.length(); i++) {
            Character ch = romaNum.charAt(i);
            count += romaCharactorMap.get(ch);

            if (ch > preCh) count -= romaCharactorMap.get(preCh) * 2;
            preCh = ch;
        }

        return count;
    }
}