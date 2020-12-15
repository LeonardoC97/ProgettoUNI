package com.esame.progettoprogrammazione.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.esame.progettoprogrammazione.model.ExchangeRates;
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

@RestController
@CrossOrigin
public class CurrencyLayer {
    // essential URL structure is built using constants
    public static final String ACCESS_KEY = "d1cc65e2509890e1d243c316a2498449";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";
    public static JSONObject exchangeRates = new JSONObject();
    public static ExchangeRates exchange = new ExchangeRates();
    // this object is used for executing requests to the (REST) API
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    // sendLiveRequest() function is created to request and retrieve the data
    public static ExchangeRates sendLiveRequest(String s, int x) throws JSONException, ClientProtocolException, IOException {

        // The following line initializes the HttpGet Object with the URL in order to
        // send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        // the following line converts the JSON Response to an equivalent Java Object
        exchangeRates = new JSONObject(EntityUtils.toString(entity));
        exchange.setSource(exchangeRates.getString("source"));
        exchange.setSuccess(exchangeRates.getBoolean("success"));
        exchange.setTerms(exchangeRates.getString("terms"));
        exchange.setPrivacy(exchangeRates.getString("privacy"));
        exchange.setTimestamp(exchangeRates.getString("timestamp"));
        exchange.setQuotes(exchangeRates.getJSONObject("quotes").getDouble("USD" + s)* x);
        if(x < exchange.getQuotes()){
            exchange.setControllo("Il cambio è stato vantaggioso!");
        }else if(x > exchange.getQuotes()){
            exchange.setControllo("Il cambio è stato svantaggioso!");
        }else if(x == exchange.getQuotes()){
            exchange.setControllo("Il cambio è uguale!");
        }

        return exchange;

    }

}