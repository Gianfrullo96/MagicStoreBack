package com.gf.magic.store.front.scryfall;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/5/23
 */
//
//@Component
//public class AppStartupRunner implements CommandLineRunner {
//
//    @Autowired
//    private CardFillerService cardFillerService;
//
//    @Autowired
//    private CardRepo cardRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        if (!isDatabaseSeeded()) {
//            // Seed the database with initial data
//            System.out.println("adesso ti riempio");
//            cardFillerService.fillCards();
//
//        }
//        System.out.println("riempito, stoppa tutto");
//
//
//    }
//
//    private boolean isDatabaseSeeded() {
//        // Implement a logic to check if the database is already seeded
//        // This can be done by checking for some specific data or a flag in the database
//        System.out.println("arealo:    "   +cardRepo.count());
//
//        return cardRepo.count() > 0; // For example, check if there are any records in your repository
//    }
//}
