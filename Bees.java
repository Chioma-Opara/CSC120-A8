public class Bees  implements Contract{
    private String swarmName;
    private int swarmSize;
    private int xCoordinate; 
    private int yCoordinate; 

    /** Class constructor */
    public Bees(String swarmName, int swarmSize, int xCoordinate, int yCoordinate){
        this.swarmName = swarmName;
        this.swarmSize = swarmSize;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Getter for swarmName
     * @return the name of the bee swarm
     */
    public String getName(){
        return this.swarmName;
    } 

    /**
     * Getter for getHiveSize
     * @return the size of the bee swarm
     */
    public int getSwarmSize(){
        return this.swarmSize;
    }

    /**
     * Getter for x coordinate of swarm location
     * @return the x cooribate of swarm location
     */
    public int getXCoordinate(){
        return this.xCoordinate;
    } 

    /**
     * Getter for y coordinate of swarm location
     * @return the y cooribate of swarm location
     */
    public int getYCoordinate(){
        return this.yCoordinate;
    } 

    /** Class toString */ 
    public String toString() {
        return "The " + this.swarmName + " is a bee swarm of size  " + this.swarmSize + " currently located at (" + xCoordinate + ", " + yCoordinate + ").";
    }


    /**
     * Simulates the bee swarm picking up an object
     * @param item object to be picked up
     */
    public void grab(String item){
        System.out.println(this.swarmName + " has picked up " + item);
    }

    /**
     * Simulates the bee swarm dropping an object
     * @param item object to be dropped
     */
    public String drop(String item){
        System.out.println("The swarm just dropped " + item);
        return item; 
    }

    /**
     * Allows an object to be picked up and eaxamined.
     * @param item object to be examined
     */
    public void examine(String item){
        grab(item);
        System.out.println("I wonder if this could be food for our young. Or it could make a wonderful decoration for our hive!");
    }

    /**
     * Simulates the swarm using an object
     * @param item object in use
     */
    public void use(String item){
        grab(item);
        System.out.println(item + " is currently in use by the " + this.swarmName);
    }

    /**
     * Allows the swarm to walk in four different directions: up right (ur), up left (ul), down right(dr) and down left (dl)
     * @param direction direction of swarm movement
     * @return true if the swarm takes a step in any direction
     */
    public boolean walk(String direction){
        if (direction.equals("ur")){
            xCoordinate ++; 
            yCoordinate ++;
        }
        else if(direction.equals("ul")){
            xCoordinate --; 
            yCoordinate ++;
        }
        else if(direction.equals("dr")){
            xCoordinate ++; 
            yCoordinate --;
        }
        else if(direction.equals("dl")){
            xCoordinate --; 
            yCoordinate --;
        }
        System.out.println(this.swarmName + " has walked to (" + xCoordinate + ", " + yCoordinate + ")");
        return true; 
    }

    /**
     * Simulates a swarm flight to a new location
     * @param x the x coordinate of the new location
     * @param y the y coordinate of the new location
     * @return true if the swarm flies to a new location successfully
     */
    public boolean fly(int x, int y){
        if (xCoordinate != x && yCoordinate !=y ){
            xCoordinate = x;
            yCoordinate = y;
            System.out.println("The hive has migrated to (" + xCoordinate + ", " + yCoordinate + ")");
            return true;
        }
        else{
            throw new RuntimeException(this.swarmName + " is already at the location it wishes to fly to.");
        }
    }

    /**
     * Reduces the number of bees in the swarm by 1
     * @return the new swarm size
     */
    public Number shrink(){
        if (swarmSize > 0){
            swarmSize --;
            System.out.println(this.swarmName + " has shrunk to " + this.swarmSize + " bees.");
            return swarmSize;
        }
        else{
            throw new RuntimeException(this.swarmName + " has ceased to exist as no bees remain.");
        }
    }

    /**
     * Overloads the shrink() method to reduce swarm by multiple bees at once.
     * @param n number of bees by which to shrink swarm
     * @return the new size of the swarm
     */
    public Number shrink(int n){
        if (swarmSize > 0 && n <= swarmSize){
            swarmSize -= n;
            if (swarmSize < 0){
                throw new RuntimeException("There are less than " + n + "  bees in " + this.swarmName + " ."); 
            }
            System.out.println(this.swarmName + " has shrunk to " + this.swarmSize + " bees.");
            return swarmSize;
        }
        else{
            throw new RuntimeException(this.swarmName + " has ceased to exist as no bees remain.");
        }
    }

    /**
     * Increases number of bees in the swarm by 1
     * @return the new size of the swarm
     */
    public Number grow(){
        swarmSize ++;
        System.out.println(this.swarmName + " has grown to " + this.swarmSize + " bees.");
        return swarmSize;
    }

    /**
     * Overloads the grow() method to increase swarm by more than one bee at a time
     * @param n number of bees by which to increase swarm
     * @return the new swarm size
     */
    public Number grow(int n){
        swarmSize += n;
        System.out.println(this.swarmName + " has grown to " + this.swarmSize + " bees.");
        return swarmSize;
    }

    /**
     * Simulates the swarm settling at a particular location
     */
    public void rest(){
        System.out.println(this.swarmName + " is currently resting at (" + xCoordinate + ", " + yCoordinate + ")");
    }

    /** Prints out a statement that states that no previous action can be undone*/
    public void undo(){
        System.out.println("No action in life can be undone. Life is not lived backwards. You must face the consequences of your actions.");
    }
}

/**NOTES TO ME
 * CODE TESTER: 
 *     public static void main(String[] args) {
        Bees australianStriped = new Bees("Australian Striped", 200, 10, 10);
        System.out.println(australianStriped);
        australianStriped.examine("apple");
        australianStriped.use("apple");
        australianStriped.grab("poison");
        australianStriped.shrink(150);
        australianStriped.undo();
        australianStriped.drop("poison");
        australianStriped.grow();
        australianStriped.grow(50);
        australianStriped.walk("dr");
        australianStriped.walk("ul");
        australianStriped.fly(30, 60);
        australianStriped.rest();
    }

     edit the undo function (check purple notebook)
     complete reflection

    how does the grow() and shrink() returning a type Number affect my program? What does it even mean? Number handles every nummerical type. That's all.
    You can move forward and move backward. That's an undo example. You can do this with the undo() function.
    java relection is like a scanner that looks at the compiled code rather than user input
    you can do more, but can't miss anything when implementing an interface. So, if you want a diff call signature, overload the method.
 */
