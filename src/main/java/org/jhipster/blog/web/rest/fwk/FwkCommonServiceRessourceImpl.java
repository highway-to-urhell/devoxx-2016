package com.mycompany.myapp.fwkMaison;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
public class FwkCommonServiceRessourceImpl extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

        if(request.getRequestURI().contains("healthcheck")){
            String result= "{\"statusApplication\": \"OK\", \"dataBase\" : \"OK\" }";
            response.getWriter().println(result);
        }

        if(request.getRequestURI().contains("info")){
            String result= "{\"listFwk\": \"blabla\"}";
            response.getWriter().println(result);

        }
          if(request.getRequestURI().contains("logs")){
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            List<LoggerFwk> res= context.getLoggerList()
                .stream()
                .map(LoggerFwk::new)
                .collect(Collectors.toList());
            response.getWriter().write(res.toString());

        }

    }

}
