package com.company;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;

//---------------------------------
//---------------Классы Calendar и GregorianCalendar------------------
//---------------------------------
public class Main {
    public Main() {
    }
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2002);
        cal.set(Calendar.MONTH,Calendar.AUGUST);
        cal.set(Calendar.DAY_OF_MONTH,31);
        System.out.println(" Initialy set date: " + sdf.format(cal.getTime()));
        cal.set(Calendar.MONTH,Calendar.SEPTEMBER);
        System.out.println(" Date with month changed : " + sdf.format(cal.getTime()));
        cal.set(Calendar.DAY_OF_MONTH,30);
        System.out.println(" Date with day changed : " + sdf.format(cal.getTime()));

    }
}
//-----------------------Метод set(int field,int value).----------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR,2002);
//        cal.set(Calendar.MONTH,Calendar.AUGUST);
//        cal.set(Calendar.DAY_OF_MONTH,31);
//        System.out.println(" Initialy set date: " + sdf.format(cal.getTime()));
//        cal.set(Calendar.MONTH,Calendar.SEPTEMBER);
//        cal.set(Calendar.DAY_OF_MONTH,30);
//        System.out.println(" Date with day and month changed : " + sdf.format(cal.getTime()));
//    }
//}
//---------------Метод add(int field,int delta).------------------
//public class Main {
//
//    public Main() {
//    }
//    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR,2002);
//        cal.set(Calendar.MONTH,Calendar.AUGUST);
//        cal.set(Calendar.DAY_OF_MONTH,31);
//        cal.set(Calendar.HOUR_OF_DAY,19);
//        cal.set(Calendar.MINUTE,30);
//        cal.set(Calendar.SECOND,00);
//        System.out.println("Current date: " + sdf.format(cal.getTime()));
//        cal.add(Calendar.SECOND,75);
//        System.out.println("Current date: " + sdf.format(cal.getTime()));
//        cal.add(Calendar.MONTH,1);
//        System.out.println("Current date: " + sdf.format(cal.getTime()));
//    }
//}
//----------------------------------------------
//---------------Класс TimeZone------------------
//-----------------------------------------------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main main = new Main();
//        TimeZone tz = TimeZone.getDefault();
//        int rawOffset = tz.getRawOffset();
//        System.out.println("Current TimeZone" + tz.getDisplayName() + tz.getID() + "\n\n");
//        // Display all available TimeZones
//        System.out.println("All Available TimeZones \n");
//        String[] idArr = tz.getAvailableIDs();
//        for(int cnt=0;cnt < idArr.length;cnt++){
//            tz = TimeZone.getTimeZone(idArr[cnt]);
//            System.out.println(main.padr(tz.getDisplayName() +
//                    tz.getID(),64) + " raw offset=" + tz.getRawOffset() +
//                    ";hour offset=(" + tz.getRawOffset()/ (1000 * 60 * 60 ) + ")");
//        }
//        // Display all available TimeZones same as for Moscow
//        System.out.println("\n\n TimeZones same as for Moscow \n");
//        idArr = tz.getAvailableIDs(rawOffset);
//        for(int cnt=0;cnt < idArr.length;cnt++){
//            tz = TimeZone.getTimeZone(idArr[cnt]);
//            System.out.println(main.padr(tz.getDisplayName()+
//                    tz.getID(),64) + " raw offset=" + tz.getRawOffset() +
//                    ";hour offset=(" + tz.getRawOffset()/ (1000 * 60 * 60 ) + ")");
//        }
//    }
//    String padr(String str,int len){
//        if(len - str.length() > 0){
//            char[] buf = new char[len - str.length()];
//            Arrays.fill(buf,' ');
//            return str + new String(buf);
//        }else{
//            return str.substring(0,len);
//        }
//    }
//}
//----------------------------------------------
//---------------Класс SimpleTimeZone------------------
//-----------------------------------------------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main main = new Main();
//        SimpleTimeZone stz = new SimpleTimeZone(
//                TimeZone.getDefault().getRawOffset()
//                ,TimeZone.getDefault().getID()
//                ,Calendar.MARCH
//                ,-1
//                ,Calendar.SUNDAY
//                ,main.getTime(2,0,0,0)
//                ,Calendar.OCTOBER
//                ,-1
//                ,Calendar.SUNDAY
//                ,main.getTime(3,0,0,0)
//        );
//        System.out.println(stz.toString());
//    }
//    int getTime(int hour,int min,int sec,int ms){
//        return hour * 3600000 + min * 60000 + sec * 1000 + ms;
//    }
//}
//----------------------------------------------
//---------------Интерфейс Observer и класс Observable------------------
//-----------------------------------------------
//class MainObservable extends java.util.Observable {
//    private String name = "";
//    public MainObservable(String name) {
//        this.name = name;
//    }
//
//    public void modify() {
//        setChanged();
//    }
//
//    public String getName() {
//        return name;
//    }
//}
//
//class TestObserver implements java.util.Observer {
//    private String name = "";
//
//    public TestObserver(String name) {
//        this.name = name;
//    }
//    public void update(java.util.Observable o,Object arg) {
//        String str = "Called update of " + name;
//        str += " from " + ((MainObservable)o).getName();
//        str += " with argument " + (String)arg;
//        System.out.println(str);
//    }
//}
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        MainObservable to = new MainObservable("Observable");
//        TestObserver o1 = new TestObserver("Observer 1");
//        TestObserver o2 = new TestObserver("Observer 2");
//        to.addObserver(o1);
//        to.addObserver(o2);
//        to.modify();
//        to.notifyObservers("Notify argument");
//    }
//}
//
//
//----------------------------------------------
//---------------Конкретные классы коллекций------------------
//-----------------------------------------------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        LinkedList ll = new LinkedList();
//        ll.add("Element1");
//        ll.addFirst("Element2");
//        ll.addFirst("Element3");
//        ll.addLast("Element4");
//        test.dumpList(ll);
//        ll.remove(2);
//        test.dumpList(ll);
//        String element = (String)ll.getLast();
//        ll.remove(element);
//        test.dumpList(ll);
//    }
//    private void dumpList(List list){
//        Iterator it = list.iterator();
//        System.out.println();
//        while(it.hasNext()){
//            System.out.println((String)it.next());
//        }
//    }
//}

