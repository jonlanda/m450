# m450

## Zusammenfassung (Introduction):
Das Testkonzept dient dazu, die Funktionalität und Zuverlässigkeit des "Football Player Stats Comparator" zu gewährleisten. Dieses Java-Programm ermöglicht es, die Statistiken von zwei Fußballspielern einzugeben, ihre Leistung zu vergleichen und den Gewinner aufgrund einer Punktzahl zu ermitteln.

## Big Picture - System Architektur mit den Test Items:
Das Programm besteht aus einer einfachen Konsolenanwendung, die Benutzereingaben annimmt, Statistiken berechnet und einen Gewinner basierend auf den Punkten ermittelt. Die Hauptkomponenten umfassen die Benutzerschnittstelle, die Statistikberechnungen und die Punktevergabe.

## Test Features - welche Elemente getestet werden:
1. Eingabevalidierung: Überprüfung, ob die Eingaben für Spieler 1 und Spieler 2 korrekt sind.
2. Berechnung der Punkte: Gewährleistung der korrekten Berechnung der Punkte gemäß den gegebenen Kriterien.
3. Gewinnerermittlung: Überprüfung, ob der Gewinner korrekt basierend auf den Punkten ermittelt wird.

## Features not to be tested - welche Aspekte nicht getestet werden:
1. Grafische Benutzeroberfläche: Da es sich um eine Konsolenanwendung handelt, werden keine GUI-Tests durchgeführt.
2. Netzwerkkommunikation oder Datenbankzugriff: Das Programm hat keine Netzwerk- oder Datenbankfunktionalität.

## Testvorgehen - Ihr Projekt wird nach dem TDD umgesetzt:
1. Schreiben von Testfällen vor der Implementierung.
2. Implementierung des Programms, um die Tests erfolgreich durchzuführen.
3. Wiederholtes Testen und Debuggen, um sicherzustellen, dass alle Tests bestanden werden.
4. Bei Bedarf Anpassung und Erweiterung der Tests.

## Kriterien für erfolgreiche / nicht-erfolgreiche Tests (optional):
- Erfolgreiche Tests: Alle Testfälle bestehen ohne Fehler oder Ausnahmen.
- Nicht erfolgreiche Tests: Ein oder mehrere Testfälle schlagen fehl, und es treten Fehler oder Ausnahmen auf.

## Testumgebung - welche Tools Sie für das Testen verwenden:
- JUnit Framework: Zur Durchführung von Unittests und Testautomatisierung.
- Entwicklungsumgebung: Eclipse, IntelliJ oder eine andere Java-IDE zur Codeerstellung und Testausführung.

## Kurze Planung:
1. Erstellung einer Liste von Testfällen für die Eingabevalidierung, Punkteberechnung und Gewinnerermittlung.
2. Implementierung des Programms unter Berücksichtigung der Testfälle.
3. Durchführung von Unittests mit JUnit, um sicherzustellen, dass die Funktionen wie erwartet arbeiten.
4. Debuggen und Anpassen des Codes bei Bedarf, um alle Testfälle erfolgreich zu bestehen.
5. Abschlussprüfung, um sicherzustellen, dass die Gesamtfunktionalität des Programms korrekt ist.

Mit diesem Testkonzept können Sie sicherstellen, dass Ihr "Football Player Stats Comparator" zuverlässig und gemäß den Spezifikationen funktioniert.
