import java.util.*;
import java.util.Random;
import javax.lang.model.util.ElementScanner6;


public class week13h {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // new Scanner let player can create random map
        int x, y, m_n, f, mo = 0, e = 1;
        // x=scanner.nextInt();
        // y=scanner.nextInt();
        // m_n=scanner.nextInt();
        // Minemap new_game = new Minemap(8, 5, 5);

        int t = 1;
        // t = new_game.touchEvent(2, 2);
        while (e != 0) {
            System.out.println("\t<<< Welcome to Landmine >>>");
            System.out.println("Please chose mode:");
            System.out.println("1.Easy   :(map: 8* 8,mine:10)");
            System.out.println("2.Medium :(map:16*16,mine:40)");
            System.out.println("3.Hard   :(map:30*16,mine:99)");
            System.out.println("4.Custom :(define by yourself)");
            System.out.println("0.Leave the game");
            System.out.print(">> ");
            mo = scanner.nextInt();
            if (mo == 1) {
                mine(8, 8, 10);
            } else if (mo == 2) {
                mine(16, 16, 40);
            } else if (mo == 3) {
                mine(30, 16, 99);
            } else if (mo == 4) {
                System.out.println("Please Enter map size,(x y)");
                System.out.print(">> ");
                x = scanner.nextInt();
                y = scanner.nextInt();
                System.out.println("Please Enter mines number:");
                System.out.print(">> ");
                m_n = scanner.nextInt();
                mine(x, y, m_n);
            } else {
                System.out.print("Bye");
                break;
            }
            System.out.println("Enter any to continue.....(without 0)");

            e = scanner.nextInt();
        }
        /*
         * while (t != 3 && t != 0) { System.out.println("(1)found mine(2)set flag"); f
         * = scanner.nextInt(); if (f == 1) { System.out.println("found mine:(x,y)"); x
         * = scanner.nextInt(); y = scanner.nextInt(); t = new_game.touchEvent(x, y); if
         * (t == 3) { System.out.println("End!"); break; } if (t == 1) { continue; } if
         * (t == 4) { System.out.println("Space"); } if (t == 5) {
         * System.out.println("Win!"); } } else { System.out.println("set flag(x,y)"); x
         * = scanner.nextInt(); y = scanner.nextInt(); new_game.setFlag(x, y);
         * new_game.display_map.render(); }
         * 
         * }
         */
        // new_game.display_map.render();
        // new_game.showMapStatus();
    }

    public static void mine(int x, int y, int m_n) {
        Minemap new_game = new Minemap(x, y, m_n);
        Scanner scanner = new Scanner(System.in);
        int t = 1, f, r = 1;
        while (t != 3 && t != 0) {
            System.out.println("round " + r);
            r++;
            new_game.display_map.render();
            System.out.println("#Enter 0 to End!");
            System.out.println("chose operate:(1)found mine(2)set flag");
            System.out.print(">> ");
            f = scanner.nextInt();
            if(f==0)
            {
                System.out.println("End and Bye!");
                break;
            }
            System.out.println("chose coordinate:(x y)");
            System.out.print(">> ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (f == 1) {
                // System.out.println("found mine:(x,y)");
                // x = scanner.nextInt();
                // y = scanner.nextInt();
                t = new_game.touchEvent(x, y);
                if (t == 3) {
                    System.out.println("Lose!");
                    System.out.println("round "+r);
                    new_game.map.render();
                    break;
                }
                if (t == 1) {
                    continue;
                }
                if (t == 4) {
                    System.out.println("Space");
                }
                if (t == 5) {
                    System.out.println("Win!");
                }
            } else if (f == 2) {
                // System.out.println("set flag(x,y)");
                // x = scanner.nextInt();
                // y = scanner.nextInt();
                new_game.setFlag(x, y);
                //new_game.display_map.render();
            } else {
                System.out.println("End and Bye!");
                break;
            }
            if (new_game.checkToWin2()) {
                System.out.println("round "+r);
                System.out.println("Win!!");
                new_game.display_map.render();
                break;
            }
            //System.out.println(new_game.space_num+" "+new_game.mine_num+" "+new_game.flag_num);


        }

    }
}

class Minemap {
    Draw map;
    Draw display_map;
    int mine_num;
    int flag_num=0;
    int space_num;

    public Minemap(int size_x, int size_y, int mine_num) {
        this.mine_num = mine_num;
        this.space_num = size_x * size_y;
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
        if (checkToWin()) {
            return 5;
        }
        if (display_map.isOutSide(x, y)) {
            System.out.println("outside");
            return 1;
        }
        int status = map.getPoint(x, y);
        if (status > 0 && status <= 8) {
            /* do someing */
            this.space_num--;
            display_map.setPoint(x, y, (char) status);
            //display_map.render();
            return 2;
        } else if (status == 'm') {// mine
            /* do something */
            display_map.setPoint(x, y, '*');// 'Z'
            //display_map.render();
            return 3;
        } else if (status == 0) {// space
            s_filledInBy(x, y, '0');// '`'
            // openMap(x,y,status,(char)status);
            //display_map.render();
            return 4;
        }
        return 0;
    }

    public boolean checkToWin() {
        if ((this.flag_num == this.mine_num) && (this.space_num == 0)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean checkToWin2(){
        int s=0,f=0,e=0;
        for (int i = 0; i < display_map.canvas.length; i++) {
            for (int j = 0; j < display_map.canvas[0].length; j++) {
                // canvas[i][j] = c;
                if(display_map.canvas[i][j]=='F'){
                f++;
                }
                else if(display_map.canvas[i][j]=='E'){
                    e++;
                }
                
            }
        }
        if(e==0&& f==this.mine_num)
        return true;
        else
        return false;
    }

    public void setFlag(int x, int y) {
        if (((char) display_map.getPoint(x, y)) == 'F') {
            display_map.removeAnchor('F');
            display_map.setPoint(x, y, 'E');
            display_map.addAnchor('F');
            this.flag_num--;
        } else if (display_map.setPoint(x, y, 'F')) {
            this.flag_num++;
            display_map.addAnchor('F');
        }
    }

    private boolean openMap(int x, int y, char s) {
        /* Recursive like filledIn to show map */
        display_map.setPoint(x, y, (char) map.getPoint(x, y));
        //this.space_num--;
        if (map.getPoint(x, y) == 0) {
            this.space_num--;
            display_map.setPoint(x, y, s);
            return map.setPoint(x, y, s);
        } else
        {
            return false;
        }

    }

    private void s_filledInBy(int x, int y, char dest) {
        if (openMap(x, y, dest)) {
            s_filledInBy(x - 1, y - 1, dest);
            s_filledInBy(x, y - 1, dest);
            s_filledInBy(x + 1, y - 1, dest);
            s_filledInBy(x - 1, y, dest);
            s_filledInBy(x + 1, y, dest);
            s_filledInBy(x - 1, y + 1, dest);
            s_filledInBy(x, y + 1, dest);
            s_filledInBy(x + 1, y + 1, dest);
        }
    }

    public void showMapStatus() {
        map.renderInt();
    }
}

class Draw {
    public char[][] canvas = null;
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
                System.out.printf(" %c", (getPoint(x, y) + 48));
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