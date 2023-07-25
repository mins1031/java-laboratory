package java_lab._동시성._volatile_atomic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AtomicInventoryTest {

    @DisplayName("")
    @Test
    public void name() {
        //given
        AtomicInventory atomicInventory = new AtomicInventory();
        int currentValue = atomicInventory.atomicInteger.get();
        System.out.println(currentValue);
//        System.out.println(atomicInventory.atomicInteger.compareAndSet(currentValue, ));
        System.out.println(atomicInventory.atomicInteger.get());

        //when
        //then
    }
}