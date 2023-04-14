import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.ChartUtils;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Alphabeth {
    private static String[] spanish = {
            "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "Ñ", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z"};//DREVOTEÑEUGENEVLADIMIROVICH //ABCDEFGHIJKLMNÑOPQRSTUVWXYZ
    private static String[] spanishASCII = {
            "01000001", "01000010", "01000011", "01000100", "01000101", "01000110",
            "01000111", "01001000", "01001001", "01001010", "01001011", "01001100",
            "01001101", "01001110", "10100101" ,"01001111", "01010000", "01010001",
            "01010010", "01010011", "01010100", "01010101", "01010110", "01010111",
            "01011000", "01011001", "01011010"};
    private static int[] spanishSize = {
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0};
    private static String[] kazach = {
            "А", "Ә", "Б", "В", "Г", "Ғ",
            "Д", "Е", "Ё", "Ж", "З", "И",
            "Й", "К", "Қ", "Л", "М", "Н",
            "Ң", "О", "Ө", "П", "Р", "С",
            "Т", "У", "Ұ", "Ү", "Ф", "Х",
            "Һ", "Ц", "Ч", "Ш", "Щ", "Ъ",
            "Ы", "І", "Ь", "Э",	"Ю", "Я"};//ДРЕВОЕНЬЕВГЕНИВЛАДІМІРОВІЧ //АӘБВГҒДЕЁЖЗИЙКҚЛМНҢОӨПРСТУҰҮФХҺЦЧШЩЪЫІЬЭЮЯ
    private static String[] kazachASCII = {
            "010000010000", "010011011000", "010000010001", "010000010010", "010000010011", "010010010010",
            "010000010100", "010000010101", "010000010110", "010000010111", "010000011000", "010000011001",
            "010000011010", "010000011011", "010010011010", "010000011100", "010000011101", "010000011110",
            "010010100010", "010000011111", "010011101000", "010000100000", "010000100001", "010000100010",
            "010000100011", "010000100100", "010010110000", "010000100101", "010000100110", "010000100111",
            "010010111010", "010000101000", "010000101001", "010000101010", "010000101011", "010000101100",
            "010000101101", "010000000110", "010000101110", "010000101111",	"010000000001", "010000110001"};
    private static int[] kazachSize = {
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0};
    private static String[] binary = {"0", "1"};
    private static int[] binarySize = {0, 0};

    public static DefaultCategoryDataset setSpanishPieDataset(String span){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < span.length(); ++i) {
            int tempChar = Arrays.asList(spanish).indexOf(span.substring(i, i+1));
            ++spanishSize[tempChar];
        }
        for (int i =0; i < spanish.length; ++i) {
            dataset.addValue(spanishSize[i], spanish[i], "1");
        }
        System.out.println("Испанский подсчитан");
        return dataset;
    }
    public static DefaultCategoryDataset setKazachPieDataset(String kaz){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < kaz.length(); ++i) {
            int tempChar = Arrays.asList(kazach).indexOf(kaz.substring(i, i+1));
            ++kazachSize[tempChar];
        }
        for (int i =0; i < kazach.length; ++i) {
            dataset.addValue(kazachSize[i], kazach[i], "1");
        }
        System.out.println("Казахский подсчитан");
        return dataset;
    }

    public static String parseToASCII(String input, char lang){
        String answer = "";
        switch (lang){
            case 'k':
                for (int i=0; i< input.length(); ++i){
                    answer += kazachASCII[Arrays.asList(kazach).indexOf(input.substring(i, i+1))];
                }
                break;
            case 's':
                for (int i=0; i< input.length(); ++i){
                    answer += spanishASCII[Arrays.asList(spanish).indexOf(input.substring(i, i+1))];
                }
                break;
            default:
                System.err.println("ERROR: Unknown language!");
                break;
        }
        return answer;
    }

    public static void clearSpanishSize(){
        for (int i =0; i < spanish.length; ++i) {
            spanishSize[i] = 0;
        }
    }

    public static void clearKazachSize(){
        for (int i =0; i < kazach.length; ++i) {
            kazachSize[i] = 0;
        }
    }

    public static int[] getSpanishSize() {
        return spanishSize;
    }

    public static int[] getKazachSize() {
        return kazachSize;
    }
}
