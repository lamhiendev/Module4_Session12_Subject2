package demo.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetails {
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
}
