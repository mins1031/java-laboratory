package java_lab.callbook.service;

import java_lab.callbook.vo.CallBookVo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class CallBookService {

    private Map<String, String> callBook = new LinkedHashMap<>();

    public void load(CallBookVo callBookVo) {
        callBook.put(callBookVo.getPhone(), callBookVo.getName());
    }

    public List<CallBookVo> findByName(String name) {
        List<CallBookVo> callBooks = new ArrayList<>();
        for (Map.Entry<String, String> entry : callBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                callBooks.add(new CallBookVo(entry.getValue(), entry.getKey()));
            }
        }

        return callBooks;
    }

}
