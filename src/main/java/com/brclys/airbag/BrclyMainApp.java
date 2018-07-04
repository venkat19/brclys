package com.brclys.airbag;
import java.util.List;
import java.util.Map;

import com.brclys.airbag.business.*;

import com.brclys.airbag.constants.*;

import com.brclys.airbag.input.*;




import com.brclys.airbag.pojos.*;




/**
 * 
 *
 */
public class BrclyMainApp 
{
    public static void main( String[] args )
    {



    	BrclyConveyorGraph conveyorGraph = null;

        Map<String, BrclyFlightDeparture> flightIdToDepartureMap = null;

        Map<String, BrclyBag> bagIdToBagMap = null;



        BrclyConveyorGraphHandler conveyorGraphHandler = new BrclyConveyorGraphHandler();

        try {

            conveyorGraphHandler.process();

            conveyorGraph = conveyorGraphHandler.getConveyorGraph();

            //System.out.println(conveyorGraph);

        } catch (Exception ex) {

            ex.printStackTrace();

        }



        BrclyFlightDepartureHandler flightDepartureHandler = new BrclyFlightDepartureHandler();

        try {

            flightDepartureHandler.process();

            flightIdToDepartureMap = flightDepartureHandler.getFlightIdToDepartureMap();

            //System.out.println(flightIdToDepartureMap);

        } catch (Exception ex) {

            ex.printStackTrace();

        }



        BrclyBagHandler bagHandler = new BrclyBagHandler();

        try {

            bagHandler.process();

            bagIdToBagMap = bagHandler.getBagIdToBagMap();

            //System.out.println(bagIdToBagMap);

        } catch (Exception ex) {

            ex.printStackTrace();

        }



        StringBuffer output = new StringBuffer();



        for (Map.Entry<String, BrclyBag> entry : bagIdToBagMap.entrySet()) {

        	BrclyBag bag = entry.getValue();

            String bagId = bag.getId();

            String flightId = bag.getFlightId();

            BrclyGate sourceGate = bag.getEntryPoint();



            output.append(bagId + " ");





            BrclyGate departureGate = null;

            if (flightId.equals("ARRIVAL")) {

                departureGate = sourceGate.BAGGAGE_CLAIM;

            } else {

                departureGate = flightIdToDepartureMap.get(flightId).getDepartureGate();

            }



            BrclyConveyorNode sourceNode = new BrclyConveyorNode(sourceGate, sourceGate.getValue());

            BrclyConveyorNode targetNode = new BrclyConveyorNode(departureGate, departureGate.getValue());

            List<BrclyConveyorNode> shortestPath = conveyorGraph.findShortestPath(sourceNode, targetNode);



            if (!shortestPath.isEmpty()) {

                output.append(sourceGate.getValue() + " ");

                BrclyConveyorNode prevNode = shortestPath.get(0);

                output.append(prevNode.getNodeId().getValue() + " ");



                for (int i = 1; i < shortestPath.size(); i++) {

                	BrclyConveyorNode current = shortestPath.get(i);

                    prevNode = current;

                    output.append(current.getNodeId().getValue() + " ");

                }

                output.append(": " + prevNode.getMinDistance());

                output.append(System.lineSeparator());

            } else { //PATH NOT FOUND

                output.append("PATH_NOT_EXISTS");

                output.append(System.lineSeparator());

            }

        }



        System.out.println(output.toString());

    }

}

