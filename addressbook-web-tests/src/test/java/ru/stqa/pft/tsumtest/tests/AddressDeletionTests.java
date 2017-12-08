package ru.stqa.pft.tsumtest.tests;

import org.testng.annotations.Test;

public class  AddressDeletionTests extends TestBase {

    @Test
    public void testAddressDeletion() {
        app.gotoAddressPage();
        app.deleteAddress();
        app.gotoAddressPage();
    }

}