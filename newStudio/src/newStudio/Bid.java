package newStudio;

public class Bid {
    private int bidAmount;
  //  private int increment;
    private int maxBid;

    /**
     * Constructor for Bid
     * @param bidAmount
    / * @param increment
     */
    public Bid(int bidAmount, int maxBid) {
        this.bidAmount = bidAmount;
        this.maxBid = maxBid;
    }

    public int getBidAmount() {
        return this.bidAmount;
    }
    public int getMaxBid() {
        return this.maxBid;
    }

    public void setBidAmount(int newBid) {
        this.bidAmount = newBid;
    }

    // students will complete
    public boolean checkExceedsMax(int bid, int max) {
        if (bid>max) return true;
        else return false;
    }

    // students will complete
    public boolean raiseBid(int maxBid, int increment) {
        int newBid = this.bidAmount + increment;
        if(!checkExceedsMax(newBid, maxBid)) {
            this.bidAmount = newBid;
            return true;
        } else {
            return false;
        }
    }

}























