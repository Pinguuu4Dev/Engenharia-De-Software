package Componentes_Principais.Proxy;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Proxy {

    public void setBoundsToLog(){
        try {
            FileWriter writer = new FileWriter("D:\\Faculdade\\6o-Período\\Engenharia-De-Software" +
                    "\\Proxy\\resources\\log.txt", true);
            writer.write("---------------------------\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToLog(String logInput) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("D:\\Faculdade\\6o-Período\\Engenharia-De-Software" +
                    "\\Proxy\\resources\\log.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            if (reader.readLine() == null){
                setBoundsToLog();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", new Locale("pt", "BR"));
        String dataFormatada = agora.format(formatador);

        {
            try {
                FileWriter writer = new FileWriter("D:\\Faculdade\\6o-Período\\Engenharia-De-Software" +
                        "\\Proxy\\resources\\log.txt", true);
                writer.write(dataFormatada + " " + logInput + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
