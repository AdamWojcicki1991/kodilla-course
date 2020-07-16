package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        //Given
        CadetTask moduleTwentyFour = new KodillaModuleTwentyFour();
        CadetTask moduleSeventeen = new KodillaModuleSeventeen();
        Mentor andrzejJaromin = new Mentor("Andrzej Jaromin");
        Mentor marcinSzuppe = new Mentor("Marcin Szuppe");
        moduleTwentyFour.registerObserver(andrzejJaromin);
        moduleSeventeen.registerObserver(andrzejJaromin);
        moduleSeventeen.registerObserver(marcinSzuppe);
        //When
        moduleTwentyFour.addTask("Create aspects for OrderFacade method processOrder(): Kodilla task 24.3");
        moduleTwentyFour.addTask("Create PIZZA DECORATOR: Kodilla task 24.2");
        moduleSeventeen.addTask("Create NAMED QUERIE'S for Entity EMPLOYEE and COMPANY Hibernate: Kodilla task 17.4");
        moduleTwentyFour.addTask("Create FACADE for Entity EMPLOYEE and COMPANY: Kodilla task 24.1");
        moduleSeventeen.addTask("Create Entity INVOICES Hibernate: Kodilla task 17.3");
        //Then
        assertEquals(5, andrzejJaromin.getUpdateCount());
        assertEquals(2, marcinSzuppe.getUpdateCount());
    }
}
