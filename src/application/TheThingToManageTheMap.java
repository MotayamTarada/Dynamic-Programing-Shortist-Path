//package application;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class TheThingToManageTheMap {
//    private Node[][] start;
//    private int size;
//
//    public TheThingToManageTheMap(int maxSize) {
//        start = new Node[maxSize][];
//        this.size = 0;
//    }
//
//   
//    public void addCity(String line) {
//        String[] str = line.split("\\[");
//        Node[] nodes = new Node[str.length - 1];
//
//        int[][] result = new int[100][100]; // Adjust the size accordingly
//
//        for (int i = 1; i < str.length; i++) {
//            String temp = str[i].replace("]", "");
//            String[] temp2 = temp.split(",");
//            Location location = new Location(temp2[0], Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]));
//            nodes[i - 1] = new Node(location, size); // Fix the array index
//            
//            // Populate the result array
//            for (int j = 0; j < result.length; j++) {
//                for (int k = 0; k < result[j].length; k++) {
//                   result[j][k] = location.getHotel() + location.getPrice();
//                }
//            }
//        }
//
//        // Find the shortest path
//        int[][] shortestPath = findShortestPath(result);
//
//        // Calculate primary cost
//        int primaryCost = shortestPath[0].length > 0 ? shortestPath[0][shortestPath[0].length - 1] : Integer.MAX_VALUE;
//
//        // Print the expected result and alternative solutions once per input line
//        printExpectedResult(shortestPath[0], primaryCost);
//        printAlternativeResults(shortestPath);
//
//        start[size] = nodes;
//        size++;
//    }
//
//    public int[][] findShortestPath(int[][] c) {
//        // Number of cities
//        int n = c.length;
//
//        // Perform the shortest path algorithm
//        int[] cost = new int[n];
//        int[] d = new int[n];
//        Arrays.fill(cost, Integer.MAX_VALUE);
//        Arrays.fill(d, -1);
//
//        // Start node is city 0
//        int startNode = 0;
//        cost[startNode] = 0;
//
//        for (int i = startNode; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (c[i][j] != 0 && cost[i] != Integer.MAX_VALUE && cost[i] + c[i][j] < cost[j]) {
//                    cost[j] = cost[i] + c[i][j];
//                    d[j] = i;
//                }
//            }
//        }
//        // Return the results
//        return new int[][] { cost, d };
//    }
//
//    public void printExpectedResult(int[] cost, int primaryCost) {
//        if (primaryCost == Integer.MAX_VALUE) {
//            System.out.println("No solution found.");
//            return;
//        }
//        System.out.println("Expected Result:");
//        System.out.print("Solution_1 ➔ ");
//        for (int i = 0; i < cost.length; i++) {
//            System.out.print((cost[i] == Integer.MAX_VALUE) ? "?" : cost[i]);
//            if (i < cost.length - 1) {
//                System.out.print(" ");
//            }
//        }
//        System.out.println(" Cost = " + primaryCost);
//    }
//
//    public void printAlternativeResults(int[][] results) {
//        if (results.length <= 1) {
//            System.out.println("No alternative solutions found.");
//            return;
//        }
//        System.out.println("Alternative Results:");
//        for (int i = 1; i < results.length; i++) {
//            System.out.print("Solution_" + (i + 1) + " ➔ ");
//            for (int j = 0; j < results[i].length; j++) {
//                System.out.print((results[i][j] == Integer.MAX_VALUE) ? "?" : results[i][j]);
//                if (j < results[i].length - 1) {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public void printDPTable(int[] cost, int[] d) {
//        System.out.println("DP Table:");
//        System.out.print("Cost: ");
//        for (int c : cost) {
//            System.out.print(c + " ");
//        }
//        System.out.println();
//        System.out.print("Predecessor: ");
//        for (int p : d) {
//            System.out.print(p + " ");
//        }
//        System.out.println();
//    }
//
//    public void print() {
//        for (int i = 0; i < size; i++) {
//            Node[] nodes = start[i];
//            for (Node node : nodes) {
//                System.out.print(node + " ");
//            }
//            System.out.println();
//        }
//    }
//}
package application;

