package ru.stqa.pft.tsumtest;

import org.testng.annotations.Test;

public class  AddressDeletionTests extends TestBase {

    @Test
    public void testAddressDeletion() {
        gotoAddressPage();
        deleteAddress();
        gotoAddressPage();
    }

}