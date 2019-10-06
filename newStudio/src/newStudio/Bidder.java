package newStudio;

public class Bidder {

    private String name;
    private int maxBid;
    private Bid currentBid;

    /**
     *
     * @param name -- bidder name, computer : human
     * @param maxBid -- maximum bid for user
     * @param currentBid -- current bid entered
     */
    public Bidder(String name, int maxBid,  int startingBid, int increment){
        this.name = name;
        this.maxBid = maxBid;
        this.currentBid = new Bid(startingBid, increment);
    }

    public int getMaxBid(){
        return this.maxBid;
    }
    public Bid getCurrentBid(){
        return this.currentBid;
    }

}