//import java.util.Arrays;
//
//public class TheThingToManageTheMap {
//    public Node start;
//    private int size;
//
//    public TheThingToManageTheMap() {
//        this.size = 0;
//    }
//
//    public void addCity(String line) {
//        String[] str = line.split("\\[");
//        Node point=null;
//        if(start!=null)
//             point =start.getDes(str[0].replace(",","").trim());
//
//        if(point ==null){
//            System.out.println(str.length-1);
//            start=new Node(new Location(str[0].replace(",","").trim()),str.length-1);
//            point=start;
//        }else{
//            point.setTo(new Node[str.length-1]);
//        }
//        for (int i = 1; i < str.length; i++) {
//            String temp = str[i].replace("]", "");
//            String[] temp2 = temp.split(",");
//            // Trim leading and trailing spaces before parsing integers
//            Location location = new Location(temp2[0].trim(), Integer.parseInt(temp2[1].trim()),
//                    Integer.parseInt(temp2[2].trim()));
//           point.addLocation(location);
//            size++;
//
//        }
//    }
//
//    public int[][] findShortestPath(int[][] c, int startNode, int endNode) {
//        // Number of cities
//        int n = c.length;
//        int[] dist = new int[n];
//        int[] prev = new int[n];
//        boolean[] visited = new boolean[n];
//
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Arrays.fill(prev, -1);
//        dist[startNode] = 0;
//
//        for (int count = 0; count < n - 1; count++) {
//            int u = minDistance(dist, visited);
//            visited[u] = true;
//
//            for (int v = 0; v < n; v++) {
//                if (!visited[v] && c[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
//                        dist[u] + c[u][v] < dist[v]) {
//                    dist[v] = dist[u] + c[u][v];
//                    prev[v] = u;
//                }
//            }
//        }
//
//        // Check if there is a path to the end node
//        if (prev[endNode] == -1) {
//            return null; // No path exists
//        }
//
//        // Constructing the path
//        int[] path = new int[n];
//        Arrays.fill(path, -1); // Initialize path array with -1
//
//        int currentNode = endNode;
//        int index = 0;
//        while (currentNode != startNode) {
//            path[index++] = currentNode;
//            currentNode = prev[currentNode];
//        }
//        path[index] = startNode;
//
//        // Reverse the path array
//        int[] reversedPath = new int[n];
//        int reverseIndex = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            if (path[i] != -1) {
//                reversedPath[reverseIndex++] = path[i];
//            }
//        }
//
//        // Return the results
//        return new int[][] { dist, reversedPath };
//    }
//
//    private int minDistance(int[] dist, boolean[] visited) {
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//        for (int v = 0; v < dist.length; v++) {
//            if (!visited[v] && dist[v] <= min) {
//                min = dist[v];
//                minIndex = v;
//            }
//        }
//        return minIndex;
//    }
//
//    public String constructPathString(int[] path, Node[] cities) {
//        StringBuilder pathStr = new StringBuilder();
//        pathStr.append("{Start");
//
//        for (int i = 0; i < path.length; i++) {
//            if (path[i] >= 0 && path[i] < cities.length) {
//                pathStr.append(", ").append(cities[path[i]].getLocation());
//            } else {
//                break;
//            }
//        }
//
//        pathStr.append(", End}");
//        return pathStr.toString();
//    }
//
//    public void findShortestPathAndPrintResults() {
//        for (int i = 0; i < size; i++) {
//            Node[] cities = new Node[5];
//            int numCities = cities.length;
//            int[][] result = new int[numCities][numCities];
//
//            for (int j = 0; j < numCities; j++) {
//                for (int k = 0; k < numCities; k++) {
//                    Location from = cities[j].getLocation();
//                    Location to = cities[k].getLocation();
//                    // Assuming getHotel() and getPrice() methods are defined in Location class
//                    result[j][k] = from.getHotel() + from.getPrice();
//                }
//            }
//
//            for (int startNode = 0; startNode < numCities; startNode++) {
//                for (int endNode = 0; endNode < numCities; endNode++) {
//                    if (startNode != endNode) {
//                        int[][] shortestPath = findShortestPath(result, startNode, endNode);
//                        if (shortestPath != null) {
//                            String pathStr = constructPathString(shortestPath[1], cities);
//                            int primaryCost = shortestPath[0][endNode];
//                            // Additional logic for finding optimal hotel
//                            int hotelCost = cities[1].getLocation().getHotel(); // Assume hotel is always at index 1
//                            int totalCost = primaryCost + hotelCost;
//                            System.out.println("Solution_" + (i + 1) + " ➔ " + pathStr + " Cost = " + totalCost);
//                        } else {
//                            System.err.println("No path exists from city " + startNode + " to city " + endNode + ".");
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//-----------------------------------------------------------------------------

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TheThingToManageTheMap {
//    public Node start;
//    private int size;
//
//   
//    public TheThingToManageTheMap() {
//        this.size = 0;
//    }
//
//    
//    public void addCity(String line) {
//        String[] str = line.split("\\[");
//        Node point=null;
//        if(start!=null)
//             point =start.getDes(str[0].replace(",","").trim());
//
//        if(point ==null){
//            System.out.println(str.length-1);
//            start=new Node(new Location(str[0].replace(",","").trim()),str.length-1);
//            point=start;
//        }else{
//            point.setTo(new Node[str.length-1]);
//        }
//        for (int i = 1; i < str.length; i++) {
//            String temp = str[i].replace("]", "");
//            String[] temp2 = temp.split(",");
//            // Trim leading and trailing spaces before parsing integers
//            Location location = new Location(temp2[0].trim(), Integer.parseInt(temp2[1].trim()),
//                    Integer.parseInt(temp2[2].trim()));
//           point.addLocation(location);
//            size++;
//
//        }
//       
//    }
//    public void findShortestPathAndPrintResults(int startNodeIndex, int endNodeIndex) {
//        if (start == null) {
//            System.err.println("No cities added to the map.");
//            return;
//        }
//
//        Node[] cities = getAllCities(start);
//        List<List<Integer>> allPaths = new ArrayList<>();
//        int minCost = Integer.MAX_VALUE;
//
//        // Find all shortest paths and their costs
//        for (int i = 0; i < cities.length; i++) {
//            for (int j = i + 1; j < cities.length; j++) {
//                int[][] shortestPath = findShortestPath(cities, i, j);
//                if (shortestPath != null && shortestPath[0][j] < minCost) {
//                    minCost = shortestPath[0][j];
//                    allPaths.clear();
//                    allPaths.add(Arrays.stream(shortestPath[1]).boxed().collect(Collectors.toList()));
//                } else if (shortestPath != null && shortestPath[0][j] == minCost) {
//                    allPaths.add(Arrays.stream(shortestPath[1]).boxed().collect(Collectors.toList()));
//                }
//            }
//        }
//
//        // Print all solutions
//        for (List<Integer> path : allPaths) {
//            StringBuilder pathStr = new StringBuilder("{Start");
//            for (int i : path) {
//                pathStr.append(", ").append(cities[i].getLocation().getLocation());
//            }
//            int hotelCost = cities[path.get(path.size() - 1)].getLocation().getHotel();
//            int totalCost = minCost + hotelCost;
//            System.out.println("Solution ➔ " + pathStr.toString() + " End} Cost = " + totalCost);
//        }
//    }
//
//
//
//
//    private Node[] getAllCities(Node start) {
//        List<Node> citiesList = new ArrayList<>();
//        getAllCitiesRecursive(start, citiesList);
//        return citiesList.toArray(new Node[0]);
//    }
//
//    private void getAllCitiesRecursive(Node node, List<Node> citiesList) {
//        if (node == null) return;
//        if (!citiesList.contains(node)) citiesList.add(node);
//        for (Node next : node.getTo()) {
//            getAllCitiesRecursive(next, citiesList);
//        }
//    }
//
//    private int[][] findShortestPath(Node[] nodes, int startNodeIndex, int endNodeIndex) {
//        int n = nodes.length;
//        int[] dist = new int[n];
//        int[] prev = new int[n];
//        boolean[] visited = new boolean[n];
//
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Arrays.fill(prev, -1);
//        dist[startNodeIndex] = 0;
//
//        while (true) {
//            int u = minDistance(dist, visited);
//            if (u == -1 || u == endNodeIndex) {
//                break;
//            }
//            visited[u] = true;
//
//            for (int v = 0; v < n; v++) {
//                int costToV = nodes[u].getCostTo(v);
//                if (!visited[v] && costToV != 0 && dist[u] != Integer.MAX_VALUE
//                        && dist[u] + costToV < dist[v]) {
//                    dist[v] = dist[u] + costToV;
//                    prev[v] = u;
//                }
//            }
//        }
//
//        List<Integer> pathList = new ArrayList<>();
//        int currentNode = endNodeIndex;
//        while (currentNode != -1) {
//            pathList.add(currentNode);
//            currentNode = prev[currentNode];
//        }
//        Collections.reverse(pathList);
//        int[] path = pathList.stream().mapToInt(Integer::intValue).toArray();
//        return new int[][] { dist, path };
//    }
//
//    private int minDistance(int[] dist, boolean[] visited) {
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//
//        for (int v = 0; v < dist.length; v++) {
//            if (!visited[v] && dist[v] <= min) {
//                min = dist[v];
//                minIndex = v;
//            }
//        }
//        return minIndex;
//    }
//
//    private String constructPathString(int[] path, Node[] cities) {
//        StringBuilder pathStr = new StringBuilder();
//        pathStr.append("{Start");
//
//        for (int i = 0; i < path.length; i++) {
//            if (path[i] >= 0 && path[i] < cities.length) {
//                pathStr.append(", ").append(cities[path[i]].getLocation().getLocation());
//            } else {
//                break;
//            }
//        }
//
//        pathStr.append(", End}");
//        return pathStr.toString();
//    }
//}

import java.util.*;

public class TheThingToManageTheMap {
	Node start;
	private int size;

	// Constructor
	public TheThingToManageTheMap() {
		this.start = null;
		this.size = 0;
	}

	public void addCity(String line) {
		String[] str = line.split("\\[");
		Node point = null;
		if (start != null)
			point = start.getDes(str[0].replace(",", "").trim());

		if (point == null) {
			System.out.println(str.length - 1);
			start = new Node(new Location(str[0].replace(",", "").trim()), str.length - 1);
			point = start;
		} else {
			point.setTo(new Node[str.length - 1]);
		}
		for (int i = 1; i < str.length; i++) {
			String temp = str[i].replace("]", "");
			String[] temp2 = temp.split(",");
			// Trim leading and trailing spaces before parsing integers
			Location location = new Location(temp2[0].trim(), Integer.parseInt(temp2[1].trim()),
					Integer.parseInt(temp2[2].trim()));
			point.addLocation(location);
			size++;

		}
	}
	public void findShortestPathAndPrintResults(int startNodeIndex, int endNodeIndex) {
	    if (start == null) {
	        System.err.println("No cities added to the map.");
	        return;
	    }

	    Node[] cities = getAllCities(start);

	    // Find shortest paths and their costs
	    int minCost = Integer.MAX_VALUE;
	    List<List<Integer>> shortestPaths = new ArrayList<>();
	    for (int i = 0; i < cities.length; i++) {
	        for (int j = i + 1; j < cities.length; j++) {
	            int cost = findShortestPath(cities, i, j);
	            if (cost != -1 && cost <= minCost) {
	                if (cost < minCost) {
	                    minCost = cost;
	                    // Clear previous shortest paths
	                    shortestPaths.clear();
	                }
	                // Add the current path to the list of shortest paths
	                shortestPaths.add(Arrays.asList(i, j));
	            }
	        }
	    }

	    // Debug print to check found paths
	    System.out.println("Number of paths found: " + shortestPaths.size());
	    for (List<Integer> p : shortestPaths) {
	        System.out.println("Path: " + p);
	    }

	    // Print all solutions containing the start and end nodes
	    for (List<Integer> path : shortestPaths) {
	        if (path.get(0) == startNodeIndex && path.get(path.size() - 1) == endNodeIndex) {
	            StringBuilder pathStr = new StringBuilder("{Start, ");
	            int totalCost = calculateCost(cities, path); // Calculate total cost for the path
	            for (int i : path) {
	                pathStr.append(cities[i].getLocation().getLocation()).append(", ");
	            }
	            pathStr.append("End} Cost = ").append(totalCost + cities[path.get(path.size() - 1)].getLocation().getHotel());
	            System.out.println("Solution ➔ " + pathStr);
	        }
	    }
	}



/// Method to get all cities
	private Node[] getAllCities(Node start) {
		List<Node> citiesList = new ArrayList<>();
		for (Node next : start.getTo()) {
			getAllCitiesRecursive(next, citiesList);
		}
		return citiesList.toArray(new Node[0]);
	}

	// Recursive method to get all cities
	private void getAllCitiesRecursive(Node node, List<Node> citiesList) {
		if (node == null)
			return;
		if (!citiesList.contains(node))
			citiesList.add(node);
		for (Node next : node.getTo()) {
			getAllCitiesRecursive(next, citiesList);
		}
	}


	private int findShortestPath(Node[] nodes, int startNodeIndex, int endNodeIndex) {
	    int n = nodes.length;
	    int[] dist = new int[n];
	    int[] prev = new int[n];
	    boolean[] visited = new boolean[n];

	    Arrays.fill(dist, Integer.MAX_VALUE);
	    Arrays.fill(prev, -1);
	    dist[startNodeIndex] = 0;

	    while (true) {
	        int u = minDistance(dist, visited);
	        if (u == -1 || u == endNodeIndex) {
	            break;
	        }
	        visited[u] = true;

	        for (int v = 0; v < n; v++) {
	            int costToV = nodes[u].getCostTo(nodes[v]); // Call getCostTo with Node parameter
	            if (!visited[v] && costToV != -1 && dist[u] != Integer.MAX_VALUE && dist[u] + costToV < dist[v]) {
	                dist[v] = dist[u] + costToV;
	                prev[v] = u;
	            }
	        }
	    }
	    return dist[endNodeIndex];
	}

	// Method to find the minimum distance
	private int minDistance(int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int v = 0; v < dist.length; v++) {
			if (!visited[v] && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	private int calculateCost(Node[] cities, List<Integer> path) {
		int cost = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			int fromIndex = path.get(i);
			int toIndex = path.get(i + 1);
			Node fromNode = cities[fromIndex];
			Node toNode = cities[toIndex];
			cost += fromNode.getCostTo(toNode);
		}
		return cost;
	}

}
