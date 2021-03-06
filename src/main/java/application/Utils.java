package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Utils {
    public static List<Ayah> readData(String path) {
        List<Ayah> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine();
            reader.lines().forEach(line -> {
                String[] values = line.split(",");
                data.add(new Ayah(parseInt(values[0]), values[2], parseInt(values[3]), parseBoolean(values[4])));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<Ayah> findRuku(List<Ayah> ayaat) {
        List<Ayah> rukuat = new ArrayList<>();
        for (int i = 0; i < ayaat.size(); i++) {
            Ayah ayah = ayaat.get(i);
            if (ayah.startofRuku) {
                rukuat.add(ayah);
            }
        }
        return rukuat;
    }

    public static Ayah selectRandomStartPoint(List<Ayah> rukuat) {
        int totalRukuat = rukuat.size();
        int ruku = (int)(Math.random() * totalRukuat);
        return rukuat.get(ruku - 1);
    }
}
