import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.PriorityQueue;

public class Task
{
    // Фунция заполнения Класса
     public static ClassOfStore GenerateHashSet(int numId)
    {
    System.out.println("Введите вес выпадения: ");
    Scanner scanner = new Scanner(System.in);
    int numWeight = scanner.nextInt();
    
    System.out.println("Введите название игрушки: ");
    Scanner scanner1 = new Scanner(System.in);
    String nameToy = scanner1.nextLine();
    
    ClassOfStore toyFromStore = new ClassOfStore (numId, numWeight, nameToy);
    System.out.println(toyFromStore.getNum());
    return toyFromStore;
    }
    
    // Меню
    public static void print_menu() {
        
        System.out.println("Меню: \n1 - Новая игрушка;\n2 - Перечень всех игрушек;");
        System.out.println("3 - Провести розыгрыш; \n4 - Выход.");
    }
    
    public static void print_all_toys(LinkedList ObjSet1) {
        
        for (Object str1 : ObjSet1) {
            System.out.println(str1.toString());
        }
    }
    
    // функция генерации Link
    public static LinkedList generatorOfLink(String Toy)
    {
        LinkedList<String> toLinkToyStore = new LinkedList<>();
        toLinkToyStore.add(generatorOfElem(Toy, "id"));
        toLinkToyStore.add(generatorOfElem(Toy, "weight"));
        toLinkToyStore.add(generatorOfElem(Toy, "Name"));
        return toLinkToyStore;
    }
    
    // функция поиска элемента в строке через определение индексов
    public static String generatorOfElem(String Toy, String Elem)
    {
        int firstIndex = FindFirstIndexOf(Toy, Elem);
        int finalIndex = firstIndex + Elem.length()+2;
        String elem = FindLastIndexOf(Toy, finalIndex);
        return elem.trim();
    }
    
    // поиск первого индекса подстроки в строке
    public static int FindFirstIndexOf(String BigStr, String SmallStr) {
        int index = BigStr.lastIndexOf(SmallStr);
        return index;
    }
    
    // функция поиска значения параметра через индексы строки
    public static String FindLastIndexOf(String BigStr, int StartIndex) {
        String word = "";
        for (int i = StartIndex + 1; i < BigStr.length(); i++) {

            char char1 = BigStr.charAt(i);
            if ((char1 != ',') & (char1 != '.')) {
                word += char1;
            } else {
                break;
            }
        }
        return word;
    }
    
    //////////////////////
    // функция розыгрыша приза (будет осуществляться через массив)
    public static void make_calkulation(LinkedList ObjSet1)
    {
        LinkedList<String> toLinkToy = new LinkedList<>();
        int lengthWeight = 0;
        for (Object str1 : ObjSet1) {
            toLinkToy = generatorOfLink(str1.toString()); // запускается алгоритм перевода строки в LinkedLink
            lengthWeight += Integer.parseInt(toLinkToy.get(1));
        }
        String[] arrRoulette = new String[lengthWeight]; // массив-рулекта
        arrRoulette = arrFill(ObjSet1, arrRoulette); // заполняю массиву-рулетку названиями игрушек
        String elem = arrRandomElem(arrRoulette);
        System.out.println("Игрушка победитель: " + elem);
        
    }
    
    //функция заполнения массива названиями игрушек
    public static String[] arrFill(LinkedList ObjSet1, String[]arrRoulette)
    {
        int count = 0;
        LinkedList<String> toLinkToy = new LinkedList<>();
        for (Object str1 : ObjSet1){
            toLinkToy = generatorOfLink(str1.toString());
            for (int i = 0; i < Integer.parseInt(toLinkToy.get(1)); i++){
                arrRoulette[count] = toLinkToy.get(2);
                count++;
            }
        }
        return arrRoulette;
    }
    
    // функция извлечение случайного элемента из массива-рулетки
    public static String arrRandomElem(String[]arrRoulette)
    {
        Random random = new Random();
        int randomIndex = random.nextInt(arrRoulette.length);
        return arrRoulette[randomIndex];
    }
    
    
    public static void work_with_PriorityQueue(LinkedList ObjSet1)
    {
        
    }
 
 
    public static void main (String[]args)
    {

    LinkedList <ClassOfStore> ObjSet1 = new LinkedList <> ();
    Scanner scanner = new Scanner(System.in);
    print_menu();
    int count = 1;
     int num = 0;
        while (true) {
            
            System.out.print("Введите число: ");
            num = scanner.nextInt();
            if (num == 5){break;}
            switch (num) {
                case 1:
                    ObjSet1.add(GenerateHashSet(count++));
                    continue;
                case 2:
                    print_all_toys(ObjSet1);
                    continue;
                case 3:
                    make_calkulation(ObjSet1);
                    continue;
                case 4:
                    work_with_PriorityQueue(ObjSet1);
                    continue;
                
            }
    
    } 
}
}
