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
        System.out.println(span.length());
        System.out.println("Введите строку из больших символов на казахском языке");
        String kaz = in.nextLine();
        System.out.println(kaz.length());

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

        System.out.println("---\na)\nГрафики построены!");

        System.out.println("---\nб)");
        MyMath spanBin = new MyMath(Alphabeth.parseToASCII(span, 's'), Double.NaN);
        MyMath kazBin = new MyMath(Alphabeth.parseToASCII(kaz, 'k'), Double.NaN);

        System.out.format("Энтропия бинарного алфавита: %s\n", spanBin.getHa().toString());

        System.out.println("---\nв)\n(а)исходные алфавиты");
        MyMath spanMath = new MyMath(Alphabeth.getSpanishSize(), span.length(), Double.NaN, 's');
        MyMath kazMath = new MyMath(Alphabeth.getKazachSize(), kaz.length(), Double.NaN,'k');

        System.out.println("p(ошибочной передачисимвола)=0.0");
        System.out.format("Энтропия испанского алфавита, если все Р(встречи каждого символа)=const: %s\n",
                spanMath.getHa().toString()
        );
        System.out.format("Энтропия казахского алфавита, если все Р(встречи каждого символа)=const: %s\n",
                kazMath.getHa().toString()
        );
        System.out.format("Энтропия испанского алфавита, если все Р(встречи каждого символа) вычислены по входной строке: %s\n",
                spanMath.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита, если все Р(встречи каждого символа) вычислены по входной строке: %s\n",
                kazMath.getHe().toString()
        );
        System.out.format("Кол-во информации испанского алфавита: %s\n", spanMath.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита: %s\n", kazMath.getIsa().toString());
        System.out.println("(б)");
        System.out.format("Энтропия испанского алфавита в ASCII, если все Р(встречи каждого символа) вычислены по входной строке: %s\n",
                spanBin.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита в ASCII, если все Р(встречи каждого символа) вычислены по входной строке: %s\n",
                kazBin.getHe().toString()
        );
        System.out.format("Кол-во информации испанского алфавита (bin): %s\n", spanBin.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита (bin): %s\n", kazBin.getIsa().toString());

        System.out.println("---\nг)\np=0.1");

        spanBin = new MyMath(Alphabeth.parseToASCII(span, 's'), 0.1);
        kazBin = new MyMath(Alphabeth.parseToASCII(kaz, 'k'), 0.1);
        spanMath = new MyMath(Alphabeth.getSpanishSize(), span.length(), 0.1, 's');
        kazMath = new MyMath(Alphabeth.getKazachSize(), kaz.length(), 0.1,'k');
        System.out.println("(а)исходные алфавиты");
        System.out.format("Энтропия испанского алфавита: %s\n",
                spanMath.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита: %s\n",
                kazMath.getHe().toString()
        );
        System.out.format("Кол-во информации испанского алфавита: %s\n", spanMath.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита: %s\n", kazMath.getIsa().toString());
        System.out.println("(б)");
        System.out.format("Энтропия испанского алфавита в ASCII: %s\n",
                spanBin.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита в ASCII: %s\n",
                kazBin.getHe().toString()
        );
        System.out.format("Кол-во информации испанского алфавита (bin): %s\n", spanBin.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита (bin): %s\n", kazBin.getIsa().toString());

        System.out.println("\np=0.5");

        spanBin = new MyMath(Alphabeth.parseToASCII(span, 's'), 0.5);
        kazBin = new MyMath(Alphabeth.parseToASCII(kaz, 'k'), 0.5);
        spanMath = new MyMath(Alphabeth.getSpanishSize(), span.length(), 0.5, 's');
        kazMath = new MyMath(Alphabeth.getKazachSize(), kaz.length(), 0.5,'k');
        System.out.println("(а)исходные алфавиты");
        System.out.format("Энтропия испанского алфавита: %s\n",
                spanMath.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита: %s\n",
                kazMath.getHe().toString()
        );
        System.out.format("Кол-во информации испанского алфавита: %s\n", spanMath.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита: %s\n", kazMath.getIsa().toString());
        System.out.println("(б)");
        System.out.format("Энтропия испанского алфавита в ASCII: %s\n",
                spanBin.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита в ASCII: %s\n",
                kazBin.getHe().toString()
        );
        System.out.format("Кол-во информации испанского алфавита (bin): %s\n", spanBin.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита (bin): %s\n", kazBin.getIsa().toString());

        System.out.println("\np=1.0");

        spanBin = new MyMath(Alphabeth.parseToASCII(span, 's'), 0.999);
        kazBin = new MyMath(Alphabeth.parseToASCII(kaz, 'k'), 0.999);
        spanMath = new MyMath(Alphabeth.getSpanishSize(), span.length(), 0.999, 's');
        kazMath = new MyMath(Alphabeth.getKazachSize(), kaz.length(), 0.999,'k');
        System.out.println("(а)исходные алфавиты");
        System.out.format("Энтропия испанского алфавита: %s\n",
                spanMath.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита: %s\n",
                kazMath.getHe().toString()
        );
        System.out.println("(б)");
        System.out.format("Кол-во информации испанского алфавита: %s\n", spanMath.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита: %s\n", kazMath.getIsa().toString());
        System.out.format("Энтропия испанского алфавита в ASCII: %s\n",
                spanBin.getHe().toString()
        );
        System.out.format("Энтропия казахского алфавита в ASCII: %s\n",
                kazBin.getHe().toString()
        );
        System.out.format("Кол-во информации испанского алфавита (bin): %s\n", spanBin.getIsa().toString());
        System.out.format("Кол-во информации казахского алфавита (bin): %s\n", kazBin.getIsa().toString());

        Alphabeth.clearSpanishSize();
        Alphabeth.clearKazachSize();
    }
}
