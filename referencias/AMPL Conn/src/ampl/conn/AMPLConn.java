/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ampl.conn;

import org.neos.client.NeosClient;
import org.neos.client.NeosJob;
import org.neos.client.NeosJobXml;

/**
 *
 * @author Aluno
 */
public class AMPLConn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Connect to server */
        NeosClient client = new NeosClient("https://neos-server.org", "3333");

        /* Create job XML */
        NeosJobXml ncoJob = new NeosJobXml("nco", "MINOS", "GAMS");
        ncoJob.addParam("model", "combinedModel");

        /* Submit job to NEOS */
        NeosJob job = client.submitJob(ncoJob.toXMLString());

        /* Print result */
        System.out.println(job.getResult());
    }
    
}
