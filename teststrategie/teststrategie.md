# Test-Strategie

## Lernziele

* Ich kenne die Elemente einer Teststrategie
* Ich kann den Unterschied zwischen abstrakten und konkreten Testfällen erklären
* Ich kenne den Unterschied zwischen funktionalen und nicht-funktionalen Testfällen und kann Beispiele nennen
* Ich kann Testmethoden erklären

---

## Zusammenfassung
### Testobjekte:
Identifikation der Komponenten oder Teile der Anwendung, die getestet werden müssen. Beispiele reichen von Programmmodulen bis zu Skripten und Datenkonvertierungsverfahren. Beispielsweise könnte man in einer Software für Autovermietungen nur die Abrechnungskomponente testen, die Rechnungen für Kunden erstellt.

### Testfälle:
Hierbei geht es darum, festzulegen, was genau in der Software getestet wird. Das Dokument unterscheidet zwischen funktionalen Testfällen (die auf Kundenanforderungen basieren und die Funktionen der Software beschreiben) und nicht-funktionalen Testfällen (wie leistungsbezogene Aspekte). Es wird auch zwischen abstrakten Testfällen, die logische Operatoren ohne spezifische Werte verwenden, und konkreten Testfällen, die spezifische Eingabe- und Ausgabewerte beinhalten, unterschieden.

### Testmethoden:
Die Auswahl, wie getestet wird, ist entscheidend. Dies umfasst die Entscheidung zwischen Black-Box- und White-Box-Tests. White-Box-Tests eignen sich für Tests auf Unit-Ebene, bei denen der Code sichtbar und gründlich untersuchbar ist. Im Gegensatz dazu werden Black-Box-Tests verwendet, wenn der Code nicht sichtbar ist, wie bei kompilierten Anwendungen, und werden oft von einem Testteam durchgeführt.

### Testumgebung:
Abschließend hebt das Dokument die Bedeutung der Definition der Testumgebung hervor, die eng mit den gewählten Testmethoden verbunden ist. Dies beinhaltet die Auswahl geeigneter Tools und Ressourcen zur Durchführung der Tests.

## Übungen
### Aufgabe 1
#### Abstrakte Testfälle
| Testfall | Bedingung                 | Ergebnis    |
|----------|---------------------------|-------------|
| T1       | Preis < 15'000            | kein Rabatt |
| T2       | 15'000 <= Preis <= 20'000 |  5% Rabatt  |
| T3       | 20'000 < Preis < 25'000   | 7% Rabatt   |
| T4       | Preis >= 25'000           | 8.5% Rabatt |

#### Konkrete Testfälle
| Testfall | Eingabe                         | Ergebnis    |
|----------|---------------------------------|-------------|
| T1       | Auto wird für 12'000 gekauft    | kein Rabatt |
| T2       | Auto wird für 17'000 gekauft    |  5% Rabatt  |
| T3       | Auto wird für 23'000 gekauft    | 7% Rabatt   |
| T4       | Auto wird für 2'000'000 gekauft | 8.5% Rabatt |

### Aufgabe 2
| ID | Beschreibung                             | Erwartetes Resultat                                          | Effektives Resultat                                            | Status      | Mögliche Ursache |
|----|------------------------------------------|--------------------------------------------------------------|----------------------------------------------------------------|-------------|------------------|
| 1  | Homebutton führt mich zurück zu Homepage | Lande wieder auf der Startseite                              | Wurde zurück zu Startseite gebracht                            | Erfolgreich | -                |
| 2  | Fahrzeuge am Flugahfen in Zürich suchen  | Alle Fahrzeuge die am Flughafen Zürich sind werden angezeigt | Alle Fahrzeugen wurden angezeigt                               | Erfolgreich | -                |
| 3  | Fahrzeug-Kategorie ändern                | Es werden nurnoch Fahrzeuge von dieser Kategorie angezeigt   | Es wurden nurnoch Fahrzeuge von dieser Kategorie angezeigt     | Erfolgreich | -                |
| 4  | Fahrzeug auswählen                       | Fahrzeug wird ausgewählt und ich kann es Mieten              | Ich muss die verschiedenen Schütze und Anzahl Personen angeben | Erfolgreich | -                |
| 5  | Buchungsanfrage senden                   | Buchunsanfrage wird gesendet und bearbeitet                  | Buchungsanfrage wird gesendet und bearbeitet von der Firma     | Erfolgreich | -                |

### Aufgabe 3
#### Black-Box
| ID | Beschreibung      | Erwartetes Resultat                                                                   |
|----|-------------------|---------------------------------------------------------------------------------------|
| 1  | Account erstellen | Account wird erstellt                                                                 |
| 2  | Geld ablegen      | Geld wird auf meinen Account abgelegt und gespeichert                                 |
| 3  | Geld abheben      | Geld wird von meinem Account abgehoben                                                |
| 4  | Währungstausch    | Währung wird korrekt umgerechnet                                                      |
| 5  | Fehler ausheben   | Falls während dem Ablegen/Abheben von Geld ein Fehler passiert ist das Geld noch dort |

#### White-Box
| ID | Beschreibung         | Erwartetes Resultat                                                                      |
|----|----------------------|------------------------------------------------------------------------------------------|
| 1  | API Request Handling | Alle calls werden bearbeitet und werfen passende Exceptions und Fehler falls nötig       |
| 2  | Data Parsing         | Sensible Daten werden richtig gespeichert und können nicht verloren gehen                |
| 3  | Exception Scenarios  | Fehlerhafte inputs werden gehandlet und passende Fehlermeldungen werden dem User gegeben |