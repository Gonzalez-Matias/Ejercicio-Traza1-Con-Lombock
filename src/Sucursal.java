import lombok.*;

import java.time.LocalTime;


@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Sucursal {
    @NonNull
    private String nombre;
    @NonNull
    private boolean esCasaMatriz;
    @NonNull
    private Domicilio domicilioSucursal;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;


}
