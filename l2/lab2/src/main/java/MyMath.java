public class MyMath {

    private Double Ha;
    private Double Ia;
    private Double Isa;
    private Double He;

    public MyMath(int[] p, int length, Double err, char lang){
        int tempSize = lang=='k'? 42 : 27;
        Ha = Math.log(tempSize)/Math.log(2);
        Ia = length * Ha;
        double Hxy = 0;
        for (int i: p) {
            if (i != 0)
                Hxy -= ((double)i/(double)length)*(Math.log((double)i/(double)length)/Math.log(2));
        }
        He = err.isNaN()? Hxy : 1 - (0-((err)*(Math.log(err)/Math.log(2)))-((1-err)*(Math.log(1-err)/Math.log(2))));
        Isa = He * length;
    }

    public MyMath(String bin, Double err){
        int ones = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i)=='1') ++ones;
        }
        int zeros = bin.length() - ones;
        int tempSize = 2;
        Ha = Math.log(tempSize)/Math.log(2);
        Ia = bin.length() * Ha;
        double Hxy = 0.000;
        if ((ones != 0)&&(zeros != 0)) {
            Hxy -= ((double) ones / (double) bin.length()) * (Math.log((double) ones / (double) bin.length()) / Math.log(2));
            Hxy -= ((double) zeros / (double) bin.length()) * (Math.log((double) zeros / (double) bin.length()) / Math.log(2));
        } else {
            Hxy = 1.000;
        }
        He = err.isNaN()? Hxy : 1 - (0.000-((err)*(Math.log(err)/Math.log(2)))-((1.000-err)*(Math.log(1-err)/Math.log(2))));
        Isa = He * bin.length();
    }

    public void setIsa(Double err, int len) {
        Double NHe = 1 - (0.000-((err)*(Math.log(err)/Math.log(2)))-((1.000-err)*(Math.log(1-err)/Math.log(2))));
        Isa = NHe.isNaN()? 0.0 : NHe * len;
    }
    public void setBinIsa(Double err, int len) {
        double NHe = err == 0.999? He - (0.000-((err)*(Math.log(err)/Math.log(2)))-((1.000-err)*(Math.log(1-err)/Math.log(2)))) : 1 - (0.000-((err)*(Math.log(err)/Math.log(2)))-((1.000-err)*(Math.log(1-err)/Math.log(2))));
        Isa = NHe * len;
    }

    public Double getHa() {
        return Ha;
    }
    public Double getIa() {
        return Ia;
    }
    public Double getIsa() {
        return Isa;
    }
    public Double getHe() {
        return He;
    }
}
