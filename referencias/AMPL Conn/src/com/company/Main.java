package com.company;
import org.neos.client.*;
public class Main {

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
