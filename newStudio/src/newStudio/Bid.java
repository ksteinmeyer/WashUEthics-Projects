package newStudio;

public class Bid {
    private final String name;
    private final int maxBid;
    private int bidAmount;



    public Bid(String name, int maxBid, int bidAmount){ //constructor for Bid object
        //you can make a new bid by initializing 'Bid a = new Bid(6, 10)'
        this.bidAmount = bidAmount;
        this.maxBid = maxBid;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public int getMaxBid(){
        return this.maxBid;
    }
    public int getBidAmount(){
        return this.bidAmount;
    }

    public void setBidAmount(){
        this.bidAmount = bidAmount;
    }
    public String withDrawBid(){
        getBidIndex(a); //need to fix to allow user to withdraw bid
        return"Bid "+name+" is no longer in auction";
    }

    public static void main(String[] args){
       Bid a = new Bid("a", 10, 1);
    }






















}