//----------------------------------------------
//---------------Класс Collections------------------
//-----------------------------------------------
//public class Main {
//    private class TestObject {
//        private String name = "";
//        public TestObject(String name) {
//            this.name = name;
//        }
//    }
//    private class MyComparator implements Comparator {
//        public int compare(Object l,Object r) {
//            String left = (String)l;
//            String right = (String)r;
//            return -1 * left.compareTo(right);
//        }
//    }
//    public Main() {
//    }
//
//    public static void main(String[] args) {
//        Main test = new Main();
//        Vector v = new Vector();
//        v.add("bbbbb");
//        v.add("aaaaa");
//        v.add("ccccc");
//        System.out.println("Default elements order");
//        test.dumpList(v);
//        Collections.sort(v);
//        System.out.println("Default sorting order");
//        test.dumpList(v);
//        System.out.println("Reverse sorting order with providing imlicit comparator");
//        Collections.sort(v,test.new MyComparator());
//        test.dumpList(v);
//    }
//    private void dumpList(List l) {
//        Iterator it = l.iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
//    }
//}
//----------------------------------------------
//--------------- Класс Properties------------------
//-----------------------------------------------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        Properties props = new Properties();
//        StringWriter sw = new StringWriter();
//        sw.write("Key1 = Value1 \n");
//        sw.write(" Key2 : Value2 \r\n");
//        sw.write(" Key3 Value3 \n ");
//        InputStream is = new ByteArrayInputStream(sw.toString().getBytes());
//
//        try {
//            props.load(is);
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        props.list(System.out);
//        props.setProperty("Key1","Modified Value1");
//        props.setProperty("Key4","Added Value4");
//        props.list(System.out);
//    }
//}
//----------------------------------------------
//--------------- Класс Arrays------------------
//-----------------------------------------------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        String[] arr = {"String 1","String 4",
//                "String 2","String 3"};
//        test.dumpArray(arr);
//        Arrays.sort(arr);
//        test.dumpArray(arr);
//        int ind = Arrays.binarySearch(arr,
//                "String 4");
//        System.out.println(
//                "\nIndex of \"String 4\" = " + ind);
//    }
//    void dumpArray(String arr[]){
//        System.out.println();
//        for(int cnt=0;cnt < arr.length;cnt++) {
//            System.out.println(arr[cnt]);
//        }
//    }
//}
//----------------------------------------------
//--------------- Класс StringTokenizer------------------
//----------------------------------------------
//public class Main {
//
//    public Main () {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        String toParse =
//                "word1;word2;word3;word4";
//        StringTokenizer st =
//                new StringTokenizer(toParse,";");
//        while(st.hasMoreTokens()){
//            System.out.println(st.nextToken());
//        }
//    }
//}
//----------------------------------------------
//--------------- Класс  BitSet------------------
//----------------------------------------------
//public class Main {
//
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        BitSet bs1 = new BitSet();
//        BitSet bs2 = new BitSet();
//        bs1.set(0);
//        bs1.set(2);
//        bs1.set(4);
//        System.out.println("Length = " +
//                bs1.length()+" size = "+bs1.size());
//        System.out.println(bs1);
//        bs2.set(1);
//        bs2.set(2);
//        bs1.and(bs2);
//        System.out.println(bs1);
//    }
//}
//----------------------------------------------
//--------------- Класс  Random------------------
//----------------------------------------------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        Random r = new Random(100);
//        // Generating the same sequence numbers
//        for(int cnt=0;cnt<9;cnt++){
//            System.out.print(r.nextInt() + " ");
//        }
//        System.out.println();
//        r = new Random(100);
//        for(int cnt=0;cnt<9;cnt++) {
//            System.out.print(r.nextInt() + " ");
//        }
//        System.out.println();
//        // Generating sequence of bytes
//        byte[] randArray = new byte[8];
//        r.nextBytes(randArray);
//        test.dumpArray(randArray);
//    }
//    void dumpArray(byte[] arr) {
//        for(int cnt=0;cnt< arr.length;cnt++) {
//            System.out.print(arr[cnt]);
//        }
//        System.out.println();
//    }
//}
//----------------------------------------------
//--------------- Локализация------------------
//----------------Класс Locale   ------------------
//----------------------------------------------
//public class Main {
//    public Main() {
//    }
//    public static void main(String[] args) {
//        Main test = new Main();
//        Locale l = Locale.getDefault();
//        System.out.println(l.getCountry() + " " +
//                l.getDisplayCountry() + " " + l.getISO3Country());
//        System.out.println(l.getLanguage() + " " +
//                l.getDisplayLanguage() + " " + l.getISO3Language());
//        System.out.println(l.getVariant() + " " + l.getDisplayVariant());
//        l = new Locale("ru","RU","WINDOWS");
//        System.out.println(l.getCountry() + " " +
//                l.getDisplayCountry() + " " + l.getISO3Country());
//        System.out.println(l.getLanguage() + " " +
//                l.getDisplayLanguage() + " " + l.getISO3Language());
//        System.out.println(l.getVariant() + " " + l.getDisplayVariant());
//    }
//}

