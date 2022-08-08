package callbook.service;

import callbook.vo.CallBookVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CallBookServiceTest {

    @Test
    void 이름_벨류_번호_키_속도() {
        CallBookService callBookService = new CallBookService();
        loadCallBooks(callBookService);
        callBookService.load(new CallBookVo("min young", "01055346038"));
        callBookService.load(new CallBookVo("jae young", "01024016038"));
        callBookService.load(new CallBookVo("mom", "01077606038"));
        callBookService.load(new CallBookVo("dad", "01033816038"));

        long start = System.currentTimeMillis();
        List<CallBookVo> mom = callBookService.findByName("mom");
        long end = System.currentTimeMillis();

        System.out.println(end - start);
        Assertions.assertEquals("01077606038", mom.get(0).getPhone());
    }

    public void loadCallBooks(CallBookService callBookService) {
        for (int i = 0; i < 100000; i++) {
            callBookService.load(new CallBookVo("name" + i, UUID.randomUUID().toString().substring(0, 8)));
        }
    }
}