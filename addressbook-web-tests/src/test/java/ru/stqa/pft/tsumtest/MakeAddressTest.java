package ru.stqa.pft.tsumtest;

import org.testng.annotations.Test;

public class MakeAddressTest extends TestBase{

    @Test
    public void testMakeAddress() {
        gotoAddressPage();
        initAndfillNewAddress(new AddressCreation("Улица", "555555", "5555", "5555", "5555"));
        submitAdressCreation();
    }

}
