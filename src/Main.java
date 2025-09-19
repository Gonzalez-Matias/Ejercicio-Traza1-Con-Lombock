import repositorio.InMemoryRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Crear país Argentina
        Pais paisArg = Pais.builder()
                .nombre("Argentina")
                .build();

        // Crear provincia Buenos Aires y relacionarla con el país
        Provincia provBSAS = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(paisArg)
                .build();

        // Crear localidad CABA y relacionarla con Buenos Aires
        Localidad locCABA = Localidad.builder()
                .nombre("CABA")
                .provincia(provBSAS)
                .build();

        // Crear domicilio en CABA
        Domicilio domCABA1 = Domicilio.builder()
                .calle("San Martin")
                .numero(1246)
                .localidad(locCABA)
                .build();

        // Crear localidad La Plata y relacionarla con Buenos Aires
        Localidad locLaPlata = Localidad.builder()
                .nombre("La Plata")
                .provincia(provBSAS)
                .build();

        // Crear domicilio en La Plata
        Domicilio domLaPlata1 = Domicilio.builder()
                .calle("Avenida Colon")
                .numero(785)
                .localidad(locLaPlata)
                .build();

        // Crear provincia Córdoba y relacionarla con el país
        Provincia provCordoba = Provincia.builder()
                .nombre("Córdoba")
                .pais(paisArg)
                .build();

        // Crear localidad Córdoba Capital y relacionarla con Córdoba
        Localidad locCbaCap = Localidad.builder()
                .nombre("Córdoba Capital")
                .provincia(provCordoba)
                .build();

        // Crear domicilio en Córdoba Capital
        Domicilio domCbaCap1 = Domicilio.builder()
                .calle("Avenida Gutierrez")
                .numero(1796)
                .localidad(locCbaCap)
                .build();

        // Crear localidad Villa Carlos Paz y relacionarla con Córdoba
        Localidad locCarPaz = Localidad.builder()
                .nombre("Villa Carlos Paz")
                .provincia(provCordoba)
                .build();

        // Crear domicilio en Villa Carlos Paz
        Domicilio domCarPaz1 = Domicilio.builder()
                .calle("Rioja")
                .numero(416)
                .localidad(locCarPaz)
                .build();

        // Crear sucursal en CABA (casa matriz)
        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal CABA")
                .domicilioSucursal(domCABA1)
                .esCasaMatriz(true)
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .build();

        // Crear sucursal en La Plata
        Sucursal sucursal2 = Sucursal.builder()
                .nombre("Sucursal La Plata")
                .domicilioSucursal(domLaPlata1)
                .esCasaMatriz(false)
                .horarioApertura(LocalTime.of(10, 0))
                .horarioCierre(LocalTime.of(19, 0))
                .build();

        // Crear sucursal en Córdoba Capital
        Sucursal sucursal3 = Sucursal.builder()
                .nombre("Sucursal Córdoba Capital")
                .domicilioSucursal(domCbaCap1)
                .esCasaMatriz(true)
                .horarioApertura(LocalTime.of(8, 30))
                .horarioCierre(LocalTime.of(17, 30))
                .build();

        // Crear sucursal en Villa Carlos Paz
        Sucursal sucursal4 = Sucursal.builder()
                .nombre("Sucursal Villa Carlos Paz")
                .domicilioSucursal(domCarPaz1)
                .esCasaMatriz(false)
                .horarioApertura(LocalTime.of(9, 30))
                .horarioCierre(LocalTime.of(18, 30))
                .build();

        // Crear repositorio en memoria de empresas
        InMemoryRepository<Empresa> empresaRepositorio = new InMemoryRepository<>();

        // Crear empresa 1 y guardarla en el repositorio
        Empresa empresa1 = Empresa.builder()
                .razonSocial("Tech Solutions S.A.")
                .nombre("TechSol")
                .cuit(12345678)
                .build();
        empresaRepositorio.save(empresa1);

        // Asociar sucursales 1 y 2 a la empresa 1
        empresa1.añadirSurcursal(sucursal1);
        empresa1.añadirSurcursal(sucursal2);

        // Crear empresa 2 y guardarla en el repositorio
        Empresa empresa2 = Empresa.builder()
                .razonSocial("AgroCordoba S.R.L.")
                .nombre("AgroCba")
                .cuit(45875123)
                .build();
        empresaRepositorio.save(empresa2);

        // Asociar sucursales 3 y 4 a la empresa 2
        empresa2.añadirSurcursal(sucursal3);
        empresa2.añadirSurcursal(sucursal4);

        // Buscar empresa con ID 3 y mostrarla (no existe)
        Optional<Empresa> empresaEncontrada = empresaRepositorio.findById(3L);
        System.out.println(empresaEncontrada.toString());

        // Buscar empresa con ID 2 y mostrarla
        Optional<Empresa> empresaEncontrada2 = empresaRepositorio.findById(2L);
        System.out.println(empresaEncontrada2.toString());

        // Actualizar CUIT de la empresa encontrada
        empresaEncontrada2.ifPresent(empresa -> empresa.setCuit(99999999));
        System.out.println();

        // Listar todas las empresas del repositorio
        System.out.println("Empresas en el repositorio:");
        System.out.println("-------------------------");
        for (Empresa emp : empresaRepositorio.findAll()){
            System.out.println(emp.toString());
            System.out.println("-------------------------");
        }

        // Buscar empresas por nombre "TechSol"
        List<Empresa> empresasEncontradas3 = empresaRepositorio.genericFindByField("nombre", "TechSol");
        System.out.println(empresasEncontradas3.toString());

        // Buscar empresas por nombre "abcd" (no existen)
        List<Empresa> empresasEncontradas4 = empresaRepositorio.genericFindByField("nombre", "abcd");
        System.out.println(empresasEncontradas4.toString());

        // Eliminar empresa con ID 1
        empresaRepositorio.genericDelete(1L);

        // Listar todas las empresas luego de eliminar
        System.out.println("Empresas en el repositorio:");
        System.out.println("-------------------------");
        for (Empresa emp : empresaRepositorio.findAll()){
            System.out.println(emp.toString());
            System.out.println("-------------------------");
        }
    }
}
