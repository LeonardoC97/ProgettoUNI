package com.esame.progettoprogrammazione.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;



@RestController
@CrossOrigin
public class CurrencyLayer {

    // essential URL structure is built using constants 
    public static final String ACCESS_KEY = "d1cc65e2509890e1d243c316a2498449";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";
   
    // this object is used for executing requests to the (REST) API
    static CloseableHttpClient httpClient = HttpClients.createDefault();
    
    /**
     * 
     * Notes:<br><br>
     * 
     * A JSON response of the form {"key":"value"} is considered a simple Java JSONObject.<br>
     * To get a simple value from the JSONObject, use: <JSONObject identifier>.get<Type>("key");<br>
     * 
     * A JSON response of the form {"key":{"key":"value"}} is considered a complex Java JSONObject.<br>
     * To get a complex value like another JSONObject, use: <JSONObject identifier>.getJSONObject("key")
     * 
     * Values can also be JSONArray Objects. JSONArray objects are simple, consisting of multiple JSONObject Objects.
     * 
     * 
     */
    
    // sendLiveRequest() function is created to request and retrieve the data


    public static void sendLiveRequest(){
        
        
        
        
        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        
        try {

                
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();
           
            // the following line converts the JSON Response to an equivalent Java Object
            
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
            
            System.out.println("Live Currency Exchange Rates");
            
           // Parsed JSON Objects are accessed according to the JSON response's hierarchy, output strings are built
           Date timeStampDate = new Date(); 
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
           String formattedDate = dateFormat.format(timeStampDate);
           System.out.println("1 " + exchangeRates.getString("source") + " in GBP : " + exchangeRates.getJSONObject("quotes").getDouble("USDGBP") + " (Date: " + formattedDate + ")");   
           System.out.println("\n");
           response.close();
        }
        catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
     
    }
    
     
    }