package com.brclys.airbag.pojos;



import java.util.Objects;



/**

 * 

 * ConveyorLink.java

 *

 * @author Neeli

 */

public final class BrclyConveyorLink {



    private BrclyConveyorNode from;

    private BrclyConveyorNode to;

    private double cost;



    public BrclyConveyorLink(BrclyConveyorNode from, BrclyConveyorNode to, double cost) {

        this.from = from;

        this.to = to;

        this.cost = cost;

    }



    public BrclyConveyorNode getFrom() {

        return from;

    }



    public BrclyConveyorNode getTo() {

        return to;

    }



    public double getCost() {

        return cost;

    }



    @Override

    public boolean equals(Object obj) {

        if (this == obj) {

            return true;

        }



        if (obj == null || !(obj instanceof BrclyConveyorNode)) {

            return false;

        }



        BrclyConveyorLink other = (BrclyConveyorLink) obj;



        return (this.from.equals(other.from) && this.to.equals(other.to));

    }



    @Override

    public int hashCode() {

        return Objects.hash(from, to);

    }



    @Override

    public String toString() {

        return "Link [" + from.getNodeId().getValue() + "->" + to.getNodeId().getValue() + " : " + cost + "]";

    }

}