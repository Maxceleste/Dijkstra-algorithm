package src.com.max;

/**
 * Represent a Children list of a node in a weighted graph.
 */
public class Children{

    private String[] childNames;
    private double[] weights;

    /**
     * The names and weigth needs to be the same size and order.
     * @param childNames Array of children names
     * @param weights Array of children weigth.
     */
    public Children(String[] childNames, double[] weights){

        if (childNames.length != weights.length) throw new IllegalArgumentException("childNames and weights must be the same size.");
        
        this.childNames = childNames;
        this.weights = weights;
    }

    public String[] getNames(){
        return childNames;
    }

    public double[] getWeights(){
        return weights;
    }

    public int getSize(){
        return childNames.length;
    }

    public String getName(int index){
        return childNames[index];
    }


    public double getWeight(String childName){
        return weights[getIndex(childName)];
    }

    public double getWeight(int index){
        return weights[index];
    }


    private int getIndex(String childName){
        int index = 0;

        for (String name : childNames){
            if (name == childName) break;
            index++;
        }
        if (index + 1 > childNames.length) throw new IllegalArgumentException("This child name doesn't exist.");
        return index;
    }
}