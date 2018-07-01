package ZYCUS.QA_Assignment;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class TestCreateCustomerAPI extends Mockito{
	
	//given:
		HttpClient httpClient = mock(HttpClient.class);
        HttpGet httpGet = mock(HttpGet.class);
        HttpResponse httpResponse = mock(HttpResponse.class);
        StatusLine statusLine = mock(StatusLine.class);
	
	
	 @Test
	    public void should_return_true_if_the_status_api_works_properly() throws ClientProtocolException, IOException {
	        
	        //and:
	        when(statusLine.getStatusCode()).thenReturn(200);
	        when(statusLine.getReasonPhrase()).thenReturn("OK");
	        when(httpResponse.getStatusLine()).thenReturn(statusLine);
	        when(httpClient.execute(httpGet)).thenReturn(httpResponse);

	        //and:
	        CreateCustomerAPI client = new CreateCustomerAPI(httpClient, httpGet);

	        //when:
	        String status = client.getStatus();

	        //then:
	        Assert.assertEquals(status, "OK");
	    }
	 
	 @Test
	    public void should_return_false_if_status_api_do_not_respond() throws ClientProtocolException, IOException {
	        //given:
	        
	        //and:
	        when(httpClient.execute(httpGet)).thenThrow(HttpHostConnectException.class);

	        //and:
	        CreateCustomerAPI client = new CreateCustomerAPI(httpClient, httpGet);

	        //when:
	        String status = client.getStatus();

	        //then:
	        Assert.assertEquals(status, "");
	        
	    }
    
}
