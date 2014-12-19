package ReportsUtils;

/*import java.util.*;

//import javax.mail.*;
//import javax.mail.internet.*;
import javax.activation.*;

public class GenerateEmailReport
{
   @SuppressWarnings({ "unchecked", "rawtypes" })
   public static void sendEmailReport()
   {
      
	    Properties props = new Properties();
		String to = "tr.dinesh@wipro.com";
		final String from = "tr.dinesh@wipro.com";
		String subject = "Selenium Batch Run Report";
		String messageText = "Find the auto-generated test report attached.";
		final String pswd="tests";
		String fileToAttach =  System.getProperty("user.dir")+"//Test_Output//emailable-report.html";
		String fileName="SeleniumAutomation";
		ArrayList cc = new ArrayList();
		
		//cc list
		/*cc.add("");
		cc.add("");
		cc.add("");
		*/
		
		
		// Create some properties and get the default Session.
		/*props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable" , "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.user",from);
		props.put("mail.smtp.password", pswd);

		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new Authenticator()
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(from, pswd);
				//	and put your password in second parameter
			}
		});
		System.out.println("after session:");

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         ArrayList ccs=new ArrayList();
			for(Iterator i = cc.iterator();i.hasNext();)
			{
				String s = (String)i.next();
				ccs.add(new InternetAddress(s));

			}
			message.setRecipients(Message.RecipientType.CC,
					(InternetAddress[]) ccs.toArray(new InternetAddress[ccs.size()]));


         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(subject);
      // Set Dtae and time
         message.setSentDate(new Date());
         // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();

         // Fill the message
         messageBodyPart.setText(messageText);
         
         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         
         DataSource source = new FileDataSource(fileToAttach);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(fileName);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}*/
