package Controller;

import org.neos.client.ResultCallback;
/* create a class that implements ResultCallback interface */
public class JobReceiver implements ResultCallback {	
   @Override
   public void handleJobInfo(int jobNo, String pass) {
      System.out.println("Job Number : " + jobNo);
      System.out.println("Password   : " + pass);
   }	
   @Override
   public void handleFinalResult(String results) {
      //System.out.println(results);
   }
}
