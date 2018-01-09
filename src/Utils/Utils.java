/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neos.client.FileUtils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Utils {

    static public String readLineFromConsole(String strPrompt) {
        try {
            System.out.print(strPrompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public int readIntFromConsole(String strPrompt) {
        try {
            System.out.print(strPrompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return Integer.parseInt(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    static public boolean readConfirmationFromConsole(String strPrompt) {
        String resposta;
        try {
            System.out.print(strPrompt + "[N->Não / S->Sim]");

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            resposta = in.readLine();

            if (resposta.equalsIgnoreCase("S")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static public Date readDateFromConsole(String strPrompt) {
        do {
            try {
                String strDate = readLineFromConsole(strPrompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    static public void imprimeSeparador() {
        String s = "";
        int tamanho = 80, i = 0;
        for (i = 0; i < tamanho; i++) {
            s += "=";
        }
        System.out.println(s);
    }

    public static String loadTextFile(String filename) {
        FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        String mod = fileUtils.readFile(filename);
        String normalized_mod = Normalizer.normalize(mod, Normalizer.Form.NFD);
        return normalized_mod;
    }
}
