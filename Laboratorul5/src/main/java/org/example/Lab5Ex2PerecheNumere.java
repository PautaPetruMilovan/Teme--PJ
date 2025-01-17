package org.example;

import java.util.Objects;

public class Lab5Ex2PerecheNumere {
    private int numar1;
    private int numar2;

    // Constructor fără parametri
    public Lab5Ex2PerecheNumere() {
    }

    // Constructor cu parametri
    public Lab5Ex2PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    // Gettere și settere
    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    // Verificare dacă numerele sunt consecutive în șirul Fibonacci
    public boolean suntConsecutiveFibonacci() {
        return isFibonacci(numar1) && isFibonacci(numar2) && Math.abs(indexFibonacci(numar1) - indexFibonacci(numar2)) == 1;
    }

    private boolean isFibonacci(int n) {
        int x1 = 5 * n * n + 4;
        int x2 = 5 * n * n - 4;
        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    private boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }

    private int indexFibonacci(int n) {
        int a = 0, b = 1, index = 0;
        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;
            index++;
        }
        return (b == n) ? index : -1;
    }

    // Calcularea celui mai mic multiplu comun (CMMMC)
    public int cmmmc() {
        return (numar1 * numar2) / cmmdc(numar1, numar2);
    }

    private int cmmdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Verificare dacă suma cifrelor celor două numere este egală
    public boolean sumaCifrelorEgala() {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }

    private int sumaCifrelor(int n) {
        int suma = 0;
        while (n != 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    // Verificare dacă numerele au același număr de cifre pare
    public boolean acelasiNumarDeCifrePare() {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int numarCifrePare(int n) {
        int count = 0;
        while (n != 0) {
            if ((n % 10) % 2 == 0) count++;
            n /= 10;
        }
        return count;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "numar1=" + numar1 +
                ", numar2=" + numar2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab5Ex2PerecheNumere that = (Lab5Ex2PerecheNumere) o;
        return numar1 == that.numar1 && numar2 == that.numar2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numar1, numar2);
    }
}
