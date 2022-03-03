package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){
        return this.reservationDao.findAll();
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservationById(@PathVariable int id){
        return this.reservationDao.get(id);
    }

    @GetMapping("hotels/{id}/reservations")
    public List<Reservation> getReservationsByHotelId(@PathVariable int hotelId){
        return this.reservationDao.findByHotel(hotelId);
    }

    @PostMapping("/reservation")
    public Reservation createdReservation(@RequestBody Reservation newReservation){
        return this.reservationDao.create(newReservation, newReservation.getHotelID());
    }
}
