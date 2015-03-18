package com.apwglobal.bd;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BD extends BigDecimal {

    private static final MathContext DEFAULT_MC = new MathContext(34, RoundingMode.HALF_UP);
    private MathContext mc;

    public BD(String val) {
        super(val, DEFAULT_MC);
        this.mc = DEFAULT_MC;
    }

    public BD(String val, MathContext mc) {
        super(val, mc);
        this.mc = mc;
    }

    public BD(double val) {
        super(Double.toString(val), DEFAULT_MC);
        this.mc = DEFAULT_MC;
    }

    public BD(double val, MathContext mc) {
        super(Double.toString(val), mc);
        this.mc = mc;
    }

    public BD(float val) {
        super(Float.toString(val), DEFAULT_MC);
        this.mc = DEFAULT_MC;
    }

    public BD(float val, MathContext mc) {
        super(Float.toString(val), mc);
        this.mc = mc;
    }

    public BD(long val) {
        super(Long.toString(val), DEFAULT_MC);
        this.mc = DEFAULT_MC;
    }

    public BD(long val, MathContext mc) {
        super(Long.toString(val), mc);
        this.mc = mc;
    }

    public BD(int val) {
        super(Integer.toString(val), DEFAULT_MC);
        this.mc = DEFAULT_MC;
    }

    public BD(int val, MathContext mc) {
        super(Integer.toString(val), mc);
        this.mc = mc;
    }

    public BD(BigDecimal val) {
        super(val.toString(), DEFAULT_MC);
        this.mc = DEFAULT_MC;
    }

    public BD(BigDecimal val, MathContext mc) {
        super(val.toString(), mc);
        this.mc = mc;
    }



    //==========================================
    // rounding
    //==========================================

    @Override
    public BigDecimal setScale(int newScale) {
        return super.setScale(newScale, mc.getRoundingMode());
    }

    public BD floor(int scale) {
        return new BD(setScale(scale, RoundingMode.FLOOR));
    }

    public BD ceil(int scale) {
        return new BD(setScale(scale, RoundingMode.CEILING));
    }



    //==========================================
    // conv
    //==========================================

    public double doubleValue(int scale) {
        return setScale(scale).doubleValue();
    }

    public float floatValue(int scale) {
        return setScale(scale).floatValue();
    }

    public int intValue(int scale) {
        return setScale(scale).intValue();
    }

    public long longValue(int scale) {
        return setScale(scale).longValue();
    }

    //==========================================
    // add
    //==========================================

    public BD add(String augend, MathContext mc) {
        return new BD(super.add(new BD(augend, mc), mc), mc);
    }

    public BD add(String augend) {
        return add(augend, mc);
    }

    public BD add(BD augend) {
        return add(augend.toString(), mc);
    }

    public BD add(double augend) {
        return add(Double.toString(augend), mc);
    }

    public BD add(float augend) {
        return add(Float.toString(augend), mc);
    }

    public BD add(int augend) {
        return add(Integer.toString(augend), mc);
    }

    public BD add(long augend) {
        return add(Long.toString(augend), mc);
    }



    //==========================================
    // subtract
    //==========================================

    public BD subtract(String subtrahend, MathContext mc) {
        return new BD(super.subtract(new BD(subtrahend, mc), mc), mc);
    }

    public BD subtract(String subtrahend) {
        return subtract(subtrahend, mc);
    }

    public BD subtract(BD subtrahend) {
        return subtract(subtrahend.toString(), mc);
    }

    public BD subtract(double subtrahend) {
        return subtract(Double.toString(subtrahend), mc);
    }

    public BD subtract(float subtrahend) {
        return subtract(Float.toString(subtrahend), mc);
    }

    public BD subtract(int subtrahend) {
        return subtract(Integer.toString(subtrahend), mc);
    }

    public BD subtract(long subtrahend) {
        return subtract(Long.toString(subtrahend), mc);
    }



    //==========================================
    // multiply
    //==========================================

    public BD multiply(String multiplicand, MathContext mc) {
        return new BD(super.multiply(new BD(multiplicand, mc), mc), mc);
    }

    public BD multiply(String multiplicand) {
        return multiply(multiplicand, mc);
    }

    public BD multiply(BD multiplicand) {
        return multiply(multiplicand.toString(), mc);
    }

    public BD multiply(double multiplicand) {
        return multiply(Double.toString(multiplicand), mc);
    }

    public BD multiply(float multiplicand) {
        return multiply(Float.toString(multiplicand), mc);
    }

    public BD multiply(int multiplicand) {
        return multiply(Integer.toString(multiplicand), mc);
    }

    public BD multiply(long multiplicand) {
        return multiply(Long.toString(multiplicand), mc);
    }



    //==========================================
    // divide
    //==========================================

    public BD divide(String divisor, MathContext mc) {
        return new BD(super.divide(new BD(divisor, mc), mc), mc);
    }

    public BD divide(String divisor) {
        return divide(divisor, mc);
    }

    public BD divide(BD divisor) {
        return divide(divisor.toString(), mc);
    }

    public BD divide(double divisor) {
        return divide(Double.toString(divisor), mc);
    }

    public BD divide(float divisor) {
        return divide(Float.toString(divisor), mc);
    }

    public BD divide(int divisor) {
        return divide(Integer.toString(divisor), mc);
    }

    public BD divide(long divisor) {
        return divide(Long.toString(divisor), mc);
    }



    //==========================================
    // taxes
    //==========================================

    private String getTaxFactor(String taxRate) {
        return "1." + taxRate;
    }

    public BD gross(int taxRate) {
        return gross(Integer.toString(taxRate));
    }

    public BD net(int taxRate) {
        return net(Integer.toString(taxRate));
    }

    public BD tax(int taxRate) {
        return tax(Integer.toString(taxRate));
    }

    public BD gross(String taxRate) {
        return multiply(getTaxFactor(taxRate));
    }

    public BD net(String taxRate) {
        return subtract(tax(taxRate));
    }

    public BD tax(String taxRate) {
        return multiply(taxRate)
                .divide(
                        new BD(getTaxFactor(taxRate)).multiply(100)
                );
    }
    
    
    public static void main(String[] args) {


    }
}
