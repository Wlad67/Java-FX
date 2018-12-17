package sample;

import java.net.URL;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import  java.io.*;
import java.util.Date;
import java.util.ArrayList;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button butt;

    @FXML
    private TextField Aname;

    @FXML
    private TextField Aname1;

    @FXML
    private TextArea infoarea;

    @FXML
    private Button butt2;

   /*@FXML
    private Button butt211;*/

    @FXML
    private Button butt21;


   /* @FXML
    private TextField Anamew;

    @FXML
    private TextField Aname1w;

    @FXML
    private TextField Aname2;

    @FXML
    private TextField Aname3;

    @FXML
    private TextField Aname4;

    @FXML
    private TextField Aname5;

    @FXML
    private TextField Aname6;*/


    @FXML
    void initialize() throws ParseException {

        BufferedReader br = null;

        Scanner name = new Scanner(System.in);
        Date daten=new Date();
        SimpleDateFormat objSDF= new SimpleDateFormat("dd-mm-yyyy");
        //library[] library=new library[10];
        ArrayList<MyNewLIB> library=new ArrayList<>(10);
        library.add(0,new MyNewLIB("Зеленая миля", "Стивен Кинг", 1996, "Росмэн", 150, "Хорошое","24-07-2017"));
        library.add (1 , new MyNewLIB("Искусство программирования","Кнут Дональд",1968,"Addison–Wesley",85,"Отличное","08-04-2017"));
        library.add (2,new MyNewLIB("Техника и философия хакерских атак","Крис Касперски",1999,"СОЛОН-Р",120,"Удовлетворительное","14-09-2017"));
        library.add (3, new MyNewLIB("Алиса в Стране чудес","Льюис Кэрролл",1865,"Macmillan and Co",130,"Хорошое","07-05-2017"));
        library.add(4, new MyNewLIB("2001: Космическая одиссея","Артур Кларк",1968,"New American Library",95,"Отличное","23-06-2017"));
        library.add(5, new MyNewLIB("Убийство в «Восточном экспрессе»","Агата Кристи",1934,"Collins Crime Club",140,"Хорошое","17-01-2017"));
        library.add(6,new MyNewLIB("Сияние","Стивен Кинг",1977,"Doubleday",132,"Удовлетворительное","08-08-2017"));
        library.add(7,new MyNewLIB("Оно","Стивен Кинг",1986,"Viking",88,"Хорощое","24-03- 2017"));
        library.add(8,new MyNewLIB("Смерть в облаках","Агата Кристи",1935,"Эксмо-Пресс",90,"Отличное","05-06-2017"));
        library.add(9,new MyNewLIB("11/22/63","Стивен Кинг",2011,"Charles Scribner's Sons",143,"Хорошое","19-04-2017" ));

        try {
            File filex = new File("text.txt");
            if (!filex.exists()) {
                filex.createNewFile();
            }
            PrintWriter pw = new PrintWriter(filex);
            for(int i=0;i<10;i++){
                pw.println(library.get(i).librinfo());
            }
            pw.close();

            br = new BufferedReader(new FileReader("text.txt"));
            String line;
            while((line = br.readLine())!=null){System.out.println(line);}

        } catch (IOException e) {
            System.out.println("Error" + e);
        }finally {
            try{
                br.close();
            }catch (IOException e){System.out.println("Error" + e);}
        }


       /* System.out.println("\nИзменить состояние книг, изданных больше N лет назад : \n");
        for(int i=0;i<10;i++){
            if(library.get(i).year<1990){System.out.println(library.get(i).newstate("Удовлетворительное"));}
            else {}
        }
        System.out.println("\nВывести названия всех книг, цена на которые > 100 гривен :\n ");
        for(int i=0;i<10;i++){
            if(library.get(i).value>100){System.out.println(library.get(i).librinfo());}
            else {}
        }
        System.out.println("\nВывести названия всех книг данного автора :\n ");
        String aut = name.nextLine();
        for(int i=0;i<10;i++){
            if(library.get(i).author.equals(aut)){System.out.println(library.get(i).librinfo());}
            else {}
        }
        System.out.println("\nВывести информацию о книгах, которые находятся на руках дольше 3 месяцев :\n ");
        Date tod =objSDF.parse("01-11-2017");

        for(int i=0;i<10;i++){
            if(library.get(i).date.compareTo(toString())>-95){System.out.println(library.get(i).librinfo());}
            else {}
        }*/

        butt.setOnAction(event -> {
            String text= Aname.getText();
            String text2= Aname1.getText();

            for(int i=0;i<library.size();i++){
                if(library.get(i).author.equals(text)){infoarea.appendText("\n"+library.get(i).librinfo());}
                else {}
                if(library.get(i).title.equals(text2)){infoarea.appendText("\n"+library.get(i).librinfo());}
                else {}
            }
       });


        butt21.setOnAction(event -> {
            String text2= Aname1.getText();
            for(int i=0;i<library.size();i++){
                if(library.get(i).title.equals(text2)){
                    library.remove(i).librinfo();
                    infoarea.appendText("\n"+library.get(i).librinfo());
                }
                else {}
            }
        });

        butt2.setOnAction(event -> {
            infoarea.clear();
        });

        /*butt211.setOnAction(event -> {
            //butt211.getScene().getWindow().hide();

            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/window.fxml"));
            try{
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

            String field= Anamew.getText();
            String field2= Aname5.getText();
            int field3= Aname6.getAnchor();
            String field4= Aname4.getText();
            double field5= Aname3.getBaselineOffset();
            String field6= Aname2.getText();
            String field7= Aname1w.getText();

            library.add(new MyNewLIB(field,field2,field3,field4,field5,field6,field7))  ;

        });*/


    }
}
