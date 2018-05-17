package com.venkata.vallabhaneni;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.venkata.vallabhaneni.ProductApplication;

@SpringBootTest(classes = ProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@TestPropertySource(locations = "classpath:application-integrationtest.proprties")
public class ProductsIntegrationTest {

}
