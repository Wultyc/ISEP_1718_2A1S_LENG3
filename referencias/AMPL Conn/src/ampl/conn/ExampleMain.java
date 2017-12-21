package ampl.conn;

import org.neos.client.FileUtils;
import org.neos.client.NeosClient;
import org.neos.client.NeosJobXml;
import org.neos.client.NeosJob;

public class ExampleMain {
    /* set the HOST and the PORT fields of the NEOS XML-RPC server */

    private static final String HOST = "neos-server.org";
    private static final String PORT = "3333";

    public static void main(String[] args) {
        
        String model = ficheiros.getModel();

        String data = ficheiros.getData();

        String run = ficheiros.getRun();
        
        /* create NeosClient object client with server information */
        NeosClient client = new NeosClient(HOST, PORT);

        /* create NeosJobXml object exJob with problem type nco for nonlinearly */
        /* constrained optimization, KNITRO for the solver, GAMS for the input */
        //NeosJobXml exJob = new NeosJobXml("lp", "Gurobi", "AMPL");
        NeosJobXml exJob = new NeosJobXml("lp", "CPLEX", "AMPL");


        /* create FileUtils object to facilitate reading model file ChemEq.txt */
        /* into a string called example */
        //FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        //String example = fileUtils.readFile("ChemEq.txt");
        /* add contents of string example to model field of job XML */
        exJob.addParam("model", model);
        exJob.addParam("data", data);
        exJob.addParam("commands", run);

        /* call submitJob() method with string representation of job XML */
        NeosJob job = client.submitJob(exJob.toXMLString());
        /* print results to standard output */
        System.out.println(job.getResult());
    }
}
