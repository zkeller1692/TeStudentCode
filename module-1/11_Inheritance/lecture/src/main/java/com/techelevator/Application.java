package com.techelevator;

public class Application {

    public static void main(String[] args) {

        Bid dummyBid = new Bid("Zach", 50);
        System.out.println(dummyBid.toString());

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        System.out.println("The winning bid was " +generalAuction.getHighBid().toString());
        System.out.println();
        System.out.println();

        ReserveAuction reserveAuction = new ReserveAuction("TE Paperweight", 100);

        reserveAuction.placeBid(new Bid("Zach", 25));
        reserveAuction.placeBid(new Bid("Jack",110));

        System.out.println("The winning reserve auction bid is " + reserveAuction.getHighBid());


    }


}
