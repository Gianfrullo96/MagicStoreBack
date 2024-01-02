package com.gf.magic.store.front.repository;

import com.gf.magic.store.front.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */
@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
}
