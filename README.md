# Ejercicio Traza 1 (JDK 21 + Lombok)

Modelado y práctica de relaciones entre entidades usando **encapsulación**, **cardinalidades** y **`HashSet`** como colección de multiplicidad.  
El dominio representa **Empresas**, sus **Sucursales** y su **ubicación física** (País → Provincia → Localidad → Domicilio).

## Objetivos del ejercicio

- Crear las clases del modelo respetando **encapsulación** (atributos privados, getters/setters o Lombok).
- Implementar relaciones según **cardinalidad** y **dirección** (composición/agrupación donde corresponda).
- Usar **`HashSet`** para las colecciones de multiplicidad.
- En el `main`, construir los datos del escenario propuesto y permitir:
    - Listar todas las empresas.
    - Buscar empresa por **ID**.
    - Buscar empresa por **nombre**.
    - **Actualizar** datos de una empresa por ID (ej.: modificar CUIL).
    - **Eliminar** una empresa por ID.

## Requisitos

- **JDK 21** (obligatorio).
- **Lombok** (plugin en el IDE + *annotation processing* habilitado).
- IDE recomendado: IntelliJ IDEA (o por consola con `javac`).