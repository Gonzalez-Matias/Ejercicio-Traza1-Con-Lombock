import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Domicilio {
    @NonNull
    private String calle;
    @NonNull
    private Integer numero;
    @NonNull
    private Localidad localidad;
    private Integer cp;
}
