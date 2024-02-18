package src.com.max;

/**
 * Represent an edge for the weighted graph, with the name and the weigh.
 */
public class Child{
    private String childName;
    private double weight;

    /**
     * @param childName The name of this child
     * @param weight The weight to go to this child.
     */
    public Child(String childName, double weight){
        this.childName = childName;
        this.weight = weight;
    }

    public String getName(){
        return childName;
    }

    public double getWeight(){
        return weight;
    }
}