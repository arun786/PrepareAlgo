package Map.probing;

public class App {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 12);
        hashMap.put(3, 100);

        System.out.println(hashMap);

        int i = hashMap.get(3);
        System.out.println(i);
    }
}
