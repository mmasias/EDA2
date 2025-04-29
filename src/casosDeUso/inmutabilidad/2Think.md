# 2Think

## Caso 001

Considere:

```java
public class Student {
    private final String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {
        Student a = new Student("Leo", 80);
        Student b = a;
        
        b.setScore(90);

        System.out.println("Score of a: " + a.getScore());
        System.out.println("Score of b: " + b.getScore());
    }
}
```

### Preguntas

#### ¿Qué impresión aparece en consola?

- a) Score of a: 80 / Score of b: 90
- b) Score of a: 90 / Score of b: 90
- c) Score of a: 80 / Score of b: 80
- d) Score of a: 90 / Score of b: 80

#### `Student` ¿es mutable o inmutable? ¿Por qué?

#### ¿Cómo alteraría su condición¿ (es decir, si es inmutable, como hacerla mutable o viceversa)

<details>
<summary>Mostrar solución</summary>

**Respuestas:**

1. **Respuesta correcta: b)**  
   Ambas (`a` y `b`) apuntan al mismo objeto, y el `setScore` cambia directamente su estado.

2. **Mutable.**  
   Porque tiene un `setScore`, y el atributo `score` puede cambiar después de creado el objeto.

3. Para volverla inmutable:
   - Eliminar el `setScore`.
   - Marcar `score` como `final`.
   - Para modificar el `score`, agregar un **wither** como:
     ```java
     public Student withScore(int score) {
         return new Student(this.name, score);
     }
     ```
</details>



## Caso 002

Considere

```java
public class Professor {
    private final String name;
    private final int age;

    public Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Professor withAge(int newAge) {
        return new Professor(this.name, newAge);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Assistant {
    private String name;
    private int age;

    public Assistant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        Professor prof1 = new Professor("Dr. Smith", 50);
        Professor prof2 = prof1.withAge(55);

        Assistant assistant1 = new Assistant("John", 25);
        Assistant assistant2 = assistant1;
        
        assistant2.setAge(30);

        System.out.println("prof1 age: " + prof1.getAge());
        System.out.println("prof2 age: " + prof2.getAge());
        System.out.println("assistant1 age: " + assistant1.getAge());
        System.out.println("assistant2 age: " + assistant2.getAge());
    }
}
```

---

### Preguntas

#### ¿Qué impresión aparecerá en consola?  

   ```
   prof1 age: ?
   prof2 age: ?
   assistant1 age: ?
   assistant2 age: ?
   ```

#### ¿`prof1` y `prof2` interfieren entre sí? ¿Por qué?

#### ¿`assistant1` y `assistant2` interfieren entre sí? ¿Por qué?

<details>
<summary>Mostrar solución</summary>

1. Salida esperada:

   ```
   prof1 age: 50
   prof2 age: 55
   assistant1 age: 30
   assistant2 age: 30
   ```

2. No: `Professor` es **inmutable**: cada vez que se "cambia" algo, en realidad se crea un **nuevo objeto** con el método `withAge`, por eso `prof1` y `prof2` son diferentes.

3. Sí: `Assistant` es **mutable**: `assistant1` y `assistant2` **apuntan al mismo objeto en memoria**, así que cambiar uno cambia el otro.
</details>
