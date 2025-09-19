import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Empresa {
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String razonSocial;
    @NonNull
    private Integer cuit;
    private String logo;
    @Builder.Default
    private HashSet<Sucursal> sucursales = new HashSet<>();

    public void añadirSurcursal(Sucursal nuevaSucursal){
        this.sucursales.add(nuevaSucursal);
    }

    public void removerSurcursal(Sucursal nuevaSucursal){
        this.sucursales.remove(nuevaSucursal);
    }
}
