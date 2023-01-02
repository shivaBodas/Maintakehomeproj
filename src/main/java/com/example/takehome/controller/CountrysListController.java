package com.example.takehome.controller;


import com.example.takehome.model.Continent;
import com.example.takehome.model.ContinetOutput;
import com.example.takehome.model.CountryIn;
import com.example.takehome.model.CountrysListEntity;
import com.example.takehome.model.Output;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Component
@RestController
@Slf4j
public class CountrysListController {

    private CountrysListEntity parsedResponse;
    private String url = "https://countries.trevorblades.com/graphql/";
    private ContinetOutput continetOutput = null;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getCountryCodesList/{countryCodes}", produces = "application/json")
    public ContinetOutput getCountryList(@PathVariable List<String> countryCodes) throws URISyntaxException, IOException {
        log.info(String.valueOf(countryCodes));
        Output output = new Output();
        for (String code : countryCodes) {
            output.getCountrys().add(code.substring(1, code.length() - 1));
            String query = "query{\n" +
                    "  country(code :" + code + ") {\n" +
                    "    name\n" +
                    "    continent{\n" +
                    "      name\n" +
                    "      countries{\n" +
                    "        name\n" +
                    "        code\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
            HttpResponse httpResponse = callGraphQLService(url, query);
            log.warn(String.valueOf(httpResponse));
            HttpEntity entity = httpResponse.getEntity();

            String content = EntityUtils.toString(entity);
            parsedResponse = new ObjectMapper().readValue(content, CountrysListEntity.class);
            output.setName(parsedResponse.getData().getCountry().getContinent().getName());
            for (CountryIn othCode : parsedResponse.getData().getCountry().getContinent().getCountries()) {
                if(!output.getOtherCountry().contains(othCode.getCode()))
                    output.getOtherCountry().add(othCode.getCode());
            }
            continetOutput = continetOutput == null ? new ContinetOutput() : continetOutput;
            continetOutput.setContinent(output);
        }
         continetOutput.getContinent().getOtherCountry().removeAll(output.getCountrys());
        return continetOutput;
    }


    public static HttpResponse callGraphQLService(String url, String query)
            throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        URI uri = new URIBuilder(request.getURI())
                .addParameter("query", query)
                .build();
        request.setURI(uri);
        return client.execute(request);
    }

}
