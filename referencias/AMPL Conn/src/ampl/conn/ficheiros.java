/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ampl.conn;

import org.neos.client.FileUtils;

public class ficheiros {

    public static String getModel() {
        FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        String mod = fileUtils.readFile("ex1.mod");
        return mod;
    }

    public static String getData() {
        FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        String data = fileUtils.readFile("ex1.dat");
        return data;
    }

    public static String getRun() {
        FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        String run = fileUtils.readFile("ex1.run");
        return run;
    }
}
