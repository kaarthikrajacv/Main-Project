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
        
        String[] statusCode = {"200","202","502","400","404"};
        String[] reason = {"OK","Accepted","Bad Gateway","Bad Request","Not Found"};
	
	
	 @Test
	    public void should_return_true_if_the_status_api_works_properly() throws ClientProtocolException, IOException {
	        
	    for(int i=0;i<reason.length;i++) {
		 //and:
	        when(statusLine.getStatusCode()).thenReturn(Integer.parseInt(statusCode[i]));
	        when(statusLine.getReasonPhrase()).thenReturn(reason[i]);
	        when(httpResponse.getStatusLine()).thenReturn(statusLine);
	        when(httpClient.execute(httpGet)).thenReturn(httpResponse);

	        //and:
	        CreateCustomerAPI client = new CreateCustomerAPI(httpClient, httpGet);

	        //when:
	        String status = client.getStatus();

	        //then:
	        Assert.assertEquals(status, reason[i]);
	    }
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
