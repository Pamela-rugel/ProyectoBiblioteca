# ProyectoBiblioteca
Al principio del programa se genera una biblioteca con la siguiente información:

```
-----LIBROS DISPONIBLES----
Código: 001, titulo: Crepúsculo, autor: Stephenie Meyer, cantidad: 6
Código: 002, titulo: El diario de Ana Frank, autor: Anna Frank, cantidad: 7
Código: 003, titulo: El código Da Vinci, autor: Dan Brown, cantidad: 4
```

Para iniciar sesión como estudiante necesita ingresar la siguiente información

```
-----ESTUDIANTE----
Usuario: pamela
Contraseña: 1234
```

El cual ya ha prestado los siguientes libros:

```
-----LIBROS PRESTADOS----
Titulo:Crepúsculo, autor:Stephenie Meyer, fecha de emisión: 2022/1/31, fecha de devolución: 2022/3/2
Titulo:El diario de Ana Frank, autor:Anna Frank, fecha de emisión: 2022/1/31, fecha de devolución: 2022/3/2
```

Cuando un estudiante requiera prestar libros, deberá ingresar los códigos hasta cuando quiera confirmarsu préstamo,entonces deberá enviar la letra C:
```
Confirmar préstamo: C
Cancelar préstamo: X
Código: 
003
Código: 
C
Libros prestados con éxito!
```

Y para cancelar el préstamo, deberá enviar como código la letra X:
```
Confirmar préstamo: C
Cancelar préstamo: X
Código: 
003
Código: 
X
Préstamo Cancelado
```
