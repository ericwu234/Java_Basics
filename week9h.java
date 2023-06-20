import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class week9h {
    /*
     * private static char[][] canvas = null; private static int weight = -1;
     * private static int height = -1;
     */
    public static void main(String[] args) {
        int f = 0, x = 0, y = 0, x_1, y_1, g = 1, an = 0;
        char ch;
        ArrayList<Draw> list = new ArrayList<Draw>();
        Scanner scanner = new Scanner(System.in);
        while (g != -1) {
            System.out.println("1:draw new 2:draw 3:draw another");
            g = scanner.nextInt();
            if (g == 1)// draw new
            {
                System.out.println("Enter x y to create canvas");
                x = scanner.nextInt();
                y = scanner.nextInt();
                Draw dr = new Draw(x, y);
                list.add(dr);
                System.out.println("Please draw");
                // System.out.println("1:filledAll 2:setPoint 3:setAround 4:drawSquare
                // 5:sumAround 6:sumPoint -1:End");
                list.get(an).chose();
                an++;
            } else if (g == 2) {// draw
                list.get(an - 1).chose();
            } else if (g == 3)// draw another
            {
                System.out.println("which canvas to draw");
                an = scanner.nextInt();
                System.out.println("Please draw");
                list.get(an).renderInt();
                // System.out.println("1:filledAll 2:setPoint 3:setAround 4:drawSquare
                // 5:sumAround 6:sumPoint -1:End");
                list.get(an).chose();

            } else {
                break;
            }
        }
    }
}

class Draw {
    private char[][] canvas = null;
    private int weight = -1;
    private int height = -1;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> Anchor=new ArrayList<Character>();

    public Draw(int w, int h) {
        weight = w;
        height = h;
        canvas = new char[height][weight];
    }

    /*
     * public static boolean createCanvas(int w, int h) { if (weight == -1 || height
     * == -1) { weight = w; height = h; canvas = new char[height][weight]; return
     * true; } return false; }
     */
    public void chose() {
        int f = 0, x = 0, y = 0, x_1, y_1;
        char ch;
        while (true) {
            System.out.println("1:filledAll 2:setPoint 3:setAround 4:drawSquare 5:sumAround 6:sumPoint 7:filledIn 8:addAnchor 9:removeAnchor-1:End");
            f = scanner.nextInt();
            if (f == 1) {
                System.out.println("==filledAll==");
                System.out.println("Enter char");
                ch = scanner.next().charAt(0);
                filledAll(ch);
                renderInt();
            } else if (f == 2) {
                System.out.println("==setPoint==");
                System.out.println("Enter x y char");
                x = scanner.nextInt();
                y = scanner.nextInt();
                ch = scanner.next().charAt(0);
                setPoint(x, y, ch);
                renderInt();
            } else if (f == 3) {
                System.out.println("==setAround==");
                System.out.println("Enter x y char");
                x = scanner.nextInt();
                y = scanner.nextInt();
                ch = scanner.next().charAt(0);
                setAround(x, y, ch);
                renderInt();
            } else if (f == 4) {
                System.out.println("==drawSquare==");
                System.out.println("Enter x1 y1 x2 y2 char");
                x = scanner.nextInt();
                y = scanner.nextInt();
                x_1 = scanner.nextInt();
                y_1 = scanner.nextInt();
                ch = scanner.next().charAt(0);
                drawSquare(x, y, x_1, y_1, ch);
                renderInt();
            } else if (f == 5) {
                System.out.println("==sumAround==");
                System.out.println("Enter x y char");
                x = scanner.nextInt();
                y = scanner.nextInt();
                ch = scanner.next().charAt(0);
                sumAround(x, y, ch);
                renderInt();
            } else if (f == 6) {
                System.out.println("==sumPoint==");
                System.out.println("Enter x y char");
                x = scanner.nextInt();
                y = scanner.nextInt();
                ch = scanner.next().charAt(0);
                sumPoint(x, y, ch);
                renderInt();
            } else if (f == 7) {
                System.out.println("==filledIn==");
                System.out.println("Enter x y char");
                x = scanner.nextInt();
                y = scanner.nextInt();
                ch = scanner.next().charAt(0);
                filledIn(x, y, ch);
                renderInt();
            } else if(f==8){
                System.out.println("==addAnchor==");
                System.out.println("Enter char");
                ch=scanner.next().charAt(0);
                addAnchor(ch);
                renderInt();
            } else if(f== 9){
                System.out.println("==removeAnchor==");
                System.out.println("Enter char");
                ch=scanner.next().charAt(0);
                removeAnchor(ch);
                renderInt();
            }
            else {
                break;
            }
            // Use Scanner to choose Function for work
            // input "-1" exit
        }
    }

