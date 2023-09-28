# Email-Test-Automation-GmailAPI
Project to cover email test automation using Gmail API and testng.

Gmail API has to be enabled from google cloud console where we can create client id and client secret id to connect with the provided credentails.

To handle the 400-URI mismatch, callback URI has to be added under add URI section on google console. i.e. "http://localhost:9999/Callback".

In case integration throw "403- Access denied", test user (the user to be used for connection) should be added under web client on cloud console.

Note: Credentails need to be replaced as provided credentails are dummy one.
