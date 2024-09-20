//package application;
//
//import java.util.Arrays;
//
//public class Node {
//	private Location location;
//	private Node[] to;
//	private int count = 0;
//
//	public Node(Location location) {
//		this.location = location;
//	}
//
//	public Node(Location location, int size) {
//        this.location = location;
//        this.to = new Node[size];
//        this.count = 0;
//    }
//    
//	
//	public void addLocation(Location l){
//		to[count]=new Node(l);
//		count++;
//	}
//
//
//	public Node getDes(String location) {
//		if (this.location.equals(location)) {
//			return this;
//		}
//		if (to == null)
//			return null;
//		for (int i = 0; i < to.length; i++) {
//			if (to != null && to[i] != null) {
//				if (to[i].getLocation().equals(location))
//					return to[i];
//			}
//		}
//		for (int i = 0; i < to.length; i++) {
//			if (to != null && to[i] != null) {
//				return to[i].getDes(location);
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("Node [location=").append(location.getLocation()).append(", ");
//		if (to != null) {
//			for (int i = 0; i < count; i++) {
//				sb.append("[").append(to[i].getLocation().getLocation()).append(", ")
//						.append(to[i].getLocation().getPrice()).append(", ").append(to[i].getLocation().getHotel())
//						.append("], ");
//			}
//		}
//		sb.append("Cost=").append(location.getPrice()).append(location.getHotel()).append(", ");
//		if (to != null) {
//			sb.append("to=").append(Arrays.toString(Arrays.copyOf(to, count)));
//		} else {
//			sb.append("to=null");
//		}
//		sb.append("]");
//		return sb.toString();
//	}
//
//	public Location getLocation() {
//		return location;
//	}
//
//	public void setLocation(Location location) {
//		this.location = location;
//	}
//
//	public Node[] getTo() {
//		return to != null ? to : new Node[0];
//	}
//
//	public void setTo(Node[] to) {
//		this.to = to;
//	}
//
//	public int getCostTo(int v) {
//		return getCostToHelper(this, v);
//	}
//
//	private int getCostToHelper(Node current, int v) {
//		if (current.getLocation().getLocation().equals(v)) {
//			// If the current node matches the destination location, return its price
//			return current.getLocation().getPrice();
//		} else {
//			// Traverse the connected nodes recursively
//			Node[] destinations = current.getTo();
//			if (destinations != null) {
//				for (Node dest : destinations) {
//					if (dest != null) {
//						int cost = getCostToHelper(dest, v);
//						if (cost != -1) {
//							// If the cost is not -1, it means the destination was found
//							// Add the current node's price to the cost and return
//							return cost + current.getLocation().getPrice();
//						}
//					}
//				}
//			}
//			// If the destination is not found, return -1
//			return -1;
//		}
//	}
//	public void addTo(Node connectedNode) {
//	    if (count >= to.length) {
//	        // Resize the array to accommodate more elements
//	        Node[] newArray = new Node[to.length * 2];
//	        System.arraycopy(to, 0, newArray, 0, to.length);
//	        to = newArray;
//	    }
//	    
//	    // Add the connected node to the array of connections
//	    to[count] = connectedNode;
//	    count++; // Increment count after adding the connection
//	}
//
//}

package application;


import java.util.Arrays;

public class Node {
	private Location location;
	private Node[] to;
	private int count;
	public Node(Location location, int size) {
		this.location = location;
		this.to = new Node[size];
	}public Node(Location location) {
		this.location = location;
	}
	public void addLocation(Location l){
		to[count]=new Node(l);
		count++;
	}

	public Node getDes(String location) {
		if(this.location.equals(location)){
			return this;
		}
		if(to==null)
			return null;
	    for (int i = 0; i < to.length; i++) {
	        if (to!=null && to[i] != null ) {
	           if(to[i].getLocation().equals(location))
				   return to[i];
	        }
	    }
		for (int i = 0; i < to.length; i++) {
			if (to!=null && to[i] != null ) {
				return to[i].getDes(location);
			}
		}
	    return null;
	}

	@Override
	public String toString() {
		return "Node [location=" + location + ", to=" + Arrays.toString(to) + "]";
	}
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Node[] getTo() {
	    return to != null ? to : new Node[0];
	}


	public void setTo(Node[] to) {
		this.to = to;
	}
	
	public int getCostTo(Node destination) {
	    return getCostToHelper(this, destination);
	}

	private int getCostToHelper(Node current, Node destination) {
	    if (current == destination) {
	        // If the current node matches the destination node, return its price
	        return current.getLocation().getPrice();
	    } else {
	        // Traverse the connected nodes recursively
	        Node[] destinations = current.getTo();
	        if (destinations != null) {
	            for (Node dest : destinations) {
	                if (dest != null) {
	                    int cost = getCostToHelper(dest, destination);
	                    if (cost != -1) {
	                        // If the cost is not -1, it means the destination was found
	                        // Add the current node's price to the cost and return
	                        return cost + current.getLocation().getPrice();
	                    }
	                }
	            }
	        }
	        // If the destination is not found, return -1
	        return -1;
	    }
	
	}
}

