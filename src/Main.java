import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
            "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
            "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
            "mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = getFrequencyMap();

        Map<String, Integer> maxMinMap = getMaxMin(map);
        int maxValue = maxMinMap.get("max");
        int minValue = maxMinMap.get("min");

        Map<String, String> maxMinChars = getMaxMinChars(maxMinMap, map);
        String maxChars = maxMinChars.get("max");
        String minChars = maxMinChars.get("min");

        System.out.println("Чаще всего встречаются символы \"" + maxChars + "\" (" + maxValue + " раз)");
        System.out.println("Реже всего встречаются символы \"" + minChars + "\" (" + minValue + " раз)");
    }

    public static Map<Character, Integer> getFrequencyMap() {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map;
    }

    public static Map<String, Integer> getMaxMin(Map<Character, Integer> map) {
        int maxValue = -1;
        int minValue = Integer.MAX_VALUE;

        for (Integer value : map.values()) {
            maxValue = value > maxValue ? value : maxValue;
            minValue = value < minValue ? value : minValue;
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("max", maxValue);
        result.put("min", minValue);

        return result;
    }

    public static Map<String, String> getMaxMinChars(Map<String, Integer> maxMinMap, Map<Character, Integer> map) {
        String maxChars = "";
        String minChars = "";
        int maxValue = maxMinMap.get("max");
        int minValue = maxMinMap.get("min");

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            if (maxValue == value) {
                maxChars += (maxChars.isEmpty() ? "" : ", ") + entry.getKey();
            }
            if (minValue == value) {
                minChars += (minChars.isEmpty() ? "" : ", ") + entry.getKey();
            }
        }

        Map<String, String> result = new HashMap<>();
        result.put("max", maxChars);
        result.put("min", minChars);

        return result;
    }
}