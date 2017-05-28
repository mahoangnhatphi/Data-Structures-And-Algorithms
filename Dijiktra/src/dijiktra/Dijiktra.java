/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijiktra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Phi
 */
public class Dijiktra {

    /**
     * @param args the command line arguments
     */
    private final String fileName = "input.txt";
    
    int size, begin, end;
    int g[][];
    
    void loadData(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            String arr[] = s.split(" ");
            size = Integer.parseInt(arr[0].trim());
            begin = Integer.parseInt(arr[1].trim());
            end = Integer.parseInt(arr[2].trim());
            g = new int[size][size];
            for (int i = 0; i < size; i++) {
                s = br.readLine();
                String arrStr[] = s.split(" ");
                for (int j = 0; j < arrStr.length; j++) {
                    g[i][j] = Integer.parseInt(arrStr[j].trim());
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void main() {
        loadData(fileName);
        int value = dijktra();
        System.out.printf("Minimum value to move from %d to %d is %d\n", begin, end, value);
    }
    
    int dijktra() {
        int pre[] = new int[size], len[] = new int[size];
        boolean isCheck[] = new boolean[size];
        for (int i = 0; i < size; i++) {
            pre[i] = -1;
            len[i] = Integer.MAX_VALUE;
            isCheck[i] = false;
        }
        
        int vBegin = begin - 1;
        int vEnd = end - 1;
        
        len[vBegin] = 0;
        
        while (!isCheck[vEnd]) {
            int i;
            for (i = 0; i < size; i++) {
                if (!isCheck[i] && len[i] < Integer.MAX_VALUE) break;
            }
            
            if (i >= size) {
                return -1;
            }
            
            for (int j = 0; j < size; j++) {
                if (!isCheck[j] && len[j] < len[i]) i = j;
            }
            
            isCheck[i] = true;
            
            for (int j = 0; j < size; j++) {
                if (!isCheck[j] && g[i][j] != 0 && len[i] + g[i][j] < len[j]) {
                    len[j] = len[i] + g[i][j];
                    pre[j] = i;
                }
            }
        }
        
        int i = vEnd;
        Stack<Integer> step = new Stack<>();
        do {
            step.add(i);
            i = pre[i];
        } while (i != -1);
        System.out.print("Step: ");
        for (int j = 0; j <= step.size(); j++) {
            System.out.print(step.pop() + "->");
        }
        System.out.println(step.pop());
        return len[vEnd];
    }

    public static void main(String[] args) {
        new Dijiktra().main();
    }

}
