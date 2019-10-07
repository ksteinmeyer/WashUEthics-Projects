package newStudio;

public class StudentEthicalAuction{

    private final String name;
    private final int incrementAmount; //how much bids will increment by
    private final int startingValue; //starting value of auction

    // private Bidder[] bidders = new Bidder[2];
    private Bidder playerOne;
    private Bidder playerTwo;

    private final int numberOfBidders = 2;

    //bidder arrays
    private String[] bidderNames = new String[numberOfBidders];
    private int[] bidderMaxBids = new int[numberOfBidders];
    private int[] bidderCurrentBids = new int[numberOfBidders];



    private String winner;

    public static void main(String[] args) {
        //here's where you can make your bids and enter them in the auction
        Bidder Player1 = new Bidder("Player 1", 12, 9);
        Bidder Player2 = new Bidder("Player 2", 4, 9);

        Auction auction = new Auction("auction",3, 9, Player1, Player2);

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
        currentWinner();
    }

    public void bidQualify(int i){ //to enter bid in auction the max bid must be larger than the bidAmount,
        // and the bidAmount must be equal to or larger than the auction starting amount
        if(bidderCurrentBids[i] < bidderMaxBids[i]){
            if(bidderCurrentBids[i] >= startingValue){

            }
        } else{
            bidderCurrentBids[i] = -1;
        }
    }


    private void currentWinner(){ //calculates current winner of auction
       //FIXME
    }


    private int pushToMax(int i){
        //FIXME
        return 0;
    }

}

