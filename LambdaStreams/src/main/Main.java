package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader arq = new BufferedReader(new FileReader("C:\\Users\\guilh\\atividades_Java" +
                    "\\LambdaStreams\\externalFiles\\dadosEmployees.csv"));
            System.out.println(arq.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
