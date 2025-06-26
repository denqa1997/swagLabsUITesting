package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommonActions {


    public static void clearDirectories() {
        List<String> directoriesForClear = new ArrayList<>();
        directoriesForClear.add(0, "build/reports/tests");
        directoriesForClear.add(1, "build/downloads");
        for (String directory : directoriesForClear) {
            for (File myFile : new File(directory).listFiles())
                if (myFile.isFile()) myFile.delete();
        }
    }
}
