# Ejercicios — CommandExecutor y plugin.yml

> Objetivo: practicar comandos de Spigot mediante ejercicios pequeños y progresivos.
> No implementar todavía sistemas reales de MondaCoins, vidas o eventos.

---

## Ejercicio 1 — CommandSender

### Objetivo

Entender qué es `CommandSender` y diferenciar un jugador de la consola.

Haz que:

```text
/monda
```

responda al jugador:

```text
Hola, <nombre>
```

### Prueba adicional

Ejecuta `/monda` desde la consola del servidor.

Investiga:

- ¿Qué tipo de objeto es `sender`?
- ¿Qué relación tiene `CommandSender` con `Player`?
- ¿Por qué no puedes asumir que `sender` siempre es un `Player`?

### Pista

Investiga `instanceof` y la relación entre `CommandSender` y `Player`.

---

## Ejercicio 2 — Primer argumento

### Objetivo

Practicar el uso de `args`.

Haz que:

```text
/monda hola
```

responda:

```text
Has utilizado el argumento hola
```

Y:

```text
/monda coins
```

responda:

```text
Has utilizado el argumento coins
```

### Prueba adicional

Ejecuta:

```text
/monda
```

El plugin no debe producir un error.

### Debes investigar

- `args`
- `args.length`
- `args[0]`

---

## Ejercicio 3 — Subcomandos

### Objetivo

Crear diferentes comportamientos utilizando el primer argumento.

Haz que existan:

```text
/monda help
/monda coins
/monda lives
```

Cada uno debe mostrar un mensaje diferente.

### Prueba adicional

¿Qué ocurre con?

```text
/monda cualquiercosa
```

Crea una respuesta apropiada para ese caso.

### Pista

Puedes utilizar `switch`.

---

## Ejercicio 4 — Múltiples argumentos

### Objetivo

Aprender a trabajar con varios argumentos.

Haz que el comando:

```text
/monda coins give Johan 100
```

reconozca:

```text
args[0] → coins
args[1] → give
args[2] → Johan
args[3] → 100
```

No necesitas modificar realmente las monedas.

Simplemente muestra algo como:

```text
Sistema: coins
Acción: give
Jugador: Johan
Cantidad: 100
```

### Pruebas adicionales

Prueba:

```text
/monda coins
/monda coins give
/monda coins give Johan
```

El plugin debe manejar correctamente los argumentos faltantes.

---

## Ejercicio 5 — Comandos exclusivos para jugadores

### Objetivo

Aprender a diferenciar entre jugadores y otros `CommandSender`.

Haz que:

```text
/monda coins
```

solamente pueda ser utilizado por jugadores.

Si la consola intenta utilizarlo, debe recibir un mensaje indicando que el comando solamente puede ser utilizado por jugadores.

Sin embargo:

```text
/monda help
```

sí debe funcionar desde la consola.

### Debes pensar

¿En qué momento debes comprobar si `sender` es un `Player`?

---

## Ejercicio 6 — Comando administrativo

### Objetivo

Practicar una estructura de subcomandos más profunda.

Crea:

```text
/monda admin reload
```

Por ahora no necesitas recargar ninguna configuración.

Simplemente muestra:

```text
Configuración recargada correctamente.
```

### Estructura

```text
/monda
    └── admin
          └── reload
```

### Prueba adicional

Comprueba qué ocurre con:

```text
/monda admin
/monda admin hola
```

---

# plugin.yml

## Ejercicio 7 — Descripción y uso

### Objetivo

Practicar la información que se declara sobre un comando en `plugin.yml`.

Modifica la declaración de `/monda` para que tenga:

- Descripción.
- Uso (`usage`).

Investiga para qué sirve cada propiedad.

### Debes entender

`plugin.yml`:

```text
declara el comando
```

Mientras que `CommandExecutor`:

```text
define qué hace el comando
```

---

## Ejercicio 8 — Alias

### Objetivo

Aprender a crear aliases para un comando.

Haz que `/monda` tenga un alias corto.

Por ejemplo:

```text
/m
```

Deberían funcionar ambos:

```text
/monda
/m
```

Y ambos deben terminar ejecutando el mismo `CommandExecutor`.

### Debes investigar

`aliases` dentro de `plugin.yml`.

---

## Ejercicio 9 — Segundo comando

### Objetivo

Aprender a registrar más de un comando.

Crea:

```text
/mondaevent
```

Al ejecutarlo debe mostrar:

```text
Sistema de eventos de Monda.
```

Ahora tu plugin tendrá:

```text
/monda
/mondaevent
```

### Debes entender

Cada comando puede tener su propio `CommandExecutor`.

---

## Ejercicio 10 — Permisos

### Objetivo

Aprender la relación entre comandos y permisos.

Haz que:

```text
/monda admin reload
```

requiera un permiso como:

```text
monda.admin
```

Un jugador con el permiso podrá utilizarlo.

Un jugador sin el permiso no podrá utilizarlo.

### Debes investigar

- `permissions` en `plugin.yml`
- Cómo comprobar permisos desde el comando.
- Qué ocurre cuando un jugador no tiene el permiso.

---

# Ejercicio final — Sistema de comandos de Monda

Combina todo lo aprendido.

Tu comando principal debe soportar:

```text
/monda
/monda help
/monda coins
/monda lives
/monda event
/monda admin reload
```

### Reglas

```text
/monda help
→ Jugadores y consola.

/monda coins
→ Jugadores.

/monda lives
→ Jugadores.

/monda event
→ Jugadores y consola.

/monda admin reload
→ Solamente usuarios con el permiso correspondiente.
```

No implementes todavía:

- MondaCoins reales.
- Sistema de vidas.
- Eventos.
- Recarga real del `config.yml`.
- Base de datos.
- GUI.

El objetivo es practicar exclusivamente:

```text
CommandExecutor
      ↓
CommandSender
      ↓
Player
      ↓
args
      ↓
Subcomandos
      ↓
plugin.yml
      ↓
Aliases
      ↓
Permisos
```

---

# Orden recomendado

1. `CommandSender`
2. `args`
3. Subcomandos
4. Múltiples argumentos
5. Jugador vs. consola
6. Subcomandos administrativos
7. `plugin.yml` — descripción y uso
8. Aliases
9. Segundo comando
10. Permisos
11. Ejercicio final
