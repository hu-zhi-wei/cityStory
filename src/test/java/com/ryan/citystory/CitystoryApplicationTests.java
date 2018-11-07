package com.ryan.citystory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitystoryApplicationTests {

    @Test
    public void contextLoads() {
        List<String> list = Arrays.asList("p", "k", "u", "f", "o", "r", "k");
        list.forEach(e ->
                System.out.println(e)

        );
        Arrays.asList( "p", "k", "u","f", "o", "r","k").forEach(e -> System.out.println( e ) );
    }

}
