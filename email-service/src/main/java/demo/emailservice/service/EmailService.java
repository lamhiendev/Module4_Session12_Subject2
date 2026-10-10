package demo.emailservice.service;


import demo.emailservice.dto.OrderDetails;
import demo.emailservice.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @KafkaListener(
            topics = "order-created-event",
            groupId = "email-group"
    )
    public void sendEmail(OrderEvent orderEvent){
        System.out.println("Inventory nhận được 1 thông tin đơn hàng mới: ");
        System.out.println("Mã đơn hàng: " + orderEvent.getOrders().getOrderId());
        System.out.println("Địa chỉ nhận đơn: " + orderEvent.getOrders().getReceivedAddress());
        System.out.println("Khách hàng: " + orderEvent.getOrders().getFullName());

        System.out.println("\n\n");

        System.out.println("Đã gửi email cho khách hàng: ");
        for(OrderDetails orderDetails : orderEvent.getOrderDetails()){
            System.out.println("-------------------------------");
            System.out.println("Mã sản phẩm: " + orderDetails.getOrderId());
            System.out.println("Số lượng: " + orderDetails.getQuantity());
        }
    }
}
