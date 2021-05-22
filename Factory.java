public class Factory {
    //Instance variables
    private long revenue = 0;

    private int currentDate = 1;

    private int orderCount = 1;

    private int discountCount = 0;

    private int rushCount = 0;

    Factory(){
        initialize();
        factoryLoop();
    }

    OrderPQ factoryQueue = new OrderPQ();
    //Populate the queue
    public void initialize(){

        for (int x = 0; x < 10; x++) {

            factoryQueue.addOrderDefault(orderCount);

            orderCount ++;
        }
    }
    //Add a new order that will either go to the front or back of the queue
    public void addNewOrder(){

        factoryQueue.newOrderAfterStart(orderCount);

        orderCount ++;
    }
    //Add a discounted order
    public void addDiscountOrder(){

        factoryQueue.addDiscountOrder(orderCount);

        discountCount ++;

        orderCount ++;
    }

    //Check to see if we can add a new order
    public void checkForNewOrder(){

        double headache = currentDate/50.000000000000;

        int migraine = currentDate/50;

        if (headache == migraine) {

            System.out.println("\nA new Order has arrived");

            addNewOrder();



        }
    }

    //Check to see if the queue is empty, and if it is add a discount order
    public void checkForEmptyQueue(){
        if (factoryQueue.isEmpty() == true){

            addDiscountOrder();
        }
    }

    //Check to see if the simulation is over
    public void isSimOver(){
        if (currentDate == 731){
            System.out.println("\nThe simulation has ended!\n");

            System.out.printf("\nThere were %s total orders,\n", orderCount );

            System.out.printf("There were %s rushed orders,\n", rushCount);

            System.out.printf("There were %s discounted orders.\n", discountCount);

            System.out.printf("The total revenue for the factory was %s $\n", revenue);

            System.exit(0);

        }
    }

    //Main loop for the factory
    public void factoryLoop(){

        int daysWorked;

        int tempDate = 1;

        int endDate = 730;

        System.out.println("The factory has opened");

        while(currentDate < endDate){

            //Check to see if a discount order needs to be added
            checkForEmptyQueue();

            Order orderBeingDone = factoryQueue.removeAndGiveOrder();

            if (orderBeingDone.getPriority() == 1){

                rushCount ++;
            }
            daysWorked = orderBeingDone.getLength();

            //The total value of the order will be reached as this is added every day it's being worked on
            revenue = revenue + orderBeingDone.getValue();

            //This loop will handle adding days and checking for new orders
            for (int i = 0; i < daysWorked; i ++){

                System.out.println("\nIt is day " + currentDate + "");

                System.out.printf("%s is being worked on, it's priority is %s\n", orderBeingDone.getName(), orderBeingDone.getPriority());

                currentDate ++;

                isSimOver();

                checkForNewOrder();

            }

        }
    }
}




