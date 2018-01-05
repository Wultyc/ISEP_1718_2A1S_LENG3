/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ampl.conn;

import java.text.Normalizer;
import org.neos.client.FileUtils;

public class ficheiros {

    public static String getModel() {
        FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        String mod = fileUtils.readFile("LENG3.mod");
        String normalized_mod = Normalizer.normalize(mod, Normalizer.Form.NFD);
        return normalized_mod;
    }

    public static String getData() {
        FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        String data = fileUtils.readFile("LENG3.dat");
        String normalized_data = Normalizer.normalize(data, Normalizer.Form.NFD);
        return normalized_data;
    }

    public static String getRun() {
        FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        String run = fileUtils.readFile("LENG3.run");
        String normalized_run = Normalizer.normalize(run, Normalizer.Form.NFD);
        return normalized_run;
    }
}