//public class Main {
//
//    public int sideA;
//    public int sideB;
//
//    public Main(int x, int y) {
//        super();
//        sideA = x;
//        sideB = y;
//    }
//
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Main))
//            return false;
//        Main ref = (Main) obj;
//        return (((this.sideA == ref.sideA) && (this.sideB == ref.sideB)) ||
//                (this.sideA == ref.sideB) && (this.sideB == ref.sideA));
//    }
//
//    public static void main(String[] args) {
//        Main r1 = new Main(10, 20);
//        Main r2 = new Main(10, 10);
//        Main r3 = new Main(20, 10);
//        System.out.println("r1.equals(r1) == " + r1.equals(r1));
//        System.out.println("r1.equals(r2) == " + r1.equals(r2));
//        System.out.println("r1.equals(r3) == " + r1.equals(r3));
//        System.out.println("r2.equals(r3) == " + r2.equals(r3));
//        System.out.println("r1.equals(null) == " + r1.equals(null));
//    }
//}

//    private String title;
//    private String author;
//    private int pagesNumber;
//    public Main(String title, String author,
//                int pagesNumber) {
//        super();
//        this.title = title;
//        this.author = author;
//        this.pagesNumber = pagesNumber;
//    }
//    public static void main(String[] args) {
//        Main book = new Main("Java2","Sun",1000);
//        System.out.println("object is: " + book);
//    }
//    public String toString(){
//        return "Book: " + title + " ( " + author +
//                ", " + pagesNumber + " pages )";
//    }



