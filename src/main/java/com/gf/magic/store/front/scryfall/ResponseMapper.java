package com.gf.magic.store.front.scryfall;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.scryfall.entities.CardFace;
import com.gf.magic.store.front.scryfall.entities.Datum;

import java.util.ArrayList;
import java.util.List;


/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/5/23
 */
public class ResponseMapper {

    public Card mapDatum(Datum datum){
        Card c= new Card();
        c.setName(datum.getName());
        c.setCardSet(datum.getSetName());
        c.setRarity(datum.getRarity());
        c.setType(datum.getTypeLine());
        c.setImageUrl(datum.getImageUris().getNormal());
        c.setQuantity(0);
        return c;
    }

    public List<Card> mapDatums(List<Datum> datums){

        List<Card> cardlist = new ArrayList<Card>();

        for (Datum datum:datums) {
            Card c= new Card();
            c.setName(datum.getName());
            c.setCardSet(datum.getSetName());
            c.setRarity(datum.getRarity());
            c.setType(datum.getTypeLine());
            if (datum.getImageUris() == null) {
                List<CardFace> cardFaces = datum.getCardFaces();
                if (cardFaces != null && !cardFaces.isEmpty()) {
                    CardFace firstCardFace = cardFaces.get(0);
                    if (firstCardFace.getImageUris() != null) {
                        c.setImageUrl(firstCardFace.getImageUris().getNormal());
                    } else {
                        c.setImageUrl("thereWereProblems1");
                    }
                } else {
                    c.setImageUrl("thereWereProblems2");
                }
            } else {
                c.setImageUrl(datum.getImageUris().getNormal());
            }
            String priceString = datum.getPrices().getEur();
            if (priceString != null) {
                try {
                    double price = Double.parseDouble(priceString);
                    c.setPrice(price);
                } catch (NumberFormatException e) {
                    // Handle the case where the price string cannot be parsed as a double
                    // You can set a default value or log an error here
                    c.setPrice(0.0); // Default value or appropriate handling
                }
            } else {
                // Handle the case where priceString is null
                // You can set a default value or log an error here
                c.setPrice(0.0); // Default value or appropriate handling
            }
            c.setQuantity(0);
            cardlist.add(c);
        }


        return cardlist;
    }
}
