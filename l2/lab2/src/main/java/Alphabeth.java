import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.ChartUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Alphabeth {
    private static String[] spanish = {
            "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "Ñ", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z"};//ÑAÑAÑUR //ABCDEFGHIJKLMNÑOPQRSTUVWXYZ
    private static int[] spanishSize = {
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0,
            0, 0, 0};
    private static String[] kazach = {
            "А", "Ә", "Б", "В", "Г", "Ғ", "Д", "Е", "Ё",
            "Ж", "З", "И", "Й", "К", "Қ", "Л", "М", "Н",
            "Ң", "О", "Ө", "П", "Р", "С", "Т", "У", "Ұ",
            "Ү", "Ф", "Х", "Һ", "Ц", "Ч", "Ш", "Щ", "Ъ",
            "Ы", "І", "Ь", "Э",	"Ю", "Я"};//АӘБВГҒДЕЁЖЗИЙКҚЛМНҢОӨПРСТУҰҮФХҺЦЧШЩЪЫІЬЭЮЯ
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
            spanishSize[i] = 0;
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
            kazachSize[i] = 0;
        }
        System.out.println("Казахский подсчитан");
        return dataset;
    }

}
