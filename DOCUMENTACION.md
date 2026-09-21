# Documentacion del Proyecto Integrador

## Sistema de gestion de plazoleta de comidas

**Autor:** Daniel Cogollo  
**Tecnologia:** Java 25  
**Enfoque:** Programacion Orientada a Objetos  
**Proyecto:** Entrega academica de HU3, HU4 y HU5

## 1. Objetivo

Este proyecto implementa tres historias de usuario relacionadas con la gestion de platos, restaurantes y empleados de una plazoleta de comidas.

La entrega fue construida como un proyecto sencillo de Programacion Orientada a Objetos. No utiliza pagina web, base de datos, servidor ni frameworks innecesarios para demostrar las reglas solicitadas.

Las reglas se encuentran directamente en las clases Java y se verifican con pruebas automatizadas ejecutadas desde la terminal.

## 2. Historias de usuario

### HU3: Asociar plato a restaurante

**Regla:** todo plato debe estar asociado a un restaurante.

La clase `Plato` recibe un objeto `Restaurante` en su constructor. Si se intenta crear un plato sin restaurante, el programa lanza una excepcion porque se estaria violando la regla de negocio.

Ejemplo valido:

```java
var propietario = new Propietario("Daniel");
var restaurante = new Restaurante("Restaurante Central", propietario);
var plato = new Plato("Hamburguesa", 18000, "Con queso", restaurante);
```

Ejemplo invalido:

```java
new Plato("Hamburguesa", 18000, "Con queso", null);
```

El segundo caso produce el error:

```text
Todo plato debe estar asociado a un restaurante
```

La prueba correspondiente es `Hu03PlatoTest`.

### HU4: Modificar solamente precio y descripcion

**Regla:** de un plato solo se pueden modificar el precio y la descripcion.

La clase `Plato` conserva como atributos inmutables el nombre y el restaurante. Para modificar el plato se utiliza exclusivamente el metodo:

```java
modificarPrecioYDescripcion(int nuevoPrecio, String nuevaDescripcion)
```

Este metodo no recibe un nuevo nombre ni un nuevo restaurante. Por eso, esos datos no pueden cambiarse mediante la operacion de modificacion.

La prueba `Hu04PlatoTest` confirma que:

- El precio cambia.
- La descripcion cambia.
- El nombre permanece igual.
- El restaurante permanece igual.

### HU5: Crear empleado solamente como propietario

**Regla:** solo un propietario puede crear empleados.

La operacion de creacion se encuentra en la clase `Propietario`:

```java
public Empleado crearEmpleado(String nombreEmpleado)
```

La clase `Empleado` tiene un constructor de acceso de paquete, por lo que no puede ser creado directamente desde cualquier parte del programa. La forma controlada de crearlo es mediante `Propietario.crearEmpleado(...)`.

La prueba `Hu05EmpleadoTest` confirma que el propietario puede crear un empleado y que este queda registrado en su lista de empleados.

## 3. Clases del proyecto

### `Restaurante`

Representa un restaurante de la plazoleta.

Atributos:

- `nombre`: nombre del restaurante.
- `propietario`: propietario responsable del restaurante.

Reglas:

- El nombre es obligatorio.
- El propietario es obligatorio.

### `Propietario`

Representa al usuario que administra un restaurante y puede crear empleados.

Atributos:

- `nombre`: nombre del propietario.
- `empleados`: lista de empleados creados por el propietario.

Responsabilidades:

- Crear empleados.
- Mantener la lista de empleados.
- Entregar una copia protegida de la lista para evitar modificaciones externas.

### `Empleado`

Representa a un empleado creado por un propietario.

Atributos:

- `nombre`: nombre del empleado.

El constructor no es publico. Esto ayuda a que la creacion se realice mediante el propietario.

### `Plato`

Representa un plato del menu de un restaurante.

Atributos:

- `nombre`: nombre del plato.
- `precio`: precio del plato.
- `descripcion`: descripcion del plato.
- `restaurante`: restaurante al que pertenece.

