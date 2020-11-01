package com.zerobank.step_definitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;

public class Hooks {

    @Before
    public void setUp(){    }

    @After
    public void tearDown(Scenario scenario){
        Driver.closeDriver();
    }

}
