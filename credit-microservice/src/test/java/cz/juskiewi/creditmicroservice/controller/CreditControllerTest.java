package cz.juskiewi.creditmicroservice.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cz.juskiewi.creditmicroservice.model.Credit;
import cz.juskiewi.creditmicroservice.model.CreditObject;
import cz.juskiewi.creditmicroservice.model.Customer;
import cz.juskiewi.creditmicroservice.model.Product;
import cz.juskiewi.creditmicroservice.proxy.CustomerServiceProxy;
import cz.juskiewi.creditmicroservice.proxy.DatabaseServiceProxy;
import cz.juskiewi.creditmicroservice.proxy.ProductServiceProxy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
//@WebMvcTest(CreditController.class)
@AutoConfigureMockMvc
public class CreditControllerTest {

    @MockBean
    CustomerServiceProxy customerProxy;

    @MockBean
    DatabaseServiceProxy databaseProxy;

    @MockBean
    ProductServiceProxy productProxy;



    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerBasic() throws Exception {

        when(customerProxy.getCustomers()).thenReturn(Arrays.asList(new Customer()));

        when(databaseProxy.retreiveCredits()).thenReturn(Arrays.asList(new Credit()));

        when (productProxy.getProducts()).thenReturn(Arrays.asList(new Product()));

//        CreditController mock = mock(CreditController.class);
//
//        when(mock.getCredits()).thenReturn(Arrays.asList(new CreditObject()));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/credits")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{customer: {}, credit:{}, product:{}}]"))
                .andReturn();


    }


}
