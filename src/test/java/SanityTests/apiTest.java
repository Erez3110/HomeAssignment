package SanityTests;

import Utilities.commonOps;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.apiFlows.getMail;

@Listeners(Utilities.listeners.class)
public class apiTest extends commonOps
{
    @Test(description = "Get Mail With API")
    @Description("Go to email inbox and print all mail details")
    public void test01_getMailUsingAPI()
    {
        String host = getData("api_host");
        String mailStoreType = getData("mailStoreType");
        String username = getData("user");
        String password = getData("appPassword");

        getMail(host, mailStoreType, username, password);
    }
}