Reglas:

- Todos los datos son obligatorios.
- El precio debe ser mayor que cero.
- El plato debe tener restaurante.
- Solo precio y descripcion pueden modificarse despues de crear el plato.

## 4. Principios de POO utilizados

### Encapsulamiento

Los atributos de las clases son privados. El acceso se realiza mediante metodos publicos y las modificaciones se controlan mediante operaciones especificas.

Por ejemplo, `Plato` no expone metodos para cambiar directamente el nombre o el restaurante.

### Abstraccion

Cada clase representa un concepto del problema real:

- `Plato` representa un producto del menu.
- `Restaurante` representa un negocio.
- `Propietario` representa al administrador del restaurante.
- `Empleado` representa al trabajador.

### Asociacion entre objetos

Un `Plato` tiene una asociacion obligatoria con un `Restaurante`. Un `Restaurante` tiene un `Propietario`, y un `Propietario` administra sus `Empleado`.

### Responsabilidad unica

Cada clase tiene una responsabilidad principal. Las reglas de platos estan en `Plato`, y la creacion de empleados esta en `Propietario`.

## 5. Pruebas automatizadas

Las pruebas se encuentran en `src/test/java/com/cogollo/`.

### Prueba de HU3

Archivo: `Hu03PlatoTest.java`

Verifica que:

1. Crear un plato sin restaurante produce un error.
2. Crear un plato con restaurante conserva correctamente la asociacion.

Comando:

```powershell
cd C:\Users\owenm\Downloads\cogollo\entrega-poo
mvn -Dtest=Hu03PlatoTest test
```

### Prueba de HU4

Archivo: `Hu04PlatoTest.java`

Verifica que:

1. El precio se puede modificar.
2. La descripcion se puede modificar.
3. El nombre no cambia.
4. El restaurante no cambia.

Comando:

```powershell
cd C:\Users\owenm\Downloads\cogollo\entrega-poo
mvn -Dtest=Hu04PlatoTest test
```

### Prueba de HU5

Archivo: `Hu05EmpleadoTest.java`

Verifica que:

1. El propietario puede crear un empleado.
2. El empleado queda registrado en la lista del propietario.

Comando:

```powershell
cd C:\Users\owenm\Downloads\cogollo\entrega-poo
mvn -Dtest=Hu05EmpleadoTest test
```

### Ejecutar todas las pruebas

```powershell
mvn clean test
```

Resultado esperado:

```text
BUILD SUCCESS
Tests run: 4, Failures: 0, Errors: 0
```

## 6. Requisitos para ejecutar

- Java 25 o superior.
- Maven 3.9 o superior.
- Terminal PowerShell, CMD o equivalente.

Si Maven no aparece reconocido en PowerShell, configurar la sesion:

```powershell
$env:JAVA_HOME="C:\Users\owenm\AppData\Local\jdks\jdk-25.0.2"
$env:Path="C:\Users\owenm\.maven\maven-3.9.15\bin;$env:Path"
```

Luego entrar a la carpeta del proyecto:

```powershell
cd C:\Users\owenm\Downloads\cogollo\entrega-poo
mvn clean test
```

## 7. Commits sugeridos

La entrega puede organizarse en tres commits, uno por historia:

```text
feat(plato): asociar plato a restaurante [HU-03]
feat(plato): modificar precio y descripcion [HU-04]
feat(usuario): permitir crear empleados al propietario [HU-05]
```

Ramas sugeridas:

```text
feature/HU-03-crear-plato
feature/HU-04-modificar-plato
feature/HU-05-crear-empleado
```

## 8. Conclusion

El proyecto demuestra las tres reglas solicitadas usando clases Java sencillas, encapsulamiento, asociaciones entre objetos y pruebas automatizadas.

La entrega no depende de una interfaz grafica. La evidencia principal son:

- El codigo de las clases.
- Las pruebas de cada historia.
- Los resultados de `mvn test`.
- Los commits organizados por HU.
