package com.gf.magic.store.front.scryfall;


import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.scryfall.entities.Datum;
import com.gf.magic.store.front.scryfall.entities.Root;
import com.gf.magic.store.front.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/4/23
 */
@Component
public class ScryfallCardFiller {

    @Autowired
    CardService cardService;


    public void fillCards() throws Exception {

        //TODO: per aggiungere altre carte basta cambiare questa query e riattivare la funzione di seeding del database

        //legali in commander e mitiche
        String mithicUrl = "https://api.scryfall.com/cards/search?q=(game=paper)+legal=commander+rarity=m";
        ScryfallClientImpl client = new ScryfallClientImpl(mithicUrl);



        long totalCards = 0;
        String nextPageUrl = mithicUrl; // Initialize with the base URL

        while (nextPageUrl != null) {
            Root result = client.getCards();

            // Check if there are no more pages to fetch
            if (result.getNextPage()==null) {
                nextPageUrl = null; // No more pages to fetch
            } else {
                // Decode the URL before using it
                nextPageUrl = URLDecoder.decode(result.getNextPage(), "UTF-8");
                client = new ScryfallClientImpl(nextPageUrl);
            }

            ArrayList<Datum> data = result.getData();



            ResponseMapper responseMapper = new ResponseMapper();
            List<Card> cardlist=  responseMapper.mapDatums(data);
            //print result
            for (Card card:cardlist) {
                System.out.println("Card name: " + card.getName());
                System.out.println("Card type: " + card.getType());
                System.out.println("Rarity: " + card.getRarity());
                System.out.println("Set: " + card.getCardSet());
                System.out.println("image: " + card.getImageUrl());
                System.out.println("quantity:" + card.getQuantity());
                System.out.println("----------------------------");
                cardService.createCard(card);

            }
        }

        System.out.println("Total Cards: " + totalCards);

    }



//    public static void main(String[] args) throws Exception {
//
//
//        //legali in commander e mitiche
//        String mithicUrl = "https://api.scryfall.com/cards/search?q=(game=paper)+legal=commander+rarity=m";
//        ScryfallClientImpl client = new ScryfallClientImpl(mithicUrl);
//
//
//
//        long totalCards = 0;
//        String nextPageUrl = mithicUrl; // Initialize with the base URL
//
//        while (nextPageUrl != null) {
//            Root result = client.getCards();
//
//            // Check if there are no more pages to fetch
//            if (result.getNextPage()==null) {
//                nextPageUrl = null; // No more pages to fetch
//            } else {
//                // Decode the URL before using it
//                nextPageUrl = URLDecoder.decode(result.getNextPage(), "UTF-8");
//                client = new ScryfallClientImpl(nextPageUrl);
//            }
//
//            ArrayList<Datum> data = result.getData();
//
//
//
//            ResponseMapper responseMapper = new ResponseMapper();
//            List<Card> cardlist=  responseMapper.mapDatums(data);
//      //print result
//            for (Card card:cardlist) {
//                System.out.println("Card name: " + card.getName());
//                System.out.println("Card type: " + card.getType());
//                System.out.println("Rarity: " + card.getRarity());
//                System.out.println("Set: " + card.getCardSet());
//                System.out.println("image: " + card.getImageUrl());
//                System.out.println("quantity:" + card.getQuantity());
//                System.out.println("----------------------------");
//
//
//            }
//        }
//
//        System.out.println("Total Cards: " + totalCards);
//
//
//
//
//
//    }
}


