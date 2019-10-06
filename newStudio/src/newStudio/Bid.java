package newStudio;

public class Bid {
    private int bidAmount;
    private int increment;

    /**
     * Constructor for Bid
     * @param bidAmount
     * @param increment
     */
    public Bid(int bidAmount, int increment) {
        this.bidAmount = bidAmount;
    }

    public int getBidAmount() {
        return this.bidAmount;
    }

    public void setBidAmount(int newBid) {
        this.bidAmount = newBid;
    }

    public boolean checkExceedsMax(int bid, int max) {
        if (bid>max) return true;
        else return false;
    }

    public boolean incrementBid(int maxBid) {
        int newBid = this.bidAmount + this.increment;
        if(!checkExceedsMax(newBid, maxBid)) {
            this.bidAmount = newBid;
            return true;
        } else {
            return false;
        }
    }

}






















}
