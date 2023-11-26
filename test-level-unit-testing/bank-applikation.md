# Software-Dokumentation: Bankensystem

## Klassendiagramm-Übersicht

Das Klassendiagramm zeigt die Architektur eines Bankensystems. Es definiert verschiedene Klassen und die Beziehungen zwischen ihnen.

### Klasse: Bank

- Verantwortlich für die Erstellung von Konten (`createAccount()`)
- Kann Einzahlungen entgegennehmen (`deposit()`)
- Gibt Kontostand aus (`getBalance()`)
- Druckfunktionalitäten (`print()`)
- Geldabhebungen (`withdraw()`)

### Klasse: Account

- Grundlegende Kontoattribute wie Balance (`balance`) und ID (`id`)
- Transaktionsfähigkeit (`canTransact()`)
- Einzahlungen (`deposit()`)
- Druckfunktionalitäten (`print()`)
- Geldabhebungen (`withdraw()`)

### Abgeleitete Klassen von Account

#### SavingsAccount

- Spezialisiert auf Sparfunktionen
- Verfügt über eine eigene Abhebefunktion (`withdraw()`)

#### SalaryAccount

- Spezialisiert auf Gehaltskonten
- Verfügt über eine eigene Abhebefunktion (`withdraw()`)

#### PromoYouthSavingsAccount

- Spezialisierte Sparfunktionen für junge Kunden
- Eigene Einzahlungsfunktion (`deposit()`)

### Klasse: Booking

- Buchungstransaktionen mit Attributen wie Betrag (`amount`) und Datum (`date`)
- Druckfunktionalitäten (`print()`)

### Klasse: BankUtils

- Enthält Hilfsfunktionen wie Formatierung von Beträgen (`formatAmount()`) und Daten (`formatBankDate()`)
- Verwendet `DecimalFormat` für die Formatierung

## Beziehungen

- `Bank` kann mehrere `Account`-Objekte haben (1 zu viele)
- `Account` ist die Basisklasse für `SavingsAccount`, `SalaryAccount`, und `PromoYouthSavingsAccount`
- `BankUtils` wird von anderen Klassen aufgerufen, um Formatierungen durchzuführen

## Sonstige Anmerkungen

- Das Diagramm zeigt auch abstrakte Methoden (gekennzeichnet durch Kursivschrift).
- Assoziationen sind durch Linien dargestellt, wobei gestrichelte Linien Aufrufe zwischen Methoden anzeigen.
- Der `Bank`-Klasse ist ein Schlüssel zugeordnet, was auf eine Identifizierung oder Authentifizierung hindeuten könnte.

