package RandomizedSet;

import java.util.*;

public class RandomizedSet
{
    private List<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private int size = 0;

    public RandomizedSet()
    {
    }

    public boolean insert(int val)
    {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val)
    {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        int num = list.remove(list.size()-1);
        if(list.size()>0 && index < list.size()-1)
        {
            list.set(index, num);
            map.put(num, index);
        }
        map.remove(val);
        return true;
    }

    public int getRandom()
    {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
