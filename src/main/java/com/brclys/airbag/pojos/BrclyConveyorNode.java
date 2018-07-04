package com.brclys.airbag.pojos;



import com.brclys.airbag.constants.BrclyGate;



/**

 * 

 * ConveyorNode.java

 *

 * @author 

 */

public class BrclyConveyorNode implements Comparable<BrclyConveyorNode>{



    private BrclyGate nodeId;

    private String nodeName;

    private Double minDistance = Double.POSITIVE_INFINITY;

    private BrclyConveyorNode previous;



    public BrclyConveyorNode(BrclyGate nodeId, String nodeName){

        this.nodeId = nodeId;

        this.nodeName = nodeName;

    }



    public BrclyGate getNodeId() {

        return nodeId;

    }



    public String getNodeName() {

        return nodeName;

    }



    public Double getMinDistance() {

        return minDistance;

    }



    public void setMinDistance(Double minDistance) {

        this.minDistance = minDistance;

    }



    public BrclyConveyorNode getPrevious() {

        return previous;

    }



    public void setPrevious(BrclyConveyorNode previous) {

        this.previous = previous;

    }



    @Override

    public boolean equals(Object obj){

        if (this == obj){

            return true;

        }



        if (obj == null || !(obj instanceof BrclyConveyorNode)){

            return false;

        }



        BrclyConveyorNode other = (BrclyConveyorNode) obj;



        return (this.nodeId.getValue().equals(other.nodeId.getValue()));

    }



    @Override

    public int hashCode() {

        return nodeId.getValue().hashCode();

    }



    @Override

    public int compareTo(BrclyConveyorNode other) {

        return Double.compare(minDistance, other.minDistance);

    }

}