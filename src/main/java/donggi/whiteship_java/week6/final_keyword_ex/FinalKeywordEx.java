package donggi.whiteship_java.week6.final_keyword_ex;

import java.util.ArrayList;
import java.util.List;

public class FinalKeywordEx {

    final List<Integer> arr = new ArrayList<>();

    public void hello() {
        arr.add(10);
        System.out.println(arr.size());
    }

    public static void main(String[] args) {
        FinalKeywordEx f = new FinalKeywordEx();
        f.hello();

    }

}
