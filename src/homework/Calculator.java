package homework;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws ScriptException {
        Scanner scan = new Scanner(System.in);
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String str = scan.nextLine();
        System.out.println(engine.eval(str));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            File file = new File("calc.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(engine.eval(str));
            writer.println(dtf.format(now));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}