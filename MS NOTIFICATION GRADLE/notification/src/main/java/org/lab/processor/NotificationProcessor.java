package org.lab.processor;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.lab.pojo.Payment;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.smallrye.reactive.messaging.kafka.Record;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.smallrye.common.annotation.Blocking;


@ApplicationScoped
@Slf4j
public class NotificationProcessor {

    @Inject
    ReactiveMailer reactiveMailer;

    @Inject
    Mailer mailer;

    @Incoming("payment-requests")
    @SneakyThrows
    public void process(Record<String, String> record)  {

         //ReactiveMailer reactiveMailer = new ReactiveMailer();
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var payment = objectMapper.readValue(record.value(), Payment.class);
            log.info("Topics paymentid {} | mount {}", record.key(), payment.getMount());
            reactiveMailer.send(Mail.withText("govasandovalrosales@gmail.com","Ahoy from Quarkus Reactivo RAA", "A simple email sent from a Quarkus application using the reactive API."));
        log.info("Aqui llegue");
        //mailer.send(Mail.withText("govasandovalrosales@gmail.com", "Ahoy from Quarkus", "A simple email sent from a Quarkus application."));
        
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
