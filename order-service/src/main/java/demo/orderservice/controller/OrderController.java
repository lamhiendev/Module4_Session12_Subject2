package demo.orderservice.controller;


import demo.orderservice.dto.OrderEvent;
import demo.orderservice.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final SendMessageService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEvent orderEvent){
        orderService.createOrders(orderEvent);
        return ResponseEntity.ok().body("Đã tạo đơn hàng thành công");
    }
}

