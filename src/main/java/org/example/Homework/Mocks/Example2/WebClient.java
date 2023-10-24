package org.example.Homework.Mocks.Example2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient {

    public String getContent(ConnectionFactory connectionFactory) {
        String workingContent;
        StringBuffer content = new StringBuffer();

        try(InputStream is=connectionFactory.getData()) {


            int count;
            //read all the content that is received
            while (-1 != (count = is.read())) {
                content.append(new String(Character.toChars(count)));
            }
            workingContent=content.toString();
        } catch (Exception e) {
            //if an error occurs, return null.
            workingContent=null;
        }

        return workingContent;
    }
}
