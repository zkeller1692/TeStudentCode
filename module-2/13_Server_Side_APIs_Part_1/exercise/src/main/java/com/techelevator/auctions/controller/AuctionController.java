package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like,
                              @RequestParam(defaultValue = "0") double currentBid_lte) {
        List<Auction> auctions = this.dao.list();
        if (!title_like.equals("") && currentBid_lte > 0) {
            return this.dao.searchByTitleAndPrice(title_like, currentBid_lte);
        } else if (currentBid_lte > 0 && title_like.equals("")) {
            return dao.searchByPrice(currentBid_lte);
        } else if (!title_like.equals("")) {
            return this.dao.searchByTitle(title_like);
        }
        return auctions;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return this.dao.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction newAuction) {
        return this.dao.create(newAuction);
    }

}
