package com.example.takehome;

import com.example.takehome.controller.CountrysListController;
import com.example.takehome.model.ContinetOutput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.ApiVersion;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CountrysListController.class)
class TakehomeApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(ApiVersion.LATEST.equals(ApiVersion.V3));
    }


    @MockBean
    private CountrysListController countrysListController;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();
    @Test
    public void testGetExample() throws Exception {
        ContinetOutput co= new ContinetOutput();
        List<String> stringList= new ArrayList<>();
        stringList.add("US");
        Mockito.when(countrysListController.getCountryList(stringList)).thenReturn(co);
        mockMvc.perform(get("/getCountryCodesList/US")).andExpect(status().isOk());
        Assertions.assertNotNull(co);

    }
    @Test
    public void testOutputContinet() throws Exception {
        ContinetOutput co= new ContinetOutput();
        List<String> stringList= new ArrayList<>();
        stringList.add("US");
        String code="US";
        Mockito.when(countrysListController.getCountryList(stringList)).thenReturn(co);
        mockMvc.perform(get("/getCountryCodesList/"+code)).andExpect(status().isOk());

    }

    @Test
    public void testWrongPath() throws Exception {
        ContinetOutput co= new ContinetOutput();
        List<String> stringList= new ArrayList<>();
        Mockito.when(countrysListController.getCountryList(stringList)).thenReturn(co);
        mockMvc.perform(get("/getCountryCodesList/")).andExpect(status().isNotFound());

    }
    @Test
    public void getCountrysApiStatus() throws Exception {
        

        ContinetOutput co= new ContinetOutput();
        List<String> stringList= new ArrayList<>();
        stringList.add("US");
        given(countrysListController.getCountryList(stringList));

        mockMvc.perform(get("http://localhost:8080/getCountryCodesList/US")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
