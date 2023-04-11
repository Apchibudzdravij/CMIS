import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку из больших символов на испанском языке");
        String span = in.nextLine();
        System.out.println("Введите строку из больших символов на казахском языке");
        String kaz = in.nextLine();

        JFreeChart spanChart = ChartFactory.createBarChart(
                "Количество появлений каждого символа",
                "Символ","Количество вхождений",
                Alphabeth.setSpanishPieDataset(span),
                PlotOrientation.VERTICAL,
                true,true,false);
        JFreeChart kazChart = ChartFactory.createBarChart(
                "Количество появлений каждого символа",
                "Символ","Количество вхождений",
                Alphabeth.setKazachPieDataset(kaz),
                PlotOrientation.VERTICAL,
                true,true,false);
        try{
            ChartUtils.saveChartAsJPEG(
                    new File("D:\\ExtendedData\\Laboratory\\CMIS\\l2\\spanish.JPEG"),
                    spanChart, 2000, 1000
            );
            ChartUtils.saveChartAsJPEG(
                    new File("D:\\ExtendedData\\Laboratory\\CMIS\\l2\\kazach.JPEG"),
                    kazChart, 2000, 1000
            );
        } catch (
                IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
