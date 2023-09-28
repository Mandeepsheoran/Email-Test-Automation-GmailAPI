package org.gmailapi.emailautomation;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailTest {

	@Test
	public void verifyEmail() throws IOException, GeneralSecurityException {
		String expectedSubject = "Email Automation";
		String expectedContent = "This is email automation test.";

		boolean exist = GmailAPI.isMailExist("Email Automation");
		System.out.println("Email availability is :" + exist);

		if (!exist) {
			System.out.println("Email with the subject " + expectedSubject + " not found");
		} else {
			HashMap<String, String> hm = GmailAPI.getGmailData("subject:" + expectedSubject + " AND is:unread");

			if (hm.get("subject").equalsIgnoreCase(expectedSubject)
					&& hm.get("body").toUpperCase().contains(expectedContent.toUpperCase())) {
				System.out.println("Email subject found is : " + hm.get("subject"));
			} else {
				System.out.println("Failed verification - Email content / subject mismatching !");
				Assert.fail("Failed verification - Email content / subject mismatching !");
			}
		}
	}

	@Test
	public void deleteEmail() throws IOException, GeneralSecurityException {
		String expectedSubject = "Email Automation";
		GmailAPI.deleteMessage("subject:" + expectedSubject + " AND is:unread");
		boolean exist = GmailAPI.isMailExist("Email Automation");

		if (!exist) {
			System.out.println("Email with the subject " + expectedSubject + " not found");
		} else {
			Assert.fail("Email is not deleted, hence marking the test as fail!");
		}
	}

	@Test
	public void getTotalEmailsFromInbox() throws IOException, GeneralSecurityException {
		int emailcount = GmailAPI.getTotalCountOfMails();
		System.out.println("Total email available in inbox is : " + emailcount);
	}
}