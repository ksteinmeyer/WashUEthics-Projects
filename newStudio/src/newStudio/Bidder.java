package newStudio;

public class Bidder {

    private String name;
    //private int maxBid;
    private Bid currentBid;

    /**
     *
     * @param name -- bidder name, computer : human
     */
    public Bidder(String name, int maxBid, int startingBid){
        this.name = name;
       // this.maxBid = maxBid;
        this.currentBid = new Bid(startingBid, maxBid);
    }

//    public int getMaxBid(){
//        return this.maxBid;
//    }
    public String getName(){
        return this.name;
    }
    public void setCurrentBid(int current){
        currentBid.setBidAmount(current);
    }
    public int getCurrentBid(){
        return this.currentBid.getBidAmount();
    }

    public int getMaxBid(){
        return this.currentBid.getMaxBid();
    }

}
