import java.util.Random;
import java.util.Iterator;
import java.util.Comparator;
import java.util.PriorityQueue;
public class OrderPQ {

    //Creates a custom comparator that will use priority to order the queue
    public static final Comparator<Order> ORDER_PRIORITY_COMPARATOR_ =
            Comparator.comparing(Order::getPriority);

    //Create a new PQ
    PriorityQueue<Order> orderPriorityQueue = new PriorityQueue(100, ORDER_PRIORITY_COMPARATOR_);

    //Default method for adding an order
    public void addOrderDefault(int i){

        Order order = Order.makeRandomOrder(i);

        orderPriorityQueue.add(order);
    }

    //Add a new low priority order
    public void addNewLowOrder(int i){

        Order order = new Order().lowPriorityOrder(i);

        orderPriorityQueue.add(order);
    }
    //Remove and order and allow methods to act on it
    public Order removeAndGiveOrder(){

        Order order  = orderPriorityQueue.peek();

        orderPriorityQueue.remove();
        return order;
    }

    public Order peekNextOrder(){
        return orderPriorityQueue.peek();
    }

    //This will add an order with a high priority
    public void addNewHighOrder(int i){

        Order order = new Order().highPriorityOrder(i);

        orderPriorityQueue.add(order);
    }

    //Check to see if the PQ is empty
    public boolean isEmpty(){

        boolean isEmpty;

        Iterator OrderIterator = orderPriorityQueue.iterator();

        if (OrderIterator.hasNext()){

            isEmpty = false;
        }
        else{

            isEmpty = true;
        }
        return isEmpty;



    }

    //Add an order with a 50% chance of it going to the front or back of the queue
    public void newOrderAfterStart(int i){
        Random random = new Random();

        int x = random.nextInt(101);

        if (x <= 50){

            System.out.println("This order will go to the back of the queue.");

            addNewLowOrder(i);
        }
        else if (x >= 51) {

            System.out.println("This is a rush order! It will go the front of the queue.");

            addNewHighOrder(i);
        }
    }

    //Add a discounted order
    public void addDiscountOrder(int i){

        Order order = new Order().discountOrder(i);

        orderPriorityQueue.add(order);
    }




}
