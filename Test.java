import java.io.*;

class Test{
    // test invoking a sample tensor flow model from Java using process builder API
    public static void main(String args[]) {
        try {

            //String prg = "from __future__ import print_function\nimport tensorflow as tf\nhello = tf.constant('Hello, Tensorflow!')\nsess = tf.Session()\nprint(sess.run(hello))";
            //BufferedWriter out = new BufferedWriter(new FileWriter("test1.py"));
            //out.write(prg);
            //out.close();

            ProcessBuilder pb = new ProcessBuilder("python3", "test1.py");
            Process p = pb.start();

            //BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            //String ret = new String(in.readLine());
            //System.out.println("value is : "+ret);

            int exitCode = p.waitFor();
            System.out.println("Exit Value: " + p.exitValue());

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            System.out.println("Python file output:");
            String line;
            BufferedReader reader;
            if (exitCode != 0) {
                reader = err;
            } else {
                reader = in;
            }
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
