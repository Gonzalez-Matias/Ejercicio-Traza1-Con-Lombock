import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Provincia {
    @NonNull
    private String nombre;
    @NonNull
    private Pais pais;
}
