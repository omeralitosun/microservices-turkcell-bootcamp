package com.kodlamaio.invoiceservice.business.kafka.consumer;

import com.kodlamaio.commonpackage.events.rental.RentalPaymentCreatedEvent;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.entities.Invoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalConsumer
{
    private final InvoiceService service;
    private final ModelMapperService mapper;

    @KafkaListener
    (
            topics = "rental-payment-created",
            groupId = "rental-payment-create"
    )
    public void consume(RentalPaymentCreatedEvent event)
    {
        System.out.println(event.getBrandName()+event.getModelName()+event.getPlate());
        var invoice = mapper.forRequest().map(event, Invoice.class);
        System.out.println(invoice.getBrandName()+invoice.getModelName());
        service.add(invoice);
        log.info("Rental created event consumed {}", event);
    }
}
