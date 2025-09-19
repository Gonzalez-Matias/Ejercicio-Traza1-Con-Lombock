import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Pais {
    @NonNull
    private String nombre;
}
