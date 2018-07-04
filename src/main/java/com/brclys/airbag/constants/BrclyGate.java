package com.brclys.airbag.constants;



import java.util.HashMap;

import java.util.Map;



/**

 * 

 * Gate.java

 *

 * @author Neeli

 */

public enum BrclyGate {

    A1("A1"),

    A2("A2"),

    A3("A3"),

    A4("A4"),

    A5("A5"),

    A6("A6"),

    A7("A7"),

    A8("A8"),

    A9("A9"),

    A10("A10"),

    CONCOURSE_A_TICKETING("Concourse_A_Ticketing"),

    BAGGAGE_CLAIM("BaggageClaim");



    public final String value;



    private BrclyGate(String value){

        this.value = value;

    }



    public String getValue() {

        return value;

    }



    private static final Map<String, BrclyGate> GATE_MAP = new HashMap<String, BrclyGate>();



    static {

        for (BrclyGate gate : BrclyGate.values()) {

            GATE_MAP.put(gate.getValue(), gate);

        }

    }



    public static BrclyGate getGate(String value) {

        return GATE_MAP.get(value);

    }

}