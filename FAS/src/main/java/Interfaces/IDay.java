package Interfaces;

public interface IDay {
    void resetAllPresences(); //Remove a presença marcada todos os alunos de todos as aulas da lista desse dia.
    String printAllTrainingHours(); //Retorna uma String com todas as presenças de todas as aulas do dia.
    Integer getDay(); //Retorna o nome/valor-enum do dia.
    String getDayName(Integer EnumVal); //Retorna o nome do dia em uma String.
    void setDayName(Integer EDayEnumValue); //Define um nome/valor-num para o dia.
}
