package edu.domgie.sda.io.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class SerializationDemo {
    /**
     * Serializacja to zamiana bbiektu na strumień danych
     * który można następnie zapisać do pliku, wysłać siecią, itp....
     * <p>
     * Można dzięki temu zrobić np backup czyli kopię zapasową danych
     * albo przesłać obiekty do innego komputera(albo kontenera)
     * i tam utworzyć dokadnie taki sam obiekt bez kepania go od początku
     * <p>
     * Żeby na obiekcie można było zrobić serializację, konieczne jest
     * aby implementował interfejs Serializable
     * Jest to interfejs tzw. znacznikowy, czyli nie wymusza implementacji żadnej metody,
     * tylko oznacza obiekt jako spełniający jego kryteria
     */
    public static void main(String[] args) {
        SerializedPerson person = new SerializedPerson(22, "Jan", "Kowalski", 33);
        try {
            FileOutputStream fOut = new FileOutputStream("SerializedPerson.data");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(person);
            oOut.close(); // przy try-with-resources niepotrzebne bo klasa po któej dziedzicy jest
            //ObjectOutputStream i jest closable, czyli sama się zamyka
            //sprawdza się to z Ctrl i najeżdzasz na dany kod i wyświetla się czy tak czy nie
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}