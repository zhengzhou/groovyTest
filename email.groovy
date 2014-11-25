@Grab(group='org.apache.commons', module='commons-email', version='1.3.3')
import org.apache.commons.mail.*

void sentMail(){
    Email email = new SimpleEmail();
    email.setHostName("smtp.sina.com");
    email.setSmtpPort(25);
    email.setAuthenticator(new DefaultAuthenticator("xzzxia", "xzz352107"));
    email.setSSLOnConnect(false);
    email.setFrom("xzzxia@sina.com");
    email.setSubject("TestMail");
    email.setMsg("This is a test mail ... :-)");
    email.addTo("zhengzhou.xu@hotmail.com");
    email.send();
}

sentMail()