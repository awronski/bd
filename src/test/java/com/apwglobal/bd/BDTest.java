package com.apwglobal.bd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BDTest {

    private static final int VAT_RATE = 22;

    @Test
    public void testConstructor() throws Exception {
        assertEquals("0.1", new BD(0.1).toString());
        assertEquals("-0.1", new BD(-0.1).toString());
        assertEquals("0.1", new BD(0.1f).toString());
        assertEquals("-0.1", new BD(-0.1f).toString());
    }

    @Test
    public void testAdd() throws Exception {
        BD res = new BD(1.01).add(new BD("3")).add(0.99f).add(-1).add("0.01");
        assertEquals(4.01, res.doubleValue(), 0);
        assertEquals(4.01f, res.floatValue(), 0);
        assertEquals(4, res.intValue(), 0);
        assertEquals("4.01", res.toString());

        assertEquals(1.0,
                new BD("0.99999999999999999999999999999999999")
                  .add("0.00000000000000000000000000000000001").doubleValue(), 0);

    }

    @Test
    public void testSubtract() throws Exception {
        BD res = new BD(2).subtract(0.01).subtract(0.01f).subtract(1).subtract("0.01").subtract(new BD(-1));
        assertEquals(1.97, res.doubleValue(), 0);
        assertEquals(1.97f, res.floatValue(), 0);
        assertEquals(1, res.intValue(), 0);
        assertEquals("1.97", res.toString());
    }

    @Test
    public void testMultiply() throws Exception {
        BD res = new BD(1.3f).multiply("3.3").multiply(1.1).multiply(7).multiply(-0.3f).multiply(new BD(1.0));
        assertEquals(-9.9099, res.doubleValue(), 0);
        assertEquals(-9.9099f, res.floatValue(), 0);
        assertEquals(-9, res.intValue(), 0);
        assertEquals("-9.90990", res.toString());
    }

    @Test
    public void testDivide() throws Exception {
        BD res = new BD(0.9f).divide("3").divide(3.0).divide(2).divide(-0.25f);
        assertEquals(-0.2, res.doubleValue(), 0);
        assertEquals(-0.2f, res.floatValue(), 0);
        assertEquals(0, res.intValue(), 0);
        assertEquals("-0.2", res.toString());
    }

    @Test
    public void testFloor() throws Exception {
        assertEquals(1.99, new BD("1.999").floor(2).doubleValue(), 0);
        assertEquals(-2, new BD(-1.999).floor(2).doubleValue(), 0);
    }

    @Test
    public void testCeil() throws Exception {
        assertEquals(2.00, new BD(1.999).ceil(2).doubleValue(), 0);
        assertEquals(-1.99, new BD(-1.999).ceil(2).doubleValue(), 0);
    }

    @Test
    public void testScale() throws Exception {
        assertEquals(2.00, new BD(1.999).setScale(2).doubleValue(), 0);
        assertEquals(-2.00, new BD(-1.999).setScale(2).doubleValue(), 0);

        assertEquals(1.55, new BD(1.554).setScale(2).doubleValue(), 0);
        assertEquals(1.55, new BD(1.55).setScale(2).doubleValue(), 0);
        assertEquals(1.56, new BD(1.556).setScale(2).doubleValue(), 0);
    }

    @Test
    public void testConv() throws Exception {
        assertEquals(2.00, new BD(1.999).doubleValue(2), 0);
        assertEquals(1.55f, new BD(1.5509).floatValue(2), 0);
        assertEquals(2, new BD(1.999).intValue(2), 0);

        BD bd = new BD(2488.0070591803276);
        assertEquals(2488.007059180328, bd.doubleValue(12), 0);
        assertEquals(2488.0071, bd.doubleValue(4), 0);
        assertEquals(2488.007, bd.doubleValue(3), 0);
        assertEquals(2488.01, bd.doubleValue(2), 0);
        assertEquals(2488.0, bd.doubleValue(1), 0);
        assertEquals(2488.0, bd.doubleValue(0), 0);
        assertEquals(2488.0070591803276, bd.doubleValue(), 0);

        assertEquals(1.25, new BD(1.249).doubleValue(2), 0);
        assertEquals(1.3, new BD(1.25).doubleValue(1), 0);
        assertEquals(1.26, new BD(1.255).doubleValue(2), 0);
        assertEquals(-1.25, new BD(-1.249).doubleValue(2), 0);
        assertEquals(-1.26, new BD(-1.255).doubleValue(2), 0);
    }

    @Test
    public void testGorss() throws Exception {
        assertEquals(952.20, new BD(780.49).gross(VAT_RATE).doubleValue(2), 0);
        assertEquals(100, new BD(81.97).gross(VAT_RATE).doubleValue(2), 0);
        assertEquals(13797.13, new BD(11309.12).gross(VAT_RATE).doubleValue(2), 0);
    }

    @Test
    public void testNet() throws Exception {
        assertEquals(780.49, new BD(952.20).net(VAT_RATE).doubleValue(2), 0);
        assertEquals(81.97, new BD(100).net(VAT_RATE).doubleValue(2), 0);
        assertEquals(11309.12, new BD(13797.13).net(VAT_RATE).doubleValue(2), 0);
    }

    @Test
    public void testTax() throws Exception {
        assertEquals(171.71,new BD(952.20).tax(VAT_RATE).doubleValue(2), 0);
        assertEquals(18.03, new BD(100).tax(VAT_RATE).doubleValue(2), 0);
        assertEquals(2488.01, new BD(13797.13).tax(VAT_RATE).doubleValue(2), 0);
    }

}
