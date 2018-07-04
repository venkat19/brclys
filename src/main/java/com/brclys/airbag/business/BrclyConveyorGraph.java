package com.brclys.airbag.business;



import com.brclys.airbag.pojos.BrclyConveyorLink;

import com.brclys.airbag.pojos.BrclyConveyorNode;



import java.util.*;



/**

 * 

 * ConveyorGraph.java

 *

 * @author Neeli

 */

public class BrclyConveyorGraph implements Graph<BrclyConveyorNode, BrclyConveyorLink> {



    //adjacency list representation of graph

    private Map<BrclyConveyorNode, List<BrclyConveyorLink>> neighbors = new HashMap<>();



    private Set<BrclyConveyorNode> nodes = new HashSet<>();



    private Set<BrclyConveyorLink> links = new HashSet<>();



    /**

     * Add a node to the graph.

     *

     * @param node

     */

    public void addNode(BrclyConveyorNode node) {

        if (!neighbors.containsKey(node)) {

            neighbors.put(node, new ArrayList<BrclyConveyorLink>());

            nodes.add(node);

        }

    }



    /**

     * Check if link exists between two nodes.

     *

     * @param from

     * @param to

     * @return

     */

    public boolean isLink(BrclyConveyorNode from, BrclyConveyorNode to) {

        List<BrclyConveyorLink> links = neighbors.get(from);

        if (links != null && !links.isEmpty()) {

            for (BrclyConveyorLink conveyorLink : links) {

                if (conveyorLink.getTo().equals(to)) {

                    return true;

                }

            }

        }

        return false;

    }



    /**

     * Add a link to the Graph.

     *

     * @param from

     * @param to

     * @param cost

     */

    public void addLink(BrclyConveyorNode from, BrclyConveyorNode to, double cost) {

        addNode(from);

        addNode(to);



        if (!isLink(from, to)) {

        	BrclyConveyorLink link = new BrclyConveyorLink(from, to, cost);

            neighbors.get(from).add(link);

            links.add(link);

        }

    }



    @Override

    public BrclyConveyorLink getLink(BrclyConveyorNode source, BrclyConveyorNode target) {

        List<BrclyConveyorLink> links = neighbors.get(source);

        for (BrclyConveyorLink link : links) {

            if (link.getTo().equals(target)) {

                return link;

            }

        }

        return null;

    }





    @Override

    public Iterable<BrclyConveyorNode> getNodes() {

        return nodes;

    }



    @Override

    public int getOrder() {

        return neighbors.size();

    }



    @Override

    public Iterable<BrclyConveyorLink> getLinks() {

        return links;

    }



    @Override

    public int getSize() {

        return links.size();

    }



    @Override

    public boolean containsNode(BrclyConveyorNode conveyorNode) {

        return neighbors.containsKey(conveyorNode);

    }



    @Override

    public boolean containsLink(BrclyConveyorLink conveyorLink) {

        return links.contains(conveyorLink);

    }



    /**


     * Dijkstra's shortest path implementation

     * http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
     *

     * @param source

     * @param target

     * @return

     */

    public List<BrclyConveyorNode> findShortestPath(BrclyConveyorNode source, BrclyConveyorNode target) {

        List<BrclyConveyorNode> shortestPath = new ArrayList<>();



        source.setMinDistance(0D);



        PriorityQueue<BrclyConveyorNode> vertexQueue = new PriorityQueue<>();



        for (BrclyConveyorNode vertex : nodes) {

            if (!vertex.equals(source)) {

                vertex.setMinDistance(Double.POSITIVE_INFINITY);

                vertex.setPrevious(null);

            } else {

                vertex = source;

            }

            vertexQueue.add(vertex);

        }



        while (!vertexQueue.isEmpty()) {

        	BrclyConveyorNode u = vertexQueue.poll();



            if (u.equals(target)) {

                while (u.getPrevious() != null) {

                    shortestPath.add(u);

                    u = u.getPrevious();

                }

                break;

            }



            vertexQueue.remove(u);



            List<BrclyConveyorLink> edges = neighbors.get(u);



            for (BrclyConveyorLink edge : edges) {

            	BrclyConveyorNode v = edge.getTo();



                double weight = edge.getCost();

                double distanceThroughU = u.getMinDistance() + weight;



                if (distanceThroughU < v.getMinDistance()) {

                    v.setMinDistance(distanceThroughU);

                    v.setPrevious(u);

                    vertexQueue.remove(v);

                    vertexQueue.add(v);

                }

            }

        }



        Collections.reverse(shortestPath);



        return shortestPath;

    }



    @Override

    public String toString() {

        StringBuffer sb = new StringBuffer();

        for (BrclyConveyorNode node : neighbors.keySet()) {

            sb.append("\n    " + node.getNodeId().getValue() + " -> " + neighbors.get(node));

        }

        return sb.toString();

    }



    public Map<BrclyConveyorNode, List<BrclyConveyorLink>> getNeighbors() {

        return neighbors;

    }



}