package demo.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Orders {
    private Long orderId;
    private String fullName;
    private String receivedAddress;
    private String email;
    private String phone;
}