//public static void main(String[] args) {
//    int i = 1;
//    byte b = 1;
//    String value = "1000";
//    Integer iObj = new Integer(i);
//    Byte bObj = new Byte(b);
//    System.out.println("while i==b is " +
//            (i==b));
//    System.out.println("iObj.equals(bObj) is "
//            + iObj.equals(bObj));
//    Long lObj = new Long(value);
//    System.out.println("lObj = " +
//            lObj.toString());
//    Long sum = new Long(lObj.longValue() +
//            iObj.byteValue() +
//            bObj.shortValue());
//    System.out.println("The sum = " +
//            sum.doubleValue());
//}

//    public Main() {
//    }
//        public static void main(String[] args) {
//            Main t = new Main();
//            String s1 = "Hello world !!!";
//            String s2 = "Hello world !!!";
//            System.out.println("String`s equally = " +
//                    (s1.equals(s2)));
//            System.out.println(
//                    "Strings are the same = " + (s1==s2));
//        }


//        public static void main(String[] args) {
//            Main t = new Main();
//            String s = "prefix !";
//            System.out.println(s);
//            s = s.trim();
//            System.out.println(s);
//            s = s.concat(" suffix");
//            System.out.println(s);
//        }

//    public static void main(String[] args) {
//        Main t = new Main();
//        String s = new String("ssssss");
//        StringBuffer sb =
//                new StringBuffer("bbbbbb");
//        s.concat("-aaa");
//        sb.append("-aaa");
//        System.out.println(s);
//        System.out.println(sb);
//    }


//    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer("abc");
//        String str = sb.append("e").insert(4,
//                "f").insert(3,"d").toString();
//        System.out.println(str);
//    }

//    public static void main(String[] args) {
//        Main t = new Main();
//        StringBuffer sb = new StringBuffer("aaa");
//        System.out.println("Before = " + sb);
//        t.doTest(sb);
//        System.out.println("After = " + sb);
//    }
//    void doTest(StringBuffer theSb){
//        theSb.append("-bbb");
//    }



//class MainObservable extends java.util.Observable {
//    private String name = "";
//    public MainObservable(String name) {
//        this.name = name;
//    }
//
//    public void modify() {
//        setChanged();
//    }
//
//    public String getName() {
//        return name;
//    }
//}
//
//    class TestObserver implements java.util.Observer {
//        private String name = "";
//
//        public TestObserver(String name) {
//            this.name = name;
//        }
//        public void update(java.util.Observable o,Object arg) {
//            String str = "Called update of " + name;
//            str += " from " + ((MainObservable)o).getName();
//            str += " with argument " + (String)arg;
//            System.out.println(str);
//        }
//    }
//    public class Main {
//        public Main() {
//        }
//        public static void main(String[] args) {
//            Main test = new Main();
//            MainObservable to = new MainObservable("Observable");
//            TestObserver o1 = new TestObserver("Observer 1");
//            TestObserver o2 = new TestObserver("Observer 2");
//            to.addObserver(o1);
//            to.addObserver(o2);
//            to.modify();
//            to.notifyObservers("Notify argument");
//        }
//    }


//}



//interface Vehicle {
//    void go();
//}
//class Automobile implements Vehicle {
//    public void go() {
//        System.out.println("Automobile go!");
//    }
//}
//class Truck implements Vehicle {
//    public Truck(int i) {
//        super();
//    }
//    public void go() {
//        System.out.println("Truck go!");
//    }
//}
//public class Main  {
//    public static void main(String[] args) {
//        Vehicle vehicle;
//        String[] vehicleNames = {"demo.lang.Automobile",
//                "demo.lang.Truck", "demo.lang.Tank"};
//        for(int i=0; i<vehicleNames.length; i++) {
//            try {
//                String name = vehicleNames[i];
//                System.out.println("look for class for: " + name);
//                Class aClass = Class.forName(name);
//                System.out.println("creating vehicle...");
//                vehicle = (Vehicle)aClass.newInstance();
//                System.out.println("create vehicle: " + vehicle.getClass());
//                vehicle.go();
//            } catch(ClassNotFoundException e) {
//                System.out.println("Exception: " + e);
//            } catch(InstantiationException e) {
//                System.out.println("Exception: " + e);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

