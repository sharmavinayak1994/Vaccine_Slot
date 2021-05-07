package com.vinayak.demo.utility;

import java.io.IOException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinayak.demo.model.Center;
import com.vinayak.demo.model.CowinResponse;
import com.vinayak.demo.model.Session;

@EnableScheduling
@Component
public class FetchAvailability_Jaipur_II {
	

	
	@Scheduled(cron = "0/40 * * * * ?")
	public void connectToCowin() throws IOException, NoSuchAlgorithmException {
		System.out.println(System.currentTimeMillis()+ "STARTED J 2 !!");
		HttpGet httpGet;
		CloseableHttpClient httpClient = HttpClients.custom().setSslcontext(SSLContext.getDefault()).build();
		try {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate= formatter.format(date);
			
			httpGet = new HttpGet("https://cdn-api.co-vin.in/api/v2/appointment/sessions/calendarByDistrict?");
			URI uri = new URIBuilder(httpGet.getURI()).addParameter("district_id", "506")
					.addParameter("date", strDate).build();

			httpGet.setURI(uri);

			httpGet.setHeader("Host", "cdn-api.co-vin.in");
			httpGet.setHeader("Origin", "https://selfregistration.cowin.gov.in");
			httpGet.setHeader("Referer", "https://selfregistration.cowin.gov.in");
			//httpGet.setHeader("TE", "Trailers");
			httpGet.setHeader("Connection", "keep-alive");
			httpGet.setHeader("Accept", "application/json");
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				System.out.println("!!!!Connect hua JAIPUR 2!!!!!!!");
				HttpEntity entity = response.getEntity();
				String respString = EntityUtils.toString(entity, "UTF-8");
				System.out.println("Response from Cowin :" + respString);
				
				ObjectMapper mapper = new ObjectMapper();
				CowinResponse cowin = (CowinResponse)mapper.readValue(respString, CowinResponse.class);
				Set<String> centers = new HashSet();
				boolean flag=false;
				for(Center c : cowin.getCenters()) {
					//if(c.getFeeType().equalsIgnoreCase("FREE"));
					for(Session s : c.getSessions()) {
						if(s.getMinAgeLimit() == 18 && s.getAvailableCapacity() >0) {
							centers.add(c.getName()+" "+s.getDate());
							System.out.println(c.getName());
							System.out.println("Book now ASAP");
							flag = true;
						}
					}
				}
				if(flag) {
					StringBuilder sb = new StringBuilder();
					for(String s : centers) {
						sb.append(s);
						sb.append(" ");
					}
					
				 sendmail(sb.toString());
				}
			}else {
				System.out.println(response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
			}

		} catch (Exception e) {
			System.out.println("Stuff broke!");
			System.out.println(e.getMessage());
		} finally {
			httpClient.close();
		}
	}
	
	void sendmail(String places) {
		
	      // email ID of Recipient.
	      String recipient = "nehal.singla23@gmail.com";
	  
	      // email ID of  Sender.
	      String sender = "sharma.vinayak1994@gmail.com";  // use your email id and you would have to create app password for your email use this link for referral. 
	      													// https://support.google.com/accounts/answer/185833?hl=en
	      
	      // using host as localhost
	      String host = "smtp.gmail.com";
	  
	      String pass = "arpgrnnrqogtvkan";
	      
	      // Getting system properties
	      Properties properties = System.getProperties();
	  
	      // Setting up mail server
	      properties.setProperty("mail.smtp.auth", "true");
	      properties.setProperty("mail.smtp.starttls.enable", "true");
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", "587");
	  
	      // creating session object to get properties 
	      javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties, new Authenticator() {
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    		  return new PasswordAuthentication(sender, pass);
	    	  }
		});
	      
	      /** 
	       * protected PasswordAuthentication getPasswordAuthentication() {
	    			  return new PasswordAuthentication(sender, pass);
	    		  }) {**/
	      
	      try 
	      {
	         // MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	  
	         // Set From Field: adding senders email to from field.
	         message.setFrom(new InternetAddress(sender));
	  
	         // Set To Field: adding recipient's email to from field.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	         message.addRecipient(Message.RecipientType.CC, new InternetAddress("i.meenalgrover@gmail.com"));
	  
	         // Set Subject: subject of the email
	         message.setSubject("!!!!VACCINE SLOT AVAILABLE!!!!!!");
	  
	         // set body of the email.
	         message.setText("!!!!VACCINE SLOT AVAILABLE!!!!!!" + places);
	  
	         // Send email.
	         Transport.send(message);
	         System.out.println("Mail successfully sent");
	      }
	      catch (MessagingException mex) 
	      {
	         mex.printStackTrace();
	      }
	}

}
