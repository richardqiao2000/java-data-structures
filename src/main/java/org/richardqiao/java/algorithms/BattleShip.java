package org.richardqiao.java.algorithms;
 
import java.util.*;

public class BattleShip {

  private Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
  private int count;
  public BattleShip(List<Integer[]> battleships){
    count = battleships.size();
    for(Integer[] seg: battleships){
      Set<Integer> set = new HashSet<Integer>();
      for(int i = seg[0]; i <= seg[1]; i++){
        set.add(i);
      }
      for(int i = seg[0]; i <= seg[1]; i++){
        map.put(i, set);
      }
    }
  }
  public static void main(String[] args) {
    List<Integer[]> list = new ArrayList<Integer[]>();
    list.add(new Integer[]{2,5});
    //list.add(new Integer[]{9,15});
    //list.add(new Integer[]{17,24});
    BattleShip bs = new BattleShip(list);
    System.out.println(bs.tryIt(2));
    System.out.println(bs.tryIt(3));
    System.out.println(bs.tryIt(4));
    System.out.println(bs.tryIt(5));
    System.out.println(bs.tryIt(8));
    
    System.out.println(bs.tryIt(12));
  }
  
  private String tryIt(int pos){
    if(!map.containsKey(pos)){
      return "MISS";
    }
    
    Set<Integer> set = map.get(pos);
    if(set.isEmpty()){
      return "MISS";
    }
    set.remove(pos);
    if(!set.isEmpty()){
      return "HIT";
    }
    count--;
    if(count != 0){
      return "SUNK";
    }
    return "WIN";
  }

}
