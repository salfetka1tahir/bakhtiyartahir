import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== РЕКУРСИЯ: 40 ЗАДАНИЙ =====");
            String[] names = {
                "1. Числа от 1 до N", "2. Числа от N до 1", "3. Сумма от 1 до N",
                "4. Факториал", "5. Возведение в степень", "6. Сумма цифр",
                "7. Количество цифр", "8. Произведение цифр", "9. Максимальная цифра",
                "10. Минимальная цифра", "11. Число Фибоначчи", "12. Сумма массива",
                "13. Максимум массива", "14. Минимум массива", "15. Количество чётных в массиве",
                "16. Проверка возрастания массива", "17. НОД", "18. НОК",
                "19. Число в двоичную систему", "20. Сумма квадратов от 1 до N",
                "21. Переворот строки", "22. Проверка палиндрома", "23. Подсчёт символа",
                "24. Подсчёт гласных", "25. Удаление символа", "26. Замена символов",
                "27. Все символы одинаковые?", "28. Подсчёт слов", "29. Проверка анаграммы",
                "30. Сравнение строк", "31. Быстрое возведение в степень", "32. Бинарный поиск",
                "33. Сортировка слиянием", "34. Быстрая сортировка", "35. Ханойская башня",
                "36. Все подмножества массива", "37. Уникальные перестановки строки",
                "38. Поиск пути в лабиринте", "39. Задача о N ферзях",
                "40. Генератор выражений (+, -, *)", "0. Выход"
            };
            for (String name : names) System.out.println(name);
            System.out.print("Выбери задание: ");
            int task = readInt();

            try {
                switch (task) {
                    case 0: System.out.println("Выход."); return;
                    case 1: { int n = askInt("N: "); printUp(1, n); System.out.println(); break; }
                    case 2: { int n = askInt("N: "); printDown(n); System.out.println(); break; }
                    case 3: { int n = askInt("N: "); System.out.println("Сумма = " + sumN(n)); break; }
                    case 4: { int n = askInt("N (0..20): "); if(n<0||n>20) throw new IllegalArgumentException("N должен быть от 0 до 20."); System.out.println("Факториал = " + fact(n)); break; }
                    case 5: { int a=askInt("Основание a: "), n=askInt("Степень n (0..30): "); if(n<0||n>30) throw new IllegalArgumentException("Степень должна быть от 0 до 30."); System.out.println("Результат = " + power(a,n)); break; }
                    case 6: { long n=askLong("Натуральное число: "); System.out.println("Сумма цифр = " + digitSum(n)); break; }
                    case 7: { long n=askLong("Неотрицательное число: "); System.out.println("Количество цифр = " + digitCount(n)); break; }
                    case 8: { long n=askLong("Неотрицательное число: "); System.out.println("Произведение цифр = " + digitProduct(n)); break; }
                    case 9: { long n=askLong("Натуральное число: "); System.out.println("Максимальная цифра = " + maxDigit(n)); break; }
                    case 10:{ long n=askLong("Натуральное число: "); System.out.println("Минимальная цифра = " + minDigit(n)); break; }
                    case 11:{ int n=askInt("N (0..45, где F(0)=0): "); if(n<0||n>45) throw new IllegalArgumentException("N должен быть от 0 до 45."); System.out.println("F(" + n + ") = " + fib(n)); break; }
                    case 12: { int[] a=readArray(); System.out.println("Сумма = " + arraySum(a,0)); break; }
                    case 13: { int[] a=readNonEmptyArray(); System.out.println("Максимум = " + maxArray(a,0)); break; }
                    case 14: { int[] a=readNonEmptyArray(); System.out.println("Минимум = " + minArray(a,0)); break; }
                    case 15: { int[] a=readArray(); System.out.println("Чётных элементов = " + evenCount(a,0)); break; }
                    case 16: { int[] a=readArray(); System.out.println(isIncreasing(a,0) ? "Массив отсортирован по возрастанию." : "Массив не отсортирован по возрастанию."); break; }
                    case 17: { int a=askInt("Первое число: "), b=askInt("Второе число: "); System.out.println("НОД = " + gcd(a,b)); break; }
                    case 18: { long a=askLong("Первое положительное число: "), b=askLong("Второе положительное число: "); if(a<=0||b<=0) throw new IllegalArgumentException("Числа должны быть положительными."); System.out.println("НОК = " + (a/gcdLong(a,b))*b); break; }
                    case 19: { long n=askLong("Положительное десятичное число: "); if(n<=0) throw new IllegalArgumentException("Число должно быть положительным."); System.out.println("Двоичная запись = " + toBinary(n)); break; }
                    case 20:{ int n=askInt("N: "); System.out.println("Сумма квадратов = " + sumSquares(n)); break; }
                    case 21:{ String s=askLine("Строка: "); System.out.println("Перевёрнутая строка = " + reverse(s)); break; }
                    case 22:{ String s=askLine("Строка: "); System.out.println(isPalindrome(s) ? "Это палиндром." : "Это не палиндром."); break; }
                    case 23:{ String s=askLine("Строка: "); String c=askLine("Символ: "); if(c.isEmpty()) throw new IllegalArgumentException("Символ не должен быть пустым."); System.out.println("Количество = " + countChar(s,c.charAt(0),0)); break; }
                    case 24:{ String s=askLine("Строка: "); System.out.println("Количество гласных = " + countVowels(s,0)); break; }
                    case 25:{ String s=askLine("Строка: "), c=askLine("Какой символ удалить: "); if(c.isEmpty()) throw new IllegalArgumentException("Символ не должен быть пустым."); System.out.println("Результат = " + removeChar(s,c.charAt(0))); break; }
                    case 26:{ String s=askLine("Строка: "), a=askLine("Какой символ заменить: "), b=askLine("На какой символ: "); if(a.isEmpty()||b.isEmpty()) throw new IllegalArgumentException("Введите оба символа."); System.out.println("Результат = " + replaceChar(s,a.charAt(0),b.charAt(0))); break; }
                    case 27:{ String s=askLine("Строка: "); System.out.println(allSame(s,0) ? "Да, все символы одинаковые." : "Нет."); break; }
                    case 28:{ String s=askLine("Строка: "); System.out.println("Количество слов = " + wordCount(s,0,false)); break; }
                    case 29:{ String a=askLine("Первая строка: "), b=askLine("Вторая строка: "); System.out.println(isAnagram(a,b) ? "Это анаграммы." : "Это не анаграммы."); break; }
                    case 30:{ String a=askLine("Первая строка: "), b=askLine("Вторая строка: "); int cmp=compareStrings(a,b,0); System.out.println(cmp==0 ? "Строки одинаковые." : cmp<0 ? "Первая строка меньше второй." : "Первая строка больше второй."); break; }
                    case 31:{ long a=askLong("Основание a: "); int n=askInt("Степень n (0..62): "); if(n<0||n>62) throw new IllegalArgumentException("Степень должна быть от 0 до 62."); System.out.println("Результат = " + fastPower(a,n)); break; }
                    case 32:{ int[] a=readArray(); Arrays.sort(a); System.out.println("Массив для поиска: " + Arrays.toString(a)); int x=askInt("Искомое число: "); System.out.println("Индекс = " + binarySearch(a,x,0,a.length-1)); break; }
                    case 33:{ int[] a=readArray(); mergeSort(a,0,a.length-1); System.out.println(Arrays.toString(a)); break; }
                    case 34:{ int[] a=readArray(); quickSort(a,0,a.length-1); System.out.println(Arrays.toString(a)); break; }
                    case 35:{ int n=askInt("Количество дисков (1..15): "); if(n<1||n>15) throw new IllegalArgumentException("Введите число от 1 до 15."); hanoi(n,"A","B","C"); break; }
                    case 36:{ int[] a=readArray(); subsets(a,0,new ArrayList<Integer>()); break; }
                    case 37:{ String s=askLine("Строка: "); Set<String> out=new TreeSet<>(); permutations(s.toCharArray(),0,out); for(String v:out) System.out.println(v); System.out.println("Всего: " + out.size()); break; }
                    case 38:{ runMaze(); break; }
                    case 39:{ int n=askInt("Размер доски N (1..12): "); if(n<1||n>12) throw new IllegalArgumentException("Введите число от 1 до 12."); solveQueens(n); break; }
                    case 40:{ String digits=askLine("Строка цифр (например, 123): "); long target=askLong("Целевое число: "); if(!digits.matches("\\d+")||digits.length()>10) throw new IllegalArgumentException("Введите только цифры, длина не более 10."); int[] count={0}; expressions(digits,target,0,0,0,"",count); System.out.println("Всего выражений: " + count[0]); break; }
                    default: System.out.println("Нет такого задания. Выбери от 0 до 40.");
                }
            } catch (StackOverflowError e) {
                System.out.println("Слишком большой ввод для рекурсии. Попробуй меньшее число или строку.");
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    static int readInt(){ while(!sc.hasNextInt()){System.out.print("Введи целое число: "); sc.next();} int x=sc.nextInt(); sc.nextLine(); return x; }
    static long readLong(){ while(!sc.hasNextLong()){System.out.print("Введи целое число: "); sc.next();} long x=sc.nextLong(); sc.nextLine(); return x; }
    static int askInt(String p){System.out.print(p); return readInt();}
    static long askLong(String p){System.out.print(p); return readLong();}
    static String askLine(String p){System.out.print(p); return sc.nextLine();}
    static int[] readArray(){int n=askInt("Количество элементов массива: "); if(n<0||n>10000) throw new IllegalArgumentException("Размер массива должен быть от 0 до 10000."); int[] a=new int[n]; for(int i=0;i<n;i++) a[i]=askInt("a["+i+"] = "); return a;}
    static int[] readNonEmptyArray(){int[] a=readArray(); if(a.length==0) throw new IllegalArgumentException("Массив не должен быть пустым."); return a;}

    static void printUp(int i,int n){if(i>n)return; System.out.print(i+" "); printUp(i+1,n);}
    static void printDown(int n){if(n<1)return; System.out.print(n+" "); printDown(n-1);}
    static long sumN(int n){if(n<=0)return 0; return n+sumN(n-1);}
    static long fact(int n){if(n<=1)return 1; return n*fact(n-1);}
    static long power(long a,int n){if(n==0)return 1; return a*power(a,n-1);}
    static long digitSum(long n){n=Math.abs(n); if(n<10)return n; return n%10+digitSum(n/10);}
    static int digitCount(long n){n=Math.abs(n); if(n<10)return 1; return 1+digitCount(n/10);}
    static long digitProduct(long n){n=Math.abs(n); if(n<10)return n; return n%10*digitProduct(n/10);}
    static int maxDigit(long n){n=Math.abs(n); if(n<10)return (int)n; return Math.max((int)(n%10),maxDigit(n/10));}
    static int minDigit(long n){n=Math.abs(n); if(n<10)return (int)n; return Math.min((int)(n%10),minDigit(n/10));}
    static long fib(int n){if(n<=1)return n; return fib(n-1)+fib(n-2);}
    static long arraySum(int[] a,int i){if(i==a.length)return 0; return a[i]+arraySum(a,i+1);}
    static int maxArray(int[] a,int i){if(i==a.length-1)return a[i]; return Math.max(a[i],maxArray(a,i+1));}
    static int minArray(int[] a,int i){if(i==a.length-1)return a[i]; return Math.min(a[i],minArray(a,i+1));}
    static int evenCount(int[] a,int i){if(i==a.length)return 0; return (a[i]%2==0?1:0)+evenCount(a,i+1);}
    static boolean isIncreasing(int[] a,int i){if(i>=a.length-1)return true; return a[i]<=a[i+1]&&isIncreasing(a,i+1);}
    static int gcd(int a,int b){return (int)gcdLong(a,b);}
    static long gcdLong(long a,long b){a=Math.abs(a);b=Math.abs(b); if(b==0)return a; return gcdLong(b,a%b);}
    static String toBinary(long n){if(n<2)return Long.toString(n); return toBinary(n/2)+(n%2);}
    static long sumSquares(int n){if(n<=0)return 0; return (long)n*n+sumSquares(n-1);}
    static String reverse(String s){if(s.length()<=1)return s; return reverse(s.substring(1))+s.charAt(0);}
    static boolean isPalindrome(String s){return palindrome(s.toLowerCase(Locale.ROOT),0,s.length()-1);}
    static boolean palindrome(String s,int l,int r){if(l>=r)return true; return s.charAt(l)==s.charAt(r)&&palindrome(s,l+1,r-1);}
    static int countChar(String s,char c,int i){if(i==s.length())return 0; return (s.charAt(i)==c?1:0)+countChar(s,c,i+1);}
    static boolean vowel(char c){return "аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouAEIOU".indexOf(c)>=0;}
    static int countVowels(String s,int i){if(i==s.length())return 0; return (vowel(s.charAt(i))?1:0)+countVowels(s,i+1);}
    static String removeChar(String s,char c){if(s.isEmpty())return ""; return (s.charAt(0)==c?"":s.substring(0,1))+removeChar(s.substring(1),c);}
    static String replaceChar(String s,char a,char b){if(s.isEmpty())return ""; return (s.charAt(0)==a?b:s.charAt(0))+replaceChar(s.substring(1),a,b);}
    static boolean allSame(String s,int i){if(s.length()<=1||i>=s.length()-1)return true; return s.charAt(i)==s.charAt(i+1)&&allSame(s,i+1);}
    static int wordCount(String s,int i,boolean inWord){if(i==s.length())return inWord?1:0; char c=s.charAt(i); if(c==' ')return (inWord?1:0)+wordCount(s,i+1,false); return wordCount(s,i+1,true);}
    static boolean isAnagram(String a,String b){a=a.toLowerCase(Locale.ROOT).replace(" ",""); b=b.toLowerCase(Locale.ROOT).replace(" ",""); if(a.length()!=b.length())return false; int[] f=new int[65536]; freq(a,0,f,1); freq(b,0,f,-1); return freqCheck(f,0);}
    static void freq(String s,int i,int[] f,int d){if(i==s.length())return; f[s.charAt(i)]+=d; freq(s,i+1,f,d);}
    static boolean freqCheck(int[] f,int i){if(i==f.length)return true; return f[i]==0&&freqCheck(f,i+1);}
    static int compareStrings(String a,String b,int i){if(i==a.length()&&i==b.length())return 0; if(i==a.length())return -1; if(i==b.length())return 1; if(a.charAt(i)!=b.charAt(i))return a.charAt(i)<b.charAt(i)?-1:1; return compareStrings(a,b,i+1);}
    static long fastPower(long a,int n){if(n==0)return 1; long half=fastPower(a,n/2); long r=half*half; return n%2==0?r:r*a;}
    static int binarySearch(int[] a,int x,int l,int r){if(l>r)return -1; int m=l+(r-l)/2; if(a[m]==x)return m; return x<a[m]?binarySearch(a,x,l,m-1):binarySearch(a,x,m+1,r);}
    static void mergeSort(int[] a,int l,int r){if(l>=r)return; int m=(l+r)/2; mergeSort(a,l,m); mergeSort(a,m+1,r); merge(a,l,m,r);}
    static void merge(int[] a,int l,int m,int r){int[] t=new int[r-l+1]; int i=l,j=m+1,k=0; while(i<=m&&j<=r)t[k++]=a[i]<=a[j]?a[i++]:a[j++]; while(i<=m)t[k++]=a[i++]; while(j<=r)t[k++]=a[j++]; System.arraycopy(t,0,a,l,t.length);}
    static void quickSort(int[] a,int l,int r){if(l>=r)return; int i=l,j=r,p=a[l+(r-l)/2]; while(i<=j){while(a[i]<p)i++; while(a[j]>p)j--; if(i<=j){int t=a[i];a[i]=a[j];a[j]=t;i++;j--;}} if(l<j)quickSort(a,l,j); if(i<r)quickSort(a,i,r);}
    static void hanoi(int n,String from,String aux,String to){if(n==0)return; hanoi(n-1,from,to,aux); System.out.println(from+" -> "+to); hanoi(n-1,aux,from,to);}
    static void subsets(int[] a,int i,List<Integer> cur){if(i==a.length){System.out.println(cur);return;} subsets(a,i+1,cur); cur.add(a[i]); subsets(a,i+1,cur); cur.remove(cur.size()-1);}
    static void permutations(char[] a,int pos,Set<String> out){if(pos==a.length){out.add(new String(a));return;} for(int i=pos;i<a.length;i++){swap(a,pos,i);permutations(a,pos+1,out);swap(a,pos,i);}}
    static void swap(char[] a,int i,int j){char t=a[i];a[i]=a[j];a[j]=t;}

    static void runMaze(){
        int rows=askInt("Количество строк: "), cols=askInt("Количество столбцов: ");
        if(rows<1||cols<1||rows>30||cols>30)throw new IllegalArgumentException("Размеры должны быть от 1 до 30.");
        int[][] maze=new int[rows][cols];
        System.out.println("Вводи строки лабиринта: 0 — проход, 1 — стена.");
        for(int r=0;r<rows;r++)for(int c=0;c<cols;c++)maze[r][c]=askInt("Клетка ["+r+"]["+c+"]: ");
        int sr=askInt("Стартовая строка (с 0): "), sc0=askInt("Стартовый столбец (с 0): ");
        int er=askInt("Конечная строка (с 0): "), ec=askInt("Конечный столбец (с 0): ");
        if(!inside(maze,sr,sc0)||!inside(maze,er,ec)||maze[sr][sc0]!=0||maze[er][ec]!=0)throw new IllegalArgumentException("Координаты должны указывать на свободные клетки внутри лабиринта.");
        boolean[][] seen=new boolean[rows][cols]; List<String> path=new ArrayList<>();
        if(mazePath(maze,sr,sc0,er,ec,seen,path)){System.out.println("Путь (строка, столбец): "+path);}else System.out.println("Путь не найден.");
    }
    static boolean inside(int[][] m,int r,int c){return r>=0&&r<m.length&&c>=0&&c<m[0].length;}
    static boolean mazePath(int[][] m,int r,int c,int er,int ec,boolean[][] seen,List<String> path){
        if(!inside(m,r,c)||m[r][c]==1||seen[r][c])return false;
        seen[r][c]=true; path.add("("+r+","+c+")");
        if(r==er&&c==ec)return true;
        if(mazePath(m,r+1,c,er,ec,seen,path)||mazePath(m,r,c+1,er,ec,seen,path)||mazePath(m,r-1,c,er,ec,seen,path)||mazePath(m,r,c-1,er,ec,seen,path))return true;
        path.remove(path.size()-1); return false;
    }
    static void solveQueens(int n){int[] pos=new int[n]; int[] count={0}; queens(0,n,pos,count); System.out.println("Всего решений: "+count[0]);}
    static void queens(int row,int n,int[] pos,int[] count){if(row==n){count[0]++;System.out.println("Решение "+count[0]+":");for(int r=0;r<n;r++){for(int c=0;c<n;c++)System.out.print(pos[r]==c?"Q ":". ");System.out.println();}System.out.println();return;} for(int c=0;c<n;c++){if(safeQueen(row,c,pos)){pos[row]=c;queens(row+1,n,pos,count);}}}
    static boolean safeQueen(int row,int col,int[] pos){if(row==0)return true; for(int r=0;r<row;r++)if(pos[r]==col||Math.abs(pos[r]-col)==Math.abs(r-row))return false; return true;}
    static void expressions(String s,long target,int pos,long value,long last,String expr,int[] count){
        if(pos==s.length()){if(value==target){System.out.println(expr+" = "+target);count[0]++;}return;}
        for(int end=pos;end<s.length();end++){
            if(end>pos&&s.charAt(pos)=='0')break;
            String part=s.substring(pos,end+1); long num;
            try{num=Long.parseLong(part);}catch(NumberFormatException e){continue;}
            if(pos==0)expressions(s,target,end+1,num,num,part,count);
            else{
                expressions(s,target,end+1,value+num,num,expr+"+"+part,count);
                expressions(s,target,end+1,value-num,-num,expr+"-"+part,count);
                long multiplied=last*num;
                expressions(s,target,end+1,value-last+multiplied,multiplied,expr+"*"+part,count);
            }
        }
    }
}
