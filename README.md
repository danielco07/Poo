# Proyecto Integrador - POO

Entrega sencilla de las historias de usuario HU3, HU4 y HU5 para el sistema de plazoleta de comidas.

**Autor:** Daniel Cogollo

Consulta [DOCUMENTACION.md](DOCUMENTACION.md) para la explicacion completa del proyecto, las reglas de negocio, las clases, las pruebas y los comandos.

## Historias implementadas

- **HU3:** todo `Plato` debe estar asociado a un `Restaurante`.
- **HU4:** un `Plato` solo permite modificar `precio` y `descripcion`.
- **HU5:** solo un `Propietario` puede crear `Empleado`.

## Estructura

```text
src/main/java/com/cogollo/
├── Empleado.java
├── Plato.java
├── Propietario.java
└── Restaurante.java

src/test/java/com/cogollo/
├── Hu03PlatoTest.java
├── Hu04PlatoTest.java
└── Hu05EmpleadoTest.java
```

## Prueba desde la terminal

Requisitos: Java 25 y Maven.

```powershell
cd C:\Users\owenm\Downloads\cogollo\entrega-poo
mvn clean test
```

Cada prueba demuestra una historia de usuario. No se necesita página web, base de datos ni servidor.

Resultado comprobado: 4 pruebas exitosas y 0 fallos.

## Ejecutar cada HU por separado

Desde PowerShell:

```powershell
cd C:\Users\owenm\Downloads\cogollo\entrega-poo
```

HU3, asociar el plato a un restaurante:

```powershell
mvn -Dtest=Hu03PlatoTest test
```

HU4, modificar solo precio y descripcion:

```powershell
mvn -Dtest=Hu04PlatoTest test
```

HU5, crear empleados desde el propietario:

```powershell
mvn -Dtest=Hu05EmpleadoTest test
```

Para ejecutar las tres HU juntas:

```powershell
mvn clean test
```

## Commits sugeridos

```text
feat(plato): asociar plato a restaurante [HU-03]
feat(plato): modificar precio y descripcion [HU-04]
feat(usuario): permitir crear empleados al propietario [HU-05]
```

## Ramas sugeridas

```text
feature/HU-03-crear-plato
feature/HU-04-modificar-plato
feature/HU-05-crear-empleado
```
# Poo
