package org.example;

import java.sql.*;
import java.util.Scanner;

public class Lab8Main {
    private static final String URL = "jdbc:mysql://localhost:3306/lab8";
    private static final String USER = "root"; // Înlocuiește cu utilizatorul tău
    private static final String PASSWORD = ""; // Adaugă parola ta, dacă este cazul

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\nMeniu:");
                System.out.println("1. Adăugare persoană");
                System.out.println("2. Adăugare excursie");
                System.out.println("3. Afișare persoane și excursii");
                System.out.println("4. Afișare excursii pentru o persoană");
                System.out.println("5. Afișare persoane care au vizitat o destinație");
                System.out.println("6. Afișare persoane care au făcut excursii într-un an introdus");
                System.out.println("7. Ștergere excursie");
                System.out.println("8. Ștergere persoană (împreună cu excursiile)");
                System.out.println("9. Ieșire");

                System.out.print("Alege o opțiune: ");
                int optiune = scanner.nextInt();
                scanner.nextLine(); // Consumă linia

                switch (optiune) {
                    case 1 -> adaugaPersoana(connection, scanner);
                    case 2 -> adaugaExcursie(connection, scanner);
                    case 3 -> afisarePersoaneSiExcursii(connection);
                    case 4 -> afisareExcursiiPentruPersoana(connection, scanner);
                    case 5 -> afisarePersoanePentruDestinatie(connection, scanner);
                    case 6 -> afisarePersoanePentruAn(connection, scanner);
                    case 7 -> stergereExcursie(connection, scanner);
                    case 8 -> stergerePersoana(connection, scanner);
                    case 9 -> running = false;
                    default -> System.out.println("Opțiune invalidă!");
                }
            }

        } catch (SQLException e) {
            System.err.println("Eroare la conectarea la baza de date: " + e.getMessage());
        }
    }

    private static void adaugaPersoana(Connection connection, Scanner scanner) {
        System.out.print("Introdu numele persoanei: ");
        String nume = scanner.nextLine();
        System.out.print("Introdu vârsta persoanei: ");
        int varsta = scanner.nextInt();

        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO persoane (nume, varsta) VALUES (?, ?)")) {
            stmt.setString(1, nume);
            stmt.setInt(2, varsta);
            stmt.executeUpdate();
            System.out.println("Persoana a fost adăugată cu succes.");
        } catch (SQLException e) {
            System.err.println("Eroare la adăugarea persoanei: " + e.getMessage());
        }
    }

    private static void adaugaExcursie(Connection connection, Scanner scanner) {
        System.out.print("Introdu ID-ul persoanei: ");
        int idPersoana = scanner.nextInt();
        scanner.nextLine(); // Consumă linia
        System.out.print("Introdu destinația excursiei: ");
        String destinatia = scanner.nextLine();
        System.out.print("Introdu anul excursiei: ");
        int anul = scanner.nextInt();

        try (PreparedStatement stmtVerificare = connection.prepareStatement("SELECT id FROM persoane WHERE id = ?")) {
            stmtVerificare.setInt(1, idPersoana);
            ResultSet rs = stmtVerificare.executeQuery();

            if (!rs.next()) {
                System.out.println("Persoana cu acest ID nu există.");
                return;
            }

            try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO excursii (id_persoana, destinatia, anul) VALUES (?, ?, ?)")) {
                stmt.setInt(1, idPersoana);
                stmt.setString(2, destinatia);
                stmt.setInt(3, anul);
                stmt.executeUpdate();
                System.out.println("Excursia a fost adăugată cu succes.");
            }

        } catch (SQLException e) {
            System.err.println("Eroare la adăugarea excursiei: " + e.getMessage());
        }
    }

    private static void afisarePersoaneSiExcursii(Connection connection) {
        String query = "SELECT p.nume, p.varsta, e.destinatia, e.anul FROM persoane p LEFT JOIN excursii e ON p.id = e.id_persoana";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Nume: " + rs.getString("nume") + ", Vârstă: " + rs.getInt("varsta") +
                        ", Destinație: " + rs.getString("destinatia") + ", An: " + rs.getInt("anul"));
            }
        } catch (SQLException e) {
            System.err.println("Eroare la afișare: " + e.getMessage());
        }
    }

    private static void afisareExcursiiPentruPersoana(Connection connection, Scanner scanner) {
        System.out.print("Introdu numele persoanei: ");
        String nume = scanner.nextLine();

        String query = "SELECT e.destinatia, e.anul FROM persoane p JOIN excursii e ON p.id = e.id_persoana WHERE p.nume = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nume);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Excursii pentru " + nume + ":");
            while (rs.next()) {
                System.out.println("Destinație: " + rs.getString("destinatia") + ", An: " + rs.getInt("anul"));
            }

        } catch (SQLException e) {
            System.err.println("Eroare la afișare: " + e.getMessage());
        }
    }

    private static void afisarePersoanePentruDestinatie(Connection connection, Scanner scanner) {
        System.out.print("Introdu destinația: ");
        String destinatia = scanner.nextLine();

        String query = "SELECT p.nume, p.varsta FROM persoane p JOIN excursii e ON p.id = e.id_persoana WHERE e.destinatia = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, destinatia);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Persoane care au vizitat " + destinatia + ":");
            while (rs.next()) {
                System.out.println("Nume: " + rs.getString("nume") + ", Vârstă: " + rs.getInt("varsta"));
            }

        } catch (SQLException e) {
            System.err.println("Eroare la afișare: " + e.getMessage());
        }
    }

    private static void afisarePersoanePentruAn(Connection connection, Scanner scanner) {
        System.out.print("Introdu anul: ");
        int anul = scanner.nextInt();

        String query = "SELECT p.nume, p.varsta FROM persoane p JOIN excursii e ON p.id = e.id_persoana WHERE e.anul = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, anul);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Persoane care au făcut excursii în anul " + anul + ":");
            while (rs.next()) {
                System.out.println("Nume: " + rs.getString("nume") + ", Vârstă: " + rs.getInt("varsta"));
            }

        } catch (SQLException e) {
            System.err.println("Eroare la afișare: " + e.getMessage());
        }
    }

    private static void stergereExcursie(Connection connection, Scanner scanner) {
        System.out.print("Introdu ID-ul excursiei de șters: ");
        int idExcursie = scanner.nextInt();

        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM excursii WHERE id_excursie = ?")) {
            stmt.setInt(1, idExcursie);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Excursia a fost ștearsă cu succes.");
            } else {
                System.out.println("Nu s-a găsit nicio excursie cu acest ID.");
            }
        } catch (SQLException e) {
            System.err.println("Eroare la ștergere: " + e.getMessage());
        }
    }

    private static void stergerePersoana(Connection connection, Scanner scanner) {
        System.out.print("Introdu ID-ul persoanei de șters: ");
        int idPersoana = scanner.nextInt();

        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM persoane WHERE id = ?")) {
            stmt.setInt(1, idPersoana);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Persoana și excursiile asociate au fost șterse cu succes.");
            } else {
                System.out.println("Nu s-a găsit nicio persoană cu acest ID.");
            }
        } catch (SQLException e) {
            System.err.println("Eroare la ștergere: " + e.getMessage());
        }
    }
}
