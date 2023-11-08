package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlayerDTO {
    private Long playerID;
    private String name;
    private LocalDateTime creationTime;
}
