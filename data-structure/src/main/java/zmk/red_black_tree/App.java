package zmk.red_black_tree;

import java.util.TreeMap;

/**
 * Created by Administrator on 2018/8/3/003.
 */
public class App {
    public static void main(String[] args) {
        //测试下
        MyTreeMap<Integer, Integer> myTreeMap = new MyTreeMap();
        myTreeMap.put(781, 781);
        myTreeMap.put(494, 494);
        myTreeMap.put(62, 62);
        myTreeMap.put(471, 471);
        myTreeMap.put(628, 628);
        myTreeMap.put(755, 755);
        myTreeMap.put(177, 177);
        myTreeMap.put(354, 354);
        myTreeMap.put(658, 658);
        myTreeMap.put(426, 426);
        myTreeMap.put(456, 456);
        MyEntry entry = myTreeMap.getRoot();
        MyEntry entry1 = myTreeMap.getRoot();
        String color = "红";
        if (entry.color) {
            color = "黑";
        }
        System.out.println(entry.value + ":" + color);
        while (entry.left != null) {
            MyEntry left = entry.left;
            if (left.color) {
                color = "黑";
            }else{
                color = "红";
            }
            System.out.println(left.value + ":" + color);
            entry = entry.left;
        }
        System.out.println("============");
        color = "红";
        if (entry1.color) {
            color = "黑";
        }
        System.out.println(entry1.value + ":" + color);
        while (entry1.right != null) {
            MyEntry right = entry1.right;
            if (right.color) {
                color = "黑";
            }else{
                color = "红";
            }
            System.out.println(right.value + ":" + color);
            entry1 = entry1.right;
        }
    }
}
