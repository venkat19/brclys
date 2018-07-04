package com.brclys.airbag.pojos;



import com.brclys.airbag.constants.BrclyGate;




/**

 * 

 * Bag.java

 *

 * @author Neeli

 */

public class BrclyBag {

    private String id;

    private BrclyGate entryPoint;

    private String flightId;



    public BrclyBag(){



    }



    public BrclyBag(String bagId, BrclyGate entryPoint, String flightId){

        this.id = bagId;

        this.entryPoint = entryPoint;

        this.flightId = flightId;

    }



    public String getId() {

        return id;

    }



    public void setId(String id) {

        this.id = id;

    }



    public BrclyGate getEntryPoint() {

        return entryPoint;

    }



    public void setEntryPoint(BrclyGate entryPoint) {

        this.entryPoint = entryPoint;

    }



    public String getFlightId() {

        return flightId;

    }



    public void setFlightId(String flightId) {

        this.flightId = flightId;

    }



    @Override

    public String toString() {

        return "Bag{" +

                "id='" + id + '\'' +

                ", entryPoint=" + entryPoint +

                ", flightId='" + flightId + '\'' +

                '}';

    }

}