    public void filledAll(char c) {
        // use for loop and `setPoint` function to complete
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                // canvas[i][j] = c;
                setPoint(i, j, c);
            }
        }
    }

    public boolean setPoint(int x, int y, char c) {
        // check Whether `x` and `y` in canvas
        // outside return false
        // inside set c on canvas[y][x] and return true
        if (isOutSide(x, y)||isAnchor(x, y)) {
            return false;
        } else {
            canvas[y][x] = c;
            return true;
        }
    }

    public int getPoint(int x, int y) {
        if (isOutSide(x, y))
            return -1;
        else {
            return canvas[y][x];
        }
    }

    public boolean isOutSide(int x, int y) {
        if (x < 0 || y < 0)
            return true;
        if (x >= weight || y >= height)
            return true;
        return false;
    }

    public void drawSquare(int x1, int y1, int x2, int y2, char c) {
        // use `setPoint()` to complete
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                setPoint(j, i, c);
            }
        }
    }

    public void setAround(int x, int y, char c) {
        // use `setPoint()` to complete
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i == y && j == x) {
                    continue;
                }
                setPoint(j, i, c);
            }
        }
    }

    public void sumPoint(int x, int y, char c) {
        int in1, in2, sum;
        /*
         * in1 = Character.getNumericValue(c); in2 =
         * Character.getNumericValue(canvas[y][x]); sum = in1 + in2;
         */
        sum = (int) c + (int) canvas[y][x];
        setPoint(x, y, (char) sum);
    }

    public void sumAround(int x, int y, char c) {
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i == y && j == x) {
                    continue;
                }
                sumPoint(j, i, c);
            }
        }
    }
    public void addAnchor(char c){
        Anchor.add(c);
    }
    public void removeAnchor(char c){
        for(int i=0;i<Anchor.size();i++)
        {
            if(c==Anchor.get(i))
            {
                Anchor.remove(i);
            }
        }
    }
    public boolean isAnchor(int x,int y){
        for(int i=0;i<Anchor.size();i++)
        {
            if(canvas[y][x]==Anchor.get(i))
            {
                return true;
            }
        }
        return false;
    }
    private boolean switchTo(int x,int y,int src,char dest){
        if(getPoint(x,y)==src) return setPoint(x,y,dest);
        else return false;
    }
    private void filledInBy(int x,int y,int src,char dest){
        if(switchTo(x,y,src,dest)){
            filledInBy(x-1,y-1,src,dest);
            filledInBy(x,y-1,src,dest);
            filledInBy(x+1,y-1,src,dest);
            filledInBy(x-1,y,src,dest);
            filledInBy(x+1,y,src,dest);
            filledInBy(x-1,y+1,src,dest);
            filledInBy(x,y+1,src,dest);
            filledInBy(x+1,y+1,src,dest);
        }
    }
    public void filledIn(int x,int y,char c){
        if(isAnchor(x,y)) return;
        filledInBy(x,y,getPoint(x,y),c);
    }

    public void render() {
        System.out.print(" ");
        for (int i = 0; i < weight; i++)
            System.out.printf(" %d", i);
        System.out.println();
        for (int y = 0; y < height; y++) {
            System.out.print(y);
            for (int x = 0; x < weight; x++) {
                System.out.printf(" %c", getPoint(x, y));
            }
            System.out.println();
        }
        System.out.println();
    }

    public void renderInt() {
        System.out.print(" ");
        for (int i = 0; i < weight; i++)
            System.out.printf(" %3d", i);
        System.out.println();
        for (int y = 0; y < height; y++) {
            System.out.print(y);
            for (int x = 0; x < weight; x++) {
                System.out.printf(" %3d", getPoint(x, y));
            }
            System.out.println();
        }
        System.out.println();
    }
}

/*
 * class Canvas{ public static Canvas(){ } }
 */