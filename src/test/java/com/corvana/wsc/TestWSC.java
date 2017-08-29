package com.corvana.wsc;

import org.junit.Test;
import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.*;
import com.sforce.ws.*;
public class TestWSC {

    @Test
    public void testWSCWithToken() throws Exception {
        ConnectorConfig config = new ConnectorConfig();
        config.setManualLogin(true);
        config.setSessionId("00D6A0000002SDQ!AQQAQA3kBUTEScGL4OkSYn4eY0Pkc9SzNmWNc0jnFespaauxxmR4KcgIsBAl6KLuvwqjGhjpkbTGxsGrqEOcVCC9HGbHhN.N");
        config.setTraceMessage(true);
        config.setServiceEndpoint("https://na50.salesforce.com/services/Soap/u/40");


        PartnerConnection connection = Connector.newConnection(config);
        SObject account = new SObject();
        QueryResult query = connection.query("SELECT Name,OwnerId,AccountId from Opportunity");
        for (SObject sObject : query.getRecords()) {
            System.out.println(sObject);
        }
    }
}
