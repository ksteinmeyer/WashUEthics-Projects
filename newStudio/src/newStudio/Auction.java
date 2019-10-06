package newStudio;

//import cse131.ArgsProcessor;

public class Auction {

    private final String name;
    private final int incrementAmount; //how much bids will increment by
    private final int startingValue; //starting value of auction

   // private Bidder[] bidders = new Bidder[2];
    private Bidder playerOne;
    private Bidder playerTwo;

    private final int numberOfBidders = 2;

    // Bidder arrays
    private String[] bidderNames = new String[numberOfBidders];
    private int[] bidderMaxBids = new int[numberOfBidders];
    private int[] bidderCurrentBids = new int[numberOfBidders];


//    private String[] bidName; //using parallel array to store information about the bid's name, amount, and max bid
//    private int[] bidAmount;
//    private int[] bidMax;

  //  private int size; //size of arrays
    private String winner;

    public static void main(String[] args) {
        //here's where you can make your bids and enter them in the auction
        Bidder playerOne = new Bidder("Player 1", 10, 2);
        Bidder playerTwo= new Bidder("Player 2", 11 , 1);

        Auction auction = new Auction("auction",2, 1, playerOne, playerTwo);
       // auction.addBid(a);
       // auction.addBid(b);
    }

    public Auction(String name, int incrementAmount, int startingValue, Bidder firstBidder, Bidder secondBidder){ //constructor creates object and initializes variables inside
        this.name = name;
        this.incrementAmount = incrementAmount;
        this.startingValue = startingValue;
        this.winner = "";

        this.playerOne = firstBidder;
        this.playerTwo = secondBidder;

        populateArrays();
    }

    private void populateArrays(){
        this.bidderNames[0] = this.playerOne.getName();
        this.bidderNames[1] = this.playerTwo.getName();

        this.bidderCurrentBids[0] = this.playerOne.getCurrentBid();
        this.bidderCurrentBids[1] = this.playerTwo.getCurrentBid();

        this.bidderMaxBids[0] = this.playerOne.getMaxBid();
        this.bidderMaxBids[1] = this.playerTwo.getMaxBid();
        for(int i = 0; i < bidderCurrentBids.length; i++){
            bidQualify(i);
        }
    }

    public void bidQualify(int i){ //to enter bid in auction the max bid must be larger than the bidAmount,
        // and the bidAmount must be equal to or larger than the auction starting amount
        if(bidderCurrentBids[i] > bidderMaxBids[i]){
            if(bidderCurrentBids[i] >= startingValue){
                currentWinner();
            }
        } else{
            bidderCurrentBids[i] = -1;
            currentWinner();
        }
    }
//    public boolean addBid(Bidder a){ //method for adding bid, returns true if bid was successfully added to auction,
//        // returns false if bid did not qualify for auction
//        if(bidQualify(a)) {
//
////            bidAmount[size] = a.getBidAmount(); //adds each piece of information to parallel array
////            bidName[size] = a.getName();
////            bidMax[size] = a.getMaxBid();
////            size++; //increases size of arrays
//            currentWinner(); //recalculates the current winner using new information
//            return true;
//        }
//        return false;
//    }
//    public int getBidIndex(String a){ //need to make sure user can withdraw bid
//        int index = 0;
//        for(int i = 0; i < size; i++){
//            if(bidName[i] == a){
//                index = i;
//            }
//        }
//        return index;
//    }
    private void currentWinner(){ //calculates current winner of auction

       // for(int i = 0; i < bidAmount.length; i++){ //finds the max bid amound and saves index of that bid
            if(bidderCurrentBids[0] > bidderCurrentBids[1]){
                pushToMax(bidderCurrentBids[1]);
            } else{
                pushToMax(bidderCurrentBids[0]);
            }
        //}
        if(bidderCurrentBids[0] < 0){
           winner = bidderNames[1];
           System.out.println("Winner of " + name + " is " + bidderNames[1]);
        } else if(bidderCurrentBids[1] < 0){
            winner = bidderNames[0];
            System.out.println("Winner of " + name + " is " + bidderNames[0]);
        }else {
            currentWinner();
        }//sets new winner to the name of the bid at highest amount index
    }
    private int pushToMax(int i){
        if(bidderCurrentBids[i] + incrementAmount <= bidderMaxBids[i]){
            bidderCurrentBids[i] = bidderCurrentBids[i] + incrementAmount;
        }else{
            bidderCurrentBids[i] = -1;
        }
        return bidderCurrentBids[i];
    }

//    private void bidRaise(int []bidAmount, int []bidMax){
//        for(int i = 0; i < size; i++){
//            if(bidAmount[i] > bidMax[i]){
//                delete(i);
//            }
//            if((bidName[i] != this.winner) && (bidAmount[i] < bidMax[i])){
//                bidAmount[i] = bidAmount[i] + incrementAmount;
//                currentWinner();
//            }
//        }
//    }

//    private void delete(int x){
//        String toPrint = bidName[x];
//        bidName[x] = null;
//        bidAmount[x] = 0;
//        bidMax[x] = 0;
//        for(int i = x; i < size; i++){
//            bidName[i] = bidName[i+1];
//            bidMax[i] = bidMax[i+1];
//            bidAmount[i] = bidAmount[i+1];
//        }
//        bidName[size] = null;
//        bidAmount[size] = 0;
//        bidMax[size] = 0;
//        size--;
//        System.out.println("Bid " + toPrint + " is no longer in auction: " + this.name);
//    }


}
