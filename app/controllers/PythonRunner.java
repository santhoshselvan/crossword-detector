package controllers;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



// run this way

// javac JavaRunCommand.java

// java -classpath . JavaRunCommand



public class PythonRunner {


    public static void main ( String[] args ){

        runScriptWithArguments( "/Users/tsanthosh/tmp/detect_shapes.py", "/Users/tsanthosh/tmp/cross.jpg");
    }

    public static String runScriptWithArguments(String scriptPath, String... args) {



        String st = null;


        StringBuilder output = new StringBuilder();

        try {



            String[] invokePythonCommand = {   "python",scriptPath};
            String[] command = (String[]) ArrayUtils.addAll(invokePythonCommand, args);


            ProcessBuilder pb = new ProcessBuilder( command );
            pb.environment().put("PYTHONPATH", "/usr/local/lib/python2.7/site-packages:$PYTHONPATH");

            Process p = pb.start();

            BufferedReader stdInput = new BufferedReader( new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));



            // read the output
            String s;
            while ((s = stdInput.readLine()) != null) {

                output.append( s );

            }






        }

        catch (IOException e) {

                System.out.println("exception occured");

                        e.printStackTrace();

                System.exit(-1);

            }



        return output.toString();

        }

    }