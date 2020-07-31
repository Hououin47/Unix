import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class DamArrayApp {
    private class Dam {

        private String name;
        private String fsc;
        private String level;

        public Dam(String name, String fsc, String level) {
            this.name = name;
            this.fsc = fsc;
            this.level = level;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name.trim() + " " + this.fsc.trim() + " " + this.level.trim();
        }
}
    private Dam[] dams;

    public DamArrayApp(String name) {
        String csvFile = "Dam.csv";
        String file;
        int i = 0;

        file = fixFile(csvFile);
        this.dams = processData(file);

        this.printDam(name);
    }

    public DamArrayApp() {
        String csvFile = "Dam.csv";
        String file;
        int i = 0;

        file = fixFile(csvFile);
        this.dams = processData(file);

        this.printAll();
    }

    public static void main(String[] args) {

        if (args.length < 1) {
            new DamArrayApp();
        } else {
            new DamArrayApp(args[0].trim());
        }
    }

    public String fixFile(String csvFile) {
        String line;
        String file = "";
        Scanner scan = null;
        int count = 0;
        try {
            File fileName = new File(csvFile);
            scan = new Scanner(fileName);
            scan.nextLine();
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                char arr[] = line.toCharArray();
                for (char c : arr) {
                    if (Character.compare(c, ',') == 0) {
                        count++;
                    }
                    file += c;
                }
                if (count == 45) {
                    file += "\n";
                    count = 0;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scan != null) {
                try {
                    scan.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public Dam[] processData(String file) {
        String[] lines;
        int n = 2, f = 10, p = 42;
        lines = file.split("\n");
        Dam[] dam = new Dam[lines.length];
        for (int i = 0; i < dam.length; i++) {
            String[] l = lines[i].split(",");
            dam[i] = makeDam(n, f, p, l);
        }

        return dam;
    }

    public Dam makeDam(int n, int f, int p, String[] info) {
        String name = "-";
        String fsc = "-";
        String level = "-";
        if (n > 0 && n < info.length && (info[n].length() > 0)) name = info[n];
        if (f > 0 && f < info.length && (info[f].length() > 0)) fsc = info[f];
        if (p > 0 && p < info.length && (info[p].length() > 0)) level = info[p];
        return new Dam(name, fsc, level);
    }

    public void printDam(String name) {
        int i = 0;
        String msg = "Dam not found.";
        for (i = 0; i < this.dams.length; i++) {
            if (this.dams[i].getName().contains(name)) {
                msg = this.dams[i].toString();
                break;
            }
        }
        System.out.println(msg);
    }

    public void printAll() {
        for (int i = 0; i < this.dams.length; i++) {
            System.out.println(this.dams[i]);
        }
    }
}
