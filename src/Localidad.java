import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Localidad {
    @NonNull
    private String nombre;
    @NonNull
    private Provincia provincia;
}
