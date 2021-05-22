import java.util.Random;
public class Order {
    //Instance variables for order
    private int length;

    private long value;

    private int priority;

    private String name;



    public Order(){

        this.name = null;

        this.priority = 0;

        this.length = 0;

        this.value = 0;
    }

    Order(String name, int priority, int length){

        this.name = name;

        this.priority = priority;

        this.length = length;

        this.value = 25000;
    }


    //Make a name for an order
    public static String makeName(int i){


        String orderNumString = String.valueOf(i);


        return "Order #" + orderNumString;
    }
    //Make a random priority for an order
    public static int makePriority(){

        Random random = new Random();

        return random.nextInt(20)+1;
    }
    //Make a random length of time for an order
    public static int makeLength(){

        Random random = new Random();

        return random.nextInt(41) + 10;
    }

    //Make a randomized order
    public static Order makeRandomOrder(int i){

        return new Order(makeName(i),makePriority(), makeLength());
    }
    //Create a high priority order
    public Order highPriorityOrder(int i) {

        Order newHighOrder = Order.makeRandomOrder(i);

        //Override priority and value
        newHighOrder.setPriority(1);

        newHighOrder.setValue(75000);

        return newHighOrder;
    }

    //Create a low priority order
    public Order lowPriorityOrder(int i) {

        Order newLowPriorityOrder = makeRandomOrder(i);

        //Override priority
        newLowPriorityOrder.setPriority(20);

        return newLowPriorityOrder;
    }

    //Create a discounted order
    public Order discountOrder(int i){

        Order newDiscountOrder = makeRandomOrder(i);

        //Override whatever value was already used for a discount
        newDiscountOrder.value = 10000;

        return newDiscountOrder;
    }

    //Getter methods

    public int getPriority(){
        return priority;
    }


    public long getValue(){
        return value;
    }


    public int getLength(){return length;}


    public String getName(){
        return this.name;
    }

    //Setter methods
    public void setValue(int i){
        value = 25000*i;
    }

    public void setPriority(int i){
        priority = i;
    }

    public void setLength(int i){
        length = i;
    }

    public void setName(String s){
        name = s;
    }



}
