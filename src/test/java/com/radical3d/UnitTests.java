package com.radical3d;

import com.radical3d.factory.BaseClass;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

class UnitTests {
    @Test
    public void should_createProperties() throws IOException{
        //When
        BaseClass.initializeProperties();
        Properties props = BaseClass.getProperties();
        //Then
        assertAll(
                () -> assertEquals("https://www.saucedemo.com/", props.getProperty("url")),
                () -> assertEquals("chrome", props.getProperty("browser"))
        );

    }

    @Test
    public void should_create_a_splitted_string_when_it_has_sollar_sign(){
        String actualString = "Item total: $15.99";


    }
}
