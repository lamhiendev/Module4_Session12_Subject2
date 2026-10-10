package demo.orderservice.service;

import demo.orderservice.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendMessageService {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void createOrders(OrderEvent orderEvent){
        System.out.println("Đã lưu sản phẩm vào DB");
        kafkaTemplate.send("order-created-event", orderEvent);
    }
}
