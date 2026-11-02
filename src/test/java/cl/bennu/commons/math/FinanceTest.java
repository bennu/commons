package cl.bennu.commons.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanceTest {

    private static final double DELTA = 1e-6;

    @Test
    void testPmt() {
        assertEquals(-88.848788678, Finance.pmt(0.01, 12, 1000), DELTA);
    }

    @Test
    void testPmtWithFv() {
        assertEquals(-795.045749654, Finance.pmt(0.05, 10, 0, 10000), DELTA);
    }

    @Test
    void testPmtTypeBeginning() {
        assertEquals(-87.969097701, Finance.pmt(0.01, 12, 1000, 0, 1), DELTA);
    }

    @Test
    void testPmtOverloadsDefaults() {
        assertEquals(Finance.pmt(0.01, 12, 1000, 0, 0), Finance.pmt(0.01, 12, 1000, 0), DELTA);
        assertEquals(Finance.pmt(0.01, 12, 1000, 0, 0), Finance.pmt(0.01, 12, 1000), DELTA);
    }

    @Test
    void testFv() {
        assertEquals(2886.683880332, Finance.fv(0.05, 10, -100, -1000), DELTA);
    }

    @Test
    void testFvTypeBeginning() {
        assertEquals(1320.678716233, Finance.fv(0.05, 10, -100, 0, 1), DELTA);
    }

    @Test
    void testFvOfPmtIsZero() {
        double pmt = Finance.pmt(0.01, 12, 1000);
        assertEquals(0, Finance.fv(0.01, 12, pmt, 1000), DELTA);
    }

    @Test
    void testIpmtFirstPeriod() {
        assertEquals(-10, Finance.ipmt(0.01, 1, 12, 1000), DELTA);
    }

    @Test
    void testIpmtOverloadsDefaults() {
        assertEquals(Finance.ipmt(0.01, 5, 12, 1000, 0, 0), Finance.ipmt(0.01, 5, 12, 1000, 0), DELTA);
        assertEquals(Finance.ipmt(0.01, 5, 12, 1000, 0, 0), Finance.ipmt(0.01, 5, 12, 1000), DELTA);
    }

    @Test
    void testPpmtFirstPeriod() {
        assertEquals(-78.848788678, Finance.ppmt(0.01, 1, 12, 1000), DELTA);
    }

    @Test
    void testPpmtPlusIpmtEqualsPmt() {
        double pmt = Finance.pmt(0.01, 12, 1000, 0, 1);
        for (int per = 1; per <= 12; per++) {
            double sum = Finance.ppmt(0.01, per, 12, 1000, 0, 1) + Finance.ipmt(0.01, per, 12, 1000, 0, 1);
            assertEquals(pmt, sum, DELTA);
        }
    }

    @Test
    void testPpmtSumEqualsPrincipal() {
        double total = 0;
        for (int per = 1; per <= 12; per++) {
            total += Finance.ppmt(0.01, per, 12, 1000);
        }
        assertEquals(-1000, total, DELTA);
    }

    @Test
    void testPpmtOverloadsDefaults() {
        assertEquals(Finance.ppmt(0.01, 5, 12, 1000, 0, 0), Finance.ppmt(0.01, 5, 12, 1000, 0), DELTA);
        assertEquals(Finance.ppmt(0.01, 5, 12, 1000, 0, 0), Finance.ppmt(0.01, 5, 12, 1000), DELTA);
    }

    @Test
    void testR() {
        assertEquals(0.009488793, Finance.r(0.12, 12), DELTA);
        assertEquals(0.12, Finance.r(0.12, 1), DELTA);
    }

    @Test
    void testPvAnnuity() {
        assertEquals(1000, Finance.pv(0.01, 12, 88.848788678), DELTA);
    }

    @Test
    void testPvAnnuityZeroRate() {
        assertEquals(1200, Finance.pv(0, 12, 100), DELTA);
    }

    @Test
    void testPvWithFvAndType() {
        assertEquals(1000, Finance.pv(0.01, 12, -88.848788678, 0, false), DELTA);
        assertEquals(1000, Finance.pv(0.01, 12, -87.969097701, 0, true), DELTA);
    }

    @Test
    void testPvWithFvAndTypeZeroRate() {
        assertEquals(-1700, Finance.pv(0, 12, 100, 500, false), DELTA);
    }

}
