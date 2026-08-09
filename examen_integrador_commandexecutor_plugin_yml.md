# Examen integrador — CommandExecutor + plugin.yml

**Tiempo objetivo:** 60–90 minutos. Si te toma hasta **2 horas**, está bien.

## Contexto

Crea un pequeño sistema llamado **Mondaland Tools**.

Comando principal:

`/mtools`

Alias:

`/mt`

Debes demostrar manejo de `CommandExecutor`, `CommandSender`, `Player`, consola, `args`, subcomandos, validaciones, permisos, `Bukkit.getPlayer()`, `null`, `plugin.yml` y aliases.

---

# PARTE 1 — plugin.yml

Declara `/mtools`.

Debe tener:

- `description`
- `usage`
- alias `mt`

Crea además el permiso:

`mtools.admin`

Debe tener descripción y `default: op`.

---

# PARTE 2 — `/mtools`

Cuando un jugador ejecuta:

`/mtools`

debe recibir una ayuda que muestre como mínimo:

```text
=== Mondaland Tools ===

/mtools help
/mtools player <jugador>
/mtools admin reload
```

Puedes agregar información adicional.

---

# PARTE 3 — `/mtools help`

Debe funcionar:

`/mtools help`

Debe mostrar como mínimo:

- nombre/sección del plugin
- `/mtools help`
- `/mtools player <jugador>`
- `/mtools admin reload`

Debe funcionar tanto desde jugador como desde consola.

No necesitas mostrar información diferente según el tipo de sender.

---

# PARTE 4 — `/mtools player`

Debe existir:

`/mtools player <jugador>`

Ejemplo:

`/mtools player JLealM`

Busca al jugador mediante Bukkit.

Si está conectado, muestra algo parecido a:

```text
=== Player Info ===
Jugador: JLealM
Estado: ONLINE
```

Si no está conectado:

```text
El jugador no existe o no está conectado.
```

No puede producir `NullPointerException`.

---

# PARTE 5 — Validación de `player`

Maneja correctamente:

`/mtools player`

`/mtools player JLealM extra`

Deben mostrar:

```text
Uso: /mtools player <jugador>
```

sin producir errores.

---

# PARTE 6 — `/mtools admin reload`

Debe existir:

`/mtools admin reload`

Solamente puede ejecutarlo alguien con:

`mtools.admin`

Con permiso:

```text
Configuración recargada correctamente.
```

Sin permiso:

```text
No tienes permiso para utilizar este comando.
```

La consola también debe poder ejecutarlo.

No necesitas hacer una recarga real de `config.yml`; por ahora es una simulación.

---

# PARTE 7 — Validaciones de `admin`

Maneja correctamente:

`/mtools admin`

`/mtools admin pepe`

`/mtools admin reload algo`

Debe mostrar:

```text
Uso: /mtools admin reload
```

sin lanzar excepciones.

---

# PARTE 8 — Comandos desconocidos

Para:

`/mtools hola`

o:

`/mtools xd`

debe mostrar:

```text
Comando desconocido. Utiliza /mtools help.
```

No debe mostrar accidentalmente mensajes de `player` o `admin`.

---

# PARTE 9 — Pruebas

Prueba como mínimo:

```text
/mtools
/mtools help
/mtools player
/mtools player JLealM
/mtools player JLealM algo
/mtools admin
/mtools admin reload
/mtools admin reload algo
/mtools cualquiercosa
```

Además:

- `/mtools admin reload` desde consola
- con jugador OP
- con jugador sin OP
- jugador conectado
- jugador desconectado

Ninguno debe producir errores en consola.

---

# PARTE 10 — Restricciones

No necesitas:

- managers
- services
- models
- repositories
- database
- GUI
- listeners
- scheduler

Puedes resolverlo con un `CommandExecutor` y tu clase principal. No necesitas crear más clases salvo que realmente lo consideres necesario.

---

# PARTE 11 — Requisitos técnicos

Debes utilizar correctamente:

- `CommandExecutor`
- `CommandSender`
- `Player`
- `args`
- `Bukkit.getPlayer()`
- comprobación de `null`
- `hasPermission("mtools.admin")`
- declaración del comando y permiso en `plugin.yml`

---

# PARTE 12 — Uso de ayuda externa

No copies una solución completa de Internet.

Puedes consultar documentación para recordar la sintaxis de una API concreta. Por ejemplo, puedes consultar cómo funciona `Bukkit.getPlayer()`.

El razonamiento y la estructura deben salir de ti.

---

# PARTE 13 — Entrega

Cuando termines, entrega:

1. `MToolsCommand.java`
2. `plugin.yml`
3. `Basico.java`

Se evaluará sobre **100 puntos**:

| Área | Puntos |
|---|---:|
| `CommandExecutor` y estructura | 15 |
| Manejo de `args` | 20 |
| `Player` / consola | 15 |
| Validaciones | 15 |
| `Bukkit.getPlayer()` + `null` | 10 |
| Permisos | 10 |
| `plugin.yml` | 10 |
| Limpieza/legibilidad | 5 |
| **Total** | **100** |

### Escala

- **90–100:** cerrar esta etapa.
- **80–89:** corregir un par de detalles y cerrar.
- **70–79:** ejercicio corto adicional.
- **<70:** reforzar conceptos.

---

# Regla del examen

No pidas la solución mientras lo estás resolviendo.

Si te atoras, intenta resolverlo primero. Si después de **10–15 minutos** sigues bloqueado, puedes pedir una **pista**, no la solución.

## Tiempo recomendado

- **60–90 min:** objetivo ideal.
- **90–120 min:** completamente aceptable.
- Más de 2 horas: si estás atascado, pide una pista.
