# Ejemplos

|Aspecto|[`Person` inmutable](./e001/Person.java)|[`Person` mutable](./e000/Person.java)
|----------------------------------|-----------------------------------------------------------|----------------------------------------------------------|
|**Modificación**                |No se modifica. Se crea un **nuevo objeto**.                  |Se modifica **el mismo objeto** en memoria.              |
|**Métodos de cambio**           |Usa **withers** (ej.: `withName`) que retornan nuevas copias. |Usa **setters** (ej.: `setName`) que alteran el estado interno. |
|**Referencias**                 |Las referencias antiguas **no cambian** su contenido.         |Todas las referencias **ven los cambios** en el objeto.  |
|**Seguridad frente a errores**  |Más segura: evita cambios accidentales.                       |Menos segura: cualquier referencia puede alterar datos. |
|**Ejemplo de cambio**           |`Person nueva = original.withName("NuevoNombre");`            |`original.setName("NuevoNombre");`                       |
|**¿El objeto original cambia?** |**No**, permanece igual.                                      |**Sí**, cambia directamente.                             |
|**Uso típico**                  |Programación funcional, concurrencia, diseño robusto.         |Programación estructurada, rápida para cambios simples.  |
|**Costo de operación**          |Mayor (se crean nuevos objetos).                              |Menor (se altera el mismo objeto).                       |

> [2Think!](2Think.md)
