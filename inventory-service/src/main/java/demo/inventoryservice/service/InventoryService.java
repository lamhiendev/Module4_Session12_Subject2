package demo.inventoryservice.service;

import demo.inventoryservice.dto.OrderDetails;
import demo.inventoryservice.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @KafkaListener(
            topics = "order-created-event",
            groupId = "inventory-group"
    )
    public void updateInventory(OrderEvent orderEvent){
        System.out.println("Inventory nhận được 1 thông tin đơn hàng mới: ");
        System.out.println("Mã đơn hàng: " + orderEvent.getOrders().getOrderId());
        System.out.println("Địa chỉ nhận đơn: " + orderEvent.getOrders().getReceivedAddress());
        System.out.println("Khách hàng: " + orderEvent.getOrders().getFullName());

        System.out.println("\n\n");

        System.out.println("Cập nhật số lượng trong kho: ");
        for(OrderDetails orderDetails : orderEvent.getOrderDetails()){
            System.out.println("-------------------------------");
            System.out.println("Mã sản phẩm: " + orderDetails.getOrderId());
            System.out.println("Số lượng: " + orderDetails.getQuantity());
        }
    }
}
