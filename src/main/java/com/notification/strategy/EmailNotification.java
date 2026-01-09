package com.notification.strategy;

import com.notification.utility.PdfGenerator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;

@Component("EMAIL")
public class EmailNotification implements NotificationStrategy {

    private final JavaMailSender javaMailSender;

    public EmailNotification(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String to, String message) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, false, "UTF-8");

            helper.setTo(to);
            helper.setSubject("Notification");
            helper.setText(message);

            javaMailSender.send(mimeMessage);

            System.out.println("📧 Email sent to " + to);

        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendWithAttachment(
            String to,
            String message,
            File attachment
    ) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("Notification with Attachment");
            helper.setText(message);

            helper.addAttachment(attachment.getName(), attachment);

            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            throw new RuntimeException("Email with attachment failed", e);
        }
    }
}
