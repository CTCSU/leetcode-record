import java.util.ArrayList;
import java.util.List;

public class Util {
    public static int getMin(int... value) {
        if (value.length == 0) {
            return 0;
        }
        int min = value[0];
        for (int i = 0; i < value.length; i++) {
            if (min > value[i]) {
                min = value[i];
            }
        }

        return min;

    }

    public static int getMax(int... value) {
        if (value.length == 0) {
            return 0;
        }
        int max = value[0];
        for (int i = 0; i < value.length; i++) {
            if (max < value[i]) {
                max = value[i];
            }
        }

        return max;

    }

    public static <T> void printTwoDimensions(T[][] arrays) {
        for (T[] is : arrays) {
            System.out.println();
            for (T value : is) {
                System.out.print(" " + value);
            }
        }
    }

    public static List<List<String>> readTwoArrayFromString(String s) {
        List<List<String>> stringLists = new ArrayList<List<String>>();

        List<String> currentList = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        int bracketCount = 0;
        boolean leftComma = false;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            switch (a) {
                case '[':
                    if (bracketCount == 1) {
                        currentList = new ArrayList<>();
                        stringLists.add(currentList);
                    }
                    bracketCount++;
                    break;
                case ']':
                    bracketCount--;
                    break;
                case '\"':
                    if (leftComma) {
                        currentList.add(builder.toString());
                        leftComma = false;
                    } else {
                        builder = new StringBuilder();
                        leftComma = true;
                    }
                    break;
                case ' ':
                case ',':
                    if (!leftComma) {
                        break;
                    }
                default:
                    if (leftComma) {
                        builder.append(a);
                    } else {
                        throw new IllegalArgumentException(
                                String.format("Invalid character, character index is %d, character is %s", i, a), null);
                    }
            }

        }

        return stringLists;
    }

    public static String[][] convert2DimensionArray(List<List<String>> lists) {
        int m = lists.size();
        int n = lists.get(0).size();
        String[][] results = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                results[i][j] = lists.get(i).get(j);
            }
        }

        return results;
    }

    public static String[][] readFromStringAs2DArray(String s) {
        return convert2DimensionArray(readTwoArrayFromString(s));
    }
}
