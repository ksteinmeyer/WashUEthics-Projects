package newStudio;

public class Auction {

    private final String name;
    private final int incrementAmount; //how much bids will increment by
    private final int startingValue; //starting value of auction

    private Bidder[] bidders = new Bidder[2];

//    private String[] bidName; //using parallel array to store information about the bid's name, amount, and max bid
//    private int[] bidAmount;
//    private int[] bidMax;

    private int size; //size of arrays
    private String winner;

    public static void main(String[] args) {
        Bid a = new Bid("a", 10, 2);
        Bid b = new Bid("b", 11, 1);
        Auction auction = new Auction("auction",2, 1);
        auction.addBid(a);
        auction.addBid(b);
    }

    public Auction(String name, int incrementAmount, int startingValue){ //constructor creates object and initializes variables inside
        this.name = name;
        this.incrementAmount = incrementAmount;
        this.startingValue = startingValue;
        this.bidAmount = bidAmount;
        this.bidMax = bidMax;
        this.bidName = bidName;
        this.size = 0;
        this.winner = winner;

    }
    private boolean bidQualify(Bid a){ //to enter bid in auction the max bid must be larger than the bidAmount,
        // and the bidAmount must be equal to or larger than the auction starting amount
        if(a.getMaxBid() > a.getBidAmount()){
            if(a.getBidAmount() >= startingValue){
                return true;
            }
        }
        return false;
    }
    public boolean addBid(Bid a){ //method for adding bid, returns true if bid was successfully added to auction,
        // returns false if bid did not qualify for auction
        if(bidQualify(a)) {
            bidAmount[size] = a.getBidAmount(); //adds each piece of information to parallel array
            bidName[size] = a.getName();
            bidMax[size] = a.getMaxBid();
            size++; //increases size of arrays
            currentWinner(); //recalculates the current winner using new information
            return true;
        }
        return false;
    }
    public int getBidIndex(String a){ //need to make sure user can withdraw bid
        int index = 0;
        for(int i = 0; i < size; i++){
            if(bidName[i] == a){
                index = i;
            }
        }
        return index;
    }
    private void currentWinner(){ //calculates current winner of auction
        int indexOfMax = 0;
        for(int i = 0; i < bidAmount.length; i++){ //finds the max bid amound and saves index of that bid
            if(bidAmount[i] > indexOfMax){
                indexOfMax = i;
            }
        }
        winner = bidName[indexOfMax]; //sets new winner to the name of the bid at highest amount index
    }

    private void bidRaise(int []bidAmount, int []bidMax){
        for(int i = 0; i < size; i++){
            if(bidAmount[i] > bidMax[i]){
                delete(i);
            }
            if((bidName[i] != this.winner) && (bidAmount[i] < bidMax[i])){
                bidAmount[i] = bidAmount[i] + incrementAmount;
                currentWinner();
            }
        }
    }

    private void delete(int x){
        String toPrint = bidName[x];
        bidName[x] = null;
        bidAmount[x] = 0;
        bidMax[x] = 0;
        for(int i = x; i < size; i++){
            bidName[i] = bidName[i+1];
            bidMax[i] = bidMax[i+1];
            bidAmount[i] = bidAmount[i+1];
        }
        bidName[size] = null;
        bidAmount[size] = 0;
        bidMax[size] = 0;
        size--;
        System.out.println("Bid " + toPrint + " is no longer in auction: " + this.name);
    }


}
