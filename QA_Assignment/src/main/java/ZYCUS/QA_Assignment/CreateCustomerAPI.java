package ZYCUS.QA_Assignment;

import java.io.BufferedReader;
import java.io.IOException;

import javax.ws.rs.core.Response.Status;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCustomerAPI
{
	private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerAPI.class);
	
	private String targetUrl = "";
    private HttpClient client = null;
    HttpGet httpGet = null;
    
    public CreateCustomerAPI(HttpClient client, HttpGet httpGet) {
        this.client = client;
        this.httpGet = httpGet;
    }

    public CreateCustomerAPI(String targetUrl) {
        this.targetUrl = targetUrl;
        this.client = HttpClientBuilder.create().build();
        this.httpGet = new HttpGet(targetUrl);
    }
    
    public String getStatus() {
        BufferedReader rd = null;
        String status = "";
        try{
            LOG.debug("Requesting status: " + targetUrl);


            HttpResponse response = client.execute(httpGet);

            if(response.getStatusLine().getStatusCode() == Status.OK.getStatusCode()) {
                LOG.debug("Is online.");
                //status = String.valueOf(response.getStatusLine().getStatusCode());
                status = response.getStatusLine().getReasonPhrase();
                
            }
            else if(response.getStatusLine().getStatusCode() == Status.BAD_GATEWAY.getStatusCode()) {
            	LOG.debug("Bad Gateway.");
                //status = String.valueOf(response.getStatusLine().getStatusCode());
                status = response.getStatusLine().getReasonPhrase();
            }
            else if(response.getStatusLine().getStatusCode() == Status.ACCEPTED.getStatusCode()) {
            	LOG.debug("Bad Gateway.");
                //status = String.valueOf(response.getStatusLine().getStatusCode());
                status = response.getStatusLine().getReasonPhrase();
            }
            else if(response.getStatusLine().getStatusCode() == Status.BAD_REQUEST.getStatusCode()) {
            	LOG.debug("Bad Request.");
                //status = String.valueOf(response.getStatusLine().getStatusCode());
                status = response.getStatusLine().getReasonPhrase();
            }
            else if(response.getStatusLine().getStatusCode() == Status.NOT_FOUND.getStatusCode()) {
            	LOG.debug("Not Found.");
                //status = String.valueOf(response.getStatusLine().getStatusCode());
                status = response.getStatusLine().getReasonPhrase();
            }
            

        } catch(Exception e) {
            LOG.error("Error getting the status", e);
        } finally {
            if (rd != null) {
                try{
                    rd.close();
                } catch (IOException ioe) {
                    LOG.error("Error while closing the Buffered Reader used for reading the status", ioe);
                }
            }   
        }

        return status;
    }
}
