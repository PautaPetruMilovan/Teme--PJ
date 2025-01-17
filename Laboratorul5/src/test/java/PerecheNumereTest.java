import org.example.Lab5Ex2PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest {

    @Test
    void testSuntConsecutiveFibonacci() {
        Lab5Ex2PerecheNumere pereche1 = new Lab5Ex2PerecheNumere(8, 13); // Fibonacci consecutive
        Lab5Ex2PerecheNumere pereche2 = new Lab5Ex2PerecheNumere(21, 34); // Fibonacci consecutive
        Lab5Ex2PerecheNumere pereche3 = new Lab5Ex2PerecheNumere(8, 21); // Not consecutive

        assertTrue(pereche1.suntConsecutiveFibonacci());
        assertTrue(pereche2.suntConsecutiveFibonacci());
        assertFalse(pereche3.suntConsecutiveFibonacci());
    }

    @Test
    void testCmmmc() {
        Lab5Ex2PerecheNumere pereche1 = new Lab5Ex2PerecheNumere(12, 18);
        Lab5Ex2PerecheNumere pereche2 = new Lab5Ex2PerecheNumere(14, 28);
        Lab5Ex2PerecheNumere pereche3 = new Lab5Ex2PerecheNumere(9, 10);

        assertEquals(36, pereche1.cmmmc());
        assertEquals(28, pereche2.cmmmc());
        assertEquals(90, pereche3.cmmmc());
    }

    @Test
    void testSumaCifrelorEgala() {
        Lab5Ex2PerecheNumere pereche1 = new Lab5Ex2PerecheNumere(123, 231); // Suma cifrelor este 6
        Lab5Ex2PerecheNumere pereche2 = new Lab5Ex2PerecheNumere(45, 54); // Suma cifrelor este 9
        Lab5Ex2PerecheNumere pereche3 = new Lab5Ex2PerecheNumere(14, 27); // Suma cifrelor nu este egală

        assertTrue(pereche1.sumaCifrelorEgala());
        assertTrue(pereche2.sumaCifrelorEgala());
        assertFalse(pereche3.sumaCifrelorEgala());
    }

    @Test
    void testAcelasiNumarDeCifrePare() {
        Lab5Ex2PerecheNumere pereche1 = new Lab5Ex2PerecheNumere(248, 684); // 2 cifre pare
        Lab5Ex2PerecheNumere pereche2 = new Lab5Ex2PerecheNumere(1234, 5678); // 2 cifre pare
        Lab5Ex2PerecheNumere pereche3 = new Lab5Ex2PerecheNumere(135, 246); // Diferență în numărul de cifre pare

        assertTrue(pereche1.acelasiNumarDeCifrePare());
        assertTrue(pereche2.acelasiNumarDeCifrePare());
        assertFalse(pereche3.acelasiNumarDeCifrePare());
    }
}
