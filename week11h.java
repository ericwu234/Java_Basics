import java.util.*;
import java.util.Random;
import javax.lang.model.util.ElementScanner6;

public class week11h {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // new Scanner let player can create random map
        int x,y,m_n;
        // x=scanner.nextInt();
        // y=scanner.nextInt();
        // m_n=scanner.nextInt();
        Minemap new_game = new Minemap(8, 5, 5);
        
        int t=1;
        //t = new_game.touchEvent(2, 2);
        while(t!=3&&t!=0){
            System.out.println("found mine:(x,y)");
            x=scanner.nextInt();
            y=scanner.nextInt();
            t=new_game.touchEvent(x, y);
            if(t==3)
            {
            System.out.println("End!");
            break;
            }
            if(t==1)
            {
                continue;
            }
            if(t==4)
            {
                System.out.println("Space");
            }
            
        }
        new_game.display_map.render();
        new_game.showMapStatus();
    }
}

class Minemap {
    Draw map;
    Draw display_map;

    public Minemap(int size_x, int size_y, int mine_num) {
        map = new Draw(size_x, size_y);
        display_map = new Draw(size_x, size_y);
        display_map.filledAll('E');
        int i = 1, rx, ry;
        // random your mine on your map
        while (i <= mine_num) {

            Random ran_x = new Random();
            rx = ran_x.nextInt(size_x);
            Random ran_y = new Random();
            ry = ran_y.nextInt(size_y);
            if ((map.isAnchor(rx, ry))) {
                i--;
            } else {
                setBomb(rx, ry);
            }
            i++;
            // set Anchor with something you don't want to be modified
            map.addAnchor('m');
        }
    }

    private void setBomb(int x, int y) {
        if (map.setPoint(x, y, 'm'/* number you define for bomb */)) {
            map.sumAround(x, y, (char) 1);
        }
    }

    public int touchEvent(int x, int y) {
        if (display_map.isOutSide(x, y)){
            System.out.println("outside");
            return 1;}
        int status = map.getPoint(x, y);
        if (status > 0 && status <= 8) {
            /* do someing */
            display_map.setPoint(x, y, (char) status);
            display_map.render();
            return 2;
        } else if (status == 'm') {// mine
            /* do something */
            display_map.setPoint(x, y, '*');
            display_map.render();
            return 3;
        } else if (status == 0) {// space
            s_filledInBy(x, y,'0');
            // openMap(x,y,status,(char)status);
            display_map.render();
            return 4;
        }
        return 0;
    }

    private boolean openMap(int x, int y, char s) {
        /* Recursive like filledIn to show map */
        display_map.setPoint(x, y, (char)map.getPoint(x, y));
        if (map.getPoint(x, y) == 0){
            display_map.setPoint(x, y, s);
            return map.setPoint(x, y, s);
        }
        else
            return false;

    }

    private void s_filledInBy(int x, int y, char dest) {
        if (openMap(x, y, dest)) {
            s_filledInBy(x - 1, y - 1, dest);
            s_filledInBy(x, y - 1,dest);
            s_filledInBy(x + 1, y - 1,dest);
            s_filledInBy(x - 1, y, dest);
            s_filledInBy(x + 1, y, dest);
            s_filledInBy(x - 1, y + 1, dest);
            s_filledInBy(x, y + 1, dest);
            s_filledInBy(x + 1, y + 1,dest);
        }
    }

    public void showMapStatus() {
        map.renderInt();
    }
}

class Draw {
    private char[][] canvas = null;
    private int weight = -1;
    private int height = -1;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> Anchor = new ArrayList<Character>();

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
            System.out.println(
                    "1:filledAll 2:setPoint 3:setAround 4:drawSquare 5:sumAround 6:sumPoint 7:filledIn 8:addAnchor 9:removeAnchor-1:End");
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
            } else if (f == 8) {
                System.out.println("==addAnchor==");
                System.out.println("Enter char");
                ch = scanner.next().charAt(0);
                addAnchor(ch);
                renderInt();
            } else if (f == 9) {
                System.out.println("==removeAnchor==");
                System.out.println("Enter char");
                ch = scanner.next().charAt(0);
                removeAnchor(ch);
                renderInt();
            } else {
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
                setPoint(j, i, c);
            }
        }
    }

    public boolean setPoint(int x, int y, char c) {
        // check Whether `x` and `y` in canvas
        // outside return false
        // inside set c on canvas[y][x] and return true
        if (isOutSide(x, y) || isAnchor(x, y)) {
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
            return (int) canvas[y][x];
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
         */if (isOutSide(x, y) || isAnchor(x, y)) {
        } else {
            sum = (int) c + (int) canvas[y][x];
            setPoint(x, y, (char) sum);
        }

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

    public void addAnchor(char c) {
        Anchor.add(c);
    }

    public void removeAnchor(char c) {
        for (int i = 0; i < Anchor.size(); i++) {
            if (c == Anchor.get(i)) {
                Anchor.remove(i);
            }
        }
    }

    public boolean isAnchor(int x, int y) {
        for (int i = 0; i < Anchor.size(); i++) {
            if (canvas[y][x] == Anchor.get(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean switchTo(int x, int y, int src, char dest) {
        if (getPoint(x, y) == src)
            return setPoint(x, y, dest);
        else
            return false;
    }

    private void filledInBy(int x, int y, int src, char dest) {
        if (switchTo(x, y, src, dest)) {
            filledInBy(x - 1, y - 1, src, dest);
            filledInBy(x, y - 1, src, dest);
            filledInBy(x + 1, y - 1, src, dest);
            filledInBy(x - 1, y, src, dest);
            filledInBy(x + 1, y, src, dest);
            filledInBy(x - 1, y + 1, src, dest);
            filledInBy(x, y + 1, src, dest);
            filledInBy(x + 1, y + 1, src, dest);
        }
    }

    public void filledIn(int x, int y, char c) {
        if (isAnchor(x, y))
            return;
        filledInBy(x, y, getPoint(x, y), c);
    }

    public void render() {
        System.out.print(" ");
        for (int i = 0; i < weight; i++)
            System.out.printf(" %d", i);
        System.out.println();
        for (int y = 0; y < height; y++) {
            System.out.print(y);
            for (int x = 0; x < weight; x++) {
                System.out.printf(" %c", (getPoint(x, y)+48));
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