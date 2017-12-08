package ru.stqa.pft.tsumtest.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.tsumtest.model.AddressCreation;

public class MakeAddressTest extends TestBase{

    @Test
    public void testMakeAddress() {
        app.gotoAddressPage();
        app.initAndfillNewAddress(new AddressCreation("Улица", "555555", "5555", "5555", "5555"));
        app.submitAdressCreation();
    }

}
