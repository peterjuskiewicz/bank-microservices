package cz.juskiewi.databasemicroservice.controller;

import cz.juskiewi.databasemicroservice.model.Product;
import cz.juskiewi.databasemicroservice.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {


    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;



    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerRetreiveAllTest() throws Exception {

        when (productRepository.findAll()).thenReturn(Arrays.asList(new Product(1, "test", 100)));

        List<Product> products = productController.retreiveProducts();

        RequestBuilder request = MockMvcRequestBuilders
                .get("/products")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{creditId:1, productName:test, value:100 }]"))
                .andReturn();


    }


}
