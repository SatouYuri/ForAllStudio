package Interfaces;

import Classes.Hour;
import Classes.Participant;

public interface ITrainingHour {
    Hour getStartHour(); //Retorna a hora de início do treino.
    void setStartHour(Hour startHour); //Define a hora de início do treino.
    Participant getParticipantByName(String firstName); //Retorna o participante, pesquisando pelo nome.
    Participant getParticipantById(Integer id); //Retorna o participante, pesquisando pelo id.
    String printParticipantList(); //Retorna numa String a lista impressa de participantes.
    int addParticipant(Participant addTarget); //Adiciona um participante à lista.
    int removeParticipant(Participant rmvTarget); //Remove um participante da lista.
}
