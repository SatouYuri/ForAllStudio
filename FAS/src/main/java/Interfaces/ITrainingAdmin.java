package Interfaces;

import Classes.Day;

public interface ITrainingAdmin {
    int addParticipant(String firstName, Integer id, String dayName, Integer start_Hour);
    //void rmvParticipantFromTH(String dayName, Integer start_Hour); //Remove o participante da TH especificada.
    void rmvParticipantFromDay(Integer id, String dayName); //Remove o participante de todas as THs do dia.
    void resetAllDays(); //Remove todas as presenças de todos os dias da lista.
    String printAllDays(); //Imprime todos os dias e os alunos que marcaram presença em cada aula na String de retorno.
    String printDay(String dayName); //Imprime o dia especificado na String de retorno.
}
