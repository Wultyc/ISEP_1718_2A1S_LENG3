package ampl.conn;

import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.neos.client.FileUtils;
import org.neos.client.NeosJobXml;
import org.neos.client.NeosXmlRpcClient;
import org.neos.client.ResultReceiver;

public class ExampleMainAdvanced {

    private static final String HOST = "neos-server.org";
    private static final String PORT = "3333";

    public static void main(String[] args) {

        String model = ficheiros.getModel();

        String data = ficheiros.getData();

        String run = ficheiros.getRun();

        /* create NeosXmlRpcClient object with server information */
        NeosXmlRpcClient client = new NeosXmlRpcClient(HOST, PORT);

        /* create NeosJobXml object exJob with problem type nco for nonlinearly */
        /* constrained optimization, KNITRO for the solver, GAMS for the input */
        NeosJobXml exJob = new NeosJobXml("lp", "Gurobi", "AMPL");

        /* create FileUtils object to facilitate reading model file ChemEq.txt */
        /* into a string called example */
        //FileUtils fileUtils = FileUtils.getInstance(FileUtils.APPLICATION_MODE);
        //String example = fileUtils.readFile("ChemEq.txt");
        /* add contents of string example to model field of job XML */
        
        exJob.addParam("model", model);
        exJob.addParam("data", data);
        exJob.addParam("commands", run);
        /* convert job XML to string and add it to the parameter vector */
        Vector params = new Vector();
        String jobString = exJob.toXMLString();
        params.add(jobString);

        Integer currentJob = 0;
        String currentPassword = "";
        String result = "";

        try {
            client.connect();
            /* invoke submitJob method on server and wait for response for 5000 ms */
            Object[] results = (Object[]) client.execute("submitJob", params, 5000);

            /* get returned values of job number and job password */
            currentJob = (Integer) results[0];
            currentPassword = (String) results[1];
            System.out.println("submitted" + results);

            /* initialize receiver and start output monitoring */
            JobReceiver jobReceiver = new JobReceiver();
            ResultReceiver receiver = new ResultReceiver(client, jobReceiver,
                    currentJob, currentPassword);
            receiver.run();

            System.out.println(receiver.getResult());
        } catch (XmlRpcException e) {
            System.out.println("Error submitting job :" + e.getMessage());
            return;
        }
        /* print results to standard output */
        System.out.println(result);
    }
}
