
# JUnit 5 Features

JUnit 5 ist die neueste Generation des standardmäßigen Frameworks für Unit-Tests in Java. Es bringt viele neue Features und Verbesserungen gegenüber seinen Vorgängern. Hier sind einige der herausragenden Merkmale und deren Anwendungsfälle.

## 1. Annotations
JUnit 5 bietet eine Reihe von Annotations, die für verschiedene Zwecke im Test-Lebenszyklus verwendet werden:

### `@Test`
Kennzeichnet eine Methode als Testmethode.
```java
@Test
void exampleTest() {
    assertEquals(2, 1 + 1);
}
```

### `@BeforeEach` / `@AfterEach`
Wird vor bzw. nach jeder Testmethode ausgeführt.
```java
@BeforeEach
void setUp() {
    // Initialisierungscode
}

@AfterEach
void tearDown() {
    // Aufräumcode
}
```

### `@BeforeAll` / `@AfterAll`
Wird einmal vor bzw. nach allen Testmethoden in der Klasse ausgeführt. Methoden müssen `static` sein.
```java
@BeforeAll
static void initAll() {
    // Einmalige Initialisierung
}

@AfterAll
static void cleanUpAll() {
    // Einmaliges Aufräumen
}
```

## 2. Assertions
JUnit 5 bietet eine Vielzahl von `assert`-Methoden.

### `assertEquals`
Überprüft, ob zwei Werte gleich sind.
```java
assertEquals(4, 2 + 2);
```

### `assertThrows`
Überprüft, ob eine erwartete Ausnahme geworfen wird.
```java
assertThrows(NullPointerException.class, () -> {
    throw new NullPointerException();
});
```

### `assertAll`
Gruppiert mehrere Assertions.
```java
assertAll("grouped assertions",
    () -> assertEquals(4, 2 * 2),
    () -> assertTrue(1 < 2)
);
```

## 3. Assumptions
Assumptions werden verwendet, um Tests unter bestimmten Bedingungen zu überspringen.

### `assumeTrue`
Führt den Test nur aus, wenn die Bedingung wahr ist.
```java
assumeTrue("DEV".equals(System.getenv("ENV")),
    () -> System.out.println("Nur in DEV ausführen"));
```

## 4. Tagging und Filtering
Tests können mit Tags versehen und entsprechend gefiltert werden.

### `@Tag`
Markiert Tests für bestimmte Zwecke.
```java
@Tag("nightly")
@Test
void nightlyTest() {
    // Code für nächtlichen Test
}
```

## 5. Test Suites
JUnit 5 ermöglicht die Gruppierung von Tests in Suiten.

### `@SelectClasses` / `@SelectPackages`
Ermöglicht die Auswahl von Klassen oder Paketen für eine Test Suite.
```java
@SelectClasses({TestClass1.class, TestClass2.class})
class AllTestsSuite {
    // Code für Test Suite
}
```

## 6. Erweiterungen
JUnit 5 unterstützt benutzerdefinierte Erweiterungen durch Implementierung von verschiedenen Interfaces.

### `TestInstancePostProcessor`, `BeforeEachCallback`, etc.
Ermöglichen benutzerdefinierte Logik vor und nach Tests.
```java
public class MyExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // Benutzerdefinierte Logik vor jedem Test
    }
}
```

---

Weitere Informationen zu JUnit 5 und dessen Features finden Sie in der [offiziellen JUnit 5 Benutzeranleitung](https://junit.org/junit5/docs/current/user-guide/).
