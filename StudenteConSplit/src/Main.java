import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static Studente getDataFromFile(String path) throws FileNotFoundException, IOException, BadMatricolaException {
        File file = new File(path);

        if (file.exists() && file.isFile()) {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            Studente studente = new Studente();
            String s = reader.readLine();
            String[] str = s.split(" ");


            for (int i = 0; i < 3; i++) {
                if (i == 0)
                    studente.setNome(str[0]);
                else if (i == 1)
                    studente.setCognome(str[1]);
                else if (str[i].charAt(0) == 'M')
                    studente.setMatricola(str[i]);
                else
                    throw new BadMatricolaException();
                //s = reader.readLine();
            }
            reader.close();
            return studente;
        }
        else if (file.exists() && file.isDirectory()){
            BufferedWriter writer = null;
            String[] directory = file.list();
            //Studente stud = new Studente();
            File fileDaScrivere = new File(path + "out.txt");
            writer = new BufferedWriter( new FileWriter(fileDaScrivere));

            for (String s : directory) {
                writer.write(s + "\n");
                //stud.setNome(s);
            }
            writer.close();
            return null;
        }
        else
            throw new FileNotFoundException();
    }

    public static Studente[] createStudentList (String path) throws FileNotFoundException, IOException, BadMatricolaException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String s = reader.readLine();
        Studente[] studente = new Studente[3];
        studente[0] = new Studente();
        studente[1] = new Studente();
        studente[2] = new Studente();

        //String[] str = s.split(" ");

        for (int i=0; i<3; i++) {
            String[] str = s.split(" ");
            studente[i].setNome(str[0]);
            studente[i].setCognome(str[1]);
            if (str[2].charAt(0) == 'M'){
                studente[i].setMatricola(str[2]);
                }
            else throw new BadMatricolaException();
            s = reader.readLine();

        }
        reader.close();

        return studente;
    }

    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        /*Studente matteo;
        Studente pasquale;
        Studente olimpia;
        Studente cattivo;
        String path1 = "";
        String path2 = "";
        String path3 = "";
        String path4 = "";

        System.out.println("Inserisci la path1: ");
        path1 = sc.nextLine();

        System.out.println("Inserisci la path2: ");
        path2 = sc.nextLine();

        System.out.println("Inserisci la path3: ");
        path3 = sc.nextLine();

        System.out.println("Inserisci la path4: ");
        path4 = sc.nextLine();


        try {
            matteo = getDataFromFile(path1);
            System.out.println(matteo);
            pasquale = getDataFromFile(path2);
            System.out.println("____________________________\n" + pasquale);
            olimpia = getDataFromFile(path3);
            System.out.println("____________________________\n" + olimpia);
            cattivo = getDataFromFile(path4);
            System.out.println("____________________________\n" + cattivo);


        }catch(FileNotFoundException fnf){
            System.err.println("fnf");
        }
        catch (IOException io){
            System.err.println("io");
        }
        catch (BadMatricolaException bad){
            System.err.println("bad");
        }*/

        Studente matteo, olimpia, pasquale;
        System.out.println("Inserisci la path: ");
        String path = sc.nextLine();

        try {

            LinkedList<Studente> lista = new LinkedList<>();
            for (int i=0; i<3; i++){
                lista.add(createStudentList(path)[i]);
            }
            System.out.println(lista);

            matteo = new Studente(lista.get(0).getNome(), lista.get(0).getCognome(), lista.get(0).getMatricola());
            olimpia = new Studente(lista.get(1).getNome(), lista.get(1).getCognome(), lista.get(1).getMatricola());
            pasquale = new Studente(lista.get(2).getNome(), lista.get(2).getCognome(), lista.get(2).getMatricola());

            System.out.println("_____________________________");
            System.out.println("Matteo: " + "\n" + matteo);
            System.out.println("_____________________________");
            System.out.println("Olimpia: " + "\n" + olimpia);
            System.out.println("_____________________________");
            System.out.println("Pasq: " + "\n" + pasquale);

        }catch(FileNotFoundException fnf){
            System.err.println("fnf");
        }
        catch (IOException io){
            System.err.println("io");
        }
        catch (BadMatricolaException bad){
            System.err.println("bad");
        }

    }
}
