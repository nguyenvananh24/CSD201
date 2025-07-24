// File: PE_Q1.java
package PE_Q1;

class Crypto {
    private String name;
    private int month;
    private int year;

    public Crypto(String name, int month, int year) {
        this.name = name;
        this.month = month;
        this.year = year;
    }

    public int compareYear(Crypto other) {
        return Integer.compare(this.year, other.year);
    }

    public String toString() {
        return name + " - " + month + "/" + year;
    }

    public int getYear() {
        return year;
    }
}

public class PE_Q1 {
    private Crypto[] cryptoList = new Crypto[20];
    private int size = 0;

    public void addFirst(Crypto c) {
        if (size >= cryptoList.length) return;
        for (int i = size; i > 0; i--) {
            cryptoList[i] = cryptoList[i - 1];
        }
        cryptoList[0] = c;
        size++;
    }

    public void removeLast() {
        if (size > 0) cryptoList[--size] = null;
    }

    public void mergeSort() {
        mergeSort(0, size - 1);
    }

    private void mergeSort(int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        Crypto[] temp = new Crypto[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (cryptoList[i].compareYear(cryptoList[j]) <= 0)
                temp[k++] = cryptoList[i++];
            else
                temp[k++] = cryptoList[j++];
        }

        while (i <= mid) temp[k++] = cryptoList[i++];
        while (j <= right) temp[k++] = cryptoList[j++];

        for (i = 0; i < k; i++) {
            cryptoList[left + i] = temp[i];
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(cryptoList[i]);
        }
    }

    public static void main(String[] args) {
        PE_Q1 manager = new PE_Q1();

        manager.addFirst(new Crypto("Tether", 2, 2014));
        manager.addFirst(new Crypto("Chainlink", 3, 2017));
        manager.addFirst(new Crypto("Polkadot", 1, 2020));
        manager.addFirst(new Crypto("Dogecoin", 2, 2013));
        manager.addFirst(new Crypto("Solana", 6, 2020));
        manager.addFirst(new Crypto("Cardano", 5, 2017));
        manager.addFirst(new Crypto("Litecoin", 11, 2011));
        manager.addFirst(new Crypto("Ripple", 6, 2012));
        manager.addFirst(new Crypto("Ethereum", 10, 2015));
        manager.addFirst(new Crypto("Bitcoin", 9, 2009));

        System.out.println("Before sorting:");
        manager.print();

        manager.mergeSort();

        System.out.println("\nAfter sorting by year:");
        manager.print();

        System.out.println("\nRemove last:");
        manager.removeLast();
        manager.print();
    }
}
