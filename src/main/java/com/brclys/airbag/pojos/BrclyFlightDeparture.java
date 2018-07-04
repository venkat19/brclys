package com.brclys.airbag.pojos;



import com.brclys.airbag.constants.BrclyGate;



/**

 * 

 * FlightDeparture.java

 *

 * 

 */

public class BrclyFlightDeparture {

    private String flightId;

    private BrclyGate departureGate;

    private String destination;

    private String departureTime;



    public BrclyFlightDeparture(){

    }



    public BrclyFlightDeparture(String flightId, BrclyGate departureGate, String destination, String departureTime){

        this.flightId = flightId;

        this.departureGate = departureGate;

        this.destination = destination;

        this.departureTime = departureTime;

    }



    public String getFlightId() {

        return flightId;

    }



    public void setFlightId(String flightId) {

        this.flightId = flightId;

    }



    public BrclyGate getDepartureGate() {

        return departureGate;

    }



    public void setDepartureGate(BrclyGate departureGate) {

        this.departureGate = departureGate;

    }



    public String getDestination() {

        return destination;

    }



    public void setDestination(String destination) {

        this.destination = destination;

    }



    public String getDepartureTime() {

        return departureTime;

    }



    public void setDepartureTime(String departureTime) {

        this.departureTime = departureTime;

    }



    @Override

    public String toString() {

        return "FlightDeparture{" +

                "flightId='" + flightId + '\'' +

                ", departureGate=" + departureGate +

                ", destination='" + destination + '\'' +

                ", departureTime='" + departureTime + '\'' +

                '}';

    }

}