package com.saurabhpatil;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**How spring boot autoconfigure works
 *
 *
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) throws LifecycleException {
        //System.out.println("Hello");
        Tomcat tomcat=new Tomcat();
        Context context=tomcat.addContext("",null);
        Tomcat.addServlet(context,"helloServlet",new HelloServlet());
        context.addServletMappingDecoded("/","helloServlet");
        tomcat.setPort(8080);
        tomcat.start();
        new Thread( ()->tomcat.getServer().await()).start();
    }

}
