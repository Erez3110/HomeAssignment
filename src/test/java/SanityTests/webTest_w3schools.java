package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import Utilities.helperMethods;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class webTest_w3schools extends commonOps
{
    @Test(description = "Search Value in Table")
    @Description("Search value in table and verify result")
    public static void test01_SearchValueInTable() // Columns: 0 = Company, 1 = Contact, 2 = Country
    {
        System.out.println(webFlows.getTableCellText(w3schools_Table.customers_table,1, helperMethods.getCell(3,1),0));
        boolean textMatch = verifications.verifyTableCellText(w3schools_Table.customers_table,1,helperMethods.getCell(3,1),0,helperMethods.getCell(3,0));
        System.out.println("Returned value matches expected text: " + textMatch);
    }

    @Test(description = "Search Value in Table - Using Assertions")
    @Description("Search value in table and verify result - using assertions")
    public static void test02_SearchValueInTable() // Columns: 0 = Company, 1 = Contact, 2 = Country
    {
        String actualValue = webFlows.getTableCellText(w3schools_Table.customers_table,2,helperMethods.getCell(5,2),0);
        verifications.verifyTableCellText(actualValue,helperMethods.getCell(5,0));
    }

    @Test(description = "Search Value in Table - By XPath")
    @Description("Search value is table and verify result")
    public static void test03_SearchValueInTable_ByXPath() // Columns: 0 = Company, 1 = Contact, 2 = Country
    {
        String actualValue = webFlows.getTableCellTextByXpath(w3schools_Table.customers_table,0,helperMethods.getCell(4,0),1);
        verifications.verifyTableCellText(actualValue,helperMethods.getCell(4,1));
    }

    @Test(description = "Search Value in Table - By XPath (Failed Test)")
    @Description("Search value is table and verify result")
    public static void test04_SearchValueInTable_ByXPath() // Columns: 0 = Company, 1 = Contact, 2 = Country
    {
        String actualValue = webFlows.getTableCellTextByXpath(w3schools_Table.customers_table,0,helperMethods.getCell(4,0),1);
        verifications.verifyTableCellText(actualValue,helperMethods.getCell(4,2));
    }
}
