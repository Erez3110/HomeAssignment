package WorkFlows;

import Utilities.commonOps;
import Utilities.helperMethods;
import io.qameta.allure.Step;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public class apiFlows extends commonOps
{
    @Step("Get emails from inbox")
    public static void getMail(String host, String storeType, String user, String password) {
        try {
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.imap.ssl.trust", host);

            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imaps");
            store.connect(host, user, password);

            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            System.out.println("Total Inbox Messages: " + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                message.setFlag(Flags.Flag.SEEN, true);
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Received: " + message.getReceivedDate());
                System.out.println("Text: " + helperMethods.trimMailBody(helperMethods.getText(message)));
                message.setFlag(Flags.Flag.SEEN, false);
            }

            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
