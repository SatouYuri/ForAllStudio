package Interfaces;

public interface IParticipant {
    String getFirstName(); //Retorna o primeiro nome do participante
    void setFirstName(String newFirstName); //Define o primeiro nome do participante
    //String getLastName(); //Retorna o último nome do participante
    //void setLastName(String newLastName); //Define o último nome do participante
    //String getFullName(); //Retorna o nome completo do participante
    Integer getId(); //Retorna o código de identificação Telegram do participante
    void setId(Integer newId); //Define o código de identificação Telegram do participante
}
