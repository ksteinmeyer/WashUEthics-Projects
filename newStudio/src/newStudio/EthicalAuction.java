package newStudio;


public class EthicalAuction {

    //these are instance variables, they are global variables declared in an object that you can use in all the methods,
    //all the instance variables will be provided for you, and will be initialized
    private final String name;
    private final int incrementAmount; //how much bids will increment by
    private final int startingValue; //starting value of auction

    private Bidder playerOne;
    private Bidder playerTwo;

    private final int numberOfBidders = 2;

    //bidder arrays (parallel arrays)
    private String[] bidderNames = new String[numberOfBidders];
    private int[] bidderMaxBids = new int[numberOfBidders];
    private int[] bidderCurrentBids = new int[numberOfBidders];
    private int[] previousBid = new int[numberOfBidders];



    private String winner;

    public static void main(String[] args) { //main method, this is where you type to make new auctions and bidders


        //here's where you can make your bids and enter them in the auction, only two bidders can participate in an auction at once
        Bidder Player1 = new Bidder("Player 1", 90, 9);
        Bidder Player2 = new Bidder("Player 2", 10, 9);


        //here's your auction, you can decide how much bids should increment by (increase by), what the starting bid of your
        //auction should be, and which bidders will participate in your auction
        EthicalAuction auction = new EthicalAuction("auction",2, 4, Player1, Player2);

    }

    public EthicalAuction(String name, int incrementAmount, int startingValue, Bidder firstBidder, Bidder secondBidder){
        //constructor creates object and initializes variables inside
        this.name = name;
        this.incrementAmount = incrementAmount;
        this.startingValue = startingValue;
        this.winner = "";

        this.playerOne = firstBidder;
        this.playerTwo = secondBidder;

        populateArrays();
    }
    /**
     * this method takes in no parameters and has no return value
     *
     * Description: This method uss this bidder objects to fill the arrays with their initial values, it then calls the method
     * bidQualify on each index in the parallel arrays (each index corresponds to one player), afterwards it calls te method currentWinner()
     * which begins the auction
     *
     */
    private void populateArrays(){
        this.bidderNames[0] = this.playerOne.getName();
        this.bidderNames[1] = this.playerTwo.getName();

        this.bidderCurrentBids[0] = this.playerOne.getCurrentBid();
        this.bidderCurrentBids[1] = this.playerTwo.getCurrentBid();

        this.bidderMaxBids[0] = this.playerOne.getMaxBid();
        this.bidderMaxBids[1] = this.playerTwo.getMaxBid();

        this.previousBid[0] = this.playerOne.getCurrentBid();
        this.previousBid[1] = this.playerTwo.getCurrentBid();
        for(int i = 0; i < bidderCurrentBids.length; i++){
            bidQualify(i);
        }
        currentWinner();
    }
    /**
     *
     * @param i (index of array you are examining, each index represents one player)
     * this method has no return value
     *
     * Description: This method makes sure the bid of each bidder follows the rules of the auction
     *
     * What are the rules of the auction?
     * When would a bid not follow the rules?
     * Why are the rules important for the auction to function properly?
     */
    public void bidQualify(int i){ //to enter bid in auction the max bid must be larger than the bidAmount,
        // and the bidAmount must be equal to or larger than the auction starting amount
        if(bidderCurrentBids[i] < bidderMaxBids[i]){
            if(bidderCurrentBids[i] >= startingValue){

            }
        } else{
            bidderCurrentBids[i] = -1;
        }
    }

    /**
     * no parameters
     * doesn't return anything because the method is void
     * Description: this method determines the winner of the auction, it does this by comparing the values of the two
     * bids, and increasing the smaller bid by calling the method pushToMax() on it until one of the bids hits it's maxBidAmount.
     * The method uses recursion to call itself multiple times
     *
     *
     * Analyze this method to figure out exactly how it works, test different values in your Bidder objects in the main method
     * in order to see which one will win under different conditions.
     *
     * Is this method ethically calculating the winner? Why or why not?
     * How does it decide how much the winner will pay for the item, and is it ethical?
     * How would you change this method?
     */
    private void currentWinner(){ //calculates current winner of auction
        if(bidderCurrentBids[1] >= bidderCurrentBids[0] && bidderCurrentBids[0] > 0){
             pushToMax(0);
        } else if(bidderCurrentBids[0] > bidderCurrentBids[1] && bidderCurrentBids[1] > 0){
            pushToMax(1);
        }
        if(bidderCurrentBids[0] < 0){
            if(previousBid[0] + incrementAmount <= bidderMaxBids[1]){
                bidderCurrentBids[1] = previousBid[0] + incrementAmount;
                winner = bidderNames[1];
                System.out.println("Winner of " + name + " is " + winner + " they pay " + bidderCurrentBids[1]);
            } else{
                winner = bidderNames[0];
                System.out.println("Winner of " + name + " is " + winner + " they pay " + previousBid[0]);

            }
        } else if(bidderCurrentBids[1] < 0){
            if(previousBid[1] + incrementAmount <= bidderMaxBids[0]){
                bidderCurrentBids[0] = previousBid[1] + incrementAmount;
                winner = bidderNames[0];
                System.out.println("Winner of " + name + " is " + bidderNames[0] + " they pay " + bidderCurrentBids[0]);
            } else{
                winner = bidderNames[1];
                System.out.println("Winner of " + name + " is " + bidderNames[1] + " they pay " + previousBid[1]);
            }
        }else {
            currentWinner();
        }
    }

    /**
     *
     * @param i (an interger cooresponding to the space in the parallel arrays you will be increasing the bid of)
     * @return int, the new value of the bid (at index i, the value you passed in)
     *
     * Description: this method increases the current bid of one player and stores their previous bid in the previousBid array
     *
     * Is this method ethical?
     * How does it work?
     * What other methods call it?
     */
    private int pushToMax(int i){
        if(bidderCurrentBids[i] + incrementAmount <= bidderMaxBids[i]){
            previousBid[i] = bidderCurrentBids[i];
            bidderCurrentBids[i] = bidderCurrentBids[i] + incrementAmount;
        }else{
            previousBid[i] = bidderCurrentBids[i];
            bidderCurrentBids[i] = -1;
        }
        return bidderCurrentBids[i];
    }

}