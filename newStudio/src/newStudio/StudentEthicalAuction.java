package newStudio;

public class StudentEthicalAuction{

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
        Auction auction = new Auction("auction",2, 4, Player1, Player2);

    }

    public StudentEthicalAuction(String name, int incrementAmount, int startingValue, Bidder firstBidder, Bidder secondBidder){
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
     *
     * Fix the method, if you found it unethical, so that it ethically calculcates the winner
     * Discuss your ideas to change the method with your TA
     */
    private void currentWinner(){ //calculates current winner of auction
       //FIXME
    }

    /**
     *
     * @param i (an interger cooresponding to the space in the parallel arrays you will be increasing the bid of)
     * @return int, the new value of the bid (at index i, the value you passed in)
     *
     * Fix the method, if you found it unethical, so that it ethically increases the player's bid
     */
    private int pushToMax(int i){
        //FIXME
        return 0;
    }

}

