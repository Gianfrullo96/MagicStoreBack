package com.gf.magic.store.front.repository;

import com.gf.magic.store.front.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */

@Repository
public interface CardRepo extends JpaRepository<Card,Long> {

    public Card getCardByName(String name);
}